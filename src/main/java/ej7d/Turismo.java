/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ej7d;

/**
 *
 * @author Fer
 */
public class Turismo extends Vehiculo {

    private int puertas;
    private boolean marchaAutomatica;

    public Turismo(int bastidor, String matricula, String marca, String modelo, String color, double tarifa, int puertas) {
        super(bastidor, matricula, marca, modelo, color, tarifa);
        this.puertas = puertas;
    }

    public Turismo() {
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public void arrancar() {
        System.out.println("El turismo se ha arrancado");
    }

    public void apagar() {
        System.out.println("El turismo sa ha apagado");
    }

    @Override
    public String toString() {
        return super.toString() + puertas + ":";
    }
}
