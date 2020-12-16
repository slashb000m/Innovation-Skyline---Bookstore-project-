/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import bookstore.esprit.entities.souhaits;
import bookstore.esprit.services.souhaitsCRUD;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class InterfaceLivreController implements Initializable {
    @FXML
    private AnchorPane anchorpane;

    @FXML
    private TextField description;

    @FXML
    private ImageView imageViewLivre;

    @FXML
    private Button AcheterLivre;

    @FXML
    private Button Ajout_souhait;

    @FXML
    private TextField titre;

    @FXML
    private TextField prix;
   

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

        
//    public void setTexts(String s1,String s2,String s3 , String s4)
//    {
//        InputStream stream = null;
//        try {
//            this.titre.setText(s1);
//            this.prix.setText(s2);
//            this.description.setText(s3);
//            //image
//            stream = new FileInputStream(s4);
//            Image image = new Image(stream);
//            this.imageViewLivre.setImage(image);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(InterfaceLivreController.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                stream.close();
//            } catch (IOException ex) {
//                Logger.getLogger(InterfaceLivreController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
    


public void setTexts(String s1,String s2,String s3 , String s4)
    {
        InputStream stream = null;
        try {
            this.titre.setText(s1);
            this.prix.setText(s2);
            this.description.setText(s3);
            //image
            stream = new FileInputStream(s4);
            Image image = new Image(stream);
            this.imageViewLivre.setImage(image);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterfaceLivreController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stream.close();
            } catch (IOException ex) {
                Logger.getLogger(InterfaceLivreController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}