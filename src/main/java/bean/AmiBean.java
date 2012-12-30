/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.jdo.annotations.PersistenceAware;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author Nomyx
 */
@ManagedBean(name = "AmiBean")
@SessionScoped
@PersistenceCapable
public class AmiBean implements java.io.Serializable {

    @PrimaryKey
				@Persistent
				private String token;
				
    @Persistent
				private String nom;
    
    @Persistent
				private String prenom;
    
    @Persistent
    private double lat;
    
    @Persistent
				private double longi;
    
    @Persistent
				private Boolean notActif;
				
				@Persistent
				private Boolean isSelected = false;

				/**
				 * Creates a new instance of amiBean
				 */
				public AmiBean() {
				}

				public AmiBean(String token, String n, String p, double lat, double longi) {
								this.token = token;
								this.nom = n;
								this.prenom = p;
        this.lat = lat;
								this.longi = longi;
								if (lat == 0 && longi == 0){
												this.notActif = true;
								}
								else{
												this.notActif = false;
								}
				}

				public String getNom() {
								return nom;
				}

				public String getPrenom() {
								return prenom;
				}

				public void setNom(String n) {
								this.nom = n;
				}

				public void setPrenom(String p) {
								this.prenom = p;
				}
    
    /**
				 * @return the lat
				 */
				public double getLat() {
								return lat;
				}

				/**
				 * @param lat the lat to set
				 */
				public void setLat(double lat) {
								this.lat = lat;
				}

				/**
				 * @return the longi
				 */
				public double getLongi() {
								return longi;
				}

				/**
				 * @param longi the longi to set
				 */
				public void setLongi(double longi) {
								this.longi = longi;
				}
    
    /**
				 * @return the actif
				 */
				public Boolean getNotActif() {
								return notActif;
				}

				/**
				 * @param actif the actif to set
				 */
				public void setNotActif(Boolean actif) {
								this.notActif = actif;
				}

				/**
				 * @return the isSelected
				 */
				public Boolean getIsSelected() {
								return isSelected;
				}

				/**
				 * @param isSelected the isSelected to set
				 */
				public void setIsSelected(Boolean isSelected) {
								this.isSelected = isSelected;
				}

				/**
				 * @return the token
				 */
				public String getToken() {
								return token;
				}

				/**
				 * @param token the token to set
				 */
				public void setToken(String token) {
								this.token = token;
				}
}
