package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Venta {
    Conexion conexion;

    public boolean vender(ArrayList<Integer> idProducto, ArrayList<Integer> cantidades, int ciVendedor, int ciCliente) throws SQLException {
        boolean res = false;
        conexion = new Conexion();
        Connection conn = conexion.getConn();
        boolean ventaCompletaValida = true;
        ArrayList<Integer> preciosTotales = new ArrayList<>();
        for (int i = 0; i < idProducto.size(); i++) {
            int idActual = idProducto.get(i);
            int cantActual = cantidades.get(i);
            if (!ventaIndValida(conn, idActual, cantActual, preciosTotales)){
                ventaCompletaValida = false;
                break;
            }
        }
        if (ventaCompletaValida){
            for (int i = 0; i < idProducto.size(); i++) {
                int idActual = idProducto.get(i);
                int cantActual = cantidades.get(i);
                int precioInd = preciosTotales.get(i);
                updateMedicamento(conn, idActual, cantActual);
                insertVenta(conn,idActual, precioInd, ciVendedor, ciCliente);
            }
        }
        return res;
    }

    private void updateMedicamento(Connection conn, int idProducto, int cantidad) throws SQLException {
        String selectSql = "UPDATE medicamento SET stock=stock-? WHERE id_medicamento=?";
        PreparedStatement update =  conn.prepareStatement(selectSql);
        update.setInt(1,cantidad);
        update.setInt(2,idProducto);
        update.executeUpdate();
    }

    private void insertVenta(Connection conn, int idProducto, int total, int ciVendedor, int ciCliente) throws SQLException {
        String insertSql = "INSERT INTO venta (id_venta, total, ci_cli, ci_ven) VALUES (?,?,?,?)";
        PreparedStatement insert = conn.prepareStatement(insertSql);
        insert.setInt(1,idProducto);
        insert.setInt(2,total);
        insert.setInt(3,ciCliente);
        insert.setInt(4,ciVendedor);
        insert.executeUpdate();
    }
    private boolean ventaIndValida(Connection conn, int idProducto, int cantidad, ArrayList<Integer> preciosTotales) throws SQLException {
        boolean res = false;
        String selectSql = "SELECT stock,precio FROM medicamento WHERE id_medicamento=?";
        PreparedStatement select =  conn.prepareStatement(selectSql);
        select.setInt(1,idProducto);
        ResultSet resultado = select.executeQuery();
        int stock = resultado.getInt(1);
        int precio = resultado.getInt(2);
        preciosTotales.add(precio*cantidad);
        res = (stock - cantidad) >= 0;
        return res;
    }
}