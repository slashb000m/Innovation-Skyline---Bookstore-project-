/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.services;

import bookstore.esprit.entities.Livre;
import bookstore.esprit.entities.achats;
import bookstore.esprit.entities.souhaits;
import bookstore.esprit.entities.users;
import static bookstore.esprit.services.LivreCRUD.cnx;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import test.MyConnexion;

/**
 *
 * @author Dhia
 */
public class achatsCrud {
  
        public void ajouterachats(achats a) {
        cnx = MyConnexion.getInstance().getCnx();
        try {
            String requete = "INSERT INTO achats (id_achat,prix_dachat,id_achat_livre,id_achat_user,date_achat)"
                    + "VALUES (?,?,?,?) ";
            PreparedStatement pst = cnx.prepareStatement(requete);
          pst.setInt(1,a.getId_achat());
          pst.setFloat(2,a.getPrix_dachat());
          pst.setInt(3, a.getId_achat_livre());
          pst.setInt(4,a.getId_achat_user());
          
            pst.executeUpdate();
            System.out.println("souhait ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());;
        }
    }

     
    
}
