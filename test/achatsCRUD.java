/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import bookstore.esprit.entities.Livre;
import bookstore.esprit.entities.souhaits;
import bookstore.esprit.entities.users;
import static bookstore.esprit.services.souhaitsCRUD.list1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import test.MyConnexion;

/**
 *
 * @author Dhia
 */
public class achatsCRUD {
     Connection cnx;
    static ObservableList<Livre> list = FXCollections.observableArrayList();
    static ObservableList<users> list1 = FXCollections.observableArrayList();

    public void ajouterAchats(Livre l, users u) {
        cnx = MyConnexion.getInstance().getCnx();
        java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqldate = new java.sql.Date(utilDate.getTime());
        try {
            String requete = "INSERT INTO achats (prix_dachat,id_achat_livre,id_achat_user,date_achat)"
                    + "VALUES (?,?,?,?) ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setFloat(1, l.getPrix());
            pst.setInt(2, u.getId_user());
            pst.setInt(3, l.getIdentifiant());
            pst.setDate(4, sqldate);
            pst.executeUpdate();
            System.out.println("achat ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
    }
    
    
    public HashMap<Livre, users> listerAchat(users u, Livre l)
    {
    
        HashMap<Livre, users> m = new HashMap();

        String requete = "SELECT u.id_user , a.id_achat , l.prix, a.id_achat_livre, a.date_achat , l.description ,l.titre, l.auteur , u.nom ,u.prenom from achats a "
                + "JOIN users u ON a.id_achat_user = u.id_user JOIN livres l ON a.id_achat_livre=l.id_livre";
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
                    list.add(new Livre( rs.getString("titre"), rs.getString("auteur"), rs.getString("description"),rs.getFloat("prix")));
                }
                for (int i = 0; i < list.size(); i++) {
                    m.put(list.get(i), list1.get(i));
                }}
                }catch (SQLException ex) {
                        System.out.println(ex.getMessage());
         
        }

           return m; }
    

        
    
    }



