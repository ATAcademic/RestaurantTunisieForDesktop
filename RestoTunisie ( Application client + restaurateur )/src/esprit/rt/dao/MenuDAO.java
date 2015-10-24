package esprit.rt.dao;

import esprit.rt.entities.Menu;
import esprit.rt.entities.Reservation;
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
 * @author Aditsan Kadmus
 */
public class MenuDAO {
    
    public void updateMenu(Menu m){
        String requete = "update menu set nom=?,description=? where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, m.getNom());
            ps.setString(2, m.getDescription());
            ps.setInt(3, m.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }
    
    public void deleteIt(Menu m){
        String requete = "delete from menu where id=?";
        PreparedStatement ps;
        try {
            ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, m.getId());
            ps.executeUpdate();
            System.out.println("Menu supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
        requete = "delete from plat where id_menu=?";
        try {
            ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, m.getId());
            ps.executeUpdate();
            System.out.println("Plat supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    public int insertMenu(Menu m){

        String requete = "insert into menu (nom,description,id_restaurant) values (?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, m.getNom());
            ps.setString(2, m.getDescription());
            ps.setInt(3, m.getRestaurant().getId());
            System.out.println("Ajout effectuée avec succès");
            ps.executeUpdate();
                    ResultSet rs = ps.getGeneratedKeys();
                     rs.next();
                    return rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
        return 0;
    }
    
    public List<Menu> displayMenusByRestaurant (int idRestaurant){


        List<Menu> listemenus = new ArrayList<Menu>();

        String requete = "select * from menu where id_restaurant = ?";
        System.out.println("dsd"+idRestaurant);
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, SessionRestoTunisie.crtResto.getId());
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                Menu m =new Menu();
                m.setId(resultat.getInt(1));
                m.setNom(resultat.getString(2));
                m.setDescription(resultat.getString(3));
                m.setRestaurant(new RestaurantDAO().findRestaurantById(resultat.getInt(4)));
                listemenus.add(m);
            }
            return listemenus;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du menu "+ex.getMessage());
            return null;
        }
    }
    
    public Menu menuById (int idMenu){


        List<Menu> listemenus = new ArrayList<Menu>();

        String requete = "select * from menu where id=?";
        
        try {
            Menu m =new Menu();
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, idMenu);
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                
                m.setId(resultat.getInt(1));
                m.setNom(resultat.getString(2));
                m.setDescription(resultat.getString(3));
                m.setRestaurant(new RestaurantDAO().findRestaurantById(resultat.getInt(4)));
            }
            return m;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement du menu "+ex.getMessage());
            return null;
        }
    }
}
