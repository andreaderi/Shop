package shop.view;


    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */


    /**
     *
     * @author Andrea
     */
    public class HomeFrame1 extends javax.swing.JFrame {

        /**
         * Creates new form immm
         */
        public HomeFrame1() {
            initComponents();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

            jLabel1 = new javax.swing.JLabel();
            jButton1 = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();
            jButton3 = new javax.swing.JButton();
            jLabel2 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);

            jLabel1.setFont(new java.awt.Font("Ravie", 1, 24)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(204, 0, 0));
            jLabel1.setText("         ...BENVENUTI IN ONLINE DISCOUNT...");
            getContentPane().add(jLabel1);
            jLabel1.setBounds(10, 30, 730, 57);

            jButton1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
            jButton1.setText("EFFETTUA IL LOGIN");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });
            getContentPane().add(jButton1);
            jButton1.setBounds(30, 180, 230, 110);

            jButton2.setFont(new java.awt.Font("Times New Roman", 3, 13)); // NOI18N
            jButton2.setText("REGISTRAZIONE");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });
            getContentPane().add(jButton2);
            jButton2.setBounds(310, 180, 180, 110);

            jButton3.setFont(new java.awt.Font("Times New Roman", 3, 13)); // NOI18N
            jButton3.setText("VISUALIZZA CATALOGO");
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
                }
            });
            getContentPane().add(jButton3);
            jButton3.setBounds(560, 180, 190, 110);

            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Sfondo.jpg"))); // NOI18N
            jLabel2.setText("jLabel2");
            getContentPane().add(jLabel2);
            jLabel2.setBounds(0, 0, 780, 600);

            pack();
        }// </editor-fold>

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
        }

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
                java.util.logging.Logger.getLogger(HomeFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(HomeFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(HomeFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(HomeFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new HomeFrame1().setVisible(true);
                }
            });
        }

        // Variables declaration - do not modify
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        // End of variables declaration
    }




}
