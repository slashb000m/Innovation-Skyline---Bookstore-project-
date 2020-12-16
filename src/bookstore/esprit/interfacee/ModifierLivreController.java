/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.interfacee;

import bookstore.esprit.entities.Livre;
import bookstore.esprit.services.LivreCRUD;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.omg.PortableInterceptor.INACTIVE;
import test.MyConnexion;

   

/**
 * FXML Controller class
 *
 * @author Alia
 */
public class ModifierLivreController implements Initializable {
     @FXML
    private TableView<Livre> table;

    @FXML
    private TableColumn<Livre, Integer> id;

    @FXML
    private TableColumn<Livre, String> titre;

    @FXML
    private TableColumn<Livre, String> auteur;

    @FXML
    private TableColumn<Livre, String> categorie;

    @FXML
    private TableColumn<Livre, String> description;

    @FXML
    private TableColumn<Livre, String> type;

    @FXML
    private TableColumn<Livre, Float> price;

    @FXML
    private TableColumn<Livre, Integer> nombre;

    @FXML
    private TableColumn<Livre, ?> date;
    @FXML
    private TextField tid;

    @FXML
    private TextField ttitre;

    @FXML
    private TextField tauthor;

    @FXML
    private TextField tcatg;

    @FXML
    private TextField tdesc;

    @FXML
    private TextField ttype;

    @FXML
    private TextField tprix;

    @FXML
    private TextField tnombrep;

    @FXML
    private TextField tdate;
    ObservableList<Livre> list = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           try {
            String requete = "SELECT identifiant , titre ,auteur ,catégorie , description  ,typelivre,prix,nombre_page  ,date_sortie FROM livre";
            Statement st = new MyConnexion().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Livre l = new Livre();

                list.add(new Livre(rs.getInt("identifiant"), rs.getString("titre"), rs.getString("auteur"), rs.getString("catégorie"), rs.getString("description"),rs.getString("typelivre"),rs.getFloat("prix"),rs.getInt("nombre_page"),rs.getDate("date_sortie")));

                System.out.println("\n");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        // TODO
         id.setCellValueFactory(new PropertyValueFactory<>("identifiant"));
        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        auteur.setCellValueFactory(new PropertyValueFactory<>("auteur"));
        categorie.setCellValueFactory(new PropertyValueFactory<>("catégorie"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        type.setCellValueFactory(new PropertyValueFactory<>("typelivre"));
        price.setCellValueFactory(new PropertyValueFactory<>("prix"));
        nombre.setCellValueFactory(new PropertyValueFactory<>("nombre_page"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        table.setItems(list);
    } 
     @FXML
    private void getselected(MouseEvent event) {
        Livre l = table.getSelectionModel().getSelectedItem();
        tid.setText(String.valueOf(l.getIdentifiant()));
         ttitre.setText(l.getTitre());
        tauthor.setText(l.getAuteur());
        tcatg.setText(l.getCatégorie());
        tdesc.setText(l.getDescription());
        tprix.setText(String.valueOf(l.getPrix()));
        ttype.setText(l.getTypelivre());
        tnombrep.setText(String.valueOf(l.getNombre_page()));
        tdate.setText(String.valueOf(l.getDate()));
        
        
    }
    @FXML
    private void ModifierLivre(Event event){
    int ident=Integer.parseInt(tid.getText());
    float prix= Float.parseFloat(tprix.getText());
    String titre = ttitre.getText();
    String auteur =tauthor.getText();
    String des = tdesc.getText() ;
    String type = ttype.getText();
    String  catg = tcatg.getText();
       java.sql.Date sqlDate = java.sql.Date.valueOf(tdate.getText());
    int  nombre= Integer.parseInt(tnombrep.getText());
       try {
    Livre l=new Livre(ident,auteur,titre,catg,des,type,prix,nombre,sqlDate);
    LivreCRUD lc= new LivreCRUD();
    lc.modifierLivre(l,ident);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
