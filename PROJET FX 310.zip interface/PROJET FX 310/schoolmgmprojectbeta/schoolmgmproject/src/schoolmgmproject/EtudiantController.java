/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmgmproject;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static schoolmgmproject.Mysqlconnect.ConnectDb;
import schoolmgmproject.FormetdController;

/**
 * FXML Controller class
 *
 * @author Nomad Soul
 */
public class EtudiantController implements Initializable {

    /**
     * Initializes the controller class.
     */
        
    @FXML
    private TableView<Etudiant> tabstudents;
    
        private ObservableList<Etudiant> listeetudiants;
        String sql=null;
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        Etudiant etudiant=null;
        
 @FXML
    private Button validerbtn;

 

       
    @FXML
    private TableColumn<Etudiant,String> nometdcln;

    @FXML
    private TextField filiereetdtxt;

    @FXML
    private TextField prenometdtxt;

    @FXML
    private TableColumn<Etudiant,String> matetdcln;

    @FXML
    private TextField telephoneetdtxt;

    @FXML
    private TableColumn<Etudiant,String> grpetdcln;

    @FXML
    private TextField matetdtxt;

    @FXML
    private Button retourmenubtn;

    @FXML
    private Label nomeetdlabel;

    @FXML
    private Button ajoutetudbtn;

    @FXML
    private Label prenometdlabel;

    @FXML
    private Label grpetdlabel;

    @FXML
    private TextField grpetdtxt;

    @FXML
    private Button modifetdbtn;

    @FXML
    private Button supprimeretdbtn;

 @FXML
    private Label filiereetdlabel;

    @FXML
    private TableColumn<Etudiant,String> telephonetdcln;

    @FXML
    private Label telephoneetdlabel;

    @FXML
    private TableColumn<Etudiant,String> filiereetdcln;

    @FXML
    private TextField nometdtxt;

    @FXML
    private Label matetdlabel;

    @FXML
    private TableColumn<Etudiant,String> prenometdcln;

    @FXML
    void ajouteretudiant(ActionEvent event) {
         
        
        
        
        
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
refreshtableetd();            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        if(mat.isEmpty()||nom.isEmpty()||prenom.isEmpty()||groupe.isEmpty()||filiere.isEmpty()||telephone.isEmpty()){
       Alert alert = new Alert(Alert.AlertType.WARNING);
       alert.setContentText("Veuillez remplir les cases nécésssaires");
        
        }
       
    }
    
   
        void refreshtableetd(){
  try{ Parent root4= FXMLLoader.load(getClass().getResource("etudiant.fxml"));
        Stage stage= new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
       }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  
  }
      
    
    @FXML
    void supprimeretudiant(ActionEvent event) {
        
        try{
        Etudiant selectedrow= tabstudents.getSelectionModel().getSelectedItem();
        Connection conn= Mysqlconnect.ConnectDb();
        String sqls="DELETE FROM etudiants WHERE nom=?";
        PreparedStatement pss= conn.prepareStatement(sqls);
        pss.setString(1, selectedrow.getNom());
        pss.execute();
        JOptionPane.showMessageDialog(null,"Suppression de l'étudiant réussie");
            refreshtableetd();    
        
        
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }



    @FXML
    void ouvrirajoutetd(ActionEvent event) throws IOException {
       try{ Parent root4= FXMLLoader.load(getClass().getResource("formetd.fxml"));
        Stage stage= new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
       }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       

    }
    
    
   
   
   
   
    
    
     @FXML
    void afficheretudiants(ActionEvent event) {
     try{ Parent root5= FXMLLoader.load(getClass().getResource("tableviewetd.fxml"));
        Stage stage= new Stage();
        stage.setScene(new Scene(root5));
        stage.show();
       }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
     
     
     
    }
    
    

    @FXML
    void ouvrirmodifetd(ActionEvent event) {
               try{ Parent root4= FXMLLoader.load(getClass().getResource("formetd.fxml"));
        Stage stage= new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
       }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
       

    }
    
    
    @FXML
    void updateetudiant(ActionEvent event) {
        try{ Parent root4= FXMLLoader.load(getClass().getResource("formetd.fxml"));
        Stage stage= new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
       }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }
        @FXML
public void supprimeretudiant(){
    ObservableList<Etudiant> listeetudiants;
   
       
    listeetudiants=tabstudents.getSelectionModel().getSelectedItems();
         Connection conn= Mysqlconnect.ConnectDb();
         PreparedStatement pst;
          int selectedIndex = tabstudents.getSelectionModel().getSelectedIndex();
          String selectedItem= matetdcln.getText();
        String sql="delete from etudiants WHERE matricule=?";
        
         try {
             pst = conn.prepareStatement(sql);
             pst.setString(1,selectedItem);
             pst.execute();
             tabstudents.getItems().remove(selectedIndex);
             
             JOptionPane.showMessageDialog(null, "Etudiant supprimé avec succés");
             actualiseretd();
            
             
         } catch (SQLException ex) { 
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        } 
       matetdtxt.setText("");
        nometdtxt.setText("");
        prenometdtxt.setText("");
        grpetdtxt.setText("");
        telephoneetdtxt.setText("");
        filiereetdtxt.setText("");
        
     
    }
    

   
 

    @FXML
    void retournermenu(ActionEvent event) {
        try{ Parent root6= FXMLLoader.load(getClass().getResource("schoolmgmproject.fxml"));
        Stage stage= new Stage();
        stage.setScene(new Scene(root6));
        stage.show();
       }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       

    }
   
   public void actualiseretd(){
    
         matetdcln.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("matricule"));
      nometdcln.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nom"));
      prenometdcln.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prenom"));
      grpetdcln.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("groupe"));
      filiereetdcln.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("filiere"));
      telephonetdcln.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("telephone"));
      listeetudiants=Mysqlconnect.getDataEtudiant();
      tabstudents.setItems(listeetudiants);
   }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
   ObservableList<Etudiant> listeetudiants;
        
        
         matetdcln.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("matricule"));
      nometdcln.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("nom"));
      prenometdcln.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("prenom"));
      grpetdcln.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("groupe"));
      filiereetdcln.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("filiere"));
      telephonetdcln.setCellValueFactory(new PropertyValueFactory<Etudiant,String>("telephone"));
      listeetudiants=Mysqlconnect.getDataEtudiant();
      tabstudents.setItems(listeetudiants);
}
}