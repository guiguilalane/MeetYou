/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author guillaume
 */
@PersistenceCapable
public class BrotherhoodBean {
    
    @PrimaryKey
    @Persistent
    private String me;
    
    @PrimaryKey
    @Persistent
    private String friend;
    
    public BrotherhoodBean(){
        
    }
    
    public BrotherhoodBean(String me, String friend){
        this.me = me;
        this.friend = friend;
    }

    public String getMe() {
        return me;
    }

    public String getFriend() {
        return friend;
    }

    public void setMe(String me) {
        this.me = me;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }
    
    
    
}
