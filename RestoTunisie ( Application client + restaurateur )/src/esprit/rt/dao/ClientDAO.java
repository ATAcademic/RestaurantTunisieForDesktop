package esprit.rt.dao;

import esprit.rt.entities.Client;
import esprit.rt.utilities.MyConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Pingouins du désert
 * 
 */

public class ClientDAO {
    public int auth (String[] atr)
    {
        String requete = "select utilisateurs.id from utilisateurs, client where utilisateurs.email = ? and utilisateurs.password = ? and utilisateurs.id = client.id";
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
            System.out.println("REQUEST ERROR1 "+e.getMessage());
        }
        return -1;
    }
    
    public Client ClientById(int id)
    {
        Client client = new Client();
        String requete = "select * from utilisateurs,client where utilisateurs.id = client.id and client.id = ? ";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, id);
           ResultSet resultat = ps.executeQuery();
           
            while(resultat.next()){
                
                client.setId(id);
                client.setNom(resultat.getString(2));
                client.setPrenom(resultat.getString(3));
                client.setEmail(resultat.getString(4));
                client.setDateNaissance(resultat.getDate(6));
                client.setNumTel(resultat.getInt(7));
                client.setAdresse(resultat.getString(8));
                client.setRegion(resultat.getString(9));
                client.setImage(resultat.getString(10));
                client.setSexe(resultat.getString(11).charAt(0));
                client.setQuestionSecurite(resultat.getString(12));
                client.setQuestionSecurite(resultat.getString(13));
                client.setDescription(resultat.getString(14));
            }
            
            
            return client;
            
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des clients "+ex.getMessage());
            return null;
        }
    }
    
    public void insertClient(String nom,String prenom,String email,String password, Date date_naissance,int num_tel, String adresse,String region,String image,char sexe,String question_securite,String reponse_securite,String description){
      
         String requete = "insert into utilisateurs (nom,prenom,email,password,date_naissance,num_tel,adresse,region,image,sexe,question_securite,reponse_securite,description) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
         
         try { 
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, email);
            ps.setString(4,password);
            ps.setDate(5, date_naissance);
            ps.setInt(6, num_tel);
            ps.setString(7,adresse);
            ps.setString(8, region);
            ps.setString(9, image);
            ps.setString(10, String.valueOf(sexe));
            ps.setString(11, question_securite);
            ps.setString(12, reponse_securite);
            ps.setString(13, description);
            ps.executeUpdate();
           
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
         }
            
         
         String requete2 ="insert into client(id,estbloque) values (?,'V')";   
         UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
         int res_id = utilisateurDAO.findUtilisateurtByEmail(email);
             
         try 
             {
                 PreparedStatement ps2 = MyConnection.getInstance().prepareStatement(requete2);
                 ps2.setInt(1,res_id);
                 ps2.executeUpdate();
             } 
             catch (SQLException ex2) 
             {
                 //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
                   System.out.println("erreur lors de l'insertion "+ex2.getMessage());
             }
            
            
        
    }
}
