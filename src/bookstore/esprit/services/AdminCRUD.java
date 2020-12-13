/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.services;

import bookstore.esprit.DAO.ListeReclamtionDAO;
import bookstore.esprit.Mailing.JavaMailUtil;
import bookstore.esprit.entities.Reclamations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.MyConnexion;

/**
 *
 * @author Legion
 */
public class AdminCRUD {
    Connection cnx;

    public AdminCRUD() {
        cnx = MyConnexion.getInstance().getCnx();
    }
    
   public void supprimerReclamation(Reclamations r){
       try {
            String requete = "DELETE FROM reclamations where reclamation_id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, r.getId());
            pst.executeUpdate();
            System.out.println("Reclamation supprimé ");
           
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
        
    }
   public ArrayList<ListeReclamtionDAO> afficherReclamations(){
        ArrayList<ListeReclamtionDAO> listeReclamations = new ArrayList<>();
       try {
         
           String requete = "SELECT reclamation_id,email, titre,texte from users u join reclamations r on u.id_user=r.user_reclamation_id";
           Statement st = cnx.prepareStatement(requete);
           ResultSet sr = st.executeQuery(requete);
           while(sr.next()){
               ListeReclamtionDAO r = new ListeReclamtionDAO();
               r.setId(sr.getInt(1));
               r.setMail(sr.getString(2));
               r.setTitre(sr.getString(3));
               r.setDescription(sr.getString(4));
               listeReclamations.add(r);
           }
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
       return listeReclamations;
       
   }
   
   public void supprimerReclamation(int id){
        try {
            String requete="DELETE FROM reclamations where reclamation_id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
             JavaMailUtil.sendMail(getUserEmailFromReclamationId(id),"Retour de réclamation", " réclamation traité");
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
   public void traiterReclamation(int id){
        try {
            String requete="DELETE FROM reclamations where reclamation_id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, id);
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   public String getUserEmailFromReclamationId(int reclamationId){
        try {
        String stringReclamationId = String.valueOf(reclamationId);
        String requete = "select a.email from "
                + "(SELECT reclamation_id,email, titre,texte "
                + "from users u join reclamations r on u.id_user=r.user_reclamation_id) a "
                + "where reclamation_id="+stringReclamationId;
        Statement st = cnx.prepareStatement(requete);
        ResultSet sr = st.executeQuery(requete);
        sr.next();
        return sr.getString(1);
     
        } catch (SQLException ex) {
            Logger.getLogger(AdminCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
   }
   
}

