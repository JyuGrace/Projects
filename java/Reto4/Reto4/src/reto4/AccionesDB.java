
package reto4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccionesDB {
    public static boolean guardarCuerpoAgua (CuerpoDeAgua C_Agua){
        Connection conexion = ConexionDb.getConexion();
        
        try {
            PreparedStatement ps = conexion.prepareStatement("insert into cuerpo_agua (nombre, id, municipio, tipoC_agua, tipo_agua, irca) values (?,?,?,?,?,?)");
             ps.setString(1, C_Agua.getNombre());
             ps.setInt(2, C_Agua.getId());
             ps.setString(3, C_Agua.getMunicipio());
             ps.setString(4, C_Agua.getTipoCuerpoAgua());
             ps.setString(5, C_Agua.getTipoDeAgua());
             ps.setFloat(6, C_Agua.getIrca());
             
             return ps.executeUpdate() == 1;
             
        } catch (SQLException ex) {
            System.out.println("Error guardando cliente");
            return false;
        }
        
    }
    
    public static boolean ActualizarCuerpoAgua (CuerpoDeAgua C_Agua){
        Connection conexion = ConexionDb.getConexion();
        
        try {
            PreparedStatement ps = conexion.prepareStatement("update cuerpo_agua set nombre = ?, municipio = ?, tipoC_agua = ?, tipo_agua = ?, irca = ? where id = ?");
             ps.setString(1, C_Agua.getNombre());
             ps.setString(2 , C_Agua.getMunicipio());
             ps.setString(3, C_Agua.getTipoCuerpoAgua());
             ps.setString(4, C_Agua.getTipoDeAgua());
             ps.setFloat(5, C_Agua.getIrca());
             ps.setInt(6, C_Agua.getId());
             
             return ps.executeUpdate() == 1;
             
        } catch (SQLException ex) {
            System.out.println("Error Actualziando Cuerpo de Agua");
            return false;
        }
        
    }
  
    public static boolean EliminarCuerpoAgua (int id){
        Connection conexion = ConexionDb.getConexion();
        
        try {
            PreparedStatement ps = conexion.prepareStatement("delete from cuerpo_agua where id = ?");
            ps.setInt(1, id);
             
             return ps.executeUpdate() == 1;
             
        } catch (SQLException ex) {
            System.out.println("Error Eliminando Cliente cliente");
            return false;
        }
        
    }

    public static List <CuerpoDeAgua> ObtenerCuerpoAgua (){
        Connection conexion = ConexionDb.getConexion();
        List <CuerpoDeAgua> C_aguaList = new ArrayList<>();
        
        try {
            PreparedStatement ps = conexion.prepareStatement("select nombre, id, municipio, tipoC_agua, tipo_agua, irca from cuerpo_agua");
            ResultSet resultado = ps.executeQuery();//execute query para extraer datos de la DB y se le pasa a un resultset
            while (resultado.next()){
                CuerpoDeAgua C_Agua = new CuerpoDeAgua();
                C_Agua.setNombre(resultado.getString("nombre"));
                C_Agua.setId(resultado.getInt("id"));
                C_Agua.setMunicipio(resultado.getString("municipio"));
                C_Agua.setTipoCuerpoAgua(resultado.getString("tipoC_agua"));
                C_Agua.setTipoDeAgua(resultado.getString("tipo_agua"));
                C_Agua.setIrca(resultado.getFloat("irca"));
                
                C_aguaList.add(C_Agua);
            }
            ps.close();//here
            resultado.close();
            conexion.close();
            
            return C_aguaList;
            
        } catch (SQLException ex) {
            System.out.println("Error al tratar de obtener todos los clientes");
            return List.of();// esto es para que devuelva una lista vacia
        }
    }
    
    public static CuerpoDeAgua obtenerCuerpoAgua(int id){
        Connection conexion = ConexionDb.getConexion();
        PreparedStatement ps;
        CuerpoDeAgua C_Agua = null;
        try {
            ps = conexion.prepareStatement("select nombre, id, municipio, tipoC_agua, tipo_agua, irca from cuerpo_agua where id = ?");
            ps.setInt(1, id);
            ResultSet resultado = ps.executeQuery();//execute query para extraer datos de la DB y se le pasa a un resultset
            if (resultado.next()){
                C_Agua = new CuerpoDeAgua();
                C_Agua.setNombre(resultado.getString("nombre"));
                C_Agua.setId(resultado.getInt("id"));
                C_Agua.setMunicipio(resultado.getString("municipio"));
                C_Agua.setTipoCuerpoAgua(resultado.getString("tipoC_agua"));
                C_Agua.setTipoDeAgua(resultado.getString("tipo_agua"));
                C_Agua.setIrca(resultado.getFloat("irca"));
                
            }
            ps.close();
            resultado.close();
            conexion.close();
            
            return C_Agua;
        }
        catch (SQLException ex) {
            System.out.println("Error al tratar de obtener todos los clientes");
            return null;
        }
    }
}
