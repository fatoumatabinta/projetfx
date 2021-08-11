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
public class Groupe {
     int matricule;
    String nom, datecreation, nbretu;

    public Groupe(int matricule, String nom, String datecreation, String nbretu) {
        this.matricule = matricule;
        this.nom = nom;
        this.datecreation = datecreation;
        this.nbretu = nbretu;
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

    public String getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(String datecreation) {
        this.datecreation = datecreation;
    }

    public String getNbretu() {
        return nbretu;
    }

    public void setNbretu(String nbretu) {
        this.nbretu = nbretu;
    }


    

    
}
