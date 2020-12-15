/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;


import bookstore.esprit.entities.Livre;
import bookstore.esprit.services.LivreCRUD;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class PageAccueilController  implements Initializable{
   
     @FXML
    private TextField search;

    @FXML
    private Button btnsearch;

    @FXML
    private ImageView image1;
    @FXML
    private TilePane tilePane;
    
    
    
    
private int nRows = 3;  //no of row for tile pane
    private int nCols = 3;
    int count = 0;
    File filesJpg[];
    private static final double ELEMENT_SIZE = 150;
    private static final double GAP = ELEMENT_SIZE / 17;
    ObservableList<Livre> bookList = FXCollections.observableArrayList();
    
    
    private void createElements(ObservableList<Livre> bookList) {
    tilePane.getChildren().clear();
        for (int j = 0; j < bookList.size(); j++) {
         tilePane.getChildren().add(createPage(count, bookList.get(j).getImage(), bookList.get(j).getTitre(), bookList.get(j).getIdentifiant(), bookList.get(j).getPrix(),bookList.get(j).getDescription()));
            count++;
        }
        }    
    
    
    @Override
     public void initialize(URL location, ResourceBundle resources) {
     
        tilePane.setPrefColumns(nCols);
        tilePane.setPrefRows(nRows);
        tilePane.setHgap(GAP);
        tilePane.setVgap(GAP);
        LivreCRUD bs = new LivreCRUD();
        bs.readBooks(bookList);
        System.out.println(bookList);
        nRows = bookList.size() / 3;
        System.out.println(nRows);
        System.out.println(bookList);
        createElements(bookList);
        
        
}

    
    
    
    

 public VBox createPage(int index, String imageUrl, String bookLabel, int bookId, double price, String descripion) {
        ImageView imageView = new ImageView();
        try {
            InputStream stream = new FileInputStream(imageUrl);
            Image image = new Image(stream);
            imageView.setImage(image);
            imageView.setFitWidth(ELEMENT_SIZE);
            imageView.setFitHeight(ELEMENT_SIZE);
            imageView.setClip(null);
            imageView.setTranslateY(10);
            imageView.setEffect(new DropShadow(20,javafx.scene.paint.Color.BLACK));
            imageView.setSmooth(true);
            imageView.setCache(true);
            imageView.setOnMouseClicked((MouseEvent event) -> {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../interfacee/InterfaceLivre.fxml"));
                    Parent root3 = loader.load();
                     InterfaceLivreController ilc = loader.getController();
                    System.out.println(bookLabel + String.valueOf(price) + descripion + imageUrl);
                    ilc.setTexts(bookLabel, String.valueOf(price), descripion, imageUrl);
         
                    Stage stage = new Stage();
                     Scene scene = new Scene(root3);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
              
                }
            });
        } catch (IOException ex) {
        ex.getMessage();
        }
        VBox pageBox = new VBox();
        pageBox.getChildren().add(imageView);

        return pageBox;
    

    
 }   
    
}
