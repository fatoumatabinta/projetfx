
package schoolmgmproject;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Nomad Soul
 */
public class Schoolmgmproject extends Application {
    
    @Override
   public void start(Stage primaryStage) throws IOException{
   Parent content= FXMLLoader.load(getClass().getResource("schoolmgmproject.fxml"));
  
   Scene scene= new Scene(content,640,480);
   primaryStage.setScene(scene);
   primaryStage.show();
   
   
   }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
