/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.mainInterface;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Oussema
 */
public class PersonnalData extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent personsData;
            personsData = FXMLLoader.load(getClass().getResource("../mainInterface/PersonnalDataInterface.fxml"));
            Scene scene = new Scene(personsData);
            primaryStage.setTitle("Your Personnal Data");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            ex.getMessage();
        }

    }
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
