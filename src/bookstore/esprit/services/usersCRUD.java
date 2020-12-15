/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.services;

import bookstore.esprit.entities.Livre;
import bookstore.esprit.entities.Users;
import bookstore.esprit.entities.Achats;
import bookstore.esprit.tests.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oussema
 */
public class usersCRUD {

    Connection cnx;

    public Boolean inscrire(Users u) {
        Boolean test = false;
        try {
//            String requete ="INSERT INTO personne(nom,prenom)"
//                    + " VALUES ('"+p.getNom()+"','"+p.getPrenom()+"')";
            String requete = "INSERT INTO users(nom,prenom,email,password,date_dinscription,auteur_préféré,genre_préféré,statut)"
                    + " VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete);
            pst.setString(1, u.getNom());
            pst.setString(2, u.getPrenom());
            pst.setString(3, u.getEmail());
            pst.setString(4, u.getPassword());
            pst.setDate(5, (Date) u.getDate_dinscription());
            pst.setString(6, u.getAuteur_préféré());
            pst.setString(7, u.getGenre_préféré());
            pst.setString(8, u.getStatut());           
            pst.executeUpdate();
            System.out.println("utilisateur ajouté !");
            test = true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return test;
    }

    public void modifier_PW(Users u, String pwd) {
        if (authentifier(u.getEmail(), u.getPassword())) {
            try {
                String requete = "UPDATE users set password=? WHERE email=? and password=?";
                PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete);
                pst.setString(1, pwd);
                pst.setString(2, u.getEmail());
                pst.setString(3, u.getPassword());
                pst.executeUpdate();
                System.out.println("password modifié !");
                pst.close();
            } catch (SQLException ex) {

                System.out.println(ex.getMessage());
            }
        } else {
            System.out.println("Mr " + u.getNom() + " vous n'etes pas inscrit");
        }
    }

    public Boolean authentifier(String email, String pwd) {
        Boolean test = false;
        String requete = "select nom, prenom, email,password, auteur_préféré, genre_préféré, statut,date_dinscription from users where email=? and password =?";

        try {
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete);
            pst.setString(1, email);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {                                                                  
        return (rs.getString(4).equals(pwd) && rs.getString(3).equals(email));
                 //u = new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7) , rs.getDate(8));
             //  Global.GlobalClass.setCurrentUser(u);
 //               Global.GlobalClass.setCurrentUser();
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return test;
    }

    public void Modifier_données_personnelle(Users u) {
        String requete = "UPDATE users set nom=?, prenom=?,auteur_préféré=?,genre_préféré=?,statut=? WHERE password=? and email=?";

        if (this.authentifier(u.getEmail(), u.getPassword())) {
            try {
                PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete);
                pst.setString(1, u.getNom());
                pst.setString(2, u.getPrenom());
                pst.setString(3, u.getAuteur_préféré());
                pst.setString(4, u.getGenre_préféré());
                pst.setString(5, u.getStatut());
                pst.setString(6, u.getPassword());
                pst.setString(7, u.getEmail());
                pst.executeUpdate();
                System.out.println("Personne Modifié !");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            System.err.println("vous n'étes pas " + u.getNom() + " ?");
        }
    }

    public List<Users> consulter_données_personnelles(String email, String pwd) {
        List<Users> userData = new ArrayList();
        String message = "";
        String requete = "SELECT nom,prenom,email,date_dinscription,auteur_préféré,genre_préféré,statut,id_user FROM users where email=? and password=?";
        if (authentifier(email, pwd)) {
            try {
                PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete);
                pst.setString(1, email);
                pst.setString(2, pwd);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    Users user = new Users();
                    user.setNom(rs.getString(1));
                    user.setPrenom(rs.getString(2));
                    user.setEmail(rs.getString(3));
                    user.setDate_dinscription(rs.getDate(4));
                    user.setAuteur_préféré(rs.getString(5));
                    user.setGenre_préféré(rs.getString(6));
                    user.setStatut(rs.getString(7));
                    message = " nom :" + rs.getString(1) + "\n prenom :" + rs.getString(2) + "\n email :" + rs.getString(3) + "\n date d'inscription :" + rs.getString(4)
                            + "\n auteur préféré :" + rs.getString(5) + "\n genre préféré :" + rs.getString(6) + "\n Statut :" + rs.getString(7)
                            + "\n id :" + rs.getInt(8);
                    userData.add(user);
                }
            } catch (SQLException ex) {
                ex.getMessage();
            }
        } else {
            System.out.println("vous n'êtes pas encore inscrit !");
        }
        return userData;
    }
public Users getUser(String email){
    String requete = "select * from users where email =?";
    Users user = new Users() ;
        try {            
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                  
                    user.setNom(rs.getString(1));
                    user.setPrenom(rs.getString(2));
                    user.setEmail(rs.getString(3));
                    user.setDate_dinscription(rs.getDate(4));
                    user.setAuteur_préféré(rs.getString(6));
                    user.setGenre_préféré(rs.getString(5));
                    user.setStatut(rs.getString(7));
                  //  user.setId_user(rs.getInt(8));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

return user;}
    public Map<Achats, Livre> consulterHistorique(Users u) {
        Map<Achats, Livre> myList = new HashMap<Achats, Livre>();
        try {
            String requete = "select a.id_achat_user, l.titre,l.auteur,a.prix_dachat,a.date_achat "
                    + "from livres l join achats a "
                    + "on l.id_livre = a.id_achat_livre ";
            Statement st = new MyConnection().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                if (rs.getInt(1) == u.getId_user()) {
                    Livre li = new Livre();
                    Achats l = new Achats();
                    l.setId_achat_user(rs.getInt(1));
                    li.setTitle(rs.getString(2));
                    li.setAuteur(rs.getString(3));
                    l.setPrix_dachat(rs.getFloat(4));
                    l.setDate_achat(rs.getDate(5));
                    myList.put(l, li);
                    System.out.println("\n");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;

    }

    public boolean exist(String email) {
         boolean ishere = false;
        try {           
            String requete = "Selelect * from users where email=?";
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete);
            pst.setString(1, email);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) ishere = true;
        } catch (SQLException ex) {
   ex.getMessage();
        }
   return ishere; }

}

//    public void ajouterUser(Users u){
//        try{
//            String requete="INSERT INTO Users (nom,prenom,email,password,date_dinscription,auteur_préféré,"
//                    + "genre_préféré,statut) "
//                + "VALUES(?,?,?,?,?,?,?,?)";
//        PreparedStatement pst = new MyConnexion().getCnx().prepareStatement(requete);
//        pst.setString(1,u.getNom());
//        pst.setString(2,u.getPrenom());
//        pst.setString(3,u.getEmail());
//        pst.setString(4,u.getPassword());
//        pst.setDate(5, (Date)u.getDate_dinscription());
//        pst.setString(6,u.getAuteur_préféré());
//        pst.setString(7,u.getGenre_préféré());
//        pst.setString(8,u.getStatut());
//        
//        pst.executeUpdate();
//            System.out.println("user "+ u.getNom()+"ajouté");
//        }catch(SQLException ex){
//            System.out.println(ex.getMessage());
//        }

