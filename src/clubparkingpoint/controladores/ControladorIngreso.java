/*

 */
package clubparkingpoint.controladores;


import clubparkingpoint.modelo.ConsultaUsuario;
import clubparkingpoint.modelo.ConsultaVehiculo;
import clubparkingpoint.modelo.Usuario;
import clubparkingpoint.modelo.Vehiculo;
import clubparkingpoint.vistas.VistaHome;
import clubparkingpoint.vistas.VistaIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
        
public class ControladorIngreso  implements ActionListener{
    VistaIngreso vistaingreso = new VistaIngreso();
    Usuario usuario = new Usuario();
    Vehiculo vehiculo = new Vehiculo();

    public ControladorIngreso(VistaIngreso vistaingreso, Usuario usuario, Vehiculo vehiculo) {
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.vistaingreso = vistaingreso;
        vistaingreso.botonAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        ConsultaUsuario consultaUsuario = new ConsultaUsuario();
        ConsultaVehiculo consultaVehiculo = new ConsultaVehiculo();

        usuario.setCedula(vistaingreso.txtCedula.getText());
        usuario.setNombre(vistaingreso.txtNombre.getText());
        usuario.setApellido(vistaingreso.txtApellido.getText());
        usuario.setTelefono(vistaingreso.txtTelefono.getText());
        usuario.setFechaIngreso(vistaingreso.txtIngreso.getText());

        vehiculo.setPlaca(vistaingreso.txtPlaca.getText());
        vehiculo.setMarca(vistaingreso.txtMarca.getText());
        vehiculo.setModelo(vistaingreso.txtModelo.getText());
        vehiculo.setColor(vistaingreso.txtColor.getText());
        //vehiculo.setTotalPagoVehiculo(Integer.parseInt(vistaingreso.txtPago.getText()));

        Date entrada = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEntrada = formato.format(entrada);
        usuario.setFechaIngreso(fechaEntrada);

        //llamar las consultas SQL para agregar una escuderia y un piloto
        if (consultaUsuario.registrarUsuario(usuario) && consultaVehiculo.insertarVehiculo(vehiculo)) {
            JOptionPane.showMessageDialog(null, "Exito! agregando los datos correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Error! no se agragan los datos correctamente");
        }
    }
}
