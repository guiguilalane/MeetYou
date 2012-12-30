/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import PMF.PMF;
import bean.AmiBean;
import bean.ParcBean;
import bean.ResultBean;
import javaClass.ParcResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

/**
 *
 * @author Nomyx
 */
public class ResultBeanPersist {

				private PersistenceManagerFactory pmf = PMF.getInstance();
				private PersistenceManager pm = null;
				private Transaction tx = null;

				public ResultBeanPersist() {
				}

				public void calculResultat(ResultBean tabRes) {
								try {
												pm = pmf.getPersistenceManager();
												tx = pm.currentTransaction();
												tx.begin();
												Query query = pm.newQuery("javax.jdo.query.SQL", "SELECT (6378 * ACOS(COS( 47.2248 * PI() / 180 ) * COS(Latitude * PI() / 180 ) * COS((Longitude * PI() / 180) - ( -1.59412 * PI() / 180 )) + SIN( 47.2248 * PI() / 180 ) * SIN(Latitude * PI() / 180 ))) as distance, Code, Libelle, adresse_postale, Latitude, Longitude, Acces_Tan, Jeux, Mobilier_pique_nique, Pataugeoire, Point_d_eau, Sanitaires, Abris, Acces_handicap_y_compris_sanitai, Collection_vegetale, Gardien, Chien_interdit_en_laisse, Jardin_clos, Surface_hors_batiments, Commentaire FROM EL_PARC ORDER BY distance LIMIT 5");
												query.setClass(ParcResult.class);
												ArrayList<ParcResult> results = (ArrayList<ParcResult>) query.execute();
												Iterator<ParcResult> parcIter = results.iterator();
												ParcResult parcRes;
												while (parcIter.hasNext()) {
																System.out.println("hhhh");
																parcRes = parcIter.next();
																tabRes.getTab().put((Integer) parcRes.getCode(), new ParcBean(parcRes));
												}
												tx.commit();
								} catch (Exception e) {
												System.out.println(e);
								} finally {
												if (tx.isActive()) {
																tx.rollback();
												}
												pm.close();
								}

				}
}
