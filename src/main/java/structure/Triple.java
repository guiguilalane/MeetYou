/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import bean.AmiBean;

/**
 *
 * @author Nomyx
 */
public class Triple<T, U, V> implements java.io.Serializable {

				T a;
				U b;
				V c;

				public Triple(T a, U b, V c) {
								this.a = a;
								this.b = b;
								this.c = c;
				}

    public Triple() {
        this(null, null, null);
    }

				public T getA() {
								return a;
				}

				public U getB() {
								return b;
				}

				public V getC() {
								return c;
				}

				public void setA(T a) {
								this.a = a;
				}

				public void setB(U b) {
								this.b = b;
				}

				public void setC(V c) {
								this.c = c;
				}
}
