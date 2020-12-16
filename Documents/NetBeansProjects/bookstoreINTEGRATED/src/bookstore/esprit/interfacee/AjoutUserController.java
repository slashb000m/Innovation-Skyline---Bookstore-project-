/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import bookstore.esprit.entities.Users;
import bookstore.esprit.services.UsersCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Alia
 */
public class AjoutUserController implements Initializable {

    ObservableList<String> StatutList = FXCollections.observableArrayList("Etudiant", "Professionnel", "Amateur");
    ObservableList<String> AuteurList = FXCollections.observableArrayList("Victor Hugo", "Tawfiq Al-Hakim", "Lewis Caroll");
    ObservableList<String> GenreList = FXCollections.observableArrayList("Roman", "Sci-Fi", "Horreur", "Comédie");
    @FXML
    private Button Ajoutbutt;
    @FXML
    private TextField Nom;
    @FXML
    private TextField Prenom;
    @FXML
    private TextField Email;
    @FXML
    private TextField Password;
    @FXML
    private ComboBox AuteurPrefere;
    @FXML
    private ComboBox GenrePrefere;
    @FXML
    private ComboBox Statut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Statut.setValue("Etudiant");
        Statut.setItems(StatutList);

        AuteurPrefere.setValue("Victor Hugo");
        AuteurPrefere.setItems(AuteurList);

        GenrePrefere.setValue("Sci-Fi");
        GenrePrefere.setItems(GenreList);

    }

    @FXML
    private void AjoutUser(Event event) {

        try {
            String nom = Nom.getText();
            String prenom = Prenom.getText();
            String email = Email.getText();
            String password = Password.getText();
            String statut = (String) Statut.getValue();
            String auteur = (String) AuteurPrefere.getValue();
            String genre = (String) GenrePrefere.getValue();
            

            Users u1 = new Users(nom, prenom, email, password, auteur, genre, statut);
            UsersCRUD userAdder = new UsersCRUD();
            userAdder.ajouterUser(u1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    private Button goBack;
    @FXML
    void redirectList(ActionEvent event) {
                try {
            System.out.println("-----reirection-----");
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("ListUsers.fxml"));
            Parent root2=Loader.load();
            ListUsersController pc2=Loader.getController();
            goBack.getScene().setRoot(root2);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

}
