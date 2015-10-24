/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.controllers;

import esprit.rt.entities.Menu;
import esprit.rt.entities.Plat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aditsan Kadmus
 */
public class AllPlatByRestController extends AbstractTableModel{

    String[] headers = {"Nom","Description","type","prix"};
    List<Plat> liste = new ArrayList<Plat>();
    
    @Override
    public int getRowCount() {
        try
        {
            return liste.size();
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
                return liste.get(rowIndex).getNom();
            case 1:
                return liste.get(rowIndex).getDescription();
            case 2:
                return liste.get(rowIndex).getType();
            case 3:
                return liste.get(rowIndex).getPrix();
        }
        return "erreur";
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
    
    
}
