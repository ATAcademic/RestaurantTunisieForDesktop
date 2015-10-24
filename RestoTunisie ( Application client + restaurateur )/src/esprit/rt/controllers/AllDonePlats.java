/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.controllers;

import esprit.rt.utilities.SessionRestoTunisie;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aditsan Kadmus
 */
public class AllDonePlats extends AbstractTableModel {

     String [] headers = {"Plat"};
    @Override
    public int getRowCount() {
        return SessionRestoTunisie.listedesPlatsTMP.size();
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
                return SessionRestoTunisie.listedesPlatsTMP.get(rowIndex);
            default:
                return "erreur";
        }
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
    
    
    
}
