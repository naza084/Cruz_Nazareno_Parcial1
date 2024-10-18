/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import exceptions.CodigoInvalidoException;
import exceptions.PrecioInvalidoException;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author PC
 */
public class Hospedaje extends Servicio {

    private String nombreHospedaje;
    private double precioPorNoche;

    public Hospedaje(String nombreHospedaje, double precioPorNoche, String codServicio, double porcentajeDescuento, boolean enPromocion, LocalDate diaServicio) throws CodigoInvalidoException, IllegalArgumentException, PrecioInvalidoException {
        super(codServicio, porcentajeDescuento, enPromocion, diaServicio);
        this.nombreHospedaje = nombreHospedaje;

        validarPrecioNoche(precioPorNoche);
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = this.precioPorNoche;

        if (enPromocion && esDiaHabil(dia)) {
            double descuento = this.precioPorNoche * (getPorcentajeDescuento() / 100);
            precioFinal -= descuento;
        }

        return precioFinal;
    }

    // Getters    
    public String getNombreHospedaje() {
        return nombreHospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    // Setters
    public void setNombreHospedaje(String nombreHospedaje) {
        this.nombreHospedaje = nombreHospedaje;
    }

    public void setPrecioPorNoche(double precioPorNoche) throws PrecioInvalidoException {
        validarPrecioNoche(precioPorNoche);
        this.precioPorNoche = precioPorNoche;
    }

    // Metodo auxiliares para validar datos
    public void validarPrecioNoche(double precioPorNoche) throws PrecioInvalidoException {
        // Verificacion de que el precio no sea negativo o menor a 1.0
        if (precioPorNoche < 1.0) {
            throw new PrecioInvalidoException("El precio por noche no puede ser 0 o negativo.");
        }
    }

    private boolean esDiaHabil(LocalDate dia) {
        // Se Obtiene el día de la semana y se verifica que no sea sabado ni domingo
        DayOfWeek diaSemana = dia.getDayOfWeek(); 
        return diaSemana != DayOfWeek.SATURDAY && diaSemana != DayOfWeek.SUNDAY; 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hospedaje{");
        sb.append("codServicio=").append(codServicio);
        sb.append(", porcentajeDescuento=").append(porcentajeDescuento);
        sb.append(", enPromocion=").append(enPromocion);
        sb.append(", diaServicio=").append(diaServicio);
        sb.append(", nombreHospedaje=").append(nombreHospedaje);
        sb.append(", precioPorNoche=").append(precioPorNoche);
        sb.append('}');
        return sb.toString();
    }

}
