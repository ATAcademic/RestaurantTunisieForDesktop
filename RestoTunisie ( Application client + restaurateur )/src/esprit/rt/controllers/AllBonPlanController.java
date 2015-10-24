package esprit.rt.controllers;

import esprit.rt.dao.BPDAO;
import esprit.rt.entities.BonPlan;
import esprit.rt.utilities.SessionRestoTunisie;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pingouins de désert
 * 
 */

public class AllBonPlanController extends AbstractTableModel{

    String[] headers = {"Id","Date Debut", "Date Fin", "Description"};
    List<BonPlan> listeBonPlans = new ArrayList<BonPlan>();
    
    public AllBonPlanController() {

        BPDAO bpDAO = new BPDAO();
        listeBonPlans = bpDAO.findBonPlanByIdRes();
    }
    
    @Override
    public int getRowCount() {
        try
        {
        return listeBonPlans.size();
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
                try
                {
                return listeBonPlans.get(rowIndex).getId();
                }
            catch (Exception e)
                    {
                      return -1;  
                    }
                
            case 1:
                try
                {
                    return listeBonPlans.get(rowIndex).getDateDebut();
                }
                catch(Exception e)
                {
                    return "";
                }
                
            case 2:
                try
                {
                    return listeBonPlans.get(rowIndex).getDateFin();
                }
                catch (Exception e)
                {
                    return "";
                }
                
            case 3:
                try
                {
                    return listeBonPlans.get(rowIndex).getDescription();
                }
                catch (Exception e)
                {
                    return "";
                }
                
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
