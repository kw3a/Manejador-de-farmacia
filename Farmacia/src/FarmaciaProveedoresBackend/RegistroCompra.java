/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FarmaciaProveedoresBackend;

import FarmaciaBackend.Conexion;
import static FarmaciaBackend.Conexion.getConexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Darwin
 */
public class RegistroCompra {
   
        public static void main(String[] args) {
        getConexion();
        }
       
    public static void registrarCompra(String producto ,String proveedor, String cantidad , String preciounitario ,String preciototal){
        try{
        Statement sql = Conexion.getConexion().createStatement();
            String query1 = "SELECT CURDATE();";
                ResultSet  resultado = sql.executeQuery(query1);
                String fecha ="";
                while (resultado.next()) {     
                    //LA FECHA ES DEL TIPO DATETIME EN LA BASE DE DATOS
                fecha = resultado.getString("CURDATE()");
                }
                        int PrecioUnitario=Integer.parseInt(preciounitario);
                        int Cantidad=Integer.parseInt(cantidad);
                        int TotalCompra=PrecioUnitario*Cantidad;
                        String query ="INSERT INTO pedido (id_medicamento, fecha_pedido, empresa, cantidad_comprada, " +
                                "precio_unitario, precio_total) VALUES('"+producto+"', '"+fecha+"', '"+proveedor+"', "
                                +cantidad+" , "+preciounitario+", "+TotalCompra+")";
                       
                        sql.executeUpdate(query);
                        
                        JOptionPane.showMessageDialog(null, "Una nueva compra ha sido registrada");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.toString() );
        }
    }
}
