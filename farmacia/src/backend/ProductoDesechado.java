package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDesechado {
    private Conexion conexion;
    public void desecharProductos(int cantidadAdesechar, int idMedicamento, String motivoDesecho) throws SQLException {
        conexion = new Conexion();
        Connection conn = conexion.getConn();
        int precioIndividual = precioInd(conn, cantidadAdesechar, idMedicamento);
        if (precioIndividual != -1){
            //insert a la tabla desechado
            String sqlInsert = "INSERT INTO desechado (id_medicamento,cantidad_desechada," +
                    "total_perdido,motivo_desecho) VALUES (?,?,?,?)";
            float totalPerdido = precioIndividual * cantidadAdesechar;
            PreparedStatement insert = conn.prepareStatement(sqlInsert);
            insert.setInt(1,idMedicamento);
            insert.setInt(2,cantidadAdesechar);
            insert.setFloat(3,totalPerdido);
            insert.setString(4,motivoDesecho);
            insert.executeUpdate();
        }

    }

    private int precioInd(Connection conn, int cantidadAdesechar, int idMedicamento) throws SQLException {
        int res = -1;
        String sqlSelect = "SELECT precio,stock FROM medicamento WHERE id_medicamento =?";
        PreparedStatement select = conn.prepareStatement(sqlSelect);
        select.setInt(1,idMedicamento);
        ResultSet rs = select.executeQuery();
        int precioIndividual = rs.getInt(1);
        int stock = rs.getInt(2);
        if (stock >= cantidadAdesechar){
            //actualizacion de stock tabla medicamento
            res = precioIndividual;
            int nuevaCantidad = stock - cantidadAdesechar;
            String update = "UPDATE medicamento SET stock=? WHERE id_medicamento =?";
            PreparedStatement up = conn.prepareStatement(update);
            up.setInt(1,nuevaCantidad);
            up.setInt(2,idMedicamento);
            up.executeUpdate();
        }
        return res;
    }
}
