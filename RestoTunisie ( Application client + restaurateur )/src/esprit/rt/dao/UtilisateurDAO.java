/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.dao;

import esprit.rt.entities.Utilisateur;
import esprit.rt.utilities.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Aditsan Kadmus
 */
public class UtilisateurDAO {
    public int auth (String[] atr)
    {
        String requete = "select id from utilisateurs where email = ? and password = ?";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setString(1, atr[0]);
           ps.setString(2, atr[1]);
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                return resultat.getInt(1);
            }
        }
        catch (Exception e)
        {
            System.out.println("REQUEST ERROR");
        }
        return -1;
    }
    
    public Utilisateur findUtilisateurtById(int id){
     Utilisateur utilisateur = new Utilisateur();
     String requete = "select * from utilisateurs where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               utilisateur.setId(resultat.getInt(1));
               utilisateur.setNom(resultat.getString(2));
               utilisateur.setPrenom(resultat.getString(3));
               utilisateur.setEmail(resultat.getString(4));
               utilisateur.setPassword(resultat.getString(5));
               utilisateur.setDateNaissance(resultat.getDate(6));
               utilisateur.setNumTel(resultat.getInt(7));
               utilisateur.setAdresse(resultat.getString(8));
               utilisateur.setRegion(resultat.getString(9));
               utilisateur.setImage(resultat.getString(10));
               utilisateur.setSexe(resultat.getString(11).charAt(0));
               utilisateur.setQuestionSecurite(resultat.getString(12));
               utilisateur.setReponseSecurite(resultat.getString(13));
               utilisateur.setDescription(resultat.getString(14));
            }
            return utilisateur;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du utilisateur "+ex.getMessage());
            return null;
        }
    }
    
    
    
        public int findUtilisateurtByEmail(String email){
            String requete = "select id from utilisateurs where email=?";
            try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, email);
            ResultSet resultat = ps.executeQuery();
            int id=-1;
            while (resultat.next())
            {
             id = resultat.getInt(1);
            
            }
            return id;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du utilisateur "+ex.getMessage());
            return -1;
        }
    }
}
