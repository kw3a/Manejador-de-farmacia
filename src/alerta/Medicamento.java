//@edgar
package alerta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import FarmaciaBackend.Conexion;

public class Medicamento {
//    Conexion con = new Conexion();

    public boolean stockMedicamento(int codigo,String nombre,String marca){
        int cant;
        cant = buscarStock(codigo,nombre,marca);
        return (cant > 10)? true:false;        
    }

    public int buscarStock(int codigo,String nombre,String marca){
        int cant;
        System.out.println(marca);
        try {
            Connection conn = Conexion.getConexion();
            Statement stmt = conn.createStatement();
            String query ;
            query = "select stock from medicamento where id_medicamento='"+codigo+"' and  nombre_medicamento='"+nombre+"'and marca='"+marca+"'";
            ResultSet consulta = stmt.executeQuery(query);
            consulta.next();
            Integer cont = consulta.getInt("stock");
            cant = cont;
//            System.out.println(" "+cant+" ");
        }catch (SQLException e){
            cant = 0;
        }
        return cant;
    }
}
