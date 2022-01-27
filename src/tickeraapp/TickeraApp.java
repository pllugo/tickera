/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickeraapp;

import tickeraapp.Identidades.Cliente;
import tickeraapp.Identidades.Entrada;
import tickeraapp.Identidades.Evento;
import tickeraapp.Identidades.ListaClientes;
import tickeraapp.Identidades.Vendedor;
import tickeraapp.Identidades.Vips;
import tickeraapp.Servicios.ServiciosTickera;

/**
 *
 * @author Usuario
 */
public class TickeraApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServiciosTickera tickera = new ServiciosTickera();
        Evento events = tickera.crearEvento();
        ListaClientes lista = tickera.crearListaClientes(events);
        Vendedor salesman = tickera.crearVendedor();
        Entrada tickets = tickera.venderEntradas(events.getListaEntradas().length, lista, events,salesman);
        Vips preferencial = tickera.venderVips(lista.getNombres().length, lista, events, salesman);
        tickera.ingresoEvento(events, lista, tickets, preferencial);
        //Vendedor salesman = tickera.crearVendedor();
        //Entrada ticket = tickera.crerEntrada(custumers, salesman);
        //tickera.admisionEvento(events, tickera.calcularEdad(custumers));
    }
    
}
