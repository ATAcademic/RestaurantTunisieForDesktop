/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.gui;

import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaLookAndFeel;
import esprit.rt.controllers.CBMenuByRestaurant;
import esprit.rt.controllers.CBPlatsByMenu;
import esprit.rt.dao.ClientDAO;
import esprit.rt.dao.CommandeDAO;
import esprit.rt.dao.ReservationDAO;
import esprit.rt.entities.Commande;
import esprit.rt.entities.Menu;
import esprit.rt.entities.Plat;
import esprit.rt.entities.Reservation;
import esprit.rt.utilities.SessionRestoTunisie;
import java.awt.Color;
import java.awt.Cursor;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author hp
 */
public class MenuReservation extends javax.swing.JFrame {
    private String testlab1;

    /**
     * Creates new form Reservation
     */
    public MenuReservation() {
         try {
            SyntheticaLookAndFeel.setWindowsDecorated(false);

            UIManager.put("Synthetica.dialog.icon.enabled", true);

            //Application du look SynthLookAndFeel
            //UIManager.setLookAndFeel(new SynthLookAndFeel());
            //Application du look MotifLookAndFeel
            //  UIManager.setLookAndFeel(new MotifLookAndFeel());
            //Application du look SyntheticaBlackEyeLookAndFeel   
            UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());

            //Application du look SyntheticaStandardLookAndFeel
            //  UIManager.setLookAndFeel(new SyntheticaStandardLookAndFeel());
            //Pour ajouter un nouveau look il faut importer le jar correspondant
            //Voici des liens utiles :
            //http://www.jyloo.com/
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MenuReservation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(MenuReservation.class.getName()).log(Level.SEVERE, null, ex);
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        testbot = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        badis = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jDate = new com.toedter.calendar.JDateChooser();
        jspinerplat = new javax.swing.JSpinner();
        jPlatos = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxHorsouv = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jSpinnernb = new javax.swing.JSpinner();
        dateres = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("        Menu de  Reservation");
        jLabel1.setMaximumSize(new java.awt.Dimension(100, 20));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 30, 186, 14);

        testbot.setText("Valider");
        testbot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testbotActionPerformed(evt);
            }
        });
        getContentPane().add(testbot);
        testbot.setBounds(175, 303, 100, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre des places");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 150, 160, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nos Plats");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(360, 200, 80, 17);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(570, 120, 80, 20);

        badis.setText("Simuler Couts");
        badis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                badisActionPerformed(evt);
            }
        });
        getContentPane().add(badis);
        badis.setBounds(560, 160, 100, 23);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 51, 51));
        jLabel8.setText("Quitter");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8);
        jLabel8.setBounds(370, 300, 100, 40);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 750, 70);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);
        jPanel2.add(jDate);
        jDate.setBounds(190, 30, 170, 20);
        jPanel2.add(jspinerplat);
        jspinerplat.setBounds(650, 160, 55, 20);

        jPlatos.setModel(new CBPlatsByMenu());
        jPanel2.add(jPlatos);
        jPlatos.setBounds(300, 160, 180, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre des Plats");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel5);
        jLabel5.setBounds(500, 160, 140, 20);

        jComboBoxHorsouv.setModel(new CBMenuByRestaurant());
        jComboBoxHorsouv.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxHorsouvItemStateChanged(evt);
            }
        });
        jPanel2.add(jComboBoxHorsouv);
        jComboBoxHorsouv.setBounds(80, 160, 170, 19);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nos Menus");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel3);
        jLabel3.setBounds(120, 130, 90, 17);
        jPanel2.add(jSpinnernb);
        jSpinnernb.setBounds(190, 80, 72, 20);

        dateres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dateres.setForeground(new java.awt.Color(255, 255, 255));
        dateres.setText("Date de Réservation");
        dateres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(dateres);
        dateres.setBounds(20, 30, 139, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Date");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel7);
        jLabel7.setBounds(190, 10, 50, 17);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/esprit/rt/images/blurred.jpg"))); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(0, 0, 750, 220);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 70, 750, 290);
        getContentPane().add(jPanel3);
        jPanel3.setBounds(350, 270, 110, 50);
        getContentPane().add(jPanel4);
        jPanel4.setBounds(310, 220, 10, 10);

        setSize(new java.awt.Dimension(766, 397));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void testbotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testbotActionPerformed
ReservationDAO reservationDAO = new ReservationDAO();
        Reservation  reservation = new Reservation();
        Commande commande = new Commande();
        
        
        
        reservation.setDate(new java.sql.Date(jDate.getDate().getTime()));
        reservation.setPrixTotale(Integer.parseInt(jspinerplat.getValue().toString())*((Plat) jPlatos.getSelectedItem()).getPrix() * Integer.parseInt(jSpinnernb.getValue().toString()));
        reservation.setNbrPlace(Integer.parseInt(jSpinnernb.getValue().toString()));
        reservation.setRestaurant(SessionRestoTunisie.crtResto);
        reservation.setClient(new ClientDAO().ClientById(SessionRestoTunisie.getId()));
        
        
        reservation.setId(reservationDAO.insertReservation(reservation));
        
        commande.setId(1);
        commande.setNbr(Integer.parseInt(jspinerplat.getValue().toString()));
        commande.setPlat((Plat) jPlatos.getSelectedItem());
        commande.setReservation(reservation);
        new CommandeDAO().insertCommande(commande);
        
        JOptionPane.showMessageDialog(this, "Reservation effectué avec succés");

        
       
        
        
        
        
    }//GEN-LAST:event_testbotActionPerformed

    private void badisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badisActionPerformed
        
        
       
       jTextField1.setText(""+Integer.parseInt(jspinerplat.getValue().toString())*((Plat) jPlatos.getSelectedItem()).getPrix() * Integer.parseInt(jSpinnernb.getValue().toString()));
       
        
        
    }//GEN-LAST:event_badisActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // badous
    }//GEN-LAST:event_formWindowOpened

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jComboBoxHorsouvItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxHorsouvItemStateChanged
        // TODO add your handling code here:
        jPlatos.setModel(new CBPlatsByMenu( ((Menu) jComboBoxHorsouv.getSelectedItem()).getId() ));
       
    }//GEN-LAST:event_jComboBoxHorsouvItemStateChanged

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
       this.setCursor (Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
       evt.getComponent().getParent().setBackground(Color.decode("#818181"));
    }//GEN-LAST:event_jLabel8MouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuReservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton badis;
    private javax.swing.JLabel dateres;
    private javax.swing.JComboBox jComboBoxHorsouv;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox jPlatos;
    private javax.swing.JSpinner jSpinnernb;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner jspinerplat;
    private javax.swing.JButton testbot;
    // End of variables declaration//GEN-END:variables

   
    
    static int prix = 0;
    static String k ="";


}
