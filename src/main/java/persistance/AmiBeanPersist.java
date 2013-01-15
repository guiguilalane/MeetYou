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
    
    public ArrayList<AmiBean> getFriends(String me){
        pm = pmf.getPersistenceManager();
        tx = pm.currentTransaction();
        tx.begin();
        Query query = pm.newQuery(BrotherhoodBean.class);
        ArrayList<AmiBean> friends = new ArrayList<AmiBean>();
        try {
												pm = pmf.getPersistenceManager();
												tx = pm.currentTransaction();
												tx.begin();
            query.setFilter("me == myIdentifier");
            query.declareParameters("String myIdentifier");
            
            //TODO: changer la valeur du parametre de 'execute' par la valeur de la personne connecté.
            List<BrotherhoodBean> brotherhood = (List<BrotherhoodBean>) query.execute(me);
            if(!brotherhood.isEmpty()){
//                System.out.println("My friends :");
                List<String> friendId = new ArrayList<String>();
                for(BrotherhoodBean b : brotherhood){
//                    System.out.println("\t- " + b.getFriend());
                    friendId.add(b.getFriend());
                }
                query = pm.newQuery(AmiBean.class,
                                    ":p.contains(token)");
                List<AmiBean> tmp = (List<AmiBean>) query.execute(friendId);
                if(!tmp.isEmpty())
                {
                    for(AmiBean a : tmp){
                        friends.add(a);
                        System.out.println(a);
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
