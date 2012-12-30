/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Nomyx
 */
@ManagedBean(name = "TabPositionDepart")
@SessionScoped
public class TabPositionDepart implements java.io.Serializable {

				private ArrayList<AmiBean> amiSelect = new ArrayList<AmiBean>();
				private double posRencX = 0;
				private double posRencY = 0;

				/**
				 * Creates a new instance of TabPositionDepart
				 */
				public TabPositionDepart() {
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

				public void calculPointRencontre() {
								setPosRencX(0);
								setPosRencY(0);
								Iterator<AmiBean> amiIter = amiSelect.iterator();
								AmiBean ami;
								// TODO: récupérer notre position ! est-ce qu'on la met obligatoirement dans le tabAmis ?
								// Somme des latitudes et longitudes de tous les amis sélectionnés afin de créer le point de rencontre
								while (amiIter.hasNext()) {
												ami = amiIter.next();
												setPosRencX(getPosRencX() + ami.getLat());
												setPosRencY(getPosRencY() + ami.getLongi());
								}
								
								//Coordonnées du point de rencontre
								int nbCoord = amiSelect.size();
								setPosRencX(getPosRencX() / nbCoord);
								setPosRencY(getPosRencY() / nbCoord);
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
				
				public boolean estSelect(AmiBean a){
								boolean res = false;
								if (amiSelect.contains(a)) {
												res = true;
								}
								return res;
				}
}
