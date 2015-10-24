package esprit.rt.controllers;

import esprit.rt.dao.ReservationDAO;
import esprit.rt.dao.RestaurantDAO;
import esprit.rt.entities.Reservation;
import esprit.rt.entities.Restaurant;
import esprit.rt.utilities.SessionRestoTunisie;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pingouins de désert
 * 
 */

public class VerifiedReservationsController extends AbstractTableModel{

    String[] headers = {"Id","Date", "Nombre place"};
    List<Reservation> listeReservations = new ArrayList<Reservation>();
    String etat;
    public VerifiedReservationsController(String etat) {

        ReservationDAO reservationDAO = new ReservationDAO();
        listeReservations = reservationDAO.getReservationsForIdEtat(SessionRestoTunisie.getId(),etat);
        this.etat = etat;
    }
    
    @Override
    public int getRowCount() {
        try 
        {
        return listeReservations.size();
        }
        catch (Exception e)
                {
                    return 0;
                }
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex)
        {
            case 0:
                return listeReservations.get(rowIndex).getId();
            case 1:
                return listeReservations.get(rowIndex).getDate();
            case 2:
                return listeReservations.get(rowIndex).getNbrPlace();
            default:
                return "erreur";
        }
    }
    
    @Override
    public String getColumnName(int column)
    {
        return headers[column];
    }
    
   
}
