/*
consulta de vehiculo
 */
package clubparkingpoint.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultaVehiculo extends ModeloBD{
    private  PreparedStatement  consultaSQL;
    private  ResultSet resultadoSQL;

    
    public boolean insertarVehiculo(Vehiculo vehiculo){    
        Connection conexion = conectarBD();
        String query="INSERT INTO vehiculo(placa,marca,modelo,color,totalPagoVehiculo)" + "VALUES (?,?,?,?,?)" ;           
    try{    
        consultaSQL=conexion.prepareStatement(query);
        consultaSQL.setString(1,vehiculo.getPlaca());
        consultaSQL.setString(2,vehiculo.getMarca());
        consultaSQL.setString(3,vehiculo.getModelo());
        consultaSQL.setString(4,vehiculo.getColor());
        consultaSQL.setInt(5,vehiculo.getTotalPagoVehiculo());
        int resultado=consultaSQL.executeUpdate();
        if(resultado>0){
            return true;
        }else{
            return false;
        }
    }catch(Exception error){
        System.out.println("upss....."+error);
        return false;
    }

}
    public Vehiculo buscarVehiculo(String placa){   
        Vehiculo vehiculo = new Vehiculo();
        Connection conexion = conectarBD();  
        String query="SELECT * FROM vehiculo WHERE placa=?";
        
        try{
            consultaSQL=conexion.prepareStatement(query);
            consultaSQL.setString(1,placa);
            resultadoSQL=consultaSQL.executeQuery();
            
            if(resultadoSQL.next()){
                vehiculo.setPlaca(resultadoSQL.getString("placa"));
                vehiculo.setMarca(resultadoSQL.getString("marca"));
                vehiculo.setMarca(resultadoSQL.getString("modelo"));
                vehiculo.setColor(resultadoSQL.getString("color"));
                vehiculo.setTotalPagoVehiculo(resultadoSQL.getInt("totalPagoVehiculo"));
                return vehiculo;
            }else{
                return null;
            }
        }catch(Exception error){
            System.out.println("upsss"+ error);
            return null;            
        }
    } 
}
