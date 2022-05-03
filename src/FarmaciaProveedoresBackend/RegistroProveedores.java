/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FarmaciaProveedoresBackend;

import FarmaciaBackend.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author EMA
 */
public class RegistroProveedores {
    public void registrar(String nombre,String empresa,String direccion,int telefono){
    try{
            
        Statement sql=Conexion.getConexion().createStatement();
        String query1 = "SELECT NOMBRE,EMPRESA FROM PROVEEDORES  WHERE NOMBRE = '"+nombre+"' AND EMPRESA = '"+empresa+"'";
        ResultSet  resultado = sql.executeQuery(query1);
        
                    if(resultado.next()){
                        JOptionPane.showMessageDialog(null, "Ya existe el Proveedor");
                    }
                    else{
                        
                        String query ="INSERT INTO Proveedores (nombre,empresa,direccion,telefono) "
                                + "VALUES('"+nombre+"','"+empresa+"','"+direccion+"',"+telefono+")";
        
                        sql.executeUpdate(query);
                        
                        JOptionPane.showMessageDialog(null, "Un nuevo proveedor ha sido ingresado");
                    }
        }catch(SQLException ex){
        
            JOptionPane.showMessageDialog(null,ex.toString() );
        }
    }
}
