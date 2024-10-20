/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import exceptions.CodigoInvalidoException;
import java.time.LocalDate;

/**
 *
 * @author PC
 */
public abstract class Servicio {

    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;
    protected LocalDate diaServicio;

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion, LocalDate diaServicio) throws CodigoInvalidoException, IllegalArgumentException {
        validarCodigoServicio(codServicio);
        this.codServicio = codServicio;

        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;

        validarDiaServicio(diaServicio);
        this.diaServicio = diaServicio;
    }

    public abstract double calcularPrecioFinal(LocalDate dia);

    // Getters
    public String getCodServicio() {
        return codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    public LocalDate getDiaServicio() {
        return diaServicio;
    }

    // Metodo auxiliares para validar datos
    public void validarCodigoServicio(String codServicio) throws CodigoInvalidoException {
        if (codServicio.length() != 6) {
            throw new CodigoInvalidoException("El codigo del servicio debe contener 6 caracteres exactos.");
        }
    }

    public void validarDiaServicio(LocalDate diaServicio) throws IllegalArgumentException {
        if (diaServicio.getDayOfWeek().getValue() < 0 || diaServicio.getDayOfWeek().getValue() > 7) {
            throw new IllegalArgumentException("Dia de servicio invalido.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Servicio{");
        sb.append("codServicio=").append(codServicio);
        sb.append(", porcentajeDescuento=").append(porcentajeDescuento);
        sb.append(", enPromocion=").append(enPromocion);
        sb.append(", diaServicio=").append(diaServicio);
        sb.append('}');
        return sb.toString();
    }

}
