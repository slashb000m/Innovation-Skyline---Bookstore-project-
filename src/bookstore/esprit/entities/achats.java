/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.entities;

import java.sql.Date;

/**
 *
 * @author Dhia
 */
public class achats {
    private int id_achat;
    private float prix_dachat ;
    private int id_achat_livre ;
    private int id_achat_user;
    private Date date_achat ;
public achats()
{}

    public achats(int id_achat, float prix_dachat, int id_achat_livre, int id_achat_user, Date date_achat) {
        this.id_achat = id_achat;
        this.prix_dachat = prix_dachat;
        this.id_achat_livre = id_achat_livre;
        this.id_achat_user = id_achat_user;
        this.date_achat = date_achat;
    }

    public int getId_achat() {
        return id_achat;
    }

    public float getPrix_dachat() {
        return prix_dachat;
    }

    public int getId_achat_livre() {
        return id_achat_livre;
    }

    public int getId_achat_user() {
        return id_achat_user;
    }

    public Date getDate_achat() {
        return date_achat;
    }

    public void setId_achat(int id_achat) {
        this.id_achat = id_achat;
    }

    public void setPrix_dachat(float prix_dachat) {
        this.prix_dachat = prix_dachat;
    }

    public void setId_achat_livre(int id_achat_livre) {
        this.id_achat_livre = id_achat_livre;
    }

    public void setId_achat_user(int id_achat_user) {
        this.id_achat_user = id_achat_user;
    }

    public void setDate_achat(Date date_achat) {
        this.date_achat = date_achat;
    }

    @Override
    public String toString() {
        return "achats{" + "id_achat=" + id_achat + ", prix_dachat=" + prix_dachat + ", id_achat_livre=" + id_achat_livre + ", id_achat_user=" + id_achat_user + ", date_achat=" + date_achat + '}';
    }
    
    
    
    
}
