/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Nomyx
 */
@ManagedBean(name = "TabPositionDepart")
@SessionScoped
public class TabPositionDepart implements java.io.Serializable {
				
//				private HashMap<Boolean, AmiBean> map = new HashMap<Boolean, AmiBean>();
				private ArrayList<AmiBean> amiSelect = new ArrayList<AmiBean>();

				/**
				 * Creates a new instance of TabPositionDepart
				 */
				public TabPositionDepart() {
				}

				
				public void gestionAmi(AmiBean a){
								System.out.println("Je passe");
								if (amiSelect.contains(a)){
												amiSelect.remove(a);
								}
								else{
												amiSelect.add(a);
								}
				}

				/**
				 * @return the amiSelect
				 */
				public ArrayList<AmiBean> getAmiSelect() {
								return amiSelect;
				}

				/**
				 * @param amiSelect the amiSelect to set
				 */
				public void setAmiSelect(ArrayList<AmiBean> amiSelect) {
								this.amiSelect = amiSelect;
				}

}
