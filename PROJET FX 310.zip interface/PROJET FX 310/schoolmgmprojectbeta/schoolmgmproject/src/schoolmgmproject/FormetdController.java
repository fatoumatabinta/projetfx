/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmgmproject;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import schoolmgmproject.Mysqlconnect;

/**
 * FXML Controller class
 *
 * @author Nomad Soul
 */
public class FormetdController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
       @FXML
    private TextField filiereetdtxt;

    @FXML
    private TextField prenometdtxt;

    @FXML
    private TextField telephoneetdtxt;

    @FXML
    private Label nometdlabel;

    @FXML
    private TextField matetdtxt;

    @FXML
    private Label prenometdlabel;

    @FXML
    private Button validerbtn;

    @FXML
    private TextField grpetdtxt;

    @FXML
    private Label filiereetdlabel;

        @FXML
    private Button updatebutton;
        
    @FXML
    private Label groupeetdlabel;

    @FXML
    private Label telephoneetdlabel;

    @FXML
    private TextField nometdtxt;

    @FXML
    private Label matetdlabel;
            

    @FXML
    void valideretudiant(ActionEvent event) {
    
        
        
        
        
        
        Connection conn = Mysqlconnect.ConnectDb();
        JOptionPane.showMessageDialog(null,"Connexion réussie");
        PreparedStatement pst;
       String mat=matetdtxt.getText();
       String nom=nometdtxt.getText();
       String prenom=prenometdtxt.getText();
       String groupe= grpetdtxt.getText();
       String filiere=filiereetdtxt.getText();
       String telephone= telephoneetdtxt.getText();
       
       
       
       String sql = "INSERT INTO `etudiants`(`matricule`, `nom`, `prenom`, `groupe`, `filiere`, `telephone`) VALUES (?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, matetdtxt.getText());
            pst.setString(2, nometdtxt.getText());
            pst.setString(3, prenometdtxt.getText());
            pst.setString(4, grpetdtxt.getText());
            pst.setString(5, filiereetdtxt.getText());
            pst.setString(6, telephoneetdtxt.getText());
           
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Ajout reussi");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        if(mat.isEmpty()||nom.isEmpty()||prenom.isEmpty()||groupe.isEmpty()||filiere.isEmpty()||telephone.isEmpty()){
       Alert alert = new Alert(AlertType.WARNING);
       alert.setContentText("Veuillez remplir les cases nécésssaires");
        
        }
       
    }
    
   
        
        public void editEtudiant(){
        try {
           Connection conn = Mysqlconnect.ConnectDb();
           PreparedStatement pst;
            String value1 = matetdtxt.getText();
            String value2 = nometdtxt.getText();
            String value3 = prenometdtxt.getText();
            String value4 = grpetdtxt.getText();
            String value5 = filiereetdtxt.getText();
            String value6 = telephoneetdtxt.getText();
           
            
            
            String sql = "Update etudiants set matricule ='"+value1+"',nom ='"+value2+"',"
                    + "prenom ='"+value3+"',groupe ='"+value4+"',filiere ='"+value5+"',"
                    + "telephone ='"+value6+"'  where Matricule = '"+value1+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Modification réussie ");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        matetdtxt.setText("");
        nometdtxt.setText("");
        prenometdtxt.setText("");
        grpetdtxt.setText("");
        filiereetdtxt.setText("");
        telephoneetdtxt.setText("");
     

    }
    
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
