/*

 */
package clubparkingpoint.controladores;

import clubparkingpoint.modelo.ConsultaUsuario;
import clubparkingpoint.modelo.ConsultaVehiculo;
import clubparkingpoint.modelo.Usuario;
import clubparkingpoint.modelo.Vehiculo;
import clubparkingpoint.vistas.VistaSalida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public class ControladorSalida implements ActionListener{
    VistaSalida vistasalida = new VistaSalida();
    Usuario usuario = new Usuario();
    Vehiculo vehiculo = new Vehiculo();
    
    public ControladorSalida(VistaSalida vistasalida, Usuario usuario, Vehiculo vehiculo){
        this.vistasalida = vistasalida;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        
        vistasalida.botonSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        ConsultaVehiculo consultavehiculo =  new ConsultaVehiculo();
        ConsultaUsuario consultausuario = new ConsultaUsuario();
         
         //Consultar los datos del piloto a buscar para poder editarlo
         vehiculo = consultavehiculo.buscarVehiculo(vistasalida.txtPlaca.getText());
        
         //consultar la fecha entrada STRING
         String fechaEntrada = usuario.getFechaIngreso();
         
         //convertir la FECHA STRING EN DATE
         try{
             Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaEntrada);
             Date salida = new Date();
             SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String fechaSalida =formato.format(salida);
             
             //rutina para calcular la resta de tiempo
             long tiempoDiferencia=salida.getTime()-entrada.getTime();
             TimeUnit unidadTiempo=TimeUnit.MINUTES;
             long tiempoEnVehiculo=unidadTiempo.convert(tiempoDiferencia,TimeUnit.MILLISECONDS);
             
             //llevemos el valor de la fecha salida STRING al objeto piloto
             usuario.setFechaSalida(fechaSalida);
             
             //ejecutar la consulta para actualizar el piloto
             if(consultausuario.actualizarUsuario(usuario)){
                  JOptionPane.showMessageDialog(null, "Exito retirando, se quedo: "+tiempoEnVehiculo);
             }else{
                 JOptionPane.showMessageDialog(null, "Fallamos retirando");
             }
                     
         }catch(ParseException error){
             System.out.println("upsss.. "+error);
         }
    }    
}


