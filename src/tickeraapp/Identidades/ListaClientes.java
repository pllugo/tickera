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
public class ListaClientes {
    
    private String[] nombres;
    private String[] rut;
    private Date[] fechaNacimiento;

    public ListaClientes() {
    }

    public ListaClientes(String[] nombres, String[] rut, Date[] fechaNacimiento) {
        this.nombres = nombres;
        this.rut = rut;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String[] getNombres() {
        return nombres;
    }

    public String[] getRut() {
        return rut;
    }

    public Date[] getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }

    public void setRut(String[] rut) {
        this.rut = rut;
    }

    public void setFechaNacimiento(Date[] fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    
}
