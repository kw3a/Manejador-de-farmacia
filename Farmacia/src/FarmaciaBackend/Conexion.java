/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FarmaciaBackend;

import com.sun.org.apache.bcel.internal.classfile.PMGClass;
import java.sql.*;
import java.util.Date;

public class Conexion {
	private Connection conn = null;
         
        
        public static void main(String[] args) {
        getConexion();
        obtenerfecha();
        }

	public static Connection getConexion(){
		String BD = "jdbc:mysql://localhost:3306/farmacia" +
				"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String usuario = "root";
		String pass = "admin";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("conexion exitosa");
			return DriverManager.getConnection(BD, usuario, pass);

		}catch (Exception e){
			System.out.println("conexion fallida " + e);
			return null;
		}
	}

        public static void obtenerfecha(){
        Date fecha=new Date();
            System.out.println(fecha);
        }
        
}