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
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import schoolmgmproject.EtudiantController;
import schoolmgmproject.Mysqlconnect;
/**
 *
 * @author Nomad Soul
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TableView<Etudiant> tabstudents;
      
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
    private TextField searchtxt;

    @FXML
    private Button searchbtn;

   
    @FXML
    private Button menuetdbtn;
    
    @FXML
    private Button menuprofbtn;

    @FXML
    private Button menugrpbtn;
    
    @FXML
    private Button quitterbtn;
   
    @FXML
    void ouvrirmenuetd(ActionEvent event) throws SQLException {
            try{ Parent root1=FXMLLoader.load(getClass().getResource("etudiant.fxml"));
            Stage stage2= new Stage();
            stage2.setScene(new Scene(root1));
            stage2.show();
            
         
            
            
            } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    
                  
           
            
            
   }
    
    
    @FXML
    void rechercher(ActionEvent event) {

                 

    }

    

    
       @FXML
    void ouvrirmenuprof(ActionEvent event) {
         try{ Parent root2=FXMLLoader.load(getClass().getResource("professeur.fxml"));
            Stage stage4= new Stage();
            stage4.setScene(new Scene(root2));
            stage4.show();
            
         
            
            
            } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    
    

    }
    
  
            
    
   

			
        

     
                  
           
            
            
   
      @FXML
    void ouvrirmenugrp(ActionEvent event) {
          try{ Parent root3= FXMLLoader.load(getClass().getResource("groupe.fxml"));
        Stage stage1= new Stage();
        stage1.setScene(new Scene(root3));
        stage1.show();
        }
        catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    
    
    
    
    
    
        @FXML
    void quittermenu(ActionEvent event) {
       System.exit(0);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
    }    
 
    
    
     @FXML
    void afficheretudiants(ActionEvent event) {
     try{ Parent root5= FXMLLoader.load(getClass().getResource("tableviewetd.fxml"));
        Stage stage3= new Stage();
        stage3.setScene(new Scene(root5));
        stage3.show();
       }  catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
     
     
     
    }
    
    
}
