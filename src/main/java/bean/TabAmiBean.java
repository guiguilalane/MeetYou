/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
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

				public String addAmi(AmiBean ami/*String nom, String prenom*/) {
								Triple<AmiBean, AmiBean, AmiBean> dernier = tab.get(tab.size() - 1);
								if (dernier.getB() == null) {
												dernier.setB(ami/*new AmiBean(nom, prenom)*/);
								} else if (dernier.getC() == null) {
												dernier.setC(ami/*new AmiBean(nom, prenom)*/);
								} else {
												tab.add(new Triple(ami/*new AmiBean(nom, prenom)*/, null, null));
								}
								return "index";
				}

				/**
				 * Creates a new instance of TabAmiBean
				 */
				public TabAmiBean() {
        AmiBeanPersist pp = new AmiBeanPersist();
        AmiBean Bs, Gc, Dm, Ff, Cg;
        Bs = new AmiBean("BULLIER", "Sidonie", 0, 1);
        Gc = new AmiBean("GREGOIRE", "Clémence", 1,0);
        Dm = new AmiBean("DUPUIS", "Mathilde",7,8);
        Ff = new AmiBean("FAGNIEZ", "Florian",0,2);
        Cg = new AmiBean("COUTABLE", "Guillaume",0,0);
        pp.enregistrer(Bs);
        pp.enregistrer(Gc);
        pp.enregistrer(Dm);
        pp.enregistrer(Ff);
        pp.enregistrer(Cg);
								tab.add(new Triple(Bs, Gc, Dm));
								tab.add(new Triple(Ff, Cg, null));

    }
}