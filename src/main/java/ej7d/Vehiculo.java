/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej7d;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Fer
 */
public abstract class Vehiculo implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private int bastidor;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    private boolean disponible;

    public Vehiculo() {
    }

    public Vehiculo(int bastidor, String matricula, String marca, String modelo, String color, double tarifa) {
        this.bastidor = bastidor;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
        this.disponible = false;
    }

    public int getBastidor() {
        return bastidor;
    }

    public void setBastidor(int bastidor) {
        this.bastidor = bastidor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public abstract void arrancar();

    public abstract void apagar();

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.bastidor);
        hash = 97 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return Objects.equals(this.bastidor, other.bastidor);
    }

    @Override
    public String toString() {
        return bastidor + ":" + matricula + ":" + marca + ":" + modelo + ":" + color + ":" + tarifa + ":" + disponible + ":";
    }

}
