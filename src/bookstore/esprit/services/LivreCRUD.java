package bookstore.esprit.services;

import bookstore.esprit.entities.Livre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import java.util.logging.Logger;
import javafx.collections.ObservableList;
import test.MyConnexion;

/**
 *
 * @author Alia
 */
public class LivreCRUD {

    static Connection cnx;

    public void AjouterLivre(Livre l) {
        try {
            /*String requete = "INSERT INTO livre(identifiant,titre,auteur, catégorie,description,typelivre,prix,nombre_page)"
                    +"VALUES ('"+l.getIdentifiant()+"','"+l.getTitre()+"', '"+l.getAuteur()+"','"+l.getCatégorie()+"','"+l.getDescription()+"','"+l.getTypelivre()+"','"+l.getPrix()+"','"+l.getNombre_page()+"') ";*/
            String requete = "INSERT INTO livres(id_livre,titre,auteur, categorie,description,type,prix,nbr_pages)"
                    + "VALUES (?,?,?,?,?,?,?,?) ";

            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(requete);
            pst.setInt(1, l.getIdentifiant());
            pst.setString(2, l.getTitre());
            pst.setString(3, l.getAuteur());
            pst.setString(4, l.getCatégorie());
            pst.setString(5, l.getDescription());
            pst.setString(6, l.getTypelivre());
            pst.setFloat(7, l.getPrix());
            pst.setInt(8, l.getNombre_page());
            pst.executeUpdate();
            System.out.println("livre ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void readBooks(ObservableList<Livre> bookList) {
        try {
            String req = "select * from livres";
            Statement st = new MyConnexion().getCnx().createStatement();
            ResultSet res = st.executeQuery(req);
            Livre b;
            while (res.next()) {
                b = new Livre();
                b.setTitle(res.getString("titre"));
                b.setPrix(res.getInt("prix"));
                b.setDescription(res.getString("description"));
                b.setAuteur(res.getString("auteur"));
                b.setCatégorie(res.getString("categorie"));
                b.setImage(res.getString("image"));
                b.setPrix(res.getFloat("prix"));
                b.setIdentifiant(res.getInt("id_livre"));
                bookList.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}