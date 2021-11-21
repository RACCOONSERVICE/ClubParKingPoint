/*
 objeto vehiculo
 */
package clubparkingpoint.modelo;


public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private int totalPagoVehiculo;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, String modelo, String color, int totalPagoVehiculo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.totalPagoVehiculo = totalPagoVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTotalPagoVehiculo() {
        return totalPagoVehiculo;
    }

    public void setTotalPagoVehiculo(int totalPagoVehiculo) {
        this.totalPagoVehiculo = totalPagoVehiculo;
    }
}
