/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickeraapp.Identidades;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Vendedor {
    private String nombreVendedor;
    private String rutVendedor;
    private Date nacimientoVendedor;

    public Vendedor() {
    }

    public Vendedor(String nombreVendedor, String rutVendedor, Date nacimientoVendedor) {
        this.nombreVendedor = nombreVendedor;
        this.rutVendedor = rutVendedor;
        this.nacimientoVendedor = nacimientoVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public String getRutVendedor() {
        return rutVendedor;
    }

    public Date getNacimientoVendedor() {
        return nacimientoVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public void setRutVendedor(String rutVendedor) {
        this.rutVendedor = rutVendedor;
    }

    public void setNacimientoVendedor(Date nacimientoVendedor) {
        this.nacimientoVendedor = nacimientoVendedor;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "nombreVendedor=" + nombreVendedor + ", rutVendedor=" + rutVendedor + ", nacimientoVendedor=" + nacimientoVendedor + '}';
    }

}
