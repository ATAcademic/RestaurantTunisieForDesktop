/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.gui;

import esprit.rt.dao.StatistiqueDAO;
import esprit.rt.utilities.FontsPartieRestaurateur;
import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.Rectangle;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Aditsan Kadmus
 */
public class StatistiquesRestaurateur extends javax.swing.JFrame {
DefaultPieDataset dataset;//Dataset qui va contenir les Données
    JFreeChart graphe;        //Graphe
    ChartPanel cp;     
    DefaultPieDataset dataset2;//Dataset qui va contenir les Données
    JFreeChart graphe2;        //Graphe
    ChartPanel cp2;  
    Float max1 = Float.MIN_VALUE, max2 = Float.MIN_VALUE;
    int i1=0, i2=0, j=0, k=0;
    /**
     * Creates new form StatistiquesRestaurateur
     */
    public StatistiquesRestaurateur() {
        initComponents();
        setLocationRelativeTo(null);
        dataset = new DefaultPieDataset();
//Statique
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
            "{0}: {1} places réservés ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        PieSectionLabelGenerator gen2 = new StandardPieSectionLabelGenerator(
            "{0}: {1} DT de revenue ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        for (Entry e : new StatistiqueDAO().mostBooked().entrySet())
        {
            if (Float.parseFloat((String) e.getValue()) > max1)
            {i1=j;
            max1=Float.parseFloat((String) e.getValue());
            }
            
            dataset.setValue((Comparable) e.getKey(),Float.parseFloat((String) e.getValue()) );
            j++;
        }
        
        
graphe = ChartFactory.createPieChart3D("Les restaurant les plus réservé", dataset,true ,true ,false);
PiePlot plot = (PiePlot) graphe.getPlot();
        plot.setLabelGenerator(gen);
        cp = new ChartPanel(graphe);
        cp.setBounds(new Rectangle(490, 400));
        PieChart.getContentPane().add(cp);
        cp.setVisible(true);
        PieChart.setVisible(true);
        
        title.setHorizontalAlignment(JLabel.CENTER);
        try {
            title.setFont(new FontsPartieRestaurateur().getFont(FontsPartieRestaurateur.TITLE, 70));
        } catch (FontFormatException ex) {
            Logger.getLogger(ConsultRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConsultRestaurant.class.getName()).log(Level.SEVERE, null, ex);
        }
        dataset2 = new DefaultPieDataset();
//Statique
         for (Entry e : new StatistiqueDAO().mostPayed().entrySet())
        {
            if (Float.parseFloat((String) e.getValue()) > max2)
            {i2=k;
            max2=Float.parseFloat((String) e.getValue());
            }
            dataset2.setValue((Comparable) e.getKey(),Float.parseFloat((String) e.getValue()) );
           k++;
        }
          
           
graphe2 = ChartFactory.createPieChart3D("Restaurant avec le meilleur revenue", dataset2,true ,true ,false);
PiePlot plot2 = (PiePlot) graphe2.getPlot();
        plot2.setLabelGenerator(gen2);
        cp2 = new ChartPanel(graphe2);
        cp2.setBounds(new Rectangle(490, 400));
        Pie2.add(cp2);cp2.setVisible(true);Pie2.setVisible(true);
        try
        {
            if ( i1 == i2 )
            {
                conseil.setForeground(Color.green);
                conseil.setText("Vos statistiques sont parfaites! Votre restaurant le plus réservé est celui avec le plus de revenue!");
            }
            else
            {
                conseil.setForeground(Color.red);
                conseil.setText("Le restaurant le plus réservé n'est pas celui avec le plus revenue! Verifier votre stratégie de prix!");
            }
        }
        catch (Exception e)
        {
            conseil.setVisible(false);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        PieChart = new javax.swing.JInternalFrame();
        Pie2 = new javax.swing.JInternalFrame();
        conseil = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Statistiques");
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(29, 29, 29));

        title.setForeground(new java.awt.Color(204, 204, 204));
        title.setText("Vos statistiques");

        PieChart.setVisible(true);

        javax.swing.GroupLayout PieChartLayout = new javax.swing.GroupLayout(PieChart.getContentPane());
        PieChart.getContentPane().setLayout(PieChartLayout);
        PieChartLayout.setHorizontalGroup(
            PieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );
        PieChartLayout.setVerticalGroup(
            PieChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );

        Pie2.setVisible(true);

        javax.swing.GroupLayout Pie2Layout = new javax.swing.GroupLayout(Pie2.getContentPane());
        Pie2.getContentPane().setLayout(Pie2Layout);
        Pie2Layout.setHorizontalGroup(
            Pie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );
        Pie2Layout.setVerticalGroup(
            Pie2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        conseil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        conseil.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(PieChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(conseil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PieChart)
                    .addComponent(Pie2))
                .addGap(18, 18, 18)
                .addComponent(conseil)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(StatistiquesRestaurateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatistiquesRestaurateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatistiquesRestaurateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatistiquesRestaurateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatistiquesRestaurateur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame Pie2;
    private javax.swing.JInternalFrame PieChart;
    private javax.swing.JLabel conseil;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
