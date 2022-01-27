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
public class Cliente {
    private String nombre;
    private String Rut;
    private Date fechaNacimiento;

    public Cliente() {
    }

    public Cliente(String nombre, String Rut, Date fechaNacimiento) {
        this.nombre = nombre;
        this.Rut = Rut;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return Rut;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", Rut=" + Rut + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
    
    
    
}
