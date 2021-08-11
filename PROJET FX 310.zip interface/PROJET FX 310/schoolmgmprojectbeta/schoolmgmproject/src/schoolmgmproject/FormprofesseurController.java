/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmgmproject;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Nomad Soul
 */
public class FormprofesseurController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField telephoneproftxt;

    @FXML
    private TextField nomproftxt;

    @FXML
    private Label filiereproflabel;

    @FXML
    private TextField grpproftxt;

    @FXML
    private TextField filiereproftxt;

    @FXML
    private Button validerbtn1;

    @FXML
    private Label telephoneproflabel;

    @FXML
    private Label matproflabel;

    @FXML
    private Label nomprofabel;

    @FXML
    private TextField prenomproftxt;

    @FXML
    private Label prenomproflabel;

    @FXML
    private TextField matproftxt;

    @FXML
    private Label groupeproflabel;
      @FXML
    void validerprof(ActionEvent event) {
        
        
        Connection conn = Mysqlconnect.ConnectDb();
        JOptionPane.showMessageDialog(null,"Connexion réussie");
        PreparedStatement pst;
       String mat=matproftxt.getText();
       String nom=nomproftxt.getText();
       String prenom=prenomproftxt.getText();
       String groupe= grpproftxt.getText();
       String filiere=filiereproftxt.getText();
       String telephone= telephoneproftxt.getText();
       
       
       
       String sql = "INSERT INTO `professeurs`(`matricule`, `nom`, `prenom`, `groupe`, `telephone`, `filiere`) VALUES (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, matproftxt.getText());
            pst.setString(2, nomproftxt.getText());
            pst.setString(3, prenomproftxt.getText());
            pst.setString(4, grpproftxt.getText());
            pst.setString(5, filiereproftxt.getText());
            pst.setString(6, telephoneproftxt.getText());
           
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Ajout reussi");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        if(mat.isEmpty()||nom.isEmpty()||prenom.isEmpty()||groupe.isEmpty()||filiere.isEmpty()||telephone.isEmpty()){
       Alert alert = new Alert(Alert.AlertType.WARNING);
       alert.setContentText("Veuillez remplir les cases nécésssaires");

        }

    }
  
        public void editProf(){
        try {
           Connection conn = Mysqlconnect.ConnectDb();
           PreparedStatement pst;
            String value1 = matproftxt.getText();
            String value2 = nomproftxt.getText();
            String value3 = prenomproftxt.getText();
            String value4 = grpproftxt.getText();
            String value5 = filiereproftxt.getText();
            String value6 = telephoneproftxt.getText();
           
            
            
            String sql = "Update etudiants set matricule ='"+value1+"',nom ='"+value2+"',"
                    + "prenom ='"+value3+"',groupe ='"+value4+"',filiere ='"+value5+"',"
                    + "telephone ='"+value6+"'  where Matricule = '"+value1+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Modification réussie ");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        matproftxt.setText("");
        nomproftxt.setText("");
        prenomproftxt.setText("");
        grpproftxt.setText("");
        filiereproftxt.setText("");
        telephoneproftxt.setText("");
     

    }
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    

    }
    

