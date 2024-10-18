/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import exceptions.CodigoInvalidoException;
import exceptions.PrecioInvalidoException;
import java.time.LocalDate;

/**
 *
 * @author PC
 */
public class Gastronomia extends Servicio {

    private String nombreGastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia(String nombreGastronomia, double precio, int diaSemDesc, String codServicio, double porcentajeDescuento, boolean enPromocion, LocalDate diaServicio) throws CodigoInvalidoException, IllegalArgumentException, PrecioInvalidoException {
        super(codServicio, porcentajeDescuento, enPromocion, diaServicio);
        this.nombreGastronomia = nombreGastronomia;

        validarDiaSemDesc(diaSemDesc);
        this.diaSemDesc = diaSemDesc;

        validarPrecio(precio);
        this.precio = precio;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
        double precioFinal = this.precio;

        if (enPromocion && dia.getDayOfWeek().getValue() == this.diaSemDesc) {
            double descuento = this.precio * (getPorcentajeDescuento() / 100);
            precioFinal -= descuento;
        }
        
        return precioFinal;
    }

    // Setters
    public void setNombreGastronomia(String nombreGastronomia) {
        this.nombreGastronomia = nombreGastronomia;
    }

    public void setPrecio(double precio) throws PrecioInvalidoException {
        validarPrecio(precio);
        this.precio = precio;
    }

    public void setDiaSemDesc(int diaSemDesc) throws IllegalArgumentException {
        validarDiaSemDesc(diaSemDesc);
        this.diaSemDesc = diaSemDesc;
    }

    // Getters
    public String getNombreGastronomia() {
        return nombreGastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    // Metodo auxiliares
    public void validarPrecio(double precio) throws PrecioInvalidoException {
        // Verificacion de que el precio no sea negativo o menor a 1.0
        if (precio < 1.0) {
            throw new PrecioInvalidoException("El precio no puede ser 0 o negativo.");
        }
    }

    public void validarDiaSemDesc(int dia) throws IllegalArgumentException {
        // Se verifica que el dia sea valido
        if (dia < 0 || dia > 7) {
            throw new IllegalArgumentException("Dia de la semana invalido.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gastronomia{");
        sb.append("codServicio=").append(codServicio);
        sb.append(", porcentajeDescuento=").append(porcentajeDescuento);
        sb.append(", enPromocion=").append(enPromocion);
        sb.append(", diaServicio=").append(diaServicio);
        sb.append(", nombreGastronomia=").append(nombreGastronomia);
        sb.append(", precio=").append(precio);
        sb.append(", diaSemDesc=").append(diaSemDesc);
        sb.append('}');
        return sb.toString();
    }

}
