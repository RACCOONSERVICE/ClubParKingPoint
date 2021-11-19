/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clubparkingpoint.modelos;

/**
 *
 * @author user
 */
public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private int totalPagoVehiculo;
    private int cc;
    private int id_park;

    public Vehiculo() {
    }

    public Vehiculo(String placa, String marca, String modelo, String color, int totalPagoVehiculo, int cc, int id_park) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.totalPagoVehiculo = totalPagoVehiculo;
        this.cc = cc;
        this.id_park = id_park;
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

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getId_park() {
        return id_park;
    }

    public void setId_park(int id_park) {
        this.id_park = id_park;
    }
}
