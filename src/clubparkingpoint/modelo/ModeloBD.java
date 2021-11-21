/*
coneccion a la base de datos
 */
package clubparkingpoint.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ModeloBD {
    private String servidor="jdbc:mysql://localhost/club_parking_point";
    private String usuario="root";
    private String password="";

    public ModeloBD() {
    }
    
    public Connection conectarBD(){
        
        Connection conexion=null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection(servidor,usuario,password);
            System.out.println("Exito conectandonos");
            return conexion;
            
        }catch(Exception error){
            
            System.out.println("UPSS.. "+error);
            return null;
            
        }
    }
}
