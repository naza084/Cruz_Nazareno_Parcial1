/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author PC
 */
public class Servicio extends Mercancia {
    private String nombreServicio;
    private double presupuesto;
    private double porcentajeDescuento;
    private boolean enPromocion;

    public Servicio(String nombreServicio, double presupuesto, double porcentajeDescuento, boolean enPromocion, String codigoMercancia) throws CodigoInvalidoException {
        super(codigoMercancia);
        this.nombreServicio = nombreServicio;
        this.presupuesto = presupuesto;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }

    
    @Override
    public double calcularPrecioFinal() {
        double precioFinal = this.presupuesto;
        
        if (enPromocion) {
            precioFinal = this.presupuesto * (1 - (porcentajeDescuento / 100));
        }
        
        return precioFinal;
    }

    
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Servicio {");
        sb.append("nombreServicio=").append(nombreServicio);
        sb.append(", presupuesto=").append(presupuesto);
        sb.append(", porcentajeDescuento=").append(porcentajeDescuento);
        sb.append(", enPromocion=").append(enPromocion);
        sb.append(", codigoMercancia=").append(codigoMercancia);
        sb.append('}');
        return sb.toString();
    }
    
}
