/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Alia
 */
public class MainDesignController implements Initializable {
@FXML
    private VBox vbox;
private Parent fxml;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         TranslateTransition t = new TranslateTransition(Duration.seconds(1), vbox);
        //t.setToX(vbox.getLayoutX() * 20);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("AjouterLivree.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ex){
                
            }
        });
    }  
    @FXML
      private void open_addbook(ActionEvent event){
          TranslateTransition t = new TranslateTransition(Duration.seconds(0.2), vbox);
        t.setToX(vbox.getLayoutX() *0);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("AjouterLivree.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ex){
                
            }
        });
    } 
      @FXML
    private void open_deletebook(ActionEvent event){
      TranslateTransition t = new TranslateTransition(Duration.seconds(0.2), vbox);
        t.setToX(vbox.getLayoutX() *0);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("SupprimerLivre.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ex){
                
            }
        });
    } 
      @FXML
    private void open_modifybook(ActionEvent event){
      TranslateTransition t = new TranslateTransition(Duration.seconds(0.2), vbox);
        t.setToX(vbox.getLayoutX() *0);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("ModifierLivre.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ex){
                
            }
        });
    } 
  

    @FXML
    private void openSearchbook(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(0.2), vbox);
        t.setToX(vbox.getLayoutX() *0);
        t.play();
        t.setOnFinished((e) ->{
            try{
                fxml = FXMLLoader.load(getClass().getResource("ChercherLivres.fxml"));
                vbox.getChildren().removeAll();
                vbox.getChildren().setAll(fxml);
            }catch(IOException ex){
                
            }
        });
    }
    
}
