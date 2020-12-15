/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.entities;

/**
 *
 * @author Dhia
 */
public class souhaits {
    private int id_souhait_livre;
    private int id_souhait_user ;

    public souhaits(int id_souhait_livre, int id_souhait_user) {
        this.id_souhait_livre = id_souhait_livre;
        this.id_souhait_user = id_souhait_user;
    }

    public souhaits() {
    }

    public int getId_souhait_livre() {
        return id_souhait_livre;
    }

    public int getId_souhait_user() {
        return id_souhait_user;
    }

    public void setId_souhait_livre(int id_souhait_livre) {
        this.id_souhait_livre = id_souhait_livre;
    }

    public void setId_souhait_user(int id_souhait_user) {
        this.id_souhait_user = id_souhait_user;
    }

   
    @Override
    public String toString() {
        return  "id_souhait_livre=" + id_souhait_livre + ", id_souhait_user=" + id_souhait_user + '}';
    }
    
    
    
}
