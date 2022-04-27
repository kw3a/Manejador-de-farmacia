package backend;

import java.sql.*;

public class Conexion {
    private Connection conn = null;

    public Conexion(){
        String BD = "jdbc:mysql://localhost:3306/farmacia" +
                "?useUnicode=true&useJDBCCompliantTimezoneShift=true" +
                "&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String usuario = "root";
        String pass = "admin";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(BD, usuario, pass);
            System.out.println("conexion exitosa");
        }catch (Exception e){
            System.out.println("conexion fallida " + e);
        }
    }

    public Connection getConn() {
        return conn;
    }

}
