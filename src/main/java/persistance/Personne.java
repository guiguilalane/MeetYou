/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance;

import java.util.*;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author guillaume
 */
@PersistenceCapable
public class Personne {
    
      @PrimaryKey
      @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
      private Long id;
      
      @Persistent
      private String nom ="";
      @Persistent
      private String prenom = "";

      public Personne(String pNom, String pPrenom) {
            nom=this.nom = pNom;
            prenom=pPrenom;
      }
      
      public Long getId(){
          return id;
      }

      public String getNom() { return nom; }

      public String getPrenom() { return prenom;}

      public void setNom(String pNom) { nom = pNom; }

      public void setPrenom(String pPrenom) { nom = pPrenom; }

}
