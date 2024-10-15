/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Sistema {

    private ArrayList<Mercancia> listaMercancias;

    public Sistema() {
        listaMercancias = new ArrayList<>();
    }

    
    public Mercancia traerMercancia(String codMercancia) {
        Mercancia mercancia = null;

        if (!listaMercancias.isEmpty()) {
            for (Mercancia mer : listaMercancias) {
                if (mer.getCodigoMercancia().equals(codMercancia)) {
                    mercancia = mer;
                    break;
                }
            }
        }
        
        return mercancia;
    }

    
    public ArrayList<Mercancia> traerMercancia(boolean enOferta) {
        ArrayList<Mercancia> listaRetorno = new ArrayList<>();

        if (!this.listaMercancias.isEmpty()) {
            for (Mercancia mer : this.listaMercancias) {
                if (enOferta && esMercanciaEnOferta(mer) || !enOferta && !esMercanciaEnOferta(mer)) {
                    listaRetorno.add(mer);
                }
            }
        }

        return listaRetorno;
    }

    
    public boolean agregarProducto(String codMercancia, String nombreProducto, double precioProducto, double porcentajeDescuento, boolean esDescuentoEn2daUnidad) throws CodigoInvalidoException {
        if (traerMercancia(codMercancia) != null) {  
            throw new CodigoInvalidoException("Ya existe un producto con el mismo código.");
        }

        Producto producto = new Producto(nombreProducto, precioProducto, porcentajeDescuento, esDescuentoEn2daUnidad, codMercancia);
        this.listaMercancias.add(producto);

        return true;
    }

    
    public boolean agregarServicio(String codMercancia, String nombreServicio, double presupuesto, double porcentajeDescuento, boolean enPromocion) throws CodigoInvalidoException {
        if (traerMercancia(codMercancia) != null) {  
            throw new CodigoInvalidoException("Ya existe un servicio con el mismo código.");
        }

        Servicio servicio = new Servicio(nombreServicio, presupuesto, porcentajeDescuento, enPromocion, codMercancia);
        listaMercancias.add(servicio);

        return true;
    }

    // Metodo auxiliar
    private boolean esMercanciaEnOferta(Mercancia mer) {
        boolean mercanciaEnOferta = false;

        switch (mer) {
            case Producto producto ->
                mercanciaEnOferta = producto.isEsDescuentoEn2daUnidad();
            case Servicio servicio ->
                mercanciaEnOferta = servicio.isEnPromocion();
            default -> {
            }
        }

        return mercanciaEnOferta;
    }

    
    public void setListaMercancias(ArrayList<Mercancia> listaMercancias) {
        this.listaMercancias = listaMercancias;
    }

    public ArrayList<Mercancia> getListaMercancias() {
        return listaMercancias;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sistema {");
        sb.append("listaMercancias=").append(listaMercancias);
        sb.append('}');
        return sb.toString();
    }

}
