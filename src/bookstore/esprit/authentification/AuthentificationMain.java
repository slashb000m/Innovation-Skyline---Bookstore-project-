/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.authentification;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Oussema
 */
public class AuthentificationMain extends Application {

    @Override
    public void start(Stage primaryStage2) {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("AuthentificationInterface.fxml"));
            Scene scene = new Scene(root);
            primaryStage2.setTitle("Authentification");
            primaryStage2.setScene(scene);
            primaryStage2.show();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
