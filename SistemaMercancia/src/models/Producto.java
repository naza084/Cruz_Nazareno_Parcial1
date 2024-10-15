/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author PC
 */
public class Producto extends Mercancia {
    private String nombreProducto;
    private double precioProducto;
    private double porcentajeDescuento;
    private boolean esDescuentoEn2daUnidad;

    public Producto(String nombreProducto, double precioProducto, double porcentajeDescuento, boolean esDescuentoEn2daUnidad, String codigoMercancia) throws CodigoInvalidoException {
        super(codigoMercancia);
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.porcentajeDescuento = porcentajeDescuento;
        this.esDescuentoEn2daUnidad = esDescuentoEn2daUnidad;
    }
    
    @Override
    public double calcularPrecioFinal() {
        double precioFinal = this.precioProducto;
        
        if (this.esDescuentoEn2daUnidad) {
            // Calcula el porcentaje de descuento para la segunda unidad
            double descuentoSegundaUnidad = this.precioProducto * (this.porcentajeDescuento / 100 / 2);
            precioFinal = this.precioProducto + (this.precioProducto - descuentoSegundaUnidad);
        }
        
        return precioFinal;
    }

    
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public void setEsDescuentoEn2daUnidad(boolean esDescuentoEn2daUnidad) {
        this.esDescuentoEn2daUnidad = esDescuentoEn2daUnidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public boolean isEsDescuentoEn2daUnidad() {
        return esDescuentoEn2daUnidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto {");
        sb.append("nombreProducto=").append(nombreProducto);
        sb.append(", precioProducto=").append(precioProducto);
        sb.append(", porcentajeDescuento=").append(porcentajeDescuento);
        sb.append(", esDescuentoEn2daUnidad=").append(esDescuentoEn2daUnidad);
        sb.append(", codigoMercancia=").append(codigoMercancia);
        sb.append('}');
        return sb.toString();
    }

    
}