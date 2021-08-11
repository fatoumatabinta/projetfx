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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Nomad Soul
 */
public class FormgroupeController implements Initializable {

    /**
     * Initializes the controller class.
     */
     
  
    @FXML
    private TextField dategrptxt;

    @FXML
    private Label nbrgrplabel;

    @FXML
    private Label nomgrplabel;

    @FXML
    private TextField nbrgrptxt;

   @FXML
    private Button edigrpbtn;


    @FXML
    private TextField nomgrptxt;

    @FXML
    private Label matgrplabel;

    @FXML
    private Label dategrplabel;

    @FXML
    private TextField matgrptxt;

   
    public void editgroupes() {
         try {
           Connection conn = Mysqlconnect.ConnectDb();
           PreparedStatement pst;
            String value1 = matgrptxt.getText();
            String value2 = nomgrptxt.getText();
            String value3 = dategrptxt.getText();
            String value4 = nbrgrptxt.getText();
            
           
            
            
 String grp = "Update groupes set matricule='"+value1+"',nom='"+value2+"',"
                    + "datecreation='"+value3+"',nbretu='"+value4+"' where nom= '"+value2+"'";

            pst = conn.prepareStatement(grp);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Modification réussie ");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        matgrptxt.setText("");
        nomgrptxt.setText("");
        dategrptxt.setText("");
        nbrgrptxt.setText("");
        
     

    }

    
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
