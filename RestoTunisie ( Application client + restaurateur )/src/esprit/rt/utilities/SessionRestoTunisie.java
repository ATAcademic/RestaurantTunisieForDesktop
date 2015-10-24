package esprit.rt.utilities;

import esprit.rt.entities.Menu;
import esprit.rt.entities.Plat;
import esprit.rt.entities.Restaurant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Aditsan Kadmus
 * 
 */

public class SessionRestoTunisie {
    
    private static int id = 1;
    private static float last_active;
    public static JFrame cstltResto;
    public static JFrame auth;
    public static int id_currentResto=1;
    public static int id_currentChambre=1;
    public static Restaurant crtResto;
    public static JFrame disposable;
    public static List<Plat> listedesPlatsTMP = new ArrayList<Plat>();
    public static Menu crtMenu;
    public SessionRestoTunisie()
    {
        this.last_active = new Date().getTime();
    }
    
    public SessionRestoTunisie(int id)
    {
        this.id = id;
        this.last_active = new Date().getTime();
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        SessionRestoTunisie.id = id;
    }

    public static float getLast_active() {
        return last_active;
    }

    public static void setLast_active(float last_active) {
        SessionRestoTunisie.last_active = last_active;
    }

    @Override
    public String toString() {
        return "SessionRestoTunisie{" +id+ '}';
    }
    
    
}
