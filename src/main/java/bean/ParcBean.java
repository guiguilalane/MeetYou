/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author Nomyx
 */
@ManagedBean(name = "ParcBean")
@SessionScoped
@PersistenceCapable
public class ParcBean extends DatePlace implements java.io.Serializable {

				@PrimaryKey
				@Persistent
				private int code;
				
				@Persistent
				private String libelle;
				
				@Persistent
				private String adresse_postale;
				
				@Persistent
				private double latitude;
				
				@Persistent
				private double longitude;
				
				@Persistent
				private String acces_tan;
				
				@Persistent
				private String jeux;
				
				@Persistent
				private String mobilier_pique_nique;
				
				@Persistent
				private String pataugeoire;
				
				@Persistent
				private String point_d_eau;
				
				@Persistent
				private String sanitaires;
				
				@Persistent
				private String abris;
				
				@Persistent
				private String acces_handicap_y_compris_sanitai;
				
				@Persistent
				private String collection_vegetale;
				
				@Persistent
				private String gardien;
				
				@Persistent
				private String chien_interdit_en_laisse;
				
				@Persistent
				private String jardin_clos;
				
				@Persistent
				private double surface_hors_batiments;
				
				@Persistent
				private String commentaires;
				
				/**
				 * Creates a new instance of ParcBean
				 */
				public ParcBean() {
								super();
				}
				
				public ParcBean(int c, String lib) {
								super();
								this.code = c;
								this.libelle = lib;
				}
    
    public ParcBean(int c, String lib, String adresse, double lat, double lon , String tan, String jeux, String pic, String pat, String pteau, String san, String abris, String hand, String veg, String gardien, String chien, String clos, double surface, String com) {
								super();
								this.code = c;
								this.libelle = lib;
        this.adresse_postale = adresse;
        this.latitude = lat;
        this.longitude = lon;
								this.acces_tan = tan;
								this.jeux = jeux;
								this.mobilier_pique_nique = pic;
								this.pataugeoire = pat;
								this.point_d_eau = pteau;
								this.sanitaires = san;
								this.abris = abris;
								this.acces_handicap_y_compris_sanitai = hand;
								this.collection_vegetale = veg;
        this.gardien = gardien;
								this.chien_interdit_en_laisse = chien;
								this.jardin_clos = clos;
        this.surface_hors_batiments = surface;
								this.commentaires = com;
				}
				
//				public ParcBean(ParcResult p) {
//								this.code = p.getCode();
//								this.libelle = p.getLibelle();
//								this.accesTan = p.getAccesTan();
//								this.jeux = p.getJeux();
//								this.mobilierPiquenique = p.getMobilierPiquenique();
//								this.pateaugeoire = p.getPateaugeoire();
//								this.pointEau = p.getPointEau();
//								this.sanitaire = p.getSanitaire();
//								this.abris = p.getAbris();
//								this.accesHand = p.getAccesHand();
//								this.collectionVegetale = p.getCollectionVegetale();
//								this.chienInterdit = p.getChienInterdit();
//								this.jardinClos = p.getJardinClos();
//								this.commentaires = p.getCommentaires();
//				}
				
				public String toString(){
								return ("Accès TAN: "+this.getAcces_tan()+
																"<br/> Jeux: "+this.getJeux()+
																"<br/> Aire de pique-nique: "+this.getMobilier_pique_nique()+
																"<br/> Pateaugeoire: "+this.getPataugeoire()+
																"<br/> Point d'eau: "+this.getPoint_d_eau()+
																"<br/> Sanitaire: "+this.getSanitaires()+
																"<br/> Abris: "+this.getAbris()+
																"<br/> Accès handicapé: "+this.getAcces_handicap_y_compris_sanitai()+
																"<br/> Collection végétale: "+this.getCollection_vegetale()+
																"<br/> Chien interdit en laisse: "+this.getChien_interdit_en_laisse()+
																"<br/> Jardin clos: "+this.getJardin_clos()+
																"<br/> Commentaires: "+this.getCommentaires());
				}

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param libelle the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * @return the adresse_postale
     */
    public String getAdresse_postale() {
        return adresse_postale;
    }

    /**
     * @param adresse_postale the adresse_postale to set
     */
    public void setAdresse_postale(String adresse_postale) {
        this.adresse_postale = adresse_postale;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the acces_tan
     */
    public String getAcces_tan() {
        return acces_tan;
    }

    /**
     * @param acces_tan the acces_tan to set
     */
    public void setAcces_tan(String acces_tan) {
        this.acces_tan = acces_tan;
    }

    /**
     * @return the jeux
     */
    public String getJeux() {
        return jeux;
    }

    /**
     * @param jeux the jeux to set
     */
    public void setJeux(String jeux) {
        this.jeux = jeux;
    }

    /**
     * @return the mobilier_pique_nique
     */
    public String getMobilier_pique_nique() {
        return mobilier_pique_nique;
    }

    /**
     * @param mobilier_pique_nique the mobilier_pique_nique to set
     */
    public void setMobilier_pique_nique(String mobilier_pique_nique) {
        this.mobilier_pique_nique = mobilier_pique_nique;
    }

    /**
     * @return the pateaugeoire
     */
    public String getPataugeoire() {
        return pataugeoire;
    }

    /**
     * @param pateaugeoire the pateaugeoire to set
     */
    public void setPataugeoire(String pataugeoire) {
        this.pataugeoire = pataugeoire;
    }

    /**
     * @return the point_d_eau
     */
    public String getPoint_d_eau() {
        return point_d_eau;
    }

    /**
     * @param point_d_eau the point_d_eau to set
     */
    public void setPoint_d_eau(String point_d_eau) {
        this.point_d_eau = point_d_eau;
    }

    /**
     * @return the sanitaire
     */
    public String getSanitaires() {
        return sanitaires;
    }

    /**
     * @param sanitaire the sanitaire to set
     */
    public void setSanitaires(String sanitaires) {
        this.sanitaires = sanitaires;
    }

    /**
     * @return the abris
     */
    public String getAbris() {
        return abris;
    }

    /**
     * @param abris the abris to set
     */
    public void setAbris(String abris) {
        this.abris = abris;
    }

    /**
     * @return the acces_handicap_y_compris_sanitai
     */
    public String getAcces_handicap_y_compris_sanitai() {
        return acces_handicap_y_compris_sanitai;
    }

    /**
     * @param acces_handicap_y_compris_sanitai the acces_handicap_y_compris_sanitai to set
     */
    public void setAcces_handicap_y_compris_sanitai(String acces_handicap_y_compris_sanitai) {
        this.acces_handicap_y_compris_sanitai = acces_handicap_y_compris_sanitai;
    }

    /**
     * @return the collection_vegetale
     */
    public String getCollection_vegetale() {
        return collection_vegetale;
    }

    /**
     * @param collection_vegetale the collection_vegetale to set
     */
    public void setCollection_vegetale(String collection_vegetale) {
        this.collection_vegetale = collection_vegetale;
    }

    /**
     * @return the gardien
     */
    public String getGardien() {
        return gardien;
    }

    /**
     * @param gardien the gardien to set
     */
    public void setGardien(String gardien) {
        this.gardien = gardien;
    }

    /**
     * @return the chien_interdit_en_laisse
     */
    public String getChien_interdit_en_laisse() {
        return chien_interdit_en_laisse;
    }

    /**
     * @param chien_interdit_en_laisse the chien_interdit_en_laisse to set
     */
    public void setChien_interdit_en_laisse(String chien_interdit_en_laisse) {
        this.chien_interdit_en_laisse = chien_interdit_en_laisse;
    }

    /**
     * @return the jardin_clos
     */
    public String getJardin_clos() {
        return jardin_clos;
    }

    /**
     * @param jardin_clos the jardin_clos to set
     */
    public void setJardin_clos(String jardin_clos) {
        this.jardin_clos = jardin_clos;
    }

    /**
     * @return the surface_hors_batiments
     */
    public double getSurface_hors_batiments() {
        return surface_hors_batiments;
    }

    /**
     * @param surface_hors_batiments the surface_hors_batiments to set
     */
    public void setSurface_hors_batiments(double surface_hors_batiments) {
        this.surface_hors_batiments = surface_hors_batiments;
    }

    /**
     * @return the commentaires
     */
    public String getCommentaires() {
        return commentaires;
    }

    /**
     * @param commentaires the commentaires to set
     */
    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }
}
