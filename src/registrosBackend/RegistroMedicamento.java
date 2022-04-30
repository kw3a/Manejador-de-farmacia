/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrosBackend;

/**
 *
 * @author Windows 10
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static registrosBackend.Conexion.getConexion;

/**
 *
 * @author Darwin
 */
public class RegistroMedicamento {
   
        public static void main(String[] args) {
        getConexion();
        }
       
    public static void registrarMedicamento(int id_Medicamento ,String nombre_medicamento , String unidades_contenido , String marca ,String precio, int stock){
         
        try{
        
        Statement sql = Conexion.getConexion().createStatement();
            
        
          
            
           
                
               String query1 = "SELECT nombre_medicamento FROM medicamento  WHERE nombre_medicamento = '"+nombre_medicamento+"' and marca = '"+marca+"'";
                ResultSet  resultado = sql.executeQuery(query1);
        
                    if(resultado.next() ){
                        JOptionPane.showMessageDialog(null, "Ya existe el medicamento");
                    }
                    else{
                        //INSERT INTO medicamento (nombre_medicamento, contenido, unidades_contenido, marca, precio, stock) VALUES('ibuprofeno', 0, 'decena', 'patito' , 20, 24)
                          String query ="INSERT INTO medicamento (id_Medicamento, nombre_medicamento, contenido, unidades_contenido, marca, precio, stock) VALUES("+id_Medicamento+", '"+nombre_medicamento+"', 0 , '"+unidades_contenido+"', '"+marca+"' , "+precio+", "+stock+")";
                       
                          sql.executeUpdate(query);
                        
                          JOptionPane.showMessageDialog(null, "Una nuevo medicamento ha sido registrado");
                    }
                       
                        
                            
           
            
         
        }catch(SQLException ex){
        
            JOptionPane.showMessageDialog(null,ex.toString() );
        }
    }
}

