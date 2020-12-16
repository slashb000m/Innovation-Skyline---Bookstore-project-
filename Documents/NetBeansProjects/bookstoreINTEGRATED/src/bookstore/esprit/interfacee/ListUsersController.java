/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import bookstore.esprit.entities.Users;
import bookstore.esprit.services.UsersCRUD;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import test.MyConnexion;

/**
 * FXML Controller class
 *
 * @author Alia
 */
public class ListUsersController implements Initializable {

    @FXML
    private TableView<Users> table;
    @FXML
    private TableColumn<Users, String> col_nom;
    @FXML
    private TableColumn<Users, String> col_prenom;
    @FXML
    private TableColumn<Users, String> col_email;
    @FXML
    private TableColumn<Users, String> col_statut;
    @FXML
    private TableColumn<Users, Integer> col_id_user;
    @FXML
    private TableColumn<Users, String> col_banned;
    @FXML
    private Button redAjout;
//    @FXML
    //  private TableColumn<User, String> col_action;

    ObservableList<Users> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            String requete = "SELECT * FROM users";
            Statement st = new MyConnexion().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                oblist.add(new Users(rs.getInt("id_user"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("statut"),rs.getString("banned")));

            }
            System.out.println(oblist);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        col_id_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        col_banned.setCellValueFactory(new PropertyValueFactory<>("banned"));
        
//col_action.setCellValueFactory(new PropertyValueFactory<>("action"));
        table.setItems(oblist);
        table.setEditable(true);
        col_nom.setCellFactory(TextFieldTableCell.forTableColumn());
        col_prenom.setCellFactory(TextFieldTableCell.forTableColumn());
        col_email.setCellFactory(TextFieldTableCell.forTableColumn());
        col_statut.setCellFactory(TextFieldTableCell.forTableColumn());
        col_banned.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    public void onEditChangedNom(TableColumn.CellEditEvent<Users, String> userStringCellEditEvent) {
        Users user = table.getSelectionModel().getSelectedItem();
        user.setNom(userStringCellEditEvent.getNewValue());
        UsersCRUD modUser = new UsersCRUD();
        modUser.modifierUserNom(user.getId_user(), user.getNom());

    }

    public void onEditChangedPrenom(TableColumn.CellEditEvent<Users, String> userStringCellEditEvent) {
        Users user = table.getSelectionModel().getSelectedItem();
        user.setPrenom(userStringCellEditEvent.getNewValue());
        UsersCRUD modUser = new UsersCRUD();
        modUser.modifierUserPrenom(user.getId_user(), user.getPrenom());

    }
    public void onEditChangedEmail(TableColumn.CellEditEvent<Users, String> userStringCellEditEvent) {
        Users user = table.getSelectionModel().getSelectedItem();
        user.setEmail(userStringCellEditEvent.getNewValue());
        UsersCRUD modUser = new UsersCRUD();
        modUser.modifierUserEmail(user.getId_user(), user.getEmail());

    }
    public void onEditChangedStatut(TableColumn.CellEditEvent<Users, String> userStringCellEditEvent) {
        Users user = table.getSelectionModel().getSelectedItem();
        user.setStatut(userStringCellEditEvent.getNewValue());
        UsersCRUD modUser = new UsersCRUD();
        modUser.modifierUserStatut(user.getId_user(), user.getStatut());
        
    }
    public void onEditChangedBanned(TableColumn.CellEditEvent<Users, String> userStringCellEditEvent) {
        Users user = table.getSelectionModel().getSelectedItem();
        user.setBanned(userStringCellEditEvent.getNewValue());
        UsersCRUD modUser = new UsersCRUD();
        int ban = Integer.parseInt(user.getBanned());
        modUser.modifierUserBanned(user.getId_user(), ban);
        
    }
    
        @FXML
    private void redirectAjout(ActionEvent event) {
        try {
            System.out.println("-----reirection-----");
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("AjoutUser.fxml"));
            Parent root2=Loader.load();
            AjoutUserController pc2=Loader.getController();
            redAjout.getScene().setRoot(root2);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    @FXML
    private Button btnBack;
    @FXML
    void RedirectPannel(ActionEvent event) {
        try {
            System.out.println("-----reirection-----");
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("PannelAdmin.fxml"));
            Parent root2=Loader.load();
            PannelAdminController pc2=Loader.getController();
            redAjout.getScene().setRoot(root2);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
       
    }
    
    
}
