/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.entities;

import java.util.Date;

/**
 *
 * @author Legion
 */
public class Reclamations {
    private int id;
    private String titre;
    private String texte; 
    private Date date_creation; 
    private int user_reclamation_id; 

    public Reclamations(String titre, String texte, Date date_creation) {
        this.titre = titre;
        this.texte = texte;
        this.date_creation = date_creation;
    }
    
    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public Reclamations() {
    }

    public String getTexte() {
        return texte;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public int getUser_reclamation_id() {
        return user_reclamation_id;
    }

    @Override
    public String toString() {
        return "Reclamations{" + "id=" + id + ", titre=" + titre + ", texte=" + texte + ", date_creation=" + date_creation + ", user_reclamation_id=" + user_reclamation_id + '}';
    }

    public Reclamations(int id, String texte, Date date_creation) {
        this.id = id;
        this.texte = texte;
        this.date_creation = date_creation;
    }

    public Reclamations(int id, String titre, String texte, Date date_creation) {
        this.id = id;
        this.titre = titre;
        this.texte = texte;
        this.date_creation = date_creation;
    }




    public Reclamations(int id, String titre, String texte, Date date_creation, int user_reclamation_id) {
        this.id = id;
        this.titre = titre;
        this.texte = texte;
        this.date_creation = date_creation;
        this.user_reclamation_id = user_reclamation_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public void setUser_reclamation_id(int user_reclamation_id) {
        this.user_reclamation_id = user_reclamation_id;
    }
    
    
    
}
