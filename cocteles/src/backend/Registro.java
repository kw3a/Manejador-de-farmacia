package backend;

import javax.swing.*;
import java.sql.*;
public class Registro {

    private Conexion c;
    private Connection conn;
    public Registro(){
        c = new Conexion();
        conn = c.getConn();

    }
    private boolean existe(String nombre){
        boolean res = false;
        try {
            String sql = "SELECT * FROM coctel WHERE nombre=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                res = true;
            }
        }catch (Exception e){}
        return res;
    }

    public void registrar(String nombre, float precio){
        if (!existe(nombre)){
            try {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO coctel (nombre, precio) VALUES (?,?)");
                ps.setString(1,nombre);
                ps.setFloat(2,precio);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "registrado con exito");

            }catch (Exception e){
                System.out.println("No se ha podido insertar "+e);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "ya existe");
        }
    }

}
