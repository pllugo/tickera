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
    private String[][] vendedores;

    public Vendedor() {
    }

    public Vendedor(String[][] vendedores) {
        this.vendedores = vendedores;
    }

    public String[][] getVendedores() {
        return vendedores;
    }
    
    public void setVendedores(String[][] vendedores) {
        this.vendedores = vendedores;
    }
    
    
}
