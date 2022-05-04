package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Venta {

    public static void main(String[] args) {
        ArrayList<Integer> ej = new ArrayList<>();
        ej.add(1);
        ArrayList<Integer> cant = new ArrayList<>();
        cant.add(1);
        try {
            vender(ej, cant, 124, 123);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean vender(ArrayList<Integer> idProducto, ArrayList<Integer> cantidades, int ciVendedor, int ciCliente) throws SQLException {
        Connection conn = Conexion.getConexion();
        boolean res = false;
//        conexion = new Conexion();
//        Connection conn = conexion.getConn();
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
                insertVenta(conn, precioInd, ciVendedor, ciCliente);
            }
        }
        return res;
    }

    public static float getPrecioUnitario(int id_Medicamento){
        float res = -1;
        String sql = "SELECT precio FROM medicamento WHERE id_medicamento="+id_Medicamento;
        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            res = rs.getFloat(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public static String getNombre(int id_medicamento){
        String res = "";
        String sql = "SELECT nombre_medicamento FROM medicamento WHERE id_medicamento ="+id_medicamento;
        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            res = rs.getString(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    private static void updateMedicamento(Connection conn, int idProducto, int cantidad) throws SQLException {
        String selectSql = "UPDATE medicamento SET stock=stock-? WHERE id_medicamento=?";
        PreparedStatement update =  conn.prepareStatement(selectSql);
        update.setInt(1,cantidad);
        update.setInt(2,idProducto);
        update.executeUpdate();
    }

    private static void insertVenta(Connection conn, int total, int ciVendedor, int ciCliente) throws SQLException {
        String insertSql = "INSERT INTO venta (total, ci_cli, ci_ven) VALUES (?,?,?)";
        PreparedStatement insert = conn.prepareStatement(insertSql);
        insert.setInt(1,total);
        insert.setInt(2,ciCliente);
        insert.setInt(3,ciVendedor);
        insert.executeUpdate();
    }
    private static boolean ventaIndValida(Connection conn, int idProducto, int cantidad, ArrayList<Integer> preciosTotales) throws SQLException {
        boolean res = false;
        String selectSql = "SELECT stock,precio FROM medicamento WHERE id_medicamento=?";
        PreparedStatement select =  conn.prepareStatement(selectSql);
        select.setInt(1,idProducto);
        ResultSet resultado = select.executeQuery();
        resultado.next();
        int stock = resultado.getInt(1);
        int precio = resultado.getInt(2);
        preciosTotales.add(precio*cantidad);
        res = (stock - cantidad) >= 0;
        return res;
    }
}