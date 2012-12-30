/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import PMF.PMF;
import bean.AmiBean;
import bean.ParcBean;
import bean.ResultBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
												Query query = pm.newQuery("javax.jdo.query.SQL", "SELECT Code, Libelle, adresse_postale, Latitude, Longitude, Acces_Tan, Jeux, Mobilier_pique_nique, Pataugeoire, Point_d_eau, Sanitaires, Abris, Acces_handicap_y_compris_sanitai, Collection_vegetale, Gardien, Chien_interdit_en_laisse, Jardin_clos, Surface_hors_batiments, Commentaires FROM (SELECT (6378 * ACOS(COS( 47.2248 * PI() / 180 ) * COS(Latitude * PI() / 180 ) * COS((Longitude * PI() / 180) - ( -1.59412 * PI() / 180 )) + SIN( 47.2248 * PI() / 180 ) * SIN(Latitude * PI() / 180 ))) as distance, Code, Libelle, adresse_postale, Latitude, Longitude, Acces_Tan, Jeux, Mobilier_pique_nique, Pataugeoire, Point_d_eau, Sanitaires, Abris, Acces_handicap_y_compris_sanitai, Collection_vegetale, Gardien, Chien_interdit_en_laisse, Jardin_clos, Surface_hors_batiments, Commentaires FROM PARCBEAN ORDER BY distance LIMIT 5) as T1");
												query.setClass(ParcBean.class);
												List<ParcBean> results = (List<ParcBean>) query.execute();
												Iterator<ParcBean> parcIter = results.iterator();
												ParcBean parcRes;
												while (parcIter.hasNext()) {
																parcRes = parcIter.next();
																tabRes.getTab().put(new Integer(parcRes.getCode()), parcRes);
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
