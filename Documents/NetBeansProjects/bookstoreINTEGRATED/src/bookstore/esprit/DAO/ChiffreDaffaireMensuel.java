/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.esprit.DAO;

import java.sql.Date;

/**
 *
 * @author Legion
 */
public class ChiffreDaffaireMensuel {
    private float sommeMensuel; 
    private Date date; 

    public ChiffreDaffaireMensuel() {
    }

    public void setSommeMensuel(float sommeMensuel) {
        this.sommeMensuel = sommeMensuel;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getSommeMensuel() {
        return sommeMensuel;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ChiffreDaffaireMensuel{" + "sommeMensuel=" + sommeMensuel + ", date=" + date + '}';
    }
    
    
    
}
