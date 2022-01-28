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
public class Evento {
    private String nombreEevento;
    private int edadEvento;
    private int[] listaEntradas;
    private String estadoEvento;

    public Evento() {
    }

    public Evento(String nombreEevento, int edadEvento, int[] listaEntradas, String estadoEvento) {
        this.nombreEevento = nombreEevento;
        this.edadEvento = edadEvento;
        this.listaEntradas = listaEntradas;
        this.estadoEvento = estadoEvento;
    }

    public String getNombreEevento() {
        return nombreEevento;
    }

    public int getEdadEvento() {
        return edadEvento;
    }

    public int[] getListaEntradas() {
        return listaEntradas;
    }

    public String getEstadoEvento() {
        return estadoEvento;
    }

    public void setNombreEevento(String nombreEevento) {
        this.nombreEevento = nombreEevento;
    }

    public void setEdadEvento(int edadEvento) {
        this.edadEvento = edadEvento;
    }

    public void setListaEntradas(int[] listaEntradas) {
        this.listaEntradas = listaEntradas;
    }

    public void setEstadoEvento(String estadoEvento) {
        this.estadoEvento = estadoEvento;
    }

    @Override
    public String toString() {
        return "Evento{" + "nombreEevento=" + nombreEevento + ", edadEvento=" + edadEvento + ", listaEntradas=" + listaEntradas + ", estadoEvento=" + estadoEvento + '}';
    }

    
    
    
}
