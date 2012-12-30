/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javaClass.ParcResult;
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
				private String adressePostale;
				
				@Persistent
				private double lat;
				
				@Persistent
				private double longi;
				
				@Persistent
				private String accesTan;
				
				@Persistent
				private String jeux;
				
				@Persistent
				private String mobilierPiquenique;
				
				@Persistent
				private String pateaugeoire;
				
				@Persistent
				private String pointEau;
				
				@Persistent
				private String sanitaire;
				
				@Persistent
				private String abris;
				
				@Persistent
				private String accesHand;
				
				@Persistent
				private String collectionVegetale;
				
				@Persistent
				private String gardien;
				
				@Persistent
				private String chienInterdit;
				
				@Persistent
				private String jardinClos;
				
				@Persistent
				private double surfaceHorsBat;
				
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
    
    public ParcBean(int c, String lib, String tan, String jeux, String pic, String pat, String pteau, String san, String abris, String hand, String veg, String chien, String clos, String com) {
								super();
								this.code = c;
								this.libelle = lib;
								this.accesTan = tan;
								this.jeux = jeux;
								this.mobilierPiquenique = pic;
								this.pateaugeoire = pat;
								this.pointEau = pteau;
								this.sanitaire = san;
								this.abris = abris;
								this.accesHand = hand;
								this.collectionVegetale = veg;
								this.chienInterdit = chien;
								this.jardinClos = clos;
								this.commentaires = com;
				}
				
				public ParcBean(ParcResult p) {
								this.code = p.getCode();
								this.libelle = p.getLibelle();
								this.adressePostale = p.getAdressePostale();
								this.lat = p.getLat();
								this.longi = p.getLongi();
								this.accesTan = p.getAccesTan();
								this.jeux = p.getJeux();
								this.mobilierPiquenique = p.getMobilierPiquenique();
								this.pateaugeoire = p.getPateaugeoire();
								this.pointEau = p.getPointEau();
								this.sanitaire = p.getSanitaire();
								this.abris = p.getAbris();
								this.accesHand = p.getAccesHand();
								this.collectionVegetale = p.getCollectionVegetale();
								this.gardien = p.getGardien();
								this.chienInterdit = p.getChienInterdit();
								this.jardinClos = p.getJardinClos();
								this.surfaceHorsBat = p.getSurfaceHorsBat();
								this.commentaires = p.getCommentaires();
				}
				
				public ParcBean(String[] d) {
								this.code = Integer.parseInt(d[0]);
								this.libelle = d[1];
								this.adressePostale = d[2];
								this.lat = Double.parseDouble(d[3]);
								this.longi = Double.parseDouble(d[4]);
								this.accesTan = d[5];
								this.jeux = d[6];
								this.mobilierPiquenique = d[7];
								this.pateaugeoire = d[8];
								this.pointEau = d[9];
								this.sanitaire = d[10];
								this.abris = d[11];
								this.accesHand = d[12];
								this.collectionVegetale = d[13];
								this.gardien = d[14];
								this.surfaceHorsBat = Double.parseDouble(d[15]);
								this.chienInterdit = d[16];
								this.jardinClos = d[17];
								this.commentaires = d[18];
				}
				
				public String toString(){
								return ("Accès TAN: "+this.accesTan+
																"<br/> Jeux: "+this.jeux+
																"<br/> Aire de pique-nique: "+this.mobilierPiquenique+
																"<br/> Pateaugeoire: "+this.pateaugeoire+
																"<br/> Point d'eau: "+this.pointEau+
																"<br/> Sanitaire: "+this.sanitaire+
																"<br/> Abris: "+this.abris+
																"<br/> Accès handicapé: "+this.accesHand+
																"<br/> Collection végétale: "+this.collectionVegetale+
																"<br/> Chien interdit en laisse: "+this.chienInterdit+
																"<br/> Jardin clos: "+this.jardinClos+
																"<br/> Commentaires: "+this.commentaires);
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
				 * @return the adressePostale
				 */
				public String getAdressePostale() {
								return adressePostale;
				}

				/**
				 * @param adressePostale the adressePostale to set
				 */
				public void setAdressePostale(String adressePostale) {
								this.adressePostale = adressePostale;
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
				 * @return the accesTan
				 */
				public String getAccesTan() {
								return accesTan;
				}

				/**
				 * @param accesTan the accesTan to set
				 */
				public void setAccesTan(String accesTan) {
								this.accesTan = accesTan;
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
				 * @return the mobilierPiquenique
				 */
				public String getMobilierPiquenique() {
								return mobilierPiquenique;
				}

				/**
				 * @param mobilierPiquenique the mobilierPiquenique to set
				 */
				public void setMobilierPiquenique(String mobilierPiquenique) {
								this.mobilierPiquenique = mobilierPiquenique;
				}

				/**
				 * @return the pateaugeoire
				 */
				public String getPateaugeoire() {
								return pateaugeoire;
				}

				/**
				 * @param pateaugeoire the pateaugeoire to set
				 */
				public void setPateaugeoire(String pateaugeoire) {
								this.pateaugeoire = pateaugeoire;
				}

				/**
				 * @return the pointEau
				 */
				public String getPointEau() {
								return pointEau;
				}

				/**
				 * @param pointEau the pointEau to set
				 */
				public void setPointEau(String pointEau) {
								this.pointEau = pointEau;
				}

				/**
				 * @return the sanitaire
				 */
				public String getSanitaire() {
								return sanitaire;
				}

				/**
				 * @param sanitaire the sanitaire to set
				 */
				public void setSanitaire(String sanitaire) {
								this.sanitaire = sanitaire;
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
				 * @return the accesHand
				 */
				public String getAccesHand() {
								return accesHand;
				}

				/**
				 * @param accesHand the accesHand to set
				 */
				public void setAccesHand(String accesHand) {
								this.accesHand = accesHand;
				}

				/**
				 * @return the collectionVegetale
				 */
				public String getCollectionVegetale() {
								return collectionVegetale;
				}

				/**
				 * @param collectionVegetale the collectionVegetale to set
				 */
				public void setCollectionVegetale(String collectionVegetale) {
								this.collectionVegetale = collectionVegetale;
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
				 * @return the chienInterdit
				 */
				public String getChienInterdit() {
								return chienInterdit;
				}

				/**
				 * @param chienInterdit the cheinInterdit to set
				 */
				public void setChienInterdit(String chienInterdit) {
								this.chienInterdit = chienInterdit;
				}

				/**
				 * @return the jardinClos
				 */
				public String getJardinClos() {
								return jardinClos;
				}

				/**
				 * @param jardinClos the jardinClos to set
				 */
				public void setJardinClos(String jardinClos) {
								this.jardinClos = jardinClos;
				}

				/**
				 * @return the surfaceHorsBat
				 */
				public double getSurfaceHorsBat() {
								return surfaceHorsBat;
				}

				/**
				 * @param surfaceHorsBat the surfaceHorsBat to set
				 */
				public void setSurfaceHorsBat(double surfaceHorsBat) {
								this.surfaceHorsBat = surfaceHorsBat;
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
