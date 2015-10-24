/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.controllers;

import esprit.rt.dao.MenuDAO;
import esprit.rt.entities.Menu;
import esprit.rt.utilities.SessionRestoTunisie;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aditsan Kadmus
 */
public class AllMenusController extends AbstractTableModel{
    String[] headers = {"Nom","Description"};
    List<Menu> listeMenus = new ArrayList<Menu>();
    public AllMenusController ()
    {
        listeMenus = new MenuDAO().displayMenusByRestaurant(SessionRestoTunisie.id_currentResto);
    }
    @Override
    public int getRowCount() {
        try 
        {
        return listeMenus.size();
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
                return listeMenus.get(rowIndex);
            case 1:
                return listeMenus.get(rowIndex).getDescription();
        }
        return "erreur";
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
    
    
}
