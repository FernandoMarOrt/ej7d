/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej7d;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Fer
 */
public class Main {

    public static void main(String[] args) {

        crearDirectorio("./copias"); //Creo el directorio

        copiarFicheros("./copias"); //Copio los archivos en el directorio

        List<Vehiculo> listaVehiculos = leerVehiculos("vehículos.txt");

        System.out.println("Lista de vehículos:"); //Muestro la lista de vehiculos

        listaVehiculos.forEach(System.out::println);

        //Ordeno la lista por bastidor
        System.out.println("");
        System.out.println("Ordeno la lista por bastido");
        Comparator<Vehiculo> ordenarBastidor = Comparator.comparingInt(Vehiculo::getBastidor);

        Collections.sort(listaVehiculos, ordenarBastidor);

        //Imprimo la lista ordenada
        listaVehiculos.forEach(System.out::println);

        //Borro los archivos txt originales
        borrarElemento("Deportivos.txt");
        borrarElemento("Turismos.txt");
        borrarElemento("Furgonetas.txt");

        //Listo el directorio
        listarDirectorio("../ej7DFernando");

        //Imprime por pantalla todas las matrículas ordenadas alfabéticamente de todos  los coches grises distintos
        matriculaOrdenada(listaVehiculos);
        
        //Imprime por pantalla todas las marcas de coches distintas de aquellos coches que estén disponibles.
        marcasCoche(listaVehiculos);
        
        //Saber la cantidad de vehículos Citroën.
        cantidadCitroen(listaVehiculos);
        
        //Comprobar si hay algún Peugeot negro disponible en la lista.
        comprobarPeugeotN(listaVehiculos);
        
        //Obtener una lista con todas las tarifas diferentes que se aplican a los vehículos.
        List<Double> listaTarifas = listaTarifas(listaVehiculos);
        listaTarifas.forEach(System.out::println);
        
    }

    public static void crearDirectorio(String rutaDirectorio) {

        Path directorio = Paths.get(rutaDirectorio);

        if (!Files.exists(directorio)) { // Verificar si el directorio no existe
            try {
                Files.createDirectory(directorio); // Intentar crear el directorio
                System.out.println("Directorio creado exitosamente.");
            } catch (IOException e) {
                System.err.println("Error al crear el directorio: " + e.getMessage());
            }
        } else {
            System.out.println("El directorio ya existe.");
        }
    }

    public static void copiarFicheros(String rutaCopiar) {

        String[] ficheros = {"turismos.txt", "deportivos.txt", "furgonetas.txt"}; // Array con los nombres de los ficheros a copiar

        // Copiar los ficheros uno por uno
        for (String fichero : ficheros) {
            try {
                File origen = new File(fichero); // Fichero de origen
                File destino = new File(rutaCopiar + "/" + fichero); // Fichero de destino con la ruta completa

                Files.copy(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING); // Copiar el fichero con opción de reemplazo si ya existe
                System.out.println("Se ha copiado el fichero " + fichero + " a " + rutaCopiar);
            } catch (IOException e) {
                System.err.println("Error al copiar el fichero " + fichero + ": " + e.getMessage());
            }
        }
    }

    public static ArrayList<Vehiculo> leerVehiculos(String idFichero) {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        FileInputStream fis;
        Vehiculo tmp;

        try {
            fis = new FileInputStream(idFichero);

            // A partir del fichero anterior se crea el flujo para leer objetos
            // Estructura try-with-resources
            try ( ObjectInputStream flujo = new ObjectInputStream(fis)) {
                // Devuelve el número estimado de bytes que hay por leer
                // o cero si se ha alcanzado el final del fichero
                while (fis.available() > 0) {
                    // Se hace un casting explícito del objeto devuelto
                    // por readObject()
                    tmp = (Vehiculo) flujo.readObject();
                    // Añade el objeto a la lista
                    vehiculos.add(tmp);
                }

            } catch (ClassNotFoundException | IOException e) { // Multicatch
                System.out.println(e.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("EL fichero a leer no existe.");
        }

        return vehiculos;

    }

    public static void borrarElemento(String ruta) {
        Path file = Paths.get(ruta);
        try {
            Files.delete(file);
        } catch (NoSuchFileException nsfe) {
            System.out.println("No se puede borrar " + ruta + " porque no existe");
        } catch (DirectoryNotEmptyException dnee) {
            System.out.println("No se puede borrar el directorio porque no está vacío");
        } catch (IOException e) {
            System.out.println("Problema borrando el elemento " + ruta);
        }
    }

    public static void listarDirectorio(String ruta) {

        File f = new File(ruta);
        if (f.exists()) {
            // Obtiene los ficheros y directorios dentro de f y los 
            // devuelve en un array
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
    }

    public static void matriculaOrdenada(List<Vehiculo> listaVehiculos) {

        // Imprimir por pantalla todas las matrículas ordenadas alfabéticamente de todos los coches grises distintos
        System.out.println("Matrículas de coches grises ordenadas alfabéticamente:");
        listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getColor().equalsIgnoreCase("gris"))
                .map(Vehiculo::getMatricula)
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }

    public static void marcasCoche(List<Vehiculo> listaVehiculos) {

        // Imprimir por pantalla todas las marcas de coches distintas de aquellos coches que estén disponibles
        System.out.println("Marcas de coches no disponibles:");
        listaVehiculos.stream()
                .filter(vehiculo -> !vehiculo.isDisponible())
                .map(Vehiculo::getMarca)
                .distinct()
                .forEach(System.out::println);

    }

    public static void cantidadCitroen(List<Vehiculo> listaVehiculos) {

        // Saber la cantidad de vehículos Citroën
        long cantidadCitroen = listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getMarca().equalsIgnoreCase("Citroën"))
                .count();
        System.out.println("Cantidad de vehículos Citroën: " + cantidadCitroen);

    }

    public static void comprobarPeugeotN(List<Vehiculo> listaVehiculos) {

        // Comprobar si hay algún Peugeot negro disponible en la lista
        boolean peugeotNegroDisponible = listaVehiculos.stream()
                .anyMatch(vehiculo -> vehiculo.getMarca().equalsIgnoreCase("Peugeot")
                && vehiculo.getColor().equalsIgnoreCase("negro")
                && vehiculo.isDisponible());
        System.out.println("¿Hay algún Peugeot negro disponible?: " + peugeotNegroDisponible);

    }

    public static List<Double> listaTarifas(List<Vehiculo> listaVehiculos) {

        List<Double> listaTarifas = listaVehiculos.stream()
                .map(Vehiculo::getTarifa)
                .distinct()
                .collect(Collectors.toList());

        return listaTarifas;

    }

}
