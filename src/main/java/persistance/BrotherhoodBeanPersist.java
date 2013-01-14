/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import PMF.PMF;
import bean.AmiBean;
import bean.BrotherhoodBean;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

/**
 *
 * @author guillaume
 */
public class BrotherhoodBeanPersist {
    
    private PersistenceManagerFactory pmf = PMF.getInstance();
    private PersistenceManager pm = null;
    private Transaction tx = null;
    
    public BrotherhoodBeanPersist(){

    }
    
    /**
     * Ajoute un nouvel ami, l'ajout ce fait dans les deux sens.
     * @param a le premier ami
     * @param b le deuxième ami
     */
    public void addFriend(AmiBean a, AmiBean b){
        try{
            pm = pmf.getPersistenceManager();
            tx = pm.currentTransaction();
            tx.begin();
            pm.makePersistent(new BrotherhoodBean(a.getToken(),b.getToken()));
            pm.makePersistent(new BrotherhoodBean(b.getToken(), a.getToken()));
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
    
    public void addFriends(AmiBean a, List<AmiBean> l){
        for(AmiBean ami : l){
            addFriend(a, ami);
        }
    }
}
