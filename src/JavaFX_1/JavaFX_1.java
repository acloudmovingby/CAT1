/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFX_1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Chris
 */
public class JavaFX_1 extends Application {
    static Fxml_1Controller myControllerHandle;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FXML TableView Example");
       
        /*
//Set up instance instead of using static load() method
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        
        //Now we have access to getController() through the instance... don't forget the type cast
        myControllerHandle = (Fxml_1Controller)loader.getController();
         */
       
        Pane myPane = (Pane) FXMLLoader.load(getClass().getResource("fxml_1.fxml"));
        Scene myScene = new Scene(myPane);
        
        myScene.getStylesheets().add(getClass().getResource("fxml_1.css").toExternalForm());
        primaryStage.setScene(myScene);
        primaryStage.show();
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
<columns>
            <TableColumn fx:id="thaiColumn"  text="Thai" prefWidth="100">
               
            </TableColumn>
            <TableColumn text="English" prefWidth="100">
                
            </TableColumn>
        </columns> 
*/