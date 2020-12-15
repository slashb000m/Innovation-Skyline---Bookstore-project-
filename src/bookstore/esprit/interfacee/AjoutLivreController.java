/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import bookstore.esprit.entities.Livre;
import bookstore.esprit.services.LivreCRUD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Alia
 */
public class AjoutLivreController implements Initializable {
    @FXML
    private Button Ajoutbutt;
    @FXML
    private TextField Aid;
     @FXML
    private TextField Atitre;
    @FXML
    private TextField Aauteur;
    @FXML
    private TextField Acategorie;
    @FXML
    private TextArea Adescription;
    @FXML
    private TextField Atype;
    @FXML
    private TextField Aprix;
    @FXML
    private TextField Anombre;
    private String image;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    @FXML
    private void AjoutLivre(Event event){
    
        try {
            String identifiant = Aid.getText();
    String titre = Atitre.getText();
    String auteur = Aauteur.getText();
    String catégorie=Acategorie.getText();
    String description=Adescription.getText();
    String typelivre = Atitre.getText();
  
    float prix = Float.parseFloat(Aprix.getText());
    int nombre_page =Integer.parseInt(Anombre.getText());
    Livre l= new Livre(titre,  auteur,  catégorie,  description,  typelivre,  prix,  nombre_page,  image1) ;
    LivreCRUD lc= new LivreCRUD();
    lc.AjouterLivre(l);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
