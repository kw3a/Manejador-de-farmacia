package backend;

import FarmaciaBackend.Conexion;

import java.sql.*;
import java.util.ArrayList;

public class ProductoDesechado {
    public void desecharProductos(int cantidadAdesechar, int idMedicamento, String motivoDesecho) throws SQLException {
//        conexion = new Conexion();
        Connection conn = Conexion.getConexion();
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
        if (rs.next()){
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
        }
        return res;
    }
    public ArrayList<Desecho> obtenerHistorial(Connection conn, Date fechaIni, Date fechaFin) throws SQLException {
        ArrayList<Desecho> res = new ArrayList<>();
        String selectSql = "SELECT id_medicamento,fecha_desecho,cantidad_desechada,total_perdido," +
                "motivo_desecho FROM desechado WHERE (fecha_desecho>=? AND fecha_desecho<=?) ORDER BY fecha_desecho";
        PreparedStatement select = conn.prepareStatement(selectSql);
        select.setDate(1,fechaIni);
        select.setDate(2,fechaFin);
        ResultSet rs = select.executeQuery();
        while (rs.next()){
            int idMed = rs.getInt(1);
            Date fechaDesecho = rs.getDate(2);
            int cantidadDesechada = rs.getInt(3);
            float totalPerdido= rs.getFloat(4);
            String motivo_desecho = rs.getString(5);
            Desecho act = new Desecho(idMed, fechaDesecho, totalPerdido, cantidadDesechada, motivo_desecho);
            res.add(act);
        }
        return res;
    }
}
