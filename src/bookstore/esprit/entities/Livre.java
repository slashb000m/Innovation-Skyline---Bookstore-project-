/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.entities;

import java.io.FileInputStream;

import java.sql.Blob;
import java.sql.Date;
import javafx.scene.control.TextField;


/**
 *
 * @author Alia
 */
public class Livre {
    private int identifiant;
    private String titre;
    private String auteur;
    private String catégorie;
    private String description;
    private String typelivre;
    private float prix;
    private int nombre_page;
    private String chemin;
    private String image ;
    private Date date;
   
   
   
    

    public Livre() {
    }

    public Livre(float prix , String titre) {
        this.prix = prix;
    }

   public Livre(int identifiant) {
        this.identifiant = identifiant;
        
    }
   ////modif

    public Livre(int identifiant, String titre, String auteur, String catégorie, String description, String typelivre, float prix) {
        this.identifiant = identifiant;
        this.titre = titre;
        this.auteur = auteur;
        this.catégorie = catégorie;
        this.description = description;
        this.typelivre = typelivre;
        this.prix = prix;
      
    }

    public Livre(int identifiant, String titre, String auteur, String catégorie, String description, String typelivre, float prix, int nombre_page, Date date) {
        this.identifiant = identifiant;
        this.titre = titre;
        this.auteur = auteur;
        this.catégorie = catégorie;
        this.description = description;
        this.typelivre = typelivre;
        this.prix = prix;
        this.nombre_page = nombre_page;
        this.date = date;
    }
   

    public Livre(String titre,String auteur,String categorie,String desc,String t, float p , Date d) {
        this.titre = titre;
        this.auteur= auteur;
        this.catégorie=categorie;
        this.description=desc;
        this.typelivre=t;
        this.date= d;
        this.prix=p;
        
        
    }
    
    

    public Livre(int identifiant, String titre, String auteur, String catégorie, String description, String typelivre, float prix, int nombre_page) {
        this.identifiant = identifiant;
        this.titre = titre;
        this.auteur = auteur;
        this.catégorie = catégorie;
        this.description = description;
        this.typelivre = typelivre;
        this.prix = prix;
        this.nombre_page = nombre_page;
    }

    public Livre(String titre, String auteur, String catégorie, String description, String typelivre, float prix, int nombre_page,Date date) {
        this.titre = titre;
        this.auteur = auteur;
        this.catégorie = catégorie;
        this.description = description;
        this.typelivre = typelivre;
        this.prix = prix;
        this.nombre_page = nombre_page;
        this.date=date;
       // this.image=image;
    }

   /* public Livre(Blob image) {
        this.image = image;
    }*/

    public Livre(int identifiant, String titre, String auteur, String catégorie) {
        this.identifiant = identifiant;
        this.titre = titre;
        this.auteur = auteur;
        this.catégorie = catégorie;
    }

   

    public Livre(int identifiant, String titre, String auteur, String catégorie, String description, String typelivre, float prix, int nombre_page, String chemin) {
        this.identifiant = identifiant;
        this.titre = titre;
        this.auteur = auteur;
        this.catégorie = catégorie;
        this.description = description;
        this.typelivre = typelivre;
        this.prix = prix;
        this.nombre_page = nombre_page;
        this.chemin = chemin;
    }
//ajoutlivre
    public Livre( String titre, String auteur, String catégorie, String description, String typelivre, float prix, int nombre_page, Date date , String image ,String chemin) {
  
        this.titre = titre;
        this.auteur = auteur;
        this.catégorie = catégorie;
        this.description = description;
        this.typelivre = typelivre;
        this.prix = prix;
        this.nombre_page = nombre_page;
        this.image = image;
        this.date = date;
        this.chemin=chemin;
    }
    
    

    //modifierlivre
    
    

    

   
    

    public int getIdentifiant() {
        return identifiant;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getCatégorie() {
        return catégorie;
    }

    public String getDescription() {
        return description;
    }

    public String getTypelivre() {
        return typelivre;
    }

    public float getPrix() {
        return prix;
    }

    public int getNombre_page() {
        return nombre_page;
    }

    public String getChemin() {
        return chemin;
    }
    

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public void setTitle(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setCatégorie(String catégorie) {
        this.catégorie = catégorie;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypelivre(String typelivre) {
        this.typelivre = typelivre;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setNombre_page(int nombre_page) {
        this.nombre_page = nombre_page;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String  getImage() {
        return image;
    } 

    public void setImage(String  image) {
        this.image = image;
    }
    
    

    @Override
    public String toString() {
        return "Livre{" + "identifiant=" + identifiant + ", titre=" + titre + ", auteur=" + auteur + ", cat\u00e9gorie=" + catégorie + ", description=" + description + ", typelivre=" + typelivre + ", prix=" + prix + ", nombre_page=" + nombre_page + ", chemin=" + chemin + '}';
    }
    

    
    
    
    
    
   
    
}
