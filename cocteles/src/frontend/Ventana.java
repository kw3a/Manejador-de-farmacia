package frontend;

import backend.Registro;
import javax.swing.*;
import java.awt.*;

public class Ventana extends javax.swing.JFrame{
    Registro registro;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textPrecio;


    public Ventana() {
        registro  = new Registro();
        initComponents();
    }

    private void initComponents() {

        btnRegistrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        textPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarBtnRegistrar(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel3.setText("Precio");

        jLabel4.setText("Cocteles");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(layout.createSequentialGroup()
                                                .add(92, 92, 92)
                                                .add(btnRegistrar))
                                        .add(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                        .add(jLabel2)
                                                        .add(jLabel3))
                                                .add(31, 31, 31)
                                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                        .add(textNombre)
                                                        .add(textPrecio, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                                        .add(layout.createSequentialGroup()
                                                .add(106, 236, 236)
                                                .add(jLabel4)))
                                .addContainerGap(260, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jLabel4)
                                .add(90, 90, 90)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel2)
                                        .add(textNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(31, 31, 31)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                        .add(jLabel3)
                                        .add(textPrecio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 43, Short.MAX_VALUE)
                                .add(btnRegistrar)
                                .add(3, 3, 3)
        ));
        pack();
        this.setSize(new Dimension(350, 400));
    }

    private void iniciarBtnRegistrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        String nombre = textNombre.getText();
        float precio = Float.parseFloat(textPrecio.getText());
        registro.registrar(nombre, precio);

    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

}
