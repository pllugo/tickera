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
public class Vips {
    private float[] precioVip;
    private int[] asientoVip;
    private String[] clienteVip;
    private String[] rutVip;
    private String[] vendedorVip;
    private String[] regaloVip;
    private String[] estadoVIp;

    public Vips() {
    }

    public Vips(float[] precioVip, int[] asientoVip, String[] clienteVip, String[] rutVip, String[] vendedorVip, String[] regaloVip, String[] estadoVIp) {
        this.precioVip = precioVip;
        this.asientoVip = asientoVip;
        this.clienteVip = clienteVip;
        this.rutVip = rutVip;
        this.vendedorVip = vendedorVip;
        this.regaloVip = regaloVip;
        this.estadoVIp = estadoVIp;
    }

    public float[] getPrecioVip() {
        return precioVip;
    }

    public int[] getAsientoVip() {
        return asientoVip;
    }

    public String[] getClienteVip() {
        return clienteVip;
    }

    public String[] getRutVip() {
        return rutVip;
    }

    public String[] getVendedorVip() {
        return vendedorVip;
    }

    public String[] getRegaloVip() {
        return regaloVip;
    }

    public String[] getEstadoVIp() {
        return estadoVIp;
    }

    

    
    
    
}
