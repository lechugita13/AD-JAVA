/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Edgar
 */
public class JFPrincipal extends javax.swing.JFrame {
    
    JPLibro panelLibro = new JPLibro();
    JPSocio panelSocio = new JPSocio();
    JPPrestamo panelPrestamo = new JPPrestamo();

    /**
     * Creates new form JFPrincipal
     */
    public JFPrincipal() {
        initComponents();
        
        this.setSize(1000, 900);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemSocios = new javax.swing.JMenuItem();
        itemLibros = new javax.swing.JMenuItem();
        itemPrestamos = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Edgar\\Downloads\\library_3978.png")); // NOI18N
        jMenu1.setText("Biblioteca");

        itemSocios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itemSocios.setIcon(new javax.swing.ImageIcon("C:\\Users\\Edgar\\Downloads\\customer_person_people_man_user_client_1629 (1).png")); // NOI18N
        itemSocios.setText("Socios");
        itemSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSociosActionPerformed(evt);
            }
        });
        jMenu1.add(itemSocios);

        itemLibros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        itemLibros.setIcon(new javax.swing.ImageIcon("C:\\Users\\Edgar\\Downloads\\books_21468.png")); // NOI18N
        itemLibros.setText("Libros");
        itemLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLibrosActionPerformed(evt);
            }
        });
        jMenu1.add(itemLibros);

        itemPrestamos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        itemPrestamos.setIcon(new javax.swing.ImageIcon("C:\\Users\\Edgar\\Downloads\\1486564172-finance-loan-money_81492.png")); // NOI18N
        itemPrestamos.setText("Préstamos");
        itemPrestamos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPrestamosActionPerformed(evt);
            }
        });
        jMenu1.add(itemPrestamos);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Edgar\\Downloads\\exit_closethesession_close_6317.png")); // NOI18N
        jMenu2.setText("Salir");

        jMenuItem4.setText("Salir");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemPrestamosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPrestamosActionPerformed
       panelPrestamo.setVisible(true);
       panelSocio.setVisible(false);
       panelLibro.setVisible(false);
       
       this.setContentPane(panelPrestamo);
//       panelVariable.add(panelPrestamo);
        
    }//GEN-LAST:event_itemPrestamosActionPerformed

    private void itemSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSociosActionPerformed
       panelPrestamo.setVisible(false);
       panelSocio.setVisible(true);
       panelLibro.setVisible(false);
       
       this.setContentPane(panelSocio);
//       panelVariable.add(panelSocio);
    }//GEN-LAST:event_itemSociosActionPerformed

    private void itemLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLibrosActionPerformed
       panelPrestamo.setVisible(false);
       panelSocio.setVisible(false);
       panelLibro.setVisible(true);
       
       this.setContentPane(panelLibro);
//       panelVariable.add(panelLibro);
       
    }//GEN-LAST:event_itemLibrosActionPerformed

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
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemLibros;
    private javax.swing.JMenuItem itemPrestamos;
    private javax.swing.JMenuItem itemSocios;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
}
