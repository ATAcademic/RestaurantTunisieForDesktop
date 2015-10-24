package esprit.rt.controllers;

import esprit.rt.dao.RestaurantDAO;
import esprit.rt.entities.Restaurant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pingouins de désert
 * 
 */

public class AllRestaurantsController extends AbstractTableModel{

    String[] headers = {"Id","Nom", "Adresse"};
    List<Restaurant> listeRestaurants = new ArrayList<Restaurant>();
    
    public AllRestaurantsController() {

        RestaurantDAO restaurantDAO = new RestaurantDAO();
        listeRestaurants = restaurantDAO.DisplayAllRestaurants();
    }
    
    @Override
    public int getRowCount() {
        try
        {
        return listeRestaurants.size();
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
                return listeRestaurants.get(rowIndex).getId();
            case 1:
                return listeRestaurants.get(rowIndex).getNom();
            case 2:
                return listeRestaurants.get(rowIndex).getAdresse();
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
