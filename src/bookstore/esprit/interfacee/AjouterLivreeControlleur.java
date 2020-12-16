/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import bookstore.esprit.entities.Livre;
import bookstore.esprit.services.LivreCRUD;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import org.omg.CORBA_2_3.portable.InputStream;
import test.MyConnexion;

/**
 *
 * @author Alia
 */
public class AjouterLivreeControlleur implements Initializable {

    @FXML
    private ImageView image;
    @FXML
    private TextField Atitre;
    @FXML
    private TextField Aauteur;
    @FXML
    private TextField Aprix;
    @FXML
    private TextField aidentifiant;
    @FXML
    private ComboBox<String> type;
    @FXML
    private ComboBox<String> catégoriee;
    @FXML
    private TextField Anombre;
    @FXML
    private TextField Adescription;
    private ListView listview;
  
     @FXML
    private TextField cover_path;
String pathcover;
String pathbook;
    
    @FXML
    private Button btn;
    @FXML
    private Button Ajoutbutt;
    private Image img;
    @FXML
    private DatePicker datesortie;
    @FXML
    private TextField book_path;
     
String s;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        catégoriee.getItems().setAll("Art & Photography", "Biography", "Children's Books", "History & Archaeology", "Science Fiction, Fantasy & Horror", "Mind, Body & Spirit");
        type.getItems().setAll("Livre Numérique", "Livre Audio");
    }
    

    @FXML
    private void AjoutLivre(Event event) {

        try {
            
            String titre = Atitre.getText();
            String auteur = Aauteur.getText();
            java.sql.Date sqlDate = java.sql.Date.valueOf(datesortie.getValue());
            String catégorie = catégoriee.getValue();
            String description = Adescription.getText();
            String typelivre = type.getValue();
            float prix = Float.parseFloat(Aprix.getText());
            int nombre_page = Integer.parseInt(Anombre.getText());

        
            Livre l = new Livre(titre, auteur, catégorie, description, typelivre, prix, nombre_page, sqlDate ,pathcover,pathbook);
            LivreCRUD lc = new LivreCRUD();
            lc.AjouterLivre(l);
            
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajout d'un livre");
            alert.setHeaderText("Succés");
            alert.setContentText("Results: Ce livre  a éte ajoutée");

            alert.showAndWait();
            AnnulerDonnes((ActionEvent) event);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void AnnulerDonnes(ActionEvent event) {
        Atitre.setText("");
        Aauteur.setText("");
        catégoriee.setValue("Category");
        Adescription.setText("");
        Anombre.setText("");
        type.setValue("Type of book");
        Aprix.setText("");
        cover_path.setText("");
        book_path.setText("");
    }

    @FXML
    private void choisirdocument(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            //listview.getItems().add(selectedFile.getAbsolutePath());
           
                 book_path.setText(selectedFile.getAbsolutePath());
            pathbook=selectedFile.getAbsolutePath();

        } else {
            System.out.println("file is not valid");
        }
    }
  

    @FXML
    private void modifierLivre(ActionEvent event) {
        try {
          int  identifiant = Integer.valueOf(aidentifiant.getText());
           String titre = Atitre.getText();
            String auteur = Aauteur.getText();

            java.sql.Date sqlDate = java.sql.Date.valueOf(datesortie.getValue());
            String catégorie = catégoriee.getValue();
            String description = Adescription.getText();
            String typelivre = type.getValue();
            float prix = Float.parseFloat(Aprix.getText());
            int nombre_page = Integer.parseInt(Anombre.getText());
    
    //Livre l=new Livre(identifiant,titre, auteur, catégorie, description, typelivre, prix, nombre_page, sqlDate ,pathcover,pathbook);
    //LivreCRUD lc= new LivreCRUD();
    //lc.modifierLivre(l, identifiant);
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("modification d'un livre");
            alert.setHeaderText("Succés");
            alert.setContentText("Results: Ce livre  a éte modifie");

            alert.showAndWait();
            AnnulerDonnes((ActionEvent) event);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

  

    @FXML
    private void cover_path(ActionEvent event) {
           FileChooser fc = new FileChooser();
       // fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
        File selectedFile = fc.showOpenDialog(null);
         if (selectedFile != null) {
              cover_path.setText(selectedFile.getAbsolutePath());
            pathcover=selectedFile.getAbsolutePath();
            System.out.println( pathcover);
            img = new Image(selectedFile.toURI().toString(), 100, 150, true, true);
            BufferedImage bf;
             try {
                  bf = ImageIO.read(selectedFile);
                Image img = SwingFXUtils.toFXImage(bf, null);
                image.setImage(img);
             } catch (Exception e) {
             }
         }
         else{
               System.out.println("file is not valid");
         }
        
    }
     
            
            
            
            
           

   
}
