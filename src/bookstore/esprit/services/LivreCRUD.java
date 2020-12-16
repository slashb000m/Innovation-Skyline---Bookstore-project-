/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.services;

import bookstore.esprit.entities.Livre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import org.omg.CORBA_2_3.portable.InputStream;
import test.MyConnexion;

/**
 *
 * @author Alia
 */
public class LivreCRUD {

    Connection cnx;

    public void AjouterLivre(Livre l) {
        try {
            String requete = "INSERT INTO livre (titre,auteur, catégorie,description,typelivre,prix,nombre_page,date_sortie,image,chemin)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?) ";

            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(requete);

            pst.setString(1, l.getTitre());
            pst.setString(2, l.getAuteur());
            pst.setString(3, l.getCatégorie());
            pst.setString(4, l.getDescription());
            pst.setString(5, l.getTypelivre());
            pst.setFloat(6, l.getPrix());
            pst.setInt(7, l.getNombre_page());
            pst.setDate(8, l.getDate());
            pst.setString(9, l.getImage());
            pst.setString(10, l.getChemin());
            pst.executeUpdate();
            System.out.println("livre ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean supprimerLivre(Livre l) {
        boolean etat = false;
        try {
            String requete = "DELETE FROM Livre WHERE identifiant=?";
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(requete);
            pst.setInt(1, l.getIdentifiant());
            pst.executeUpdate();
            System.out.println("livre supprimée");
            etat = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            etat = false;
        }
        return etat;
    }

    public ObservableList<Livre> listerLivre1() {
        ObservableList<Livre> list = null;
        try {
            String requete = "SELECT identifiant , titre ,auteur ,catégorie, description ,typelivre , prix ,nombre_page FROM livre";
            Statement st = new MyConnexion().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Livre l = new Livre();

                list.add(new Livre(rs.getInt("identifiant"), rs.getString("titre"), rs.getString("auteur"), rs.getString("catégorie"), rs.getString("description"), rs.getString("typelivre"), rs.getFloat("prix"), rs.getInt("nombre_page")));

                System.out.println("\n");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public List<Livre> listerLivre() {
        List<Livre> myList = new ArrayList<Livre>();
        try {
            String requete = "SELECT identifiant , titre ,auteur ,catégorie, description ,typelivre , prix ,nombre_page FROM livre";
            Statement st = new MyConnexion().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Livre l = new Livre();

                l.setIdentifiant(rs.getInt(1));
                l.setTitle(rs.getString(2));
                l.setAuteur(rs.getString(3));
                l.setCatégorie(rs.getString(4));
                l.setDescription(rs.getString(5));
                l.setTypelivre(rs.getString(6));
                l.setPrix(rs.getFloat(7));
                l.setNombre_page(rs.getInt(8));
                myList.add(l);

                System.out.println("\n");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;

    }

    public void modifierLivre(Livre l, int id) {
        try {
            String requete = "UPDATE livre SET identifiant=? ,titre=? , auteur=?,catégorie=?,description=?,typelivre=? ,prix=? ,nombre_page=? ,date_sortie=? "
                    + "WHERE identifiant=? ";
            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(requete);

            pst.setInt(1, l.getIdentifiant());
            pst.setString(2, l.getTitre());
            pst.setString(3, l.getAuteur());
            pst.setString(4, l.getCatégorie());
            pst.setString(5, l.getDescription());
            pst.setString(6, l.getTypelivre());
            pst.setFloat(7, l.getPrix());
            pst.setInt(8, l.getNombre_page());
            pst.setDate(9, l.getDate());
            //pst.setInt(8, l.getNombre_page());
           

            pst.setInt(10, id);

            pst.executeUpdate();
            System.out.println("livre modifie");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Livre> chercherLivre() {
        List<Livre> myList = new ArrayList<Livre>();
        try {
            String requete = "SELECT  titre  FROM livre";
            Statement st = new MyConnexion().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {

                Livre l = new Livre();
                l.setTitle(rs.getString("titre"));
                myList.add(l);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;

    }
   

}
