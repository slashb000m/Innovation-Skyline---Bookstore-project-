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
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class AccueilController implements Initializable {

    @FXML
    private TextField search;

    @FXML
    private Button btnsearch;

    @FXML
    private TilePane tilePane;

   private int nRows = 3;  //no of row for tile pane
    private int nCols = 3;
    int count = 0;
    File filesJpg[];
    private static final double ELEMENT_SIZE = 150;
    private static final double GAP = ELEMENT_SIZE / 17;
    ObservableList<Livre> bookList = FXCollections.observableArrayList();
 
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
        createElements(bookList);


    }

       private void createElements(ObservableList<Livre> bookList) {
tilePane.getChildren().clear();
        for (int j = 1; j < bookList.size(); j++) {
            tilePane.getChildren().add(createPage(count, this.bookList.get(j).getImage()  , this.bookList.get(j).getTitre(), this.bookList.get(j).getIdentifiant(), this.bookList.size(), this.bookList.get(j).getPrix(),this.bookList.get(j).getDescription()));
            count++;        }
    }

    
       public VBox createPage(int index, String imageUrl, String bookLabel, int bookId, int size, double price, String descripion) {
        ImageView imageView = new ImageView();
        try {
            InputStream stream = new FileInputStream(imageUrl);
            Image image = new Image(stream);
           
            imageView.setFitWidth(ELEMENT_SIZE);
            imageView.setFitHeight(ELEMENT_SIZE);
            imageView.setClip(null);
            imageView.setTranslateY(10);
            imageView.setEffect(new DropShadow(20,javafx.scene.paint.Color.BLACK));
            imageView.setSmooth(true);
            imageView.setCache(true);
            imageView.setImage(image);
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
