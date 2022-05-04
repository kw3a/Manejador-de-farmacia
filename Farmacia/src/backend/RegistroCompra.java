/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.Conexion;
import static backend.Conexion.getConexion;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Darwin
 */
public class RegistroCompra {
   
        public static void main(String[] args) {
        getConexion();
        }
       
    public static void registrarCompra(String producto ,String proveedor, String cantidad , String preciounitario ,String fechaVenc){
        try{
        Statement sql = Conexion.getConexion().createStatement();

            int PrecioUnitario=Integer.parseInt(preciounitario);
            int Cantidad=Integer.parseInt(cantidad);
            int TotalCompra=PrecioUnitario*Cantidad;
            String query ="INSERT INTO pedido (id_medicamento, fecha_vencimiento, empresa, cantidad_comprada, " +
                    "precio_unitario, precio_total) VALUES('"+producto+"', '"+fechaVenc+"', '"+proveedor+"', "
                    +cantidad+" , "+preciounitario+", "+TotalCompra+")";
            sql.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Una nueva compra ha sido registrada");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.toString() );
        }
    }

    public static String[] listaIdMedicamento() throws SQLException {
        String sql = "SELECT id_medicamento FROM medicamento";
//            String[] res = null;
        PreparedStatement select = Conexion.getConexion().prepareStatement(sql);
        ResultSet rs = select.executeQuery();
        String count = "SELECT COUNT(id_medicamento) FROM medicamento";
        PreparedStatement cn = Conexion.getConexion().prepareStatement(count);
        ResultSet tam = cn.executeQuery();
        tam.next();
        int size = tam.getInt(1);
        String[] res = new String[size];
        int contador = 0;
        while (rs.next()){
            res[contador] = rs.getString(1);
            contador++;
        }
        return res;
    }

}
