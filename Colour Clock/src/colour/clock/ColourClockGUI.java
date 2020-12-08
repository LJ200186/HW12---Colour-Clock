/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colour.clock;

import java.awt.Color;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author ldjet
 */
public class ColourClockGUI extends javax.swing.JFrame {

    /**
     * Creates new form ColourClockGUI
     */
    public ColourClockGUI() {
        initComponents();
        
        CompletableFuture.runAsync(() -> {
            ColourUpdate();
        });
        
    }
    
    public String ToHex(String Num){
        
        int Numb = Integer.parseInt(Num);
        
        Num = Integer.toHexString(Numb);
      
        
        return Num;
    }
    
    public void ColourUpdate(){
        
        DecimalFormat df = new DecimalFormat("0");
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        
        while(true){
            
            Date date = new Date();
            String CurTime = dateFormat.format(date);
            
            String CurHour = CurTime.substring(0,2);
            String IntHour = df.format(Integer.parseInt(CurHour) * 10.625);
            String CurMin = CurTime.substring(3,5);
            String IntMin = df.format(Integer.parseInt(CurMin) * 4.25);
            String CurSec = CurTime.substring(6,8);
            String IntSec = df.format(Integer.parseInt(CurSec) * 4.25);
            
            String HourHex = ToHex(IntHour);
            String MinHex = ToHex(IntMin);
            String SecHex = ToHex(IntSec);
            
            if (HourHex.length() < 2){
                
                HourHex = "0"+HourHex;
            }
            
            if (MinHex.length() < 2){
                
                MinHex = "0"+MinHex;
            }
            if (SecHex.length() < 2){
                
                SecHex = "0"+SecHex;
            }
            
            
            String Hex = HourHex + MinHex + SecHex;
            
            Time.setText(CurTime);
            HexLabelCode.setText("#"+Hex);
            
            MainFrame.setBackground(Color.decode("#"+Hex));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainFrame = new javax.swing.JLayeredPane();
        Time = new javax.swing.JLabel();
        HexLabelCode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(240, 120, 8));
        setPreferredSize(new java.awt.Dimension(599, 350));
        setResizable(false);

        MainFrame.setBackground(new java.awt.Color(0, 0, 0));
        MainFrame.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        MainFrame.setForeground(new java.awt.Color(204, 255, 51));
        MainFrame.setOpaque(true);
        MainFrame.setPreferredSize(new java.awt.Dimension(600, 345));

        Time.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 48)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 255, 255));
        Time.setText("00:00:00");

        HexLabelCode.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 14)); // NOI18N
        HexLabelCode.setForeground(new java.awt.Color(255, 255, 255));
        HexLabelCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HexLabelCode.setText("#ffffff");
        HexLabelCode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        MainFrame.setLayer(Time, javax.swing.JLayeredPane.DEFAULT_LAYER);
        MainFrame.setLayer(HexLabelCode, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout MainFrameLayout = new javax.swing.GroupLayout(MainFrame);
        MainFrame.setLayout(MainFrameLayout);
        MainFrameLayout.setHorizontalGroup(
            MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainFrameLayout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addGroup(MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainFrameLayout.createSequentialGroup()
                        .addComponent(Time)
                        .addGap(196, 196, 196))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainFrameLayout.createSequentialGroup()
                        .addComponent(HexLabelCode, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(255, 255, 255))))
        );
        MainFrameLayout.setVerticalGroup(
            MainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainFrameLayout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(Time)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(HexLabelCode, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(ColourClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColourClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColourClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColourClockGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColourClockGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HexLabelCode;
    private javax.swing.JLayeredPane MainFrame;
    private javax.swing.JLabel Time;
    // End of variables declaration//GEN-END:variables
}
