/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.entities;

/**
 *
 * @author Aditsan Kadmus
 */
public class Commentaire {
    private int id;
    private String text;
    private Utilisateur sender;
    private Utilisateur reciever;

    public Commentaire() {
    }

    public Commentaire(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Utilisateur getSender() {
        return sender;
    }

    public void setSender(Utilisateur sender) {
        this.sender = sender;
    }

    public Utilisateur getReciever() {
        return reciever;
    }

    public void setReciever(Utilisateur reciever) {
        this.reciever = reciever;
    }
    
}
