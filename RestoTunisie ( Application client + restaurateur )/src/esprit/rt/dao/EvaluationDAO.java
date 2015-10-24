/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.dao;

import esprit.rt.entities.Evaluation;
import esprit.rt.utilities.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aditsan Kadmus
 */
public class EvaluationDAO {
    public void insertEvaluation(Evaluation e){
        PreparedStatement ps;
        int id=0;
        String requete = "insert into commentaire (texte,id_sender,id_receiver) values (?,?,?)";
        try {
            ps = MyConnection.getInstance().prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, e.getCommentaire().getText());
//            ps.setNull(1, java.sql.Types.VARCHAR);
            ps.setInt(2, e.getCommentaire().getSender().getId());
            ps.setInt(3, e.getCommentaire().getReciever().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
                     rs.next();
                     id = rs.getInt(1);
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
        requete = "insert into evaluation (date,note,id_commentaire) values (?,?,?)";
        try {
            ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setDate(1, e.getDate());
//            ps.setNull(1, java.sql.Types.VARCHAR);
            ps.setInt(2, e.getNote());
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
}
