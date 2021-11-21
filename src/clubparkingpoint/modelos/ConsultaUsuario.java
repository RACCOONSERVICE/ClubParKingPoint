/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clubparkingpoint.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class ConsultaUsuario extends ModeloBD{
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
     public boolean registrarUsuario(Usuario usuario){
         
         Connection conexion=conectarBD();
        String query="INSERT INTO usuarios(cedula,nombre,apellido,telefono)"
                + "VALUES (?,?,?,?)";
        
       try{
            //Peparate que voy con toa
            consultaSQL=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setString(1,usuario.getCedula());
            consultaSQL.setString(2,usuario.getNombre());
            consultaSQL.setString(3,usuario.getApellido());
            consultaSQL.setString(4,usuario.getTelefono());
            
            //Ejecuto la consulta
            int resultado=consultaSQL.executeUpdate();
            
            //validando el resultado
            if(resultado>0){
              return true;  
            }else{
               return false; 
            } 
        }catch(Exception error){
            
            System.out.println("upsss... "+error);
            return false;
        }
     }

       // buscar usuario
     public Usuario buscarUsuario(String cedula){
       
        Connection conexion=conectarBD();
        String query = "SELECT * from usuarios where cedula=?";
        
        try{
            
            //Peparate que voy con toa
            consultaSQL=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setString(1, cedula);
            
            //Ejecuto la consulta
            resultadoSQL=consultaSQL.executeQuery();
            
            //Orgaizo el resultado
            Usuario usuario = new Usuario();
            if(resultadoSQL.next()){
                
                usuario.setCedula(resultadoSQL.getString("cedula"));
                usuario.setNombre(resultadoSQL.getString("nombre"));
                usuario.setApellido(resultadoSQL.getString("apellido"));
                usuario.setTelefono(resultadoSQL.getString("telefono"));
                
                return usuario;
                
            }else{
                
                return null;
            }
            
        }catch(Exception error){
            
            System.out.println("upsss... "+error);
            return null;
        }   
   } 
}
