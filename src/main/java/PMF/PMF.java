/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PMF;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 *
 * @author guillaume
 */
public class PMF {
    
    private static final PersistenceManagerFactory pmfInstance = JDOHelper.getPersistenceManagerFactory("Datastore");

    private PMF(){
        
    }
    
    public static PersistenceManagerFactory getInstance(){
        return pmfInstance;
    }
}
