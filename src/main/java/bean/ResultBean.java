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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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

													GestionFichier gf = new GestionFichier("http://data.nantes.fr/api/publication/LOC_PARCS_JARDINS_NANTES/LOC_PARCS_JARDINS_NANTES_STBL/content/?format=csv", "jardins_parcs.csv");
								 try {
								 gf.charger();
								 } catch (FileNotFoundException ex) {
								 Logger.getLogger(ResultBean.class.getName()).log(Level.SEVERE, null, ex);
								 } catch (MalformedURLException ex) {
								 Logger.getLogger(ResultBean.class.getName()).log(Level.SEVERE, null, ex);
								 } catch (IOException ex) {
								 Logger.getLogger(ResultBean.class.getName()).log(Level.SEVERE, null, ex);
								 }

								ResultBeanPersist pp = new ResultBeanPersist();
								this.tab.clear();
								calculPointRencontre();
								pp.calculResultat(this);

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
				
				public String transformeLibString() {
								String res = "";
								if (!tab.values().isEmpty()) {
												Iterator<ParcBean> parcIter = tab.values().iterator();
												ParcBean parc;
												while (parcIter.hasNext()) {
																parc = parcIter.next();
																res = res + parc.getLibelle().replaceAll("'", "\\\\'") + ",";
												}
												res = res.substring(0, res.length() - 1);
								}
								return res;
				}
}
