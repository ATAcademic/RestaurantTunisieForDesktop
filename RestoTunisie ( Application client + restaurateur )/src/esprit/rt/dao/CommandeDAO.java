package esprit.rt.dao;

import esprit.rt.entities.Commande;
import esprit.rt.utilities.MyConnection;
import esprit.rt.utilities.SessionRestoTunisie;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Aditsan Kadmus
 */
public class CommandeDAO {
    public void insertCommande(Commande c){

        String requete = "insert into commande (id_plat,nbr,id_reservation) values (?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, c.getPlat().getId());
//            ps.setNull(1, java.sql.Types.VARCHAR);
            ps.setInt(2, c.getNbr());
            ps.setInt(3, c.getReservation().getId());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
}
