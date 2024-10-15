/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.util.ArrayList;
import models.*;

/**
 *
 * @author PC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Testeo de codigo: 
        System.out.println("Test 1-1: ");
        try {
            // Lanza excepcion de codigo invalido al no tener 7 caracteres exactos
            Servicio servicio1 = new Servicio("Mantenimiento máquina de cortar pasto", 2500.0, 15.0, true, "897323");
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Test 1-2: ");
        try {
            Servicio servicio2 = new Servicio("Mantenimiento máquina de cortar pasto", 2500.0, 15.0, true, "8973231");
            System.out.println(servicio2);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        
        
        System.out.println("Test 1-3: ");
        try {
            // Lanza excepcion de codigo invalido al no tener 7 caracteres exactos
            Producto producto1 = new Producto("Manguera de desagote lavarropa", 650.0, 15.0, true, "432597");
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        
        
        System.out.println("Test 1-4: ");
        try {
            Producto producto2 = new Producto("Manguera de desagote lavarropa", 650.0, 15.0, true, "4325971");
            System.out.println(producto2);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }   
        
        

        System.out.println("Test 2-1: ");
        try {
            Servicio servicio = new Servicio("Mantenimiento máquina de cortar pasto", 2500.0, 15.0, true, "8973231");
            double precioFinal = servicio.calcularPrecioFinal();
            System.out.println(precioFinal);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Test 2-2: ");
        try {
            Producto producto = new Producto("Manguera de desagote lavarropa", 650.0, 15.0, true, "4325971");
            double precioFinal = producto.calcularPrecioFinal();
            System.out.println(precioFinal);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        

        
        System.out.println("Test 3-1: ");
        Sistema sistema = new Sistema();
        try {
            sistema.agregarProducto("3892871", "Aceite para máquinas", 430.0, 10.0, true);
            sistema.agregarProducto("9381925", "Tambor lavarropa", 7500.0, 25.0, false);
            
            sistema.agregarServicio("3892815", "Mantenimiento de cortadora de césped", 2520.0, 0, true);
            sistema.agregarProducto("3481759", "Mantenimiento estufa", 1250, 0, true);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        
        
        System.out.println("Test 3-2: ");
        try {
            sistema.agregarServicio("3892815", "Mantenimiento de cortadora de césped", 2520.0, 0, true);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Test 3-2: ");
        try {
            sistema.agregarProducto("9381925", "Tambor lavarropa", 7500.0, 25.0, false);
        } catch (CodigoInvalidoException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Test 3-3: ");
        ArrayList<Mercancia> mercanciaEnOferta = sistema.traerMercancia(true);
        for (Mercancia mercancia : mercanciaEnOferta) {
            System.out.println(mercancia);
        }
        
        System.out.println("Ejercicio terminado.");
    }
}
