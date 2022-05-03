/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package FarmaciaMedicamentoFrontend;

import FarmaciaBackend.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EMA
 */
public class frmMedicamentosVencidos extends javax.swing.JFrame {

    /**
     * Creates new form frmMedicamentosVencidos
     */
    public int month;
    public frmMedicamentosVencidos() {
        initComponents();
        obtenerfecha();
        cargartabla();
        
    }
public  void obtenerfecha(){
        /*Date fecha=new Date();
        System.out.println(fecha);*/
        //Para mostrar la fecha
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();        
		String dateToStr = dateFormat.format(date);
		System.out.println("Date is "+ dateToStr);
                txtFechaActual.setText(dateToStr);
        //Para obtener el mes y dia
        Date date2 = new Date();
        LocalDate localDate = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
         month = localDate.getMonthValue();
        System.out.println(""+month);
                
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegistro = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtFechaActual = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MEDICAMENTOS VENCIDOS");

        tablaRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "CANTIDAD", "CANT PERDIDAD"
            }
        ));
        jScrollPane1.setViewportView(tablaRegistro);

        jLabel3.setText("FECHA ACTUAL");

        txtFechaActual.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        txtFechaActual.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Cerca a Vencer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ya vencidos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                        .addGap(63, 63, 63))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(txtFechaActual, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cargartabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cargartablayavencidos();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void cargartabla(){
        String [] titulos={"Codigo","Nombre","Contenido","Unidades","Marca","Precio","Stock","Fecha vencimiento"};
        String [] registros=new String[9];
        String SQL="Select * from medicamentos";
        DefaultTableModel modelo=new DefaultTableModel(null,titulos);
        try {
            
            Statement sql2=Conexion.getConexion().createStatement();
            String query2 = "SELECT * FROM medicamento,pedido WHERE MONTH(fecha_vencimiento) = "+month+"";
            ResultSet  resultado = sql2.executeQuery(query2);
            
            while(resultado.next()){
            
                registros[0]=resultado.getString("ID_MEDICAMENTO");
                registros[1]=resultado.getString("nombre_medicamento");
                registros[2]=resultado.getString("contenido");
                registros[3]=resultado.getString("unidades_contenido");
                registros[4]=resultado.getString("marca");
                registros[5]=resultado.getString("precio");
                registros[6]=resultado.getString("stock");
                registros[7]=resultado.getString("fecha_vencimiento");
                
                modelo.addRow(registros);
            }
            
            tablaRegistro.setModel(modelo);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar"+e);
        }
        
    }
    public void cargartablayavencidos(){
    String [] titulos={"Codigo","Nombre","Contenido","Unidades","Marca","Precio","Stock","Fecha vencimiento"};
        String [] registros=new String[9];
        String SQL="Select * from medicamentos";
        DefaultTableModel modelo=new DefaultTableModel(null,titulos);
        try {
            
//            Statement sql2=Conexion.getConexion().createStatement();
//            String query2 = "SELECT * FROM pedido,medicamento WHERE MONTH(fecha_vencimiento) < ?"+month+
//                    "ORDER BY fecha_vencimiento";

//            String query = "(SELECT id_medicamento FROM pedido WHERE MONTH < ?)";


            String q = "SELECT * FROM pedido,medicamento WHERE pedido.id_medicamento IN (SELECT id_medicamento FROM pedido WHERE MONTH < ?)";
            PreparedStatement sel = Conexion.getConexion().prepareStatement(q);
            sel.setInt(1,month);
//            PreparedStatement select = Conexion.getConexion().prepareStatement(query2);
//            select.setInt(1,month);
            ResultSet  resultado = sel.executeQuery();
            
            while(resultado.next()){
            
                registros[0]=resultado.getString("ID_MEDICAMENTO");
                registros[1]=resultado.getString("nombre_medicamento");
                registros[2]=resultado.getString("contenido");
                registros[3]=resultado.getString("unidades_contenido");
                registros[4]=resultado.getString("marca");
                registros[5]=resultado.getString("precio");
                registros[6]=resultado.getString("stock");
                registros[7]=resultado.getString("fecha_vencimiento");
                
                modelo.addRow(registros);
            }
            
            tablaRegistro.setModel(modelo);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar"+e);
        }
        
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
            java.util.logging.Logger.getLogger(frmMedicamentosVencidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMedicamentosVencidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMedicamentosVencidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMedicamentosVencidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMedicamentosVencidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaRegistro;
    private javax.swing.JLabel txtFechaActual;
    // End of variables declaration//GEN-END:variables
}
