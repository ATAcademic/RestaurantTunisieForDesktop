/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.entities;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Aditsan Kadmus
 */
public class Meuble implements Comparable<Meuble> 
{
    private int id;
    private int x, y;
    private int reserved, currentPlaces, maxPlaces, width, height, priority;
    private Chambre chambre;
    private String image;
    

    public Meuble(int x, int y, int width, int height, int reserved, int currentPlaces, int maxPlaces) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.reserved = reserved;
        this.currentPlaces = currentPlaces;
        this.maxPlaces = maxPlaces;
    }

    public Meuble() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public int getCurrentPlaces() {
        return currentPlaces;
    }

    public void setCurrentPlaces(int currentPlaces) {
        this.currentPlaces = currentPlaces;
    }

    public int getMaxPlaces() {
        return maxPlaces;
    }

    public void setMaxPlaces(int maxPlaces) {
        this.maxPlaces = maxPlaces;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Meuble other = (Meuble) obj;
        if ((other.getX() != this.getX()) && (other.getY() != this.getY()))
            return false;
        return true;
    }

    

    @Override
    public int compareTo(Meuble o) {
        return this.priority - o.priority;
    }

    @Override
    public String toString() {
        return "Meuble{" + "id=" + id + ", x=" + x + ", y=" + y + ", reserved=" + reserved + ", currentPlaces=" + currentPlaces + ", maxPlaces=" + maxPlaces + ", width=" + width + ", height=" + height + ", priority=" + priority + ", chambre=" + chambre + ", image=" + image + '}';
    }
    
    
}
