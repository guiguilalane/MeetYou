/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;


import PMF.PMF;
import bean.ParcBean;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
/**
 *
 * @author guillaume
 */

public class ParcBeanPersist {
    
    private PersistenceManagerFactory pmf = PMF.getInstance();
    private PersistenceManager pm = null;
    private Transaction tx = null;
    
    public ParcBeanPersist(){

    }
    
    public void enregistrer(ParcBean p){
        try{
            pm = pmf.getPersistenceManager();
            tx = pm.currentTransaction();
            tx.begin();
            pm.makePersistent(p);
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
    
}
