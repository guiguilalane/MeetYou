/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.Vector;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import structure.Triple;
import persistance.*;

/**
 *
 * @author Nomyx
 */
@ManagedBean(name = "TabAmiBean")
@SessionScoped
public class TabAmiBean implements java.io.Serializable {

				ArrayList<Triple<AmiBean, AmiBean, AmiBean>> tab = new ArrayList<Triple<AmiBean, AmiBean, AmiBean>>();
				
				public ArrayList<Triple<AmiBean, AmiBean, AmiBean>> getTab() {
								return tab;
				}

				public void setTab(ArrayList<Triple<AmiBean, AmiBean, AmiBean>> tab) {
								this.tab.addAll(tab);
				}

				public final String addAmi(AmiBean ami/*String nom, String prenom*/) {
								
        if(tab.isEmpty()){
            tab.add(new Triple(ami/*new AmiBean(nom, prenom)*/, null, null));
        } else {
            Triple<AmiBean, AmiBean, AmiBean> dernier = tab.get(tab.size() - 1);
            if (dernier.getB() == null) {
												dernier.setB(ami/*new AmiBean(nom, prenom)*/);
            } else if (dernier.getC() == null) {
                dernier.setC(ami/*new AmiBean(nom, prenom)*/);
            } else {
                tab.add(new Triple(ami/*new AmiBean(nom, prenom)*/, null, null));
            }
        }
								return "index";
				}

				/**
				 * Creates a new instance of TabAmiBean
				 */
				public TabAmiBean() {
        AmiBeanPersist pp = new AmiBeanPersist();
        ArrayList<AmiBean> friends = pp.getFriends("0005");
        for(AmiBean a : friends){
            addAmi(a);
        }
//        AmiBean Bs, Gc, Dm, Ff, Cg;
//        Bs = new AmiBean("0001", "BULLIER", "Sidonie", 47.27756368, -1.634448546);
//        Gc = new AmiBean("0002", "GREGOIRE", "Clémence", 47.27520911, -1.634768614);
//        Dm = new AmiBean("0003", "DUPUIS", "Mathilde", 47.21158288, -1.56699581);
//        Ff = new AmiBean("0004", "FAGNIEZ", "Florian", 47.21973845, -1.565343139);
//        Cg = new AmiBean("0005", "COUTABLE", "Guillaume", 0, 0);
//        pp.enregistrer(Bs);
//        pp.enregistrer(Gc);
//        pp.enregistrer(Dm);
//        pp.enregistrer(Ff);
//        pp.enregistrer(Cg);
//        
//        BrotherhoodBeanPersist bbp = new BrotherhoodBeanPersist();
//        ArrayList<AmiBean> amiBeanArray = new ArrayList<AmiBean>();
//        amiBeanArray.add(Bs);
//        amiBeanArray.add(Gc);
//        amiBeanArray.add(Dm);
//        amiBeanArray.add(Ff);
//        bbp.addFriends(Cg, amiBeanArray);
//								tab.add(new Triple(Bs, Gc, Dm));
//								tab.add(new Triple(Ff, Cg, null));

    }
}