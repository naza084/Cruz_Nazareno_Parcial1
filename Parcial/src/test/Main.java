/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import exceptions.CodigoInvalidoException;
import exceptions.PrecioInvalidoException;
import java.time.LocalDate;
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
        
        System.out.println("---------TESTEOS----------");
        
        System.out.println("Pruebas de Creación de Objetos:");
        
        System.out.println("Test 1-1: ");
        try {
            // Crear objeto con codigo invalido
            Gastronomia gastronomia1 = new Gastronomia("Hamburguesa criolla", 180.0, 4, "4892", 15.0, true, LocalDate.now());
        } catch (CodigoInvalidoException | PrecioInvalidoException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Test 1-2: ");
        try {
            // Crear objeto con codigo valido
            Gastronomia gastronomia2 = new Gastronomia("Hamburguesa criolla", 180.0, 4, "489235", 15.0, true, LocalDate.now());
        } catch (CodigoInvalidoException | PrecioInvalidoException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Test 1-3: ");
        try {
            // Crear objeto con codigo invalido
            Hospedaje hospedaje1 = new Hospedaje("Cabaña 3 personas", 1500.0, "2872", 10.0, true, LocalDate.now());
        } catch (CodigoInvalidoException | PrecioInvalidoException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Test 1-4: ");
        try {
            // Crear objeto con codigo valido
            Hospedaje hospedaje1 = new Hospedaje("Cabaña 3 personas", 1500.0, "287282", 10.0, true, LocalDate.now());
        } catch (CodigoInvalidoException | PrecioInvalidoException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("");
        System.out.println("---------------");
        System.out.println("Calculo de Precios Finales: ");
        
        System.out.println("Test 2-1: ");
        try {
            Gastronomia gastronomia2 = new Gastronomia("Hamburguesa criolla", 180.0, 4, "489235", 15.0, true, LocalDate.now());
            // No se aplica descuento al no concordar con el dia de decuento(3)
            double precioFinal1 = gastronomia2.calcularPrecioFinal(LocalDate.of(2024, 10, 28));
            System.out.println("El precio final es: " + precioFinal1);
        } catch (CodigoInvalidoException | PrecioInvalidoException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Test 2-2: ");
        try {
            Hospedaje hospedaje1 = new Hospedaje("Cabaña 3 personas", 1500.0, "287282", 10.0, true, LocalDate.now());
            // No se aplica el descuento al no ser un dia habil
            double precioFinal1 = hospedaje1.calcularPrecioFinal(LocalDate.of(2024, 10, 28));
            System.out.println("El precio final es: " + precioFinal1);
        } catch (CodigoInvalidoException | PrecioInvalidoException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        
        System.out.println("");
        System.out.println("---------------");
        System.out.println("Agregar Servicios: ");
        Sistema sistema = new Sistema();
        
        System.out.println("Test 3: ");
        try {
            // Añadir servicios con datos validos
            sistema.agregarGastronomia("858927", 15.0, true, "Milanesa con pure", 350.0, 3, LocalDate.of(2020, 10, 28));
            sistema.agregarHospedaje("489259", 10.0, true, "Habitacion triple", 2200.0, LocalDate.of(2020, 10, 28));
            sistema.agregarGastronomia("182835", 20.0, false, "Gaseosa", 120.0, 3, LocalDate.now());
            sistema.agregarHospedaje("758972", 15.0, false, "Habitación simple", 1000.0, LocalDate.now());
        } catch (CodigoInvalidoException | PrecioInvalidoException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("");
        System.out.println("---------------");
        System.out.println("Consulta de Servicios: ");
        ArrayList<Servicio> servicios = new ArrayList<>();
        
        System.out.println("Test: 4-1");
        try {
            servicios = sistema.traerServicio(true);
            System.out.println("Servicios en promoción: " + servicios);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Test: 4-2");
        try {
            servicios = sistema.traerServicio(true, LocalDate.of(2020, 10, 28));
            System.out.println("Servicios en promoción segun fecha: " + servicios);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
