package medicamento;
//@edgar

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    
    /*public static void main(String[] args) {
        Conexion con = new Conexion();
        con.conectar();
        //con.agregar();
        con.buscarStock();

    }*/

    public Connection conn = null;
    //int cant = 0;
    public void conectar(){
        String BD = "jdbc:mysql://localhost:3306/tt" ;
                       // + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario = "root";
		String pass = "admin";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			//java.sql.Connection conn;
                        conn = DriverManager.getConnection(BD, usuario, pass);
                        //System.out.println("conexion exitosa");
                        //Statement stmt = conn.createStatement(); 
                        //String query = "insert into medicamento (codigo,nombre,cantidad) values ('3','ala','3')";
                        //stmt.executeUpdate(query);
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

    public int buscarStock(int codigo,String marca){
        int cant;
        System.out.println("seremos");
      try { 
            
            Statement stmt = conn.createStatement(); 
            String query = "select cantidad from medicamento, variedad where codigo='"+codigo+"' and marca='"+marca+"';" ;              
            //int res = stmt.executeUpdate(query);
            ResultSet consulta = stmt.executeQuery(query);
            consulta.next();
            Integer cont = consulta.getInt("cantidad");
            cant = cont;
            System.out.println(" "+cant+" ");        
		}catch (SQLException e){			
			cant = 0;
		} 
      return cant;
    }
}
