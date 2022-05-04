/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import backend.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author EMA
 */
public class RegistroProveedores {
    public void registrar(String nombre,String empresa,String direccion,int telefono){
    try{
            
        Statement sql=Conexion.getConexion().createStatement();
        String query1 = "SELECT NOMBRE_REPRESENTANTE,EMPRESA FROM PROVEEDOR  WHERE NOMBRE_REPRESENTANTE = '"+nombre+"' AND EMPRESA = '"+empresa+"'";
        ResultSet  resultado = sql.executeQuery(query1);
        
                    if(resultado.next()){
                        JOptionPane.showMessageDialog(null, "Ya existe el Proveedor");
                    }
                    else{
                        
                        String query ="INSERT INTO Proveedor (nombre_representante,empresa,domicilio,telefono) "
                                + "VALUES('"+nombre+"','"+empresa+"','"+direccion+"',"+telefono+")";
        
                        sql.executeUpdate(query);
                        
                        JOptionPane.showMessageDialog(null, "Un nuevo proveedor ha sido ingresado");
                    }
        }catch(SQLException ex){
        
            JOptionPane.showMessageDialog(null,ex.toString() );
        }
    }

    public static ArrayList<String> proveedores() throws SQLException {
        ArrayList<String> res = new ArrayList<>();
        String sql = "SELECT empresa FROM PROVEEDOR";
        PreparedStatement select = Conexion.getConexion().prepareStatement(sql);
        ResultSet rs = select.executeQuery();
        while (rs.next()){
            String empr = rs.getString(1);
            res.add(empr);
        }
        return res;
    }
}
