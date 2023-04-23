/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ej7d;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Fer
 */
public class Ej7bFernando {

    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = añadirVehiculos(); //Añado vehiculos a la lista

        listaVehiculos.forEach(System.out::println); //Imprimo la lista

        generarFichero("vehículos.txt", listaVehiculos); //Genero el fichero con la lista de vehiculos

        List<Vehiculo> listaVehiculosOrdenada = generarListaFichero("vehículos.txt", ":"); //Genero el fichero desde la lista ordenada

        listaVehiculosOrdenada.forEach(System.out::println); //Imprimo lista ordenada

        generarFicheroFinal(listaVehiculosOrdenada); //Genero el fichero final

    }

    public static List<Vehiculo> añadirVehiculos() {
        List<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Turismo(19345671, "12345ABC", "Seat1", "Ibiza1", "Azul", 1, 4));
        listaVehiculos.add(new Turismo(28345672, "22349BBO", "Seat2", "Ibiza2", "Rojo", 2, 4));
        listaVehiculos.add(new Turismo(37345673, "32348CBM", "Sea3", "Ibiza3", "Verde", 3, 4));
        listaVehiculos.add(new Turismo(46345674, "42347DBN", "Seat4", "Ibiza4", "Morado", 41, 4));
        listaVehiculos.add(new Turismo(55345675, "52346EBC", "Seat5", "Ibiza5", "Naranja", 11, 4));
        listaVehiculos.add(new Turismo(64345676, "62345FBA", "Seat6", "Ibiza6", "Amarillo", 21, 4));
        listaVehiculos.add(new Turismo(73345677, "72344GBH", "Seat7", "Ibiza7", "Negro", 31, 4));
        listaVehiculos.add(new Turismo(82345678, "82343HBE", "Seat8", "Ibiza8", "Blanco", 41, 4));
        listaVehiculos.add(new Turismo(91345675, "92342IBC", "Seat9", "Ibiza9", "Gris", 71, 4));
        listaVehiculos.add(new Turismo(12345679, "12341JBD", "Seat10", "Ibiza10", "Rosa", 41, 4));

        listaVehiculos.add(new Deportivo(55555555, "67890DEF", "Ford", "Fiesta", "Rojo", 12, 5));
        listaVehiculos.add(new Deportivo(98765432, "54321GHI", "Chevrolet", "Camaro", "Negro", 26, 2));
        listaVehiculos.add(new Deportivo(11111111, "ABCDE123", "Toyota", "Corolla", "Gris", 14, 5));
        listaVehiculos.add(new Deportivo(22222222, "FGHIJ456", "Honda", "Civic", "Blanco", 19, 5));
        listaVehiculos.add(new Deportivo(33333333, "KLMNO789", "Volkswagen", "Golf", "Verde", 13, 4));
        listaVehiculos.add(new Deportivo(44444444, "PQRSTU12", "Audi", "A4", "Plateado", 19, 5));
        listaVehiculos.add(new Deportivo(77777777, "VWXYZ90", "BMW", "X3", "Azul Oscuro", 23, 4));
        listaVehiculos.add(new Deportivo(88888888, "QWERTY12", "Mercedes", "Clase A", "Blanco", 156, 5));
        listaVehiculos.add(new Deportivo(99999999, "ASDFG34", "Renault", "Clio", "Azul", 13, 5));
        listaVehiculos.add(new Deportivo(44455566, "ZXCVB78", "Fiat", "500", "Rojo", 15, 4));

        listaVehiculos.add(new Furgoneta(10000001, "AB123CD", "Ford", "Transit", "Roja", 8, 250));
        listaVehiculos.add(new Furgoneta(10000002, "CD456EF", "Renault", "Kangoo", "Azul", 6, 200));
        listaVehiculos.add(new Furgoneta(10000003, "GH789IJ", "Volkswagen", "Caddy", "Gris", 4, 150));
        listaVehiculos.add(new Furgoneta(10000004, "KL012MN", "Mercedes-Benz", "Sprinter", "Negra", 12, 350));
        listaVehiculos.add(new Furgoneta(10000005, "OP345QR", "Citroen", "Jumper", "Verde", 10, 300));
        listaVehiculos.add(new Furgoneta(10000006, "ST678UV", "Peugeot", "Boxer", "Blanco", 8, 250));
        listaVehiculos.add(new Furgoneta(10000007, "WX901YZ", "Fiat", "Ducato", "Gris", 10, 300));
        listaVehiculos.add(new Furgoneta(10000008, "AB234CD", "Iveco", "Daily", "Negra", 14, 400));
        listaVehiculos.add(new Furgoneta(10000009, "CD567EF", "Opel", "Movano", "Azul", 12, 350));
        listaVehiculos.add(new Furgoneta(10000010, "GH890IJ", "Nissan", "NV400", "Roja", 8, 250));

        return listaVehiculos;

    }

    public static void generarFichero(String nombreFichero, List<Vehiculo> listaVehiculos) {

        String idFichero = nombreFichero;
        String numeracionV = "";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            for (Vehiculo v : listaVehiculos) { //Si es un turismo añado el 0
                if (v instanceof Turismo) {

                    numeracionV = "0 - ";

                } else if (v instanceof Deportivo) { //Si es un deportivo añado el 1

                    numeracionV = "1 - ";

                } else if (v instanceof Furgoneta) { //Si es una furgoneta añado el 2

                    numeracionV = "2 - ";

                }

                //Escribo en el fichero la numeracion del vehiculo (0,1,2) con el to string 
                flujo.write(numeracionV + v.toString());
                flujo.newLine();
            }

            flujo.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static List<Vehiculo> generarListaFichero(String nomFichero, String separador) {

        List<Vehiculo> listaVehiculos = new ArrayList<>();

        String idFichero = nomFichero;
        String[] tokens;
        String linea;

        Vehiculo v = null;

        try ( Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {

            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine();// Guarda la línea completa en un String

                tokens = linea.split(separador); //Se guarda cada elemento en funcion de el separador

                //Paso todos los valores que no son string a string
                //Si contiene 0 (turismo)
                if (linea.contains("0 - ")) {

                    tokens[0] = tokens[0].replaceAll("0 - ", "");

                    v = new Turismo(Integer.valueOf(tokens[0]), tokens[1], tokens[2], tokens[3],
                            tokens[4], Double.parseDouble(tokens[5]), Integer.parseInt(tokens[7]));

                    //Si contiene 0 (Deportivo)
                } else if (linea.contains("1 - ")) {

                    tokens[0] = tokens[0].replaceAll("1 - ", "");

                    v = new Deportivo(Integer.valueOf(tokens[0]), tokens[1], tokens[2], tokens[3],
                            tokens[4], Double.parseDouble(tokens[5]), Integer.parseInt(tokens[7]));

                    //Si contiene 2 (Furgoneta)
                } else if (linea.contains("2 - ")) {

                    tokens[0] = tokens[0].replaceAll("2 - ", "");

                    v = new Furgoneta(Integer.valueOf(tokens[0]), tokens[1], tokens[2], tokens[3],
                            tokens[4], Double.parseDouble(tokens[5]), Integer.parseInt(tokens[7]));

                }

                listaVehiculos.add(v);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //Ordeno por marca los vehiculos
        Comparator<Vehiculo> ordenarMarca = (v1, v2) -> v1.getMarca().compareToIgnoreCase(v2.getMarca());

        Collections.sort(listaVehiculos, ordenarMarca);

        return listaVehiculos;

    }

    public static void generarFichero2(String nomFichero, List<Vehiculo> listaVehiculos) {

        String idFichero = nomFichero;

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            for (Vehiculo v : listaVehiculos) {

                flujo.write(v.toString());
                flujo.newLine();
            }
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void generarFicheroFinal(List<Vehiculo> listaVehiculos) {

        List<Vehiculo> listaTurismos = new ArrayList<>();
        List<Vehiculo> listaDeportivos = new ArrayList<>();
        List<Vehiculo> listaFurgonetas = new ArrayList<>();

        for (Vehiculo v : listaVehiculos) {
            if (v instanceof Turismo) {

                listaTurismos.add(v);

            } else if (v instanceof Deportivo) {

                listaDeportivos.add(v);

            } else if (v instanceof Furgoneta) {

                listaFurgonetas.add(v);
            }

            generarFichero2("Turismos.txt", listaTurismos);
            generarFichero2("Deportivos.txt", listaDeportivos);
            generarFichero2("Furgonetas.txt", listaFurgonetas);
        }
    }
}
