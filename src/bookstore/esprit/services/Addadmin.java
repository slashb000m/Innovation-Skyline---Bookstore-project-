/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.services;

import bookstore.esprit.entities.Admin;
import bookstore.esprit.tests.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author Oussema
 */
public class Addadmin {
    Connection cnx;
    public void ajouterAdmin(Admin a){
        String requete ="INSERT INTO admin(nom,prenom,email,password)"
                    + " VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = new MyConnection().getCnx().prepareStatement(requete);
            pst.setString(1, a.getNom());
            pst.setString(2, a.getPrenom());
            pst.setString(3, a.getEmail());
            pst.setString(4, a.getPassword());
            pst.executeUpdate();
            System.out.println("admin ajouté !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
