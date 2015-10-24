package esprit.rt.dao;

import esprit.rt.entities.Restaurant;
import esprit.rt.entities.Restaurateur;
import esprit.rt.utilities.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pingouins du désert
 * 
 */

public class RestaurateurDAO {
     public int auth (String[] atr)
    {
        String requete = "select utilisateurs.id from utilisateurs,restaurateur where utilisateurs.email = ? and utilisateurs.password = ? and utilisateurs.id = restaurateur.id and restaurateur.etat=?";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setString(1, atr[0]);
           ps.setString(2, atr[1]);
           ps.setString(3, "V");
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
     
     
     public int findOwnerOf(Restaurant restaurant){
    Restaurateur r = new Restaurateur();
     String requete = "select id_restaurateur from restaurant where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, restaurant.getId());
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
                return resultat.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du restaurant "+ex.getMessage());
            return 0;
        }
         return 0;
    }
}
