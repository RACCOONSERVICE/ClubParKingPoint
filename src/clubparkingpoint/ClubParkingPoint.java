/*
main de club parkig point 
 */
package clubparkingpoint;

import clubparkingpoint.controladores.ControladorHome;
import clubparkingpoint.modelo.Usuario;
import clubparkingpoint.modelo.Vehiculo;
import clubparkingpoint.vistas.VistaHome;


public class ClubParkingPoint {

    public static void main(String[] args) {
        VistaHome vistahome = new VistaHome();
        vistahome.setVisible(true);
        Usuario usuario = new Usuario();
        Vehiculo vehiculo = new Vehiculo();
        ControladorHome controlador = new ControladorHome(vistahome,usuario,vehiculo);
        
    }
    
}
