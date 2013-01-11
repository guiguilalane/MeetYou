/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import fichier.GestionFichier;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import persistance.ParcBeanPersist;
import persistance.ResultBeanPersist;

/**
 *
 * @author Nomyx
 */
@ManagedBean(name = "ResultBean")
@SessionScoped
public class ResultBean implements java.io.Serializable {

				// TODO : A revoir
				private HashMap<Integer, ParcBean> tab = new HashMap<Integer, ParcBean>();
				// Tableau contenant tous les amis sélectionnés
				private ArrayList<AmiBean> amiSelect = new ArrayList<AmiBean>();
				private double posRencX = 0;
				private double posRencY = 0;

				/**
				 * Creates a new instance of ResultBean
				 */
				public ResultBean() {
								// TODO : A supprimer
								//tab.put(1, new ParcBean(01, "Jardin des plantes", "Gare sncf lignes 1 et 12", "OUI", "NON", "OUI", "OUI", "OUI", "OUI", "", "Camellia, epiphytes, cactées", "OUI", "NON", "C’est en 1807 que débute la création du jardin des plantes. caractéristique des jardins paysagers du siècle dernier, il présente un modelé souple avec de nombreuses cascades et pièces d’eau ainsi qu’une décoration florale abondante maintenant la tradition de la mosaïculture.quelques points spécifiques doivent être mentionnés :  • la montagne : ce monticule artificiel a été réalisé avec les matériaux résultant du creusement du lac .• le magnolia d’hectot : planté en 1807, à l’âge de seize ans, c’est le plus vieil arbre du jardin.• le palmarium : construit en 1898, il abrite une collection exceptionnelle d’épiphytes.• l’orangerie : elle est destinée à l’abri des plantes en bacs pendant l’hiver.• l es serres à cactées : ancien jardin d’hiver réhabilité, ce bâtiment abrite une des plus complètes collections de cactées et succulentes de l’hexagone.• l’ecole de botanique : présente la diversité de la flore du massif armoricain.• le jardin d’essai : situé à proximité, présente au public une gamme avec leur nomenclature des plants utilisés chaque année pour la décoration des massifs floraux.• collection de camellias : c’est une plante symbole pour nantes représentée ici par une collection de 600 cultivars."));
								/*tab.put(2, new ParcBean(02, "Parc des dervallières"));
								 tab.put(3, new ParcBean(03, "Square louis bureau"));
								 tab.put(4, new ParcBean(04, "Square maquis de saffré"));
								 tab.put(5, new ParcBean(05, "Jardin des cinq sens"));*/
				}

				/**
				 * @return the tab
				 */
				public HashMap<Integer, ParcBean> getTab() {
								return tab;
				}

				/**
				 * @param tab the tab to set
				 */
				public void setTab(HashMap<Integer, ParcBean> tab) {
								this.tab = tab;
				}

				public ArrayList<Integer> getKeyAsList() {
								return new ArrayList<Integer>(tab.keySet());
				}

				/**
				 * @return the amiSelect
				 */
				public ArrayList<AmiBean> getAmiSelect() {
								return amiSelect;
				}

				/**
				 * @param amiSelect the amiSelect to set
				 */
				public void setAmiSelect(ArrayList<AmiBean> amiSelect) {
								this.amiSelect = amiSelect;
				}

				/**
				 * @return the posRencX
				 */
				public double getPosRencX() {
								return posRencX;
				}

				/**
				 * @param posRencX the posRencX to set
				 */
				public void setPosRencX(double posRencX) {
								this.posRencX = posRencX;
				}

				/**
				 * @return the posRencY
				 */
				public double getPosRencY() {
								return posRencY;
				}

				/**
				 * @param posRencY the posRencY to set
				 */
				public void setPosRencY(double posRencY) {
								this.posRencY = posRencY;
				}

				public void gestionAmi(AmiBean a) {
								if (amiSelect.contains(a)) {
												amiSelect.remove(a);
												a.setIsSelected(false);
								} else {
												amiSelect.add(a);
												a.setIsSelected(true);

								}
				}

				public void calculPointRencontre() {
								posRencX = 0;
								posRencY = 0;
								Iterator<AmiBean> amiIter = amiSelect.iterator();
								AmiBean ami;
								// TODO: récupérer notre position ! est-ce qu'on la met obligatoirement dans le tabAmis ?
								// Somme des latitudes et longitudes de tous les amis sélectionnés afin de créer le point de rencontre
								while (amiIter.hasNext()) {
												ami = amiIter.next();
												posRencX = posRencX + ami.getLat();
												posRencY = posRencY + ami.getLongi();
								}

								//Coordonnées du point de rencontre
								int nbCoord = amiSelect.size();
								posRencX = posRencX / nbCoord;
								posRencY = posRencY / nbCoord;
				}

				public void rechercheParc() {

//        ParcBeanPersist pbp = new ParcBeanPersist();
//        ParcBean p1, p2, p3, p4;
//        p1 = new ParcBean(34, "Parc des dervallières", "Rue louis le nain", 47.2248, -1.59412, "Vincent auriol ligne 56", "NON", "NON", "NON", "NON", "NON", "NON", "NON", "", "NON", "NON", "NON", 82110.0, "");
//        p2 = new ParcBean(35, "Jardin d'enfants de procé", "	Rue des dervallières",	47.2222, -1.58153,	"Lignes 22 et 56 - procé",	"OUI",	"NON", "OUI",	"OUI", "OUI",	"NON", "NON", "", "OUI", "OUI", "OUI", 5800.0, "");
//        p3 = new ParcBean(36, "Parc de proce", "Rue des dervallières, boulevard des anglais", 	47.2243,	-1.58156, "Lignes 22 et 56 - procé",	"OUI",	"NON",	"NON",	"OUI",	"OUI",	"NON",	"NON",	"Bruyères, rhododendrons, magnolias, andromèdes, lis, fuchsias, dahlias,  vivaces",	"OUI", "NON", "OUI",	113000,	"Le parc a été créé au milieu du siècle dernier, d'après les plans de d. noisette, autour d'un manoir datant de 1789.");
//        p4 = new ParcBean(115, "Square amiral halgand", "	Place de l'hotel de ville",	47.2175,	-1.55443,	"Hôtel de ville lignes 11 12 21 22 23 c lu",	"NON",	"NON",	"NON",	"NON",	"OUI",	"NON", "NON",	"","NON",	"NON",	"OUI",	1298,	"Le square de la mairie date de la reconstruction d'après-guerre, quelques jeux et la statue du général leclerc sont les principaux ornements.");
//								pbp.enregistrer(p1);
//        pbp.enregistrer(p2);
//        pbp.enregistrer(p3);
//        pbp.enregistrer(p4);

								/*					GestionFichier gf = new GestionFichier("http://data.nantes.fr/api/publication/LOC_PARCS_JARDINS_NANTES/LOC_PARCS_JARDINS_NANTES_STBL/content/?format=csv", "jardins_parcs.csv");
								 try {
								 gf.charger();
								 } catch (FileNotFoundException ex) {
								 Logger.getLogger(ResultBean.class.getName()).log(Level.SEVERE, null, ex);
								 } catch (MalformedURLException ex) {
								 Logger.getLogger(ResultBean.class.getName()).log(Level.SEVERE, null, ex);
								 } catch (IOException ex) {
								 Logger.getLogger(ResultBean.class.getName()).log(Level.SEVERE, null, ex);
								 }*/

								ResultBeanPersist pp = new ResultBeanPersist();
								calculPointRencontre();
								pp.calculResultat(this);

								// Ajout dans le tableau
								// Ajout dans le tableau

				}

				public String transformeLatString() {
								String res = "";
								if (!tab.values().isEmpty()) {
												Iterator<ParcBean> parcIter = tab.values().iterator();
												ParcBean parc;
												while (parcIter.hasNext()) {
																parc = parcIter.next();
																res = res + parc.getLatitude() + ",";
												}
												res = res.substring(0, res.length() - 1);
								}
								return res;
				}

				public String transformeLongString() {
								String res = "";
								if (!tab.values().isEmpty()) {
												Iterator<ParcBean> parcIter = tab.values().iterator();
												ParcBean parc;
												while (parcIter.hasNext()) {
																parc = parcIter.next();
																res = res + parc.getLongitude() + ",";
												}
												res = res.substring(0, res.length() - 1);
								}
								return res;
				}
}
