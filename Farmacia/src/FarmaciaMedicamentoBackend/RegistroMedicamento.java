/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FarmaciaMedicamentoBackend;

import FarmaciaBackend.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author EMA
 */
public class RegistroMedicamento {
   
    
    
    
    
    public void registrar(String nombre,int contenido,String unidades,String marca,float precio,int Stock){
    try{
            
        Statement sql=Conexion.getConexion().createStatement();
        String query1 = "SELECT NOMBRE_MEDICAMENTO FROM MEDICAMENTO WHERE NOMBRE_MEDICAMENTO = '"+nombre+"' AND MARCA = '"+marca+"'";
        ResultSet  resultado = sql.executeQuery(query1);
        
                    if(resultado.next()){
                        JOptionPane.showMessageDialog(null, "Ya existe el medicamento");
                    }
                    else{
                        
                        String query ="INSERT INTO medicamento (nombre_medicamento,contenido,unidades_contenido,marca,precio,stock) "
                                + "VALUES('"+nombre+"', "+contenido+",'"+unidades+"','"+marca+"',"+precio+","+Stock+")";
        
                        sql.executeUpdate(query);
                        
                        JOptionPane.showMessageDialog(null, "Un nuevo medicamento ha sido ingresado");
                    }
        }catch(SQLException ex){
        
            JOptionPane.showMessageDialog(null,ex.toString() );
        }
    }
    public void modificar(String nombre,int contenido,String unidades,String marca,float precio,int Stock,int id){
    try{
            
        Statement sql=Conexion.getConexion().createStatement();
        String query1 = "SELECT NOMBRE_MEDICAMENTO FROM MEDICAMENTO WHERE ID_MEDICAMENTO = "+id;
        ResultSet  resultado = sql.executeQuery(query1);
        
                    if(resultado.next()){
                         String query ="UPDATE medicamento SET nombre_medicamento='"+nombre+"',contenido="+contenido+",unidades_contenido='"+unidades+"',marca='"+marca+"',precio="+precio+",stock="+Stock+" WHERE ID_MEDICAMENTO="+id+";";
        
                        sql.executeUpdate(query);
                        
                        JOptionPane.showMessageDialog(null, "el medicamento ha sido modificado");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "no existe el medicamento");
                    }
        }catch(SQLException ex){
        
            JOptionPane.showMessageDialog(null,ex.toString() );
        }
    
    }
}



