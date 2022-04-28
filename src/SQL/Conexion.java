/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
     public static Connection getConexion(){
	String conexionUrl = "jdbc:mysql://localhost:3306;"
	+ "database = productos;" 
	+ "user = root;"
	+ "password = admin;"
	+ "loginTimeout= 30;";
        
              
                
	try{
	     Connection con = DriverManager.getConnection(conexionUrl);
	     return con;
	}
	catch(SQLException ex){
	    System.out.println(ex.toString());
	    return null;
	}
}
}
