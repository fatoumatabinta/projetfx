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
public class ProfesseurController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
        private TableView<Professeur> tabprofs;
    
        private ObservableList<Professeur> listeprofesseurs;
        String sql=null;
        Connection conn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        Professeur professeur=null;

    
 @FXML
    private TableColumn<Professeur, String> matprofcln;

    @FXML
    private TableColumn<Professeur, String> filiereprofcln;


    @FXML
    private TableColumn<Professeur, String> nomprofcln;

    @FXML
    private Button ajouterprofbtn;

    @FXML
    private TextField telephoneproftxt;

    @FXML
    private TextField nomproftxt;

  
   

    @FXML
    private Label filiereproflabel;

    @FXML
    private Button retourmenubtn;

 
    @FXML
    private Button supprimerprofbtn;

    @FXML
    private TextField grpproftxt;

    @FXML
    private TextField filiereproftxt;

    @FXML
    private Label telephoneproflabel;

    @FXML
    private TableColumn<Professeur, String> prenomprofcln;

    @FXML
    private Label matproflabel;

   

    @FXML
    private Label nomproflabel;

    @FXML
    private Button modifierprofbtn;

    @FXML
    private TableColumn<Professeur, String> telephoneprofcln;

    @FXML
    private Label grpproflabel;

    @FXML
    private TextField prenomproftxt;

    @FXML
    private Label prenomproflabel;

    @FXML
    private TextField matproftxt;

    @FXML
    private TableColumn<Professeur, String> grpprofcln;

    @FXML
    void ajouterprofesseur(ActionEvent event) {
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
              refreshtableprofs();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        if(mat.isEmpty()||nom.isEmpty()||prenom.isEmpty()||groupe.isEmpty()||filiere.isEmpty()||telephone.isEmpty()){
       Alert alert = new Alert(Alert.AlertType.WARNING);
       alert.setContentText("Veuillez remplir les cases nécésssaires");

        }

    }

    @FXML
    void updateprof(ActionEvent event) {
            try{ Parent root4= FXMLLoader.load(getClass().getResource("formprofesseur.fxml"));
        Stage stage= new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
       }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    

    

    @FXML
    void ouvrirajoutprof(ActionEvent event) {
         
    }
    
    
       

    @FXML
    void afficherprofesseurs(ActionEvent event) {
         try{ Parent root5= FXMLLoader.load(getClass().getResource("tableviewprofesseur.fxml"));
        Stage stage= new Stage();
        stage.setScene(new Scene(root5));
        stage.show();
       }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
     

    }

    @FXML
    void ouvrirmodifprof(ActionEvent event) {

    }
   void refreshtableprofs(){
  try{ Parent root4= FXMLLoader.load(getClass().getResource("professeur.fxml"));
        Stage stage= new Stage();
        stage.setScene(new Scene(root4));
        stage.show();
       }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
  
  }
    @FXML
    void supprimerprof(ActionEvent event) {
                try{
        Professeur selectedrow= tabprofs.getSelectionModel().getSelectedItem();
        Connection conn= Mysqlconnect.ConnectDb();
        String sqls="DELETE FROM professeurs WHERE nom=?";
        PreparedStatement pss= conn.prepareStatement(sqls);
        pss.setString(1, selectedrow.getNom());
        pss.execute();
        JOptionPane.showMessageDialog(null,"Suppression du professeur réussie");
                refreshtableprofs();

        
        
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
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
     public void actualiserprof(){
    
         matprofcln.setCellValueFactory(new PropertyValueFactory<Professeur,String>("matricule"));
      nomprofcln.setCellValueFactory(new PropertyValueFactory<Professeur,String>("nom"));
      prenomprofcln.setCellValueFactory(new PropertyValueFactory<Professeur,String>("prenom"));
      grpprofcln.setCellValueFactory(new PropertyValueFactory<Professeur,String>("groupe"));
      telephoneprofcln.setCellValueFactory(new PropertyValueFactory<Professeur,String>("telephone"));
      filiereprofcln.setCellValueFactory(new PropertyValueFactory<Professeur,String>("filiere"));
      listeprofesseurs=Mysqlconnect.getDataProfs();
      tabprofs.setItems(listeprofesseurs);
   }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<Professeur> listeprofesseurs;
      
        matprofcln.setCellValueFactory(new PropertyValueFactory<Professeur,String>("matricule"));
      nomprofcln.setCellValueFactory(new PropertyValueFactory<Professeur,String>("nom"));
      prenomprofcln.setCellValueFactory(new PropertyValueFactory<Professeur,String>("prenom"));
      grpprofcln.setCellValueFactory(new PropertyValueFactory<Professeur,String>("groupe"));
      telephoneprofcln.setCellValueFactory(new PropertyValueFactory<Professeur,String>("telephone"));
      filiereprofcln.setCellValueFactory(new PropertyValueFactory<Professeur,String>("filiere"));
      listeprofesseurs=Mysqlconnect.getDataProfs();
      tabprofs.setItems(listeprofesseurs);
    
}
}