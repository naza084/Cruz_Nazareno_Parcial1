/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author PC
 */
public abstract class Mercancia {
    protected String codigoMercancia;
    
    public Mercancia(String codigoMercancia) throws CodigoInvalidoException {
        setCodigo(codigoMercancia);
    }
    
    public void setCodigo(String codigo) throws CodigoInvalidoException{
        if (codigo.length() != 7) {
            throw new CodigoInvalidoException("El codigo debe ser exactamente de 7 caracteres.");
        }
        
        this.codigoMercancia = codigo;  
    }

    public String getCodigoMercancia() {
        return codigoMercancia;
    }
    
    public abstract double calcularPrecioFinal();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mercancia {");
        sb.append("codigoMercancia=").append(codigoMercancia);
        sb.append('}');
        return sb.toString();
    }
    
    
}
