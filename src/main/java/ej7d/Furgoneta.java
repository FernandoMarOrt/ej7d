/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej7d;

/**
 *
 * @author Fer
 */
public class Furgoneta extends Vehiculo {

    private int carga;

    public Furgoneta(int bastidor, String matricula, String marca, String modelo, String color, double tarifa, int carga) {
        super(bastidor, matricula, marca, modelo, color, tarifa);
        this.carga = carga;
    }

    public Furgoneta() {
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public void arrancar() {
        System.out.println("La furgoneta se ha arrancado");
    }

    public void apagar() {
        System.out.println("La furgoneta sa ha apagado");
    }

    @Override
    public String toString() {
        return super.toString() + carga + ":";
    }

}
