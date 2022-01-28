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
    private String[] estadoNormal;

    public Entrada() {
    }

    public Entrada(float[] precioNormal, int[] asientoNormal, String[] clienteNormal, String[] rutClienteNormal, String[] vendedorNormal, String[] estadoNormal) {
        this.precioNormal = precioNormal;
        this.asientoNormal = asientoNormal;
        this.clienteNormal = clienteNormal;
        this.rutClienteNormal = rutClienteNormal;
        this.vendedorNormal = vendedorNormal;
        this.estadoNormal = estadoNormal;
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

    public String[] getEstadoNormal() {
        return estadoNormal;
    }

    

    
    

    
}
