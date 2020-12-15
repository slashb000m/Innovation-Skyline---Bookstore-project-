/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.authentification;

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
public class ChangePwdInterface extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root;

        try {
            root = FXMLLoader.load(getClass().getResource("ChangePwd.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("CHANGE PASSWORD");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) {
               launch(args);
    }
         
}
