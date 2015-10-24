package esprit.rt.dao;

import esprit.rt.entities.Menu;
import esprit.rt.entities.Plat;
import esprit.rt.entities.Restaurant;
import esprit.rt.utilities.MyConnection;
import esprit.rt.utilities.SessionRestoTunisie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pingouins du désert
 * 
 */

public class PlatDAO {
    
    
    public void deleteIt(Plat p){
        String requete = "delete from plat where id=?";
        PreparedStatement ps;
        try {
            ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, p.getId());
            ps.executeUpdate();
            System.out.println("Plat supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    
    
    public List<Plat> displayPlayByMenu (int idMenu){


        List<Plat> listePlat = new ArrayList<Plat>();

        String requete = "select * from plat where id_menu = ?";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, idMenu);
           ResultSet resultat = ps.executeQuery();
           
            while(resultat.next()){
                Plat p =new Plat();
                p.setId(resultat.getInt(1));
                p.setNom(resultat.getString(2));
                p.setDescription(resultat.getString(3));
                p.setType(resultat.getString(4));
                p.setPrix(resultat.getFloat(5));
                p.setMenu(new MenuDAO().menuById(resultat.getInt(6)));
                listePlat.add(p);
            }
            
            
            return listePlat;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
        
    }
    
    public List<Plat> displayPlats ()
    {
        List<Plat> listePlat = new ArrayList<Plat>();
        
        String requete = "select * from plat";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ResultSet resultat = ps.executeQuery();
           
            while(resultat.next()){
                Plat p =new Plat();
                p.setId(resultat.getInt(1));
                p.setNom(resultat.getString(2));
                p.setDescription(resultat.getString(3));
                p.setType(resultat.getString(4));
                p.setPrix(resultat.getFloat(5));
                p.setMenu(new MenuDAO().menuById(resultat.getInt(6)));
                listePlat.add(p);
            }
            
            
            return null;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
    }

    public void insert(Plat p) {
        String requete = "insert into plat (nom,description,type,prix,id_menu) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getDescription());
            ps.setString(3, p.getType());
            ps.setFloat(4, p.getPrix());
            ps.setInt(5, p.getMenu().getId());
            System.out.println("Ajout effectuée avec succès");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
}
