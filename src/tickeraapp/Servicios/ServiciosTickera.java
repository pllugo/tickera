/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tickeraapp.Servicios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import tickeraapp.Identidades.Cliente;

import tickeraapp.Identidades.Entrada;
import tickeraapp.Identidades.Evento;
import tickeraapp.Identidades.ListaClientes;
import tickeraapp.Identidades.NombresClientes;

import tickeraapp.Identidades.Vendedor;
import tickeraapp.Identidades.Vips;

/**
 *
 * @author Usuario
 */
public class ServiciosTickera {
    private Scanner read = new Scanner(System.in).useDelimiter("\n");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Date fecha_actual = new Date();
    public Evento crearEvento(){
        System.out.println("Ingrese el evento");
        String evento = read.next();
        System.out.println("Ingrese la edad para entrar al evento");
        int edad = read.nextInt();
        System.out.println("Ingresar cuantas entradas en total se poseen");
        int cantidad = read.nextInt();
        int[] totalEntradas = new int[cantidad];
        for (int i = 0; i < 2; i++) {
            if (i==0){
                System.out.println("Ingrese la cantidad de entradas normales");
                totalEntradas[i] = read.nextInt();
            }else {
                System.out.println("Ingrese la cantidad de entradas VIPs");
                totalEntradas[i] = read.nextInt();
            }
        }
        System.out.println("Ingrese el estado del Evento");
        String estadoEvento = read.next();
        Evento events = new Evento(estadoEvento, edad, totalEntradas, estadoEvento);
        return events;
    }
    
    public Cliente crearClientes(){
        System.out.println("Ingresar el nombre del cliente");
        String nombreCliente = read.next();
        System.out.println("Ingrese el RUT");
        String rutCliente = read.next();
        System.out.println("Ingrese el dia de nacimiento");
        int dia = read.nextInt();
        System.out.println("Ingrese el mes de nacimiento");
        int mes = read.nextInt();
        System.out.println("Ingrese el año de nacimiento");
        int year = read.nextInt();
        Date fechanacimiento = new Date();
        fechanacimiento.setYear(year-1900);
        fechanacimiento.setMonth(mes-1);
        fechanacimiento.setDate(dia);
        Cliente custumers = new Cliente(nombreCliente, rutCliente, fechanacimiento);
        return custumers;
    }
    
    public ListaClientes crearListaClientes(Evento events){
        String[][] matriz = new String[events.getListaEntradas().length][events.getListaEntradas().length];
        String[] listaNombres = new String[events.getListaEntradas().length];
        String[] listaRut = new String[events.getListaEntradas().length];
        Date[] listaFechanacimiento = new Date[events.getListaEntradas().length];
        int i = 0;
        int opcion;
        boolean flag = true;
        do {
            System.out.println("Seleccione para ingresar los datos del cliente: 1) Si o 2) No");
            opcion = read.nextInt();
            switch (opcion) {
                case 1:
                    if (i < events.getListaEntradas().length ){
                        Cliente custumer = crearClientes();
                        if (admisionEvento(events, calcularEdad(custumer))) {
                            if (i == 0){
                                listaNombres[i] = custumer.getNombre();
                                listaRut[i] = custumer.getRut();
                                listaFechanacimiento[i] = custumer.getFechaNacimiento();
                                
                            }else{
                                
                                listaNombres[i] = custumer.getNombre();
                                listaRut[i] = custumer.getRut();
                                listaFechanacimiento[i] = custumer.getFechaNacimiento();
                            }
                            i = i + 1;
                        }
                    }else{
                        System.out.println("No se puede crear otro cliente debido a que excede la cantidad de clientes antes ingresado");
                        flag = false;
                    }
                    break;
                case 2:
                    flag = false;
                    break;
                default:
                    System.out.println("Error!!! Seleccione una opción válida");
            }
        } while (flag == true);

        ListaClientes lista = new ListaClientes(listaNombres, listaRut, listaFechanacimiento);
        return lista;
    }
    
    
    
    
    
    public void PrintVector(String[] vector) {
        for (int k = 0; k < vector.length; k++) {
            if (k == 0) {
                System.out.print("[" + vector[k] + ",");
            } else if (k < vector.length - 1) {
                System.out.print(vector[k] + ",");
            } else {
                System.out.print(vector[k] + "]");
            }
        }
        System.out.println("");
    }
    
    
    public void borrarNombre(String[] vector, String buscarNombre) {
        for (int k = 0; k < vector.length; k++) {
            if (buscarNombre.equalsIgnoreCase(vector[k])) {
                vector[k] = " ";
            }
            if (k == 0) {
                System.out.print("[" + vector[k] + ",");
            } else if (k < vector.length - 1) {
                System.out.print(vector[k] + ",");
            } else {
                System.out.print(vector[k] + "]");
            }
        }
        System.out.println("");
    }
    
    
    public Vendedor crearVendedor(){
        System.out.println("Ingresar el nombre del vendedor");
        String nombreVendedor = read.next();
        System.out.println("Ingrese el RUT");
        String rutVendedor = read.next();
        System.out.println("Ingrese el dia de nacimiento");
        int diaVendedor = read.nextInt();
        System.out.println("Ingrese el mes de nacimiento");
        int mesVendedor = read.nextInt();
        System.out.println("Ingrese el año de nacimiento");
        int yearVendedor = read.nextInt();
        Date fechanacimiento = new Date();
        fechanacimiento.setYear(yearVendedor-1900);
        fechanacimiento.setMonth(mesVendedor-1);
        fechanacimiento.setDate(diaVendedor);
        Vendedor salesman = new Vendedor(nombreVendedor, rutVendedor, fechanacimiento);
        return salesman;
    }
    
    
    public NombresClientes crearNombres(ListaClientes lista){
        String[] vectornombres = new String[lista.getNombres().length];
        for (int i = 0; i < lista.getNombres().length; i++) {
            vectornombres[i] = lista.getNombres()[i];
        }
        NombresClientes listaNombres = new NombresClientes(vectornombres);
        return listaNombres;
    }
    
    public Entrada entradaNormal(Evento events, ListaClientes lista, Vendedor salesman, NombresClientes listaNombres){
        
        
        float[] precioEntrada = new float[events.getListaEntradas()[0]];
        int[] asientoEntrada = new int[events.getListaEntradas()[0]];
        String[] nombreAsignado = new String[events.getListaEntradas()[0]];
        String[] rutAsignado = new String[events.getListaEntradas()[0]];
        String[] vendedorAsignado = new String[events.getListaEntradas()[0]];
        String[] estadoAsignado = new String[events.getListaEntradas()[0]];
       
        
        

        for (int i = 0; i < events.getListaEntradas()[0]; i++) {
            System.out.println("Ingresar el nombre del cliente");
            PrintVector(lista.getNombres());
            String nombre = read.next();
            
            for (int j = 0; j < lista.getNombres().length; j++) {
                if (nombre.equalsIgnoreCase(lista.getNombres()[j])) {
                    nombreAsignado[i] = nombre;
                    System.out.println("Ingresar el precio de la entrada normal");
                    precioEntrada[i] = read.nextFloat();
                    System.out.println("Ingresar el asiento");
                    asientoEntrada[i] = read.nextInt();
                    rutAsignado[i] = lista.getRut()[j];
                    vendedorAsignado[i] = salesman.getNombreVendedor();
                    estadoAsignado[i] = "Comprado";
                    listaNombres.borrarNombre(lista.getNombres(), nombre);
                }
            }
        }
        
        Entrada ticket = new Entrada(precioEntrada, asientoEntrada, nombreAsignado, rutAsignado, vendedorAsignado, estadoAsignado);
        return ticket;
        
    }
    
    
    
    public Vips entradaVips(Evento events, ListaClientes lista, Vendedor salesman, NombresClientes listaNombres){
        float[] precioVip = new float[events.getListaEntradas()[1]];
        int[] asientoVip = new int[events.getListaEntradas()[1]];
        String[] nombreVip = new String[events.getListaEntradas()[1]];
        String[] rutVip = new String[events.getListaEntradas()[1]];
        String[] vendedorVip = new String[events.getListaEntradas()[1]];
        String[] regaloVip = new String[events.getListaEntradas()[1]];
        String[] estadoVip = new String[events.getListaEntradas()[1]];

        for (int i = 0; i < events.getListaEntradas()[1]; i++) {
            System.out.println("Ingresar el nombre del cliente");
            PrintVector(lista.getNombres());
            String nombre = read.next();
            
            for (int j = 0; j < lista.getNombres().length; j++) {
                if (nombre.equalsIgnoreCase(lista.getNombres()[j])) {
                    nombreVip[i] = nombre;
                    System.out.println("Ingresar el precio de la entrada Vip");
                    precioVip[i] = read.nextFloat();
                    System.out.println("Ingresar el asiento");
                    asientoVip[i] = read.nextInt();
                    rutVip[i] = lista.getRut()[j];
                    vendedorVip[i] = salesman.getNombreVendedor();
                    System.out.println("Ingresar el regalo VIP");
                    regaloVip[i] = read.next();
                    estadoVip[i] = "Comprado";
                    listaNombres.borrarNombre(lista.getNombres(), nombre);
                }
            }
        }
        Vips preferencial = new Vips(precioVip, asientoVip, nombreVip, rutVip, vendedorVip, regaloVip, estadoVip);
        return preferencial;
    }
    
    
    
    public int calcularEdad(Cliente custumer){
        if (custumer.getFechaNacimiento().after(fecha_actual) == true){
            System.out.println("No se puede calcular la edad");
            return 0;
        } else if (fecha_actual.getMonth() == custumer.getFechaNacimiento().getMonth() && custumer.getFechaNacimiento().getDay() < fecha_actual.getDay()) {
            return ((fecha_actual.getYear() - custumer.getFechaNacimiento().getYear()) - 1);
        } else if (fecha_actual.getMonth() == custumer.getFechaNacimiento().getMonth() && custumer.getFechaNacimiento().getDay() == fecha_actual.getDay()) {
            return (fecha_actual.getYear() - custumer.getFechaNacimiento().getYear());
        } else if (fecha_actual.getMonth() == custumer.getFechaNacimiento().getMonth() && custumer.getFechaNacimiento().getDay() > fecha_actual.getDay()) {
            return ((fecha_actual.getYear() - custumer.getFechaNacimiento().getYear()) - 1);
        } else if (fecha_actual.getMonth() < custumer.getFechaNacimiento().getMonth()) {
            return ((fecha_actual.getYear() - custumer.getFechaNacimiento().getYear()) - 1);
        } else {
            return (fecha_actual.getYear() - custumer.getFechaNacimiento().getYear());
        }
    }

    
    public boolean admisionEvento(Evento events, int edadCalculada) {

        if (events.getEdadEvento() < edadCalculada) {
            System.out.println("Si puede entrar al evento");
            return true;
        } else {
            System.out.println("No puede entrar al evento");
            return false;
        }
    }

    
    public Entrada venderNormales(ListaClientes lista, Evento events, Vendedor salesman, NombresClientes listaNombres) {
        Entrada normales = entradaNormal(events, lista, salesman, listaNombres);
        return normales;
    }
    
    public Vips venderVips(ListaClientes lista, Evento events, Vendedor salesman, NombresClientes listaNombres){
        Vips exclusivos = entradaVips(events, lista, salesman, listaNombres);
        return exclusivos;
    }
    
    public void buscarRut(Evento events, String rutCliente, Entrada ticket, Vips preferencial) {
        boolean bandera = true;
        do {
            for (int i = 0; i < ticket.getClienteNormal().length; i++) {
                if (rutCliente.equalsIgnoreCase(ticket.getRutClienteNormal()[i])) {
                    System.out.println("Usando la entrada con Cliente " + ticket.getClienteNormal()[i] + " con RUT " + ticket.getRutClienteNormal()[i] + " para evento " + events.getNombreEevento() + " puede pasar");
                    ticket.getEstadoNormal()[i] = "Ya se uso";
                    bandera = false;
                } else if (i == (ticket.getClienteNormal().length - 1)) {
                    for (int j = 0; j < preferencial.getClienteVip().length; j++) {
                        if (rutCliente.equalsIgnoreCase(preferencial.getRutVip()[j])) {
                            System.out.println("Usando la entrada con Cliente " + preferencial.getClienteVip()[i] + " con RUT " + preferencial.getRutVip()[i] + " para evento " + events.getNombreEevento() + " puede pasar");
                            preferencial.getEstadoVIp()[i] = "Ya se uso";
                            bandera = false;
                        }
                    }
                }
            }
        } while (bandera == true);

    }
    
    
    public void entradasUsadas(Evento events, String rutCliente, Entrada ticket, Vips preferencial, String estado){
        boolean bandera = true;
        do {
            for (int i = 0; i < ticket.getClienteNormal().length; i++) {
                if (rutCliente.equalsIgnoreCase(ticket.getRutClienteNormal()[i]) && (estado.equalsIgnoreCase(ticket.getEstadoNormal()[i]))) {
                    System.out.println("La entrada con Cliente " + ticket.getClienteNormal()[i] + " con RUT " + ticket.getRutClienteNormal()[i] + " para evento " + events.getNombreEevento() + " Ya fue usada, no puede pasar");
                    
                    bandera = false;
                } else if (i == (ticket.getClienteNormal().length - 1)) {
                    for (int j = 0; j < preferencial.getClienteVip().length; j++) {
                        if (rutCliente.equalsIgnoreCase(preferencial.getRutVip()[j]) && (estado.equalsIgnoreCase(ticket.getEstadoNormal()[i]))) {
                            System.out.println("La entrada con Cliente " + preferencial.getClienteVip()[i] + " con RUT " + preferencial.getRutVip()[i] + " para evento " + events.getNombreEevento() + " Ya fué usada, no puede pasar");
                            
                            bandera = false;
                        }
                    }
                }
            }
        } while (bandera == true);

    }
    
    
    
    public void ingresoEvento(Evento events, Entrada tickets, Vips preferencial) {
        
        String rutCliente;
        boolean flag = true;
        do {
            System.out.println("Ingrese si el evento: 1) Esta en curso 2) Evento esta en curso (Verificación de entrada)  3) Salir");
            int opcionEvento = read.nextInt();
            switch (opcionEvento) {
                case 1:
                    events.setEstadoEvento("EnCurso");
                    System.out.println("Ingrese el Rut del cliente");
                    rutCliente = read.next();
                    buscarRut(events, rutCliente, tickets, preferencial);
                    break;
                case 2:
                    System.out.println("Ingrese el Rut del cliente");
                    rutCliente = read.next();
                    String estado = "Ya se uso";
                    entradasUsadas(events, rutCliente, tickets, preferencial, estado);
                    break;
                case 3:
                    System.out.println("Ud ha salido del programa");
                    flag = false;
                    break;
                default:
                    System.out.println("Ud no ha escogido las opciones correctas");
            }
        } while (flag == true);

    }
    
    
    public static void ImprimirMatriz(int n, String[][] mp){
        for (int i=0; i<n;i++){
            for (int j=0;j<5;j++){
                System.out.print(" " + mp[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    
}
