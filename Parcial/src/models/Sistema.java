/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import exceptions.CodigoInvalidoException;
import exceptions.PrecioInvalidoException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Sistema {

    private ArrayList<Servicio> lstServicio;

    public Sistema() {
        this.lstServicio = new ArrayList<>();
    }

    // Metodos
    public Servicio traerServicio(String codServicio) throws ArrayIndexOutOfBoundsException {
        // Se verifica que la lista no este vacia
        hayServiciosEnSistema();
        Servicio servicioBuscado = null;
        for (Servicio servicio : this.lstServicio) {
            if (servicio.getCodServicio().equalsIgnoreCase(codServicio)) {
                servicioBuscado = servicio;
                break;
            }
        }
        return servicioBuscado;
    }

    // Metodo con sobrecarga
    public ArrayList<Servicio> traerServicio(boolean enPromocion) throws ArrayIndexOutOfBoundsException{
        // Se verifica que la lista no este vacia
        hayServiciosEnSistema();
        
        ArrayList<Servicio> serviciosSegunPromocion = new ArrayList<>();
        añadirServiciosEnPromocion(enPromocion, serviciosSegunPromocion);
        return serviciosSegunPromocion;
    }


    public ArrayList<Servicio> traerServicio(boolean enPromocion, LocalDate dia) throws ArrayIndexOutOfBoundsException{
        // Se verifica que la lista no este vacia
        hayServiciosEnSistema();
        
        ArrayList<Servicio> serviciosSegunPromocionYFecha = new ArrayList<>();
        añadirServicioSegunPromocionYDia(enPromocion, dia, serviciosSegunPromocionYFecha);
        return serviciosSegunPromocionYFecha;
    }

   
    // Metodos para agregar servicios: 
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc, LocalDate diaServicio) throws CodigoInvalidoException, PrecioInvalidoException, ArrayIndexOutOfBoundsException {
        hayServicioRepetido(codServicio);
        
        Gastronomia nuevaGastronomia = new Gastronomia(gastronomia, precio, diaSemDesc, codServicio, porcentajeDescuento, enPromocion, diaServicio);
        this.lstServicio.add(nuevaGastronomia);
        return true;
    }


    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche, LocalDate diaServicio) throws CodigoInvalidoException, PrecioInvalidoException, ArrayIndexOutOfBoundsException {
        hayServicioRepetido(codServicio);
        
        Hospedaje nuevoHospedaje = new Hospedaje(hospedaje, precioPorNoche, codServicio, porcentajeDescuento, enPromocion, diaServicio);
        this.lstServicio.add(nuevoHospedaje);
        return true;
    }

    public ArrayList<Servicio> getLstServicio() {
        return lstServicio;
    }

    
    // Metodos auxiliares:
    
    public void hayServiciosEnSistema() throws ArrayIndexOutOfBoundsException {
        if (lstServicio.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("No hay servicios en el sistema.");
        }
    }
    
    // añadir servicios segun promocion a lista 
    private void añadirServiciosEnPromocion(boolean enPromocion, ArrayList<Servicio> serviciosSegunPromocion) {
        for (Servicio servicio : this.lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                serviciosSegunPromocion.add(servicio);
            }
        }
    }
    
    // añadir servicios segun promocion y fecha a lista 
    private void añadirServicioSegunPromocionYDia(boolean enPromocion, LocalDate dia, ArrayList<Servicio> serviciosSegunPromocionYFecha) {
        for (Servicio servicio : this.lstServicio) {
            if (servicio.isEnPromocion() == enPromocion && servicio.getDiaServicio().equals(dia)) {
                serviciosSegunPromocionYFecha.add(servicio);
            }
        }
    }
    
    // Buscar si hay servicio repetido
    private void hayServicioRepetido(String codServicio) throws CodigoInvalidoException {
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equalsIgnoreCase(codServicio)) {
                throw new CodigoInvalidoException("Este objeto Gastronomia ya existe.");
            }
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sistema {");
        sb.append("lstServicio=").append(lstServicio);
        sb.append('}');
        return sb.toString();
    }

}
