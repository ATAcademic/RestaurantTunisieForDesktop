package esprit.rt.entities;

import java.util.Date;

/**
 *
 * @author Aditsan Kadmus
 * 
 */

public class BonPlan 
{
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private String description;
    private Restaurateur restaurateur;

    public BonPlan() {
    }

    public BonPlan(Date dateDebut, Date dateFin, String description) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
    }

    public BonPlan(Date dateDebut, Date dateFin, String description, Restaurateur restaurateur) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
        this.restaurateur = restaurateur;
    }

    public BonPlan(int id, Date dateDebut, Date dateFin, String description, Restaurateur restaurateur) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.description = description;
        this.restaurateur = restaurateur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Restaurateur getRestaurateur() {
        return restaurateur;
    }

    public void setRestaurateur(Restaurateur restaurateur) {
        this.restaurateur = restaurateur;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final BonPlan other = (BonPlan) obj;
        if (other.id != this.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BonPlan{" + "id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", description=" + description + ", restaurateur=" + restaurateur + '}';
    }
    
    
}
