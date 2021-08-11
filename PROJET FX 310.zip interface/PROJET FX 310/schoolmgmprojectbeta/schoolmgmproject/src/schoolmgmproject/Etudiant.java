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
public class Etudiant {
    
     
   int matricule;
   String nom, prenom,groupe,naissance,telephone,adresse,email,filiere;

    
   
   

    

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

    public int getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getGroupe() {
        return groupe;
    }

    public String getNaissance() {
        return naissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getFiliere() {
        return filiere;
    }

    public Etudiant(int matricule, String nom, String prenom, String groupe,String telephone, String filiere) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.groupe = groupe;
      
        this.telephone = telephone;
        
        
        this.filiere = filiere;
    }
    
}
