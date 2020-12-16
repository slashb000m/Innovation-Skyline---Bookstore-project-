/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Alia
 */
public class MainDesign extends Application {
    
        @Override
    public void start(Stage primaryStage) {
        Parent root=null;
        try {
            root = FXMLLoader.load(getClass().getResource("MainDesign.fxml"));
         
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
      
        
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
     
     
      
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
