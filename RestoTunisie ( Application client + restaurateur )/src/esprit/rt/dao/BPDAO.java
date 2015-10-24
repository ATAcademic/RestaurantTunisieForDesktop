/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.dao;

import esprit.rt.entities.BonPlan;
import esprit.rt.entities.Restaurant;
import esprit.rt.utilities.MyConnection;
import esprit.rt.utilities.SessionRestoTunisie;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aditsan Kadmus
 */
public class BPDAO {
    public void insertBonPlan(BonPlan bp, int idRes){

        String requete = "insert into bonplan (date_debut,date_fin,description,id_restaurant) values (?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setDate(1, new Date (bp.getDateDebut().getDate()));
            ps.setDate(2, new Date (bp.getDateFin().getDate()));
            ps.setString(3, bp.getDescription());
            ps.setInt(4, idRes);
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
    
    public void deleteBonPlan(int id){
        String requete = "delete from bonplan where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Bon plan supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    
    public List<BonPlan> findBonPlanByIdRes (){


        List<BonPlan> listebps = new ArrayList<BonPlan>();

        String requete = "select bonplan.id, bonplan.date_debut, bonplan.date_fin, bonplan.description from bonplan , restaurant where bonplan.id_restaurant = restaurant.id and restaurant.id_restaurateur=?";
        
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, SessionRestoTunisie.getId());
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                BonPlan bp =new BonPlan();
                bp.setId(resultat.getInt(1));
                bp.setDateDebut(resultat.getDate(2));
                bp.setDateFin(resultat.getDate(3));
                bp.setDescription(resultat.getString(4));
                listebps.add(bp);
            }
            return listebps;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
    }
}
