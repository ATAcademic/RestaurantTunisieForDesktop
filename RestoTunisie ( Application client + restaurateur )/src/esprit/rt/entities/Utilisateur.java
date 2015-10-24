package esprit.rt.entities;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author Pingouins du désert
 * 
 */

public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private Date dateNaissance;
    private int numTel;
    private String adresse;
    private String region;
    private Image img;
    private String image;
    private char sexe;
    private String questionSecurite;
    private String reponseSecurite;
    private String description;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String email, String password, Date dateNaissance, int numTel, String adresse, String region, char sexe, String questionSecurite, String reponseSecurite, String description) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.dateNaissance = dateNaissance;
        this.numTel = numTel;
        this.adresse = adresse;
        this.region = region;
        this.img = img;
        this.image = image;
        this.sexe = sexe;
        this.questionSecurite = questionSecurite;
        this.reponseSecurite = reponseSecurite;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public void setDateNaissance(java.sql.Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        this.sexe = sexe;
    }

    public String getQuestionSecurite() {
        return questionSecurite;
    }

    public void setQuestionSecurite(String questionSecurite) {
        this.questionSecurite = questionSecurite;
    }

    public String getReponseSecurite() {
        return reponseSecurite;
    }

    public void setReponseSecurite(String reponseSecurite) {
        this.reponseSecurite = reponseSecurite;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        final Utilisateur other = (Utilisateur) obj;
        if (this.id != other.id)
            return false;
        return true;
    }
    
    
}
