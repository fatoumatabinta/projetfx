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
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 * FXML Controller class
 *
 * @author Nomad Soul
 */
public class GroupeController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private ObservableList<Groupe> listegroupes;
      @FXML
    private TableColumn<Groupe, String> nbrgrpcln;

    @FXML
    private TableColumn<Groupe, String> nomgrpcln;

    @FXML
    private TextField dategrptxt;

    @FXML
    private Button supprimergroupebtn;

    @FXML
    private TableColumn<Groupe, String> matgrpcln;

    @FXML
    private Label nomgrplabel;

    @FXML
    private Button retourmenubtn;

    @FXML
    private Label dategrplabel;

    @FXML
    private TextField matgrptxt;

    @FXML
    private Label nbrgrplabel;

    @FXML
    private TextField nbrgrptxt;

    @FXML
    private TableColumn<Groupe, String> dategrpcln;

    @FXML
    private TextField nomgrptxt;

    @FXML
    private Button ajoutergroupebtn;

    @FXML
    private Label matgrplabel;

    @FXML
    private Button modifiergroupebtn;

    @FXML
    private TableView<Groupe> tabgroupes;
  

  

    @FXML
    void supprimergroupe(ActionEvent event) {
       try{
        Groupe selectedrow= tabgroupes.getSelectionModel().getSelectedItem();
        Connection conn= Mysqlconnect.ConnectDb();
        String sqls="DELETE FROM groupes WHERE nom=?";
        PreparedStatement pss= conn.prepareStatement(sqls);
        pss.setString(1, selectedrow.getNom());
        pss.execute();
        JOptionPane.showMessageDialog(null,"Suppression du groupe réussie");
           refreshtablegroupe();
        
        
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void updategroupe(ActionEvent event) {

    }

    @FXML
    void modifgroupe(ActionEvent event){
    
        try{ Parent root8= FXMLLoader.load(getClass().getResource("formgroupe.fxml"));
        Stage stage= new Stage();
        stage.setScene(new Scene(root8));
        stage.show();
       }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
  void refreshtablegroupe(){
  try{ Parent root4= FXMLLoader.load(getClass().getResource("groupe.fxml"));
        Stage stage= new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
       }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  
  }
    @FXML
    void ajoutergroupe(ActionEvent event) {
        
        Connection conn = Mysqlconnect.ConnectDb();
        JOptionPane.showMessageDialog(null,"Connexion réussie");
        PreparedStatement pst;
       String mat=matgrptxt.getText();
       String nom=nomgrptxt.getText();
       String datecreation=dategrptxt.getText();
       String nbretu= nbrgrptxt.getText();

       
       
       
       String sql = "INSERT INTO `groupes`(`matricule`, `nom`, `datecreation`, `nbretu`) VALUES (?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, matgrptxt.getText());
            pst.setString(2, nomgrptxt.getText());
            pst.setString(3, dategrptxt.getText());
            pst.setString(4, nbrgrptxt.getText());

           
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Ajout reussi");
           refreshtablegroupe();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        if(mat.isEmpty()||nom.isEmpty()||datecreation.isEmpty()||nbretu.isEmpty()){
       Alert alert = new Alert(Alert.AlertType.WARNING);
       alert.setContentText("Veuillez remplir les cases nécésssaires");
        
        }
        

    }
    
    public void actualisergroupes(){
    
        ObservableList<Groupe> listegroupes;
      
        matgrpcln.setCellValueFactory(new PropertyValueFactory<Groupe,String>("matricule"));
      nomgrpcln.setCellValueFactory(new PropertyValueFactory<Groupe,String>("nom"));
     dategrpcln.setCellValueFactory(new PropertyValueFactory<Groupe,String>("datecreation"));
      nbrgrpcln.setCellValueFactory(new PropertyValueFactory<Groupe,String>("nbretu"));
     
      listegroupes=Mysqlconnect.getDataGroupes();
      tabgroupes.setItems(listegroupes);
   }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ObservableList<Groupe> listegroupes;
      
        matgrpcln.setCellValueFactory(new PropertyValueFactory<Groupe,String>("matricule"));
      nomgrpcln.setCellValueFactory(new PropertyValueFactory<Groupe,String>("nom"));
     dategrpcln.setCellValueFactory(new PropertyValueFactory<Groupe,String>("datecreation"));
      nbrgrpcln.setCellValueFactory(new PropertyValueFactory<Groupe,String>("nbretu"));
     
      listegroupes=Mysqlconnect.getDataGroupes();
      tabgroupes.setItems(listegroupes);
    }    
    
}
