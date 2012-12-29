/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import java.util.*;

import PMF.PMF;
import bean.AmiBean;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
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
    
}
