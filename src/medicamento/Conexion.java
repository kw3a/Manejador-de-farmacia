package medicamento;
//@edgar

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    
    public static void main(String[] args) {
        Conexion con = new Conexion();
        con.conectar();
        //con.agregar();
        int res = con.buscarStock(15,"ibuprofeno","bago");

    }

    public Connection conn = null;
    //int cant = 0;
    public void conectar(){
        String BD = "jdbc:mysql://localhost:3306/tt" ;                       
		String usuario = "root";
		String pass = "admin";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");						
                        conn = DriverManager.getConnection(BD, usuario, pass);
		}catch (Exception e){			
			
		}
    }
    public void agregar(){
        
        try { 
            System.out.println("conexion exitosa");
            Statement stmt = conn.createStatement(); 
            String query = "insert into medicamento (codigo,nombre,cantidad) values ('4','sal','3')";
            stmt.executeUpdate(query);
		}catch (SQLException e){			
			
		}
    }

    public int buscarStock(int codigo,String nombre,String marca){
        int cant;
        System.out.println(marca);
      try { 
            
            Statement stmt = conn.createStatement(); 
            String query ;                         
            query = "select stock from medicamento where codigo='"+codigo+"' and  nombre='"+nombre+"'and marca='"+marca+"'";
            ResultSet consulta = stmt.executeQuery(query);
            consulta.next();
            Integer cont = consulta.getInt("stock");
            cant = cont;
            System.out.println(" "+cant+" ");        
		}catch (SQLException e){			
			cant = 0;
		} 
      return cant;
    }
}
