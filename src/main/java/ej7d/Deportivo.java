/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej7d;

/**
 *
 * @author Fer
 */
public class Deportivo extends Vehiculo {

    private int cilindrada;

    public Deportivo(int bastidor, String matricula, String marca, String modelo, String color, double tarifa, int cilindrada) {
        super(bastidor, matricula, marca, modelo, color, tarifa);
        this.cilindrada = cilindrada;
    }

    public Deportivo() {
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void arrancar() {
        System.out.println("El deportivo se ha arrancado");
    }

    public void apagar() {
        System.out.println("El deportivo sa ha apagadoo");
    }

    @Override
    public String toString() {
        return super.toString() + cilindrada + ':';
    }

}