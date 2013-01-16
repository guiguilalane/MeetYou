/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;


import PMF.PMF;
import bean.AmiBean;
import bean.BrotherhoodBean;
import java.util.ArrayList;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;
/**
 *
 * @author guillaume
 */

public class AmiBeanPersist {
    
    private PersistenceManagerFactory pmf = PMF.getInstance();
    private PersistenceManager pm = null;
    private Transaction tx = null;
    
    public AmiBeanPersist(){

    }
    
    public void enregistrer(AmiBean a){
        try{
            pm = pmf.getPersistenceManager();
            tx = pm.currentTransaction();
            tx.begin();
            pm.makePersistent(a);
            tx.commit();
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally {
            if(tx.isActive()){
                tx.rollback();
            }
            pm.close();
        }
    }
    
    public AmiBean getAmiBean(String myId){
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        tx.begin();
        Query query = pm.newQuery(AmiBean.class);
        AmiBean me = new AmiBean();
        try{
            query.setFilter("token == myIdentifier");
            query.declareParameters("String myIdentifier");
            List<AmiBean> lami = (List<AmiBean>) query.execute(myId);
            if(!lami.isEmpty()){
                me = lami.get(0);
            }
            tx.commit();
        } catch (Exception e) {
												System.out.println(e);
								} finally {
												if (tx.isActive()) {
																tx.rollback();
												}
            query.closeAll();
												pm.close();
            return me;
								}
        
    }
    
    public ArrayList<AmiBean> getFriends(String me){
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        tx.begin();
        Query query = pm.newQuery(BrotherhoodBean.class);
        ArrayList<AmiBean> friends = new ArrayList<AmiBean>();
        try {
            query.setFilter("me == myIdentifier");
            query.declareParameters("String myIdentifier");
            
            List<BrotherhoodBean> brotherhood = (List<BrotherhoodBean>) query.execute(me);
            if(!brotherhood.isEmpty()){
                List<String> friendId = new ArrayList<String>();
                for(BrotherhoodBean b : brotherhood){
                    friendId.add(b.getFriend());
                }
                query = pm.newQuery(AmiBean.class,
                                    ":p.contains(token)");
                List<AmiBean> tmp = (List<AmiBean>) query.execute(friendId);
                if(!tmp.isEmpty())
                {
                    for(AmiBean a : tmp){
                        friends.add(a);
                    }
                }
            }
            
												tx.commit();
								} catch (Exception e) {
												System.out.println(e);
								} finally {
												if (tx.isActive()) {
																tx.rollback();
												}
            query.closeAll();
												pm.close();
            return friends;
								}
    }
}
