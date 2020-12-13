/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.DAO;

/**
 *
 * @author Legion
 */
public class ListeReclamtionDAO {

    private int id;
    private String mail;
    private String titre;
    private String Description;

    public ListeReclamtionDAO() {
    }
    

    public ListeReclamtionDAO(int id, String mail, String titre, String Description) {
        this.id = id;
        this.mail = mail;
        this.titre = titre;
        this.Description = Description;
    }

    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "ListeReclamtionDAO{" + "id=" + id + ", mail=" + mail + ", titre=" + titre + ", Description=" + Description + '}';
    }
    

    

}
