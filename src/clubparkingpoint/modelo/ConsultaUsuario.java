/*
consulta de usuario
 */
package clubparkingpoint.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaUsuario extends ModeloBD{
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
     public boolean registrarUsuario(Usuario usuario){
        Connection conexion=conectarBD();
        String query="INSERT INTO usuario(cedula,nombre,apellido,telefono,fechaIngreso,placa)"
                + "VALUES (?,?,?,?,?,?)";
        
       try{
            //Peparate que voy con toa
            consultaSQL=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setString(1,usuario.getCedula());
            consultaSQL.setString(2,usuario.getNombre());
            consultaSQL.setString(3,usuario.getApellido());
            consultaSQL.setString(4,usuario.getTelefono());
            consultaSQL.setString(5,usuario.getFechaIngreso());
            consultaSQL.setString(7,usuario.getIdPlaca());
            
            
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
        String query = "SELECT * from usuario where cc=?";
        
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
                
                usuario.setCedula(resultadoSQL.getString("cc"));
                usuario.setNombre(resultadoSQL.getString("nombre"));
                usuario.setApellido(resultadoSQL.getString("apellido"));
                usuario.setTelefono(resultadoSQL.getString("telefono"));
                usuario.setFechaIngreso(resultadoSQL.getString("fechaIngreso"));                
                return usuario;                
            }else{                
                return null;
            }
            
        }catch(Exception error){
            
            System.out.println("upsss... "+error);
            return null;
        }   
   }
     
     public  boolean actualizarUsuario(Usuario usuario){
       
       Connection conexion=conectarBD();
       String query="UPDATE usuario SET fechaSalida=? WHERE cc=?";
       
       try{
            //Peparate que voy con toa
            consultaSQL=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setString(1,usuario.getFechaSalida());
            consultaSQL.setString(2,usuario.getCedula());

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
}
