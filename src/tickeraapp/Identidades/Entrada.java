/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickeraapp.Identidades;

/**
 *
 * @author Usuario
 */
public class Entrada {
    private float[] precioNormal;
    private int[] asientoNormal;
    private String[] clienteNormal;
    private String[] rutClienteNormal;
    private String[] vendedorNormal;

    public Entrada() {
    }

    public Entrada(float[] precioNormal, int[] asientoNormal, String[] clienteNormal, String[] rutClienteNormal, String[] vendedorNormal) {
        this.precioNormal = precioNormal;
        this.asientoNormal = asientoNormal;
        this.clienteNormal = clienteNormal;
        this.rutClienteNormal = rutClienteNormal;
        this.vendedorNormal = vendedorNormal;
    }

    public float[] getPrecioNormal() {
        return precioNormal;
    }

    public int[] getAsientoNormal() {
        return asientoNormal;
    }

    public String[] getClienteNormal() {
        return clienteNormal;
    }

    public String[] getRutClienteNormal() {
        return rutClienteNormal;
    }

    public String[] getVendedorNormal() {
        return vendedorNormal;
    }

    public void setPrecioNormal(float[] precioNormal) {
        this.precioNormal = precioNormal;
    }

    public void setAsientoNormal(int[] asientoNormal) {
        this.asientoNormal = asientoNormal;
    }

    public void setClienteNormal(String[] clienteNormal) {
        this.clienteNormal = clienteNormal;
    }

    public void setRutClienteNormal(String[] rutClienteNormal) {
        this.rutClienteNormal = rutClienteNormal;
    }

    public void setVendedorNormal(String[] vendedorNormal) {
        this.vendedorNormal = vendedorNormal;
    }

    
    

    
}
