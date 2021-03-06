/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversorfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Maxi
 */
public class ConversorFX extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/FXMLConversor.fxml"));
        
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Conversor");
        stage.setResizable(false);
        stage.show();
        
        Image ico = new Image(ConversorFX.class.getResourceAsStream("resource/temp.jpg"));
        stage.getIcons().add(ico);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
