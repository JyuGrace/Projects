package reto4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDb {
     private static Connection conexion;
     
     private static void conectar (){
         final String path = System.getProperty("user.dir");
             String url = "jdbc:sqlite:" + path + "/cuerpoAgua.db";
             
         try {
             conexion = DriverManager.getConnection(url);
         } catch (SQLException ex) {
             System.out.println("No se pudo conectar a la base de datos");
             
         }
         
     }

    public static Connection getConexion() {
        conectar();
        return conexion;
    }
     
         
    
}
