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
    public Servicio traerServicio(String codServicio) {
        Servicio servicioBuscado = null;
        for (Servicio servicio : this.lstServicio) {
            if (servicio.getCodServicio().equalsIgnoreCase(codServicio)) {
                servicioBuscado = servicio;
                break;
            }
        }
        return servicioBuscado;
    }

    public ArrayList<Servicio> traerServicio(boolean enPromocion) {
        ArrayList<Servicio> serviciosSegunPromocion = new ArrayList<>();
        for (Servicio servicio : this.lstServicio) {
            if (servicio.isEnPromocion() == enPromocion) {
                serviciosSegunPromocion.add(servicio);
            }
        }
        return serviciosSegunPromocion;
    }

    public ArrayList<Servicio> traerServicio(boolean enPromocion, LocalDate dia) {
        ArrayList<Servicio> serviciosSegunPromocionYFecha = new ArrayList<>();
        for (Servicio servicio : this.lstServicio) {
            if (servicio.isEnPromocion() == enPromocion && servicio.getDiaServicio().equals(dia)) {
                serviciosSegunPromocionYFecha.add(servicio);
            }
        }
        return serviciosSegunPromocionYFecha;
    }

    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc) throws CodigoInvalidoException, PrecioInvalidoException {
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equalsIgnoreCase(codServicio)) {
                throw new CodigoInvalidoException("Este objeto Gastronomia ya existe.");
            }
        }
        Gastronomia nuevaGastronomia = new Gastronomia(gastronomia, precio, diaSemDesc, codServicio, porcentajeDescuento, enPromocion, LocalDate.now());
        this.lstServicio.add(nuevaGastronomia);

        return true;
    }

    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche) throws CodigoInvalidoException, PrecioInvalidoException{
        for (Servicio servicio : lstServicio) {
            if (servicio.getCodServicio().equalsIgnoreCase(codServicio)) {
                throw new CodigoInvalidoException("Este objeto Gastronomia ya existe.");
            }
        }
        Hospedaje nuevoHospedaje = new Hospedaje(hospedaje, precioPorNoche, codServicio, porcentajeDescuento, enPromocion, LocalDate.now());
        this.lstServicio.add(nuevoHospedaje);
        return true;
    }
    
    public ArrayList<Servicio> getLstServicio() {
        return lstServicio;
    }

}
