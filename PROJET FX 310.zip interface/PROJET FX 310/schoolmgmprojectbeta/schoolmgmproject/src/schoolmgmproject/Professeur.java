/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmgmproject;

/**
 *
 * @author Nomad Soul
 */
public class Professeur {
       int matricule;
   String nom, prenom,groupe,filiere,telephone;

    public Professeur(int matricule, String nom, String prenom, String groupe, String telephone, String filiere) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.groupe = groupe;
        this.telephone = telephone;
        this.filiere=filiere;
    }

    Professeur(int parseInt, String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

  
    

    
}
