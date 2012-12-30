/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fichier;

import bean.ParcBean;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import persistance.ParcBeanPersist;

/**
 *
 * @author Nomyx
 */
public final class GestionFichier {
				
				private String urlFichier;
				private File fichierZip;
				private File cheminStockage;
				private File csv;
				private String requeteSuppr;
				private String requeteCreation;
				private String requeteInsert;
				private int taille;
				
				public GestionFichier(String url, String dossier, String chemin){
								urlFichier = url;
								fichierZip = new File(dossier);
								cheminStockage = new File(chemin);
								csv = new File("");
				}
				
				//@Schedule(dayOfMonth = "1",month="1")
				//@Schedule(second="*/30", minute="*", hour="*")
				public void getFile()
				{
								InputStream input = null;
								FileOutputStream writeFile = null;

								try
								{
												URL url = new URL(this.urlFichier);
												URLConnection connection = url.openConnection();
												int fileLength = connection.getContentLength();
												if (fileLength == -1)
												{         
																System.out.println("Invalide URL or file.");
																return;
												}
												input = connection.getInputStream();
												String fileName = url.getFile().substring(url.getFile().lastIndexOf('/') + 1);
												writeFile = new FileOutputStream(fileName);
												byte[] buffer = new byte[1024];
												int read;
												while ((read = input.read(buffer)) > 0){
																writeFile.write(buffer, 0, read);
												}
												writeFile.flush();
								}
								catch (IOException e)
								{
												System.out.println("Error while trying to download the file.");
												e.printStackTrace();
								}
								finally
								{
												try
												{
																writeFile.close();
																input.close();
												}
												catch (IOException e){
																e.printStackTrace();
												}
								}
				}
				
	/**
   * Decompresse le fichier zip dans le répertoire donné
   * @throws FileNotFoundException
   * @throws IOException
   */
  public void unzip() throws FileNotFoundException, IOException{

								// Création de la ZipInputStream qui va servir à lire les données du fichier zip
								ZipInputStream zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(this.fichierZip.getCanonicalFile())));

								// Extractions des entrées du fichiers zip (i.e. le contenu du zip)
								ZipEntry ze = null;
								try {
												while((ze = zis.getNextEntry()) != null){

																// Pour chaque entrée, on crée un fichier dans le répertoire de sortie "cheminStockage"
																File f = new File(this.cheminStockage.getCanonicalPath(), ze.getName());
																System.out.println(this.cheminStockage.getCanonicalPath()+ze.getName());
																// Si l'entrée est un répertoire, on le crée dans le répertoire de sortie et on passe à l'entrée suivante (continue)
																if (ze.isDirectory()) {
																				f.mkdirs();
																				continue;
																}

																// L'entrée est un fichier, on crée une OutputStream pour écrire le contenu du nouveau fichier
																f.getParentFile().mkdirs();
																OutputStream fos = new BufferedOutputStream(new FileOutputStream(f));

																// On écrit le contenu du nouveau fichier qu'on lit à partir de la ZipInputStream au moyen d'un buffer (byte[])
																try {
																				try {
																								final byte[] buf = new byte[8192];
																								int bytesRead;
																								while (-1 != (bytesRead = zis.read(buf))){
																												fos.write(buf, 0, bytesRead);
																								}
																				}
																				finally {
																								fos.close();
																				}
																}
																catch (final IOException ioe) {
																				// En cas d'erreur on efface le fichier
																				f.delete();
																				throw ioe;
																}
												}
								}
								finally {
												// Fermeture de la ZipInputStream
												zis.close();
								}
				}

				public void parsingFile() throws MalformedURLException, IOException{
								ParcBeanPersist pp = new ParcBeanPersist();
								URL url = new URL(this.urlFichier);
								String nameFile = url.getFile().substring(url.getFile().lastIndexOf('/')+1,url.getFile().length()-4).replace("_csv", ".csv");
								Reader reader = new InputStreamReader(new FileInputStream(nameFile), "utf-8");
								BufferedReader br = new BufferedReader(reader);
								
								String ligne = null;
								String[] data = {};
								String[] donnees = new String[taille];
								
								Pattern p = Pattern.compile(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
								//requetes.executerRequete(requeteSuppr);
								//requetes.executerRequete(requeteCreation);
								int numLigne = 1;
								while ((ligne = br.readLine()) != null)
									{
										if (numLigne > 1){
												// Retourner la ligne dans un tableau
												data = p.split(ligne);
												int i = 0;
												for (String val : data){
														donnees[i]=val;
														i++;
												}
												if (data.length!=taille){
																donnees[taille-1]="";
												}
												ParcBean parc = new ParcBean(donnees);
												pp.enregistrer(parc);
										}
										numLigne++;
								}
								br.close();
								
				}
				
				public void charger() throws FileNotFoundException, MalformedURLException, IOException{
								this.getFile();
								this.unzip();
								this.parsingFile();
				}
				
				public void main() throws FileNotFoundException, MalformedURLException, IOException{
								GestionFichier gf = new GestionFichier("http://data.nantes.fr/fileadmin/data/datastore/3-publication/environnement/jardins_parcs/jardins_parcs_csv.zip","jardins_parcs_csv.zip","");
								gf.charger();
				}
}