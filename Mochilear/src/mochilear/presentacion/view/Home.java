/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear.presentacion.view;

import mochilear.Mochilear;

/**
 *
 * @author andres
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        clientes_menu = new javax.swing.JMenu();
        consular_clientes = new javax.swing.JMenuItem();
        registrar_clientes = new javax.swing.JMenuItem();
        lugares_menu = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        viajes_menu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(191, 146, 54));
        setName("Home"); // NOI18N
        setSize(new java.awt.Dimension(1200, 900));

        contenedor.setBackground(new java.awt.Color(13, 42, 56));

        clientes_menu.setText("Clientes");
        clientes_menu.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N

        consular_clientes.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        consular_clientes.setText("Consultas");
        consular_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consular_clientesActionPerformed(evt);
            }
        });
        clientes_menu.add(consular_clientes);

        registrar_clientes.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        registrar_clientes.setText("Registrar");
        registrar_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar_clientesActionPerformed(evt);
            }
        });
        clientes_menu.add(registrar_clientes);

        jMenuBar1.add(clientes_menu);

        lugares_menu.setText("Lugares");
        lugares_menu.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N

        jMenuItem3.setText("Consultar");
        lugares_menu.add(jMenuItem3);

        jMenuItem4.setText("Registrar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        lugares_menu.add(jMenuItem4);

        jMenuBar1.add(lugares_menu);

        viajes_menu.setText("Viajes");
        viajes_menu.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N

        jMenuItem2.setText("Consultar");
        viajes_menu.add(jMenuItem2);

        jMenuItem1.setText("Registrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        viajes_menu.add(jMenuItem1);

        jMenuBar1.add(viajes_menu);

        jMenu2.setText("Busetas");
        jMenu2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N

        jMenuItem5.setText("Consultar");
        jMenu2.add(jMenuItem5);

        jMenuItem7.setText("Registrar");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 1613, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1220, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consular_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consular_clientesActionPerformed
        Mochilear.CLIENTESVIEW.setVisible(true);
    }//GEN-LAST:event_consular_clientesActionPerformed

    private void registrar_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar_clientesActionPerformed
        // Para actualizar el combo
        Mochilear.CLIENTESCONTROL.actualizarCombo();
        Mochilear.REGISTRARCLIENTE.setVisible(true);
    }//GEN-LAST:event_registrar_clientesActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Mochilear.REGISTRARLUGAR.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Para actualizar el combo
        Mochilear.VIAJECONTROL.actualizarCombo();
        Mochilear.REGISTRARVIAJE.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // Para actualizar el combo
        Mochilear.BUSETACONTROL.actualizarCombo();
        Mochilear.REGISTRARBUSETA.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu clientes_menu;
    private javax.swing.JMenuItem consular_clientes;
    public javax.swing.JDesktopPane contenedor;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenu lugares_menu;
    private javax.swing.JMenuItem registrar_clientes;
    private javax.swing.JMenu viajes_menu;
    // End of variables declaration//GEN-END:variables
}