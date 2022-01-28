/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickeraapp;

import java.util.Scanner;
import tickeraapp.Identidades.Cliente;
import tickeraapp.Identidades.Entrada;
import tickeraapp.Identidades.Evento;
import tickeraapp.Identidades.ListaClientes;
import tickeraapp.Identidades.NombresClientes;
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
        Scanner read = new Scanner(System.in).useDelimiter("\n");
        int opcion;
        boolean flag = true;
        ServiciosTickera tickera = new ServiciosTickera();
        Evento events = tickera.crearEvento();
        ListaClientes lista = tickera.crearListaClientes(events);
        NombresClientes listaNombres = tickera.crearNombres(lista);
        Vendedor salesman = tickera.crearVendedor();
        System.out.println("---------------Venta de entradas Normales--------------------");
        Entrada tickets = tickera.venderNormales(lista, events, salesman, listaNombres);
        System.out.println("---------------Venta de entradas Vips--------------------");
        Vips preferencial = tickera.venderVips(lista, events, salesman, listaNombres);
        System.out.println("---------------Ingreso al Evento--------------------");
        tickera.ingresoEvento(events, tickets, preferencial);
        
        
        
        //Vendedor salesman = tickera.crearVendedor();
        //Entrada ticket = tickera.crerEntrada(custumers, salesman);
        //tickera.admisionEvento(events, tickera.calcularEdad(custumers));
    }
    
}
