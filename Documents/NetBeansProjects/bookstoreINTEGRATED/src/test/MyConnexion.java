/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alia
 */
public class MyConnexion {
    public String url="jdbc:mysql://localhost:3306/bookstore_bd";
    public String login="root";
    public String password="";
    Connection cnx;
    public static MyConnexion instance; 

    public MyConnexion() {
        try {
            cnx= DriverManager.getConnection(url, login, password);
            System.out.println("connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    public Connection getCnx() {
        return cnx;
    }
    public static MyConnexion getInstance(){
        if(instance == null){
            instance = new MyConnexion();
        }
        return instance;
    }
    
    
    
}
