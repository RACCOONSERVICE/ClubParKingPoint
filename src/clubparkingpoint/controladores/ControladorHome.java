/*

 */
package clubparkingpoint.controladores;

import clubparkingpoint.modelo.ConsultaUsuario;
import clubparkingpoint.modelo.Usuario;
import clubparkingpoint.modelo.Vehiculo;
import clubparkingpoint.vistas.VistaHome;
import clubparkingpoint.vistas.VistaIngreso;
import clubparkingpoint.vistas.VistaSalida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorHome implements ActionListener{

    //ATRIBUTOS
    VistaHome vistahome = new VistaHome();
    Usuario usuario = new Usuario();
    Vehiculo vehiculo = new Vehiculo();

    public ControladorHome(VistaHome vistahome, Usuario usuario, Vehiculo vehiculo) {

        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.vistahome = vistahome;
        vistahome.botonIngresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        ConsultaUsuario consultaUsuario = new ConsultaUsuario();
        String cedula = vistahome.txtCedula1.getText();

        //SI consulta una escuderia y esta SI se encuentra
        if (consultaUsuario.buscarUsuario(cedula) != null) {

            //lanzar la vista de retiro
            VistaSalida vistaSalida = new VistaSalida();
            vistahome.setVisible(false);
            vistaSalida.setVisible(true);

            //ControladorSalida controladorSalida = new ControladorSalida(vistaSalida, usuario, vehiculo);

        } else {

            //Ingresar el piloto a la escuderia
            VistaIngreso vistaIngreso = new VistaIngreso();
            vistahome.setVisible(false);
            vistaIngreso.setVisible(true);

            ControladorIngreso controladorIngreso = new ControladorIngreso(vistaIngreso, usuario, vehiculo);

        }

    }

}
