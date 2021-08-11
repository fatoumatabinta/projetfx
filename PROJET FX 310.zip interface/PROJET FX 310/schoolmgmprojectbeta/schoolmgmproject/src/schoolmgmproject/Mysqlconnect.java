/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmgmproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javax.swing.JOptionPane;
import schoolmgmproject.EtudiantController;
import schoolmgmproject.ProfesseurController;
        
/**
 *
 * @author Nomad Soul
 */
public class Mysqlconnect {


     
        String sql=null;

        PreparedStatement pst=null;
        ResultSet rs=null;
    
     @FXML
    private TableView<Etudiant> tabstudents;
      @FXML
    private TableView<Professeur> tabprofs;
    
    public static Connection ConnectDb(){
        Connection conn;
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/projetschool","root","");
            // JOptionPane.showMessageDialog(null, "Connexion Etablie");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        return null;
         
}
}
    
   
    public static ObservableList<Etudiant> getDataEtudiant(){
    Connection conn= Mysqlconnect.ConnectDb();
    String sql=null;

        PreparedStatement pst=null;
        ResultSet rs=null;
    
    ObservableList <Etudiant>  listeetudiants= FXCollections.observableArrayList();
    try {
             pst = conn.prepareStatement("Select * from etudiants");
             rs = pst.executeQuery();
             
             while(rs.next()){
             
                 listeetudiants.add(new Etudiant(Integer.parseInt(rs.getString("matricule")), rs.getString("nom"),rs.getString("prenom"), rs.getString("groupe"), rs.getString("filiere"), rs.getString("telephone")));
             }
         } catch (SQLException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
            return listeetudiants;
      }

      
    public static ObservableList<Professeur> getDataProfs(){
    Connection conn= Mysqlconnect.ConnectDb();
    String sqlprof=null;

        PreparedStatement pstprof=null;
        ResultSet rsprof=null;
    
    ObservableList <Professeur>  listeprofesseurs= FXCollections.observableArrayList();
    try {
             pstprof = conn.prepareStatement("Select * from professeurs");
             rsprof = pstprof.executeQuery();
             
             while(rsprof.next()){
             
                 listeprofesseurs.add(new Professeur(Integer.parseInt(rsprof.getString("matricule")), rsprof.getString("nom"),rsprof.getString("prenom"), rsprof.getString("groupe"), rsprof.getString("telephone"), rsprof.getString("filiere")));
             }
         } catch (SQLException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
            return listeprofesseurs;
      
            
            
    }
    
    
    
    public static ObservableList<Groupe> getDataGroupes(){
    Connection conn= Mysqlconnect.ConnectDb();
    String sqlgrp=null;

        PreparedStatement pstgrp=null;
        ResultSet rsgrp=null;
    
    ObservableList <Groupe>  listegroupes= FXCollections.observableArrayList();
    try {
             pstgrp = conn.prepareStatement("Select * from groupes");
             rsgrp = pstgrp.executeQuery();
             
             while(rsgrp.next()){
             
                 listegroupes.add(new Groupe(Integer.parseInt(rsgrp.getString("matricule")), rsgrp.getString("nom"),rsgrp.getString("datecreation"), rsgrp.getString("nbretu")));
             }
         } catch (SQLException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
            return listegroupes;
      }
      
    
    
    } 
    
