/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.services;

import bookstore.esprit.entities.Livre;
import bookstore.esprit.entities.souhaits;
import bookstore.esprit.entities.users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;
import test.MyConnexion;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Dhia
 */
public class souhaitsCRUD {

    Connection cnx;
    static ObservableList<Livre> list = FXCollections.observableArrayList();
    static ObservableList<users> list1 = FXCollections.observableArrayList();

    public void ajouterSouhaits(souhaits s) {
        cnx = MyConnexion.getInstance().getCnx();
        try {
            String requete = "INSERT INTO souhaits(id_souhait_livre ,id_souhait_user)"
                    + "VALUES (?,?) ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, s.getId_souhait_livre());
            pst.setInt(2, s.getId_souhait_user());
            pst.executeUpdate();
            System.out.println("souhait ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
    }

    public boolean supprimerSouhaits(users u, Livre L ) {
        boolean etat;
        try {
            String requete = "DELETE FROM souhaits WHERE id_souhait_livre=? and id_souhait_user=? ";
            PreparedStatement pst = cnx.prepareStatement(requete);

            pst.setInt(1, L.getIdentifiant());
            pst.setInt(2, u.getId_user());
            pst.executeUpdate();
            System.out.println("souhaits supprimée");
            etat = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            etat = false;
        }
        return etat;

    }

    public HashMap<Livre, users> listerSouhaits(users u) {
        HashMap<Livre, users> m = new HashMap<Livre, users>();

        String requete = "SELECT l.id_livre,l.titre, l.description , u.prenom, u.nom , u.id_user FROM users u "
                + " JOIN souhaits s ON s.id_souhait_user = u.id_user "
                + "JOIN livres l ON s.id_souhait_livre=l.id_livre";
        try {

//            PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(requete);
            Statement st = new MyConnexion().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                if (u.getId_user() == (rs.getInt("u.id_user"))) {

//                pr.setIdentifiant(rs.getInt(1));
//                pr.setTitle(rs.getString("titre"));
//                pr.setDescription(rs.getString("description"));
//                y.setPrenom(rs.getString("prenom"));
//                y.setNom(rs.getString("nom"));
//                y.setId_user(rs.getInt("id_user"));
//                
                    list1.add(new users(rs.getInt("id_user"), rs.getString("nom"), rs.getString("prenom")));
                    list.add(new Livre(rs.getInt("id_livre"), rs.getString("titre"), rs.getString("description")));
                }
                for (int i = 0; i < list.size(); i++) {
                    m.put(list.get(i), list1.get(i));
                }}
                }catch (SQLException ex) {
                        System.out.println(ex.getMessage());
         
        }

           return m; }

        }
