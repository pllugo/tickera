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
        
        Evento events = new Evento(evento, edad, totalEntradas);
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
        System.out.println("Ingrese la cantidad de Vendedores");
        int cantidad = read.nextInt();
        String[][] matrizVendedores = new String[cantidad][5];
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < 5; j++) {
                switch (j){
                    case 0:
                        System.out.println("Ingresar el nombre");
                        matrizVendedores[i][j] = read.next();
                        break;
                    case 1:
                        System.out.println("Ingresar el Rut");
                        matrizVendedores[i][j] = read.next();
                        break;
                    case 2:
                        System.out.println("Ingresar la fecha");
                        matrizVendedores[i][j] = read.next();
                        break;
                    case 3:
                        System.out.println("Ingresar las entradas Normales");
                        matrizVendedores[i][j] = read.next();
                        break;
                    case 4:
                        System.out.println("Ingresar las entradas VIPs");
                        matrizVendedores[i][j] = read.next();
                        break;
                    default:
                        break;
                }
            }
        }
        Vendedor salesman = new Vendedor(matrizVendedores);
        return salesman;
    }
    
    
    public Entrada crearEntrada(ListaClientes lista, String nombre, Vendedor salesman, int posi, int posj){
        
        float[] precioEntrada = new float[lista.getNombres().length];
        int[] asientoEntrada = new int[lista.getNombres().length];
        String[] nombreAsignado = new String[lista.getNombres().length];
        String[] rutAsignado = new String[lista.getNombres().length];
        String[] vendedorAsignado = new String[lista.getNombres().length];
        do {
            for (int i = 0; i < lista.getNombres().length; i++) {
                if (nombre.equalsIgnoreCase(lista.getNombres()[i])) {
                    nombreAsignado[i] = nombre;
                    rutAsignado[i] = lista.getRut()[i];
                    System.out.println("Ingrese el precio de la Entrada");
                    precioEntrada[i] = read.nextFloat();
                    System.out.println("Ingrese el asiento");
                    asientoEntrada[i] = read.nextInt();
                    vendedorAsignado[i] = salesman.getVendedores()[posi][posj];
                    Entrada ticket = new Entrada(precioEntrada, asientoEntrada, nombreAsignado, rutAsignado, vendedorAsignado);
                    return ticket;
                    
                } else if (i == lista.getNombres().length) {
                    System.out.println("No se ha encontrar el nombre en los clientes, Por favor, corregir");
                    nombre = read.next();
                }
            }
        } while (true);
        
        
    }
    
    
    
    public Vips crearVips(ListaClientes lista, String nombre, Vendedor salesman, int posi, int posj){
        float[] precioVip = new float[lista.getNombres().length];
        int[] asientoVip = new int[lista.getNombres().length];
        String[] nombreVip = new String[lista.getNombres().length];
        String[] rutVip = new String[lista.getNombres().length];
        String[] vendedorVip = new String[lista.getNombres().length];
        String[] regaloVip = new String[lista.getNombres().length];
        do {
            for (int i = 0; i < lista.getNombres().length; i++) {
                if (nombre.equalsIgnoreCase(lista.getNombres()[i])) {
                    nombreVip[i] = nombre;
                    rutVip[i] = lista.getRut()[i];
                    System.out.println("Ingrese el precio de la Entrada");
                    precioVip[i] = read.nextFloat();
                    System.out.println("Ingrese el asiento");
                    asientoVip[i] = read.nextInt();
                    System.out.println("Ingrese el regalo VIP");
                    regaloVip[i] = read.next();
                    vendedorVip[i] = salesman.getVendedores()[posi][posj];
                    Vips preferencial = new Vips(precioVip, asientoVip, nombreVip, rutVip, vendedorVip, regaloVip);
                    return preferencial;
                    
                } else if (i == lista.getNombres().length) {
                    System.out.println("No se ha encontrar el nombre en los clientes, Por favor, corregir");
                    nombre = read.next();
                }
            }
        } while (true);
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

    
    
    
   
    
    
    public Entrada venderEntradas(int cantidadEntradas, ListaClientes lista, Evento events, Vendedor salesman) {
        int opcion, contNormales, contVip;
        contNormales = 0;
        contVip = 0;
        String nombreVendedor, nombreCliente;
        String[] vectorNombres = new String[lista.getNombres().length];
        for (int i = 0; i < lista.getNombres().length; i++) {
            vectorNombres[i] = lista.getNombres()[i];
        }
        
        do {
            if (contNormales < events.getListaEntradas()[0]) {
                System.out.println("Se puede seguir vendiendo entradas");
                contNormales = contNormales + 1;
                System.out.println("Seleccione el nombre del Vendedor: ");
                nombreVendedor = read.next();
                for (int i = 0; i < salesman.getVendedores().length; i++) {
                    for (int j = 0; j < salesman.getVendedores().length; j++) {
                        if (i >= 0 && j == 0 && salesman.getVendedores()[i][j].equalsIgnoreCase(nombreVendedor)) {
                            salesman.getVendedores()[i][3] = String.valueOf(Integer.parseInt(salesman.getVendedores()[i][3]) + 1);
                            System.out.println("Escojer el cliente");
                            PrintVector(vectorNombres);
                            nombreCliente = read.next();
                            borrarNombre(vectorNombres, nombreCliente);
                            Entrada tickesito = crearEntrada(lista, nombreCliente, salesman, i, j);
                            return tickesito;
                        }
                    }
                }
            } else if (contNormales == events.getListaEntradas()[0]) {
                System.out.println("No se puede vender entradas");
                contNormales = events.getListaEntradas()[0];
            } else {
                System.out.println("No se puede vender entradas");
                contNormales = events.getListaEntradas()[0];
            }
        } while (true);
        
    }
    
    
    public Vips venderVips(int cantidadEntradas, ListaClientes lista, Evento events, Vendedor salesman){
        int contVip = 0;
        String nombreVendedor, nombreCliente;
        String[] vectorNombres = new String[lista.getNombres().length];
        for (int i = 0; i < lista.getNombres().length; i++) {
            vectorNombres[i] = lista.getNombres()[i];
        }
        do {
            if (contVip < events.getListaEntradas()[1]) {
                System.out.println("Si se puede vender entradas");
                contVip = contVip + 1;
                System.out.println("Seleccione el nombre del Vendedor: ");
                nombreVendedor = read.next();
                for (int i = 0; i < salesman.getVendedores().length; i++) {
                    for (int j = 0; j < salesman.getVendedores().length; j++) {
                        if (i >= 0 && j == 0 && salesman.getVendedores()[i][j].equalsIgnoreCase(nombreVendedor)) {
                            salesman.getVendedores()[i][4] = String.valueOf(Integer.parseInt(salesman.getVendedores()[i][4]) + 1);
                            System.out.println("Escojer el cliente");
                            PrintVector(vectorNombres);
                            nombreCliente = read.next();
                            borrarNombre(vectorNombres, nombreCliente);
                            Vips tickesito = crearVips(lista, nombreCliente, salesman, i, j);
                            return tickesito;
                        }
                    }
                }
            } else if (contVip == events.getListaEntradas()[1]) {
                System.out.println("No se puede vender entradas");
                contVip = events.getListaEntradas()[1];
            } else {
                System.out.println("No se puede vender entradas");
                contVip = events.getListaEntradas()[1];
            }
        } while (true);
    }
    
    
    
    
    public void buscarRut(Evento events, String rutCliente, Entrada ticket, Vips preferencial) {
        boolean bandera = true;
        do {
            for (int i = 0; i < ticket.getClienteNormal().length; i++) {
                if (rutCliente.equalsIgnoreCase(ticket.getRutClienteNormal()[i])) {
                    System.out.println("Usando la entrada con Cliente " + ticket.getClienteNormal()[i] + " " + ticket.getRutClienteNormal()[i] + " para evento " + events.getNombreEevento());
                    bandera = false;
                } else if (i == (ticket.getClienteNormal().length - 1)) {
                    System.out.println("No se encuentra el Rut, por favor ingresar de nuevo el Rut");
                }
            }
        } while (bandera == true);

    }
    
    public void ingresoEvento(Evento events, ListaClientes lista, Entrada tickets, Vips preferencial) {
        
        
        boolean flag = true;
        do {
            System.out.println("Ingrese si el evento esta en curso: 1) Esta en curso 2) Evento no esta en curso 3) Salir");
            int opcionEvento = read.nextInt();
            switch (opcionEvento) {
                case 1:
                    System.out.println("Ingrese el Rut del cliente");
                    String rutCliente = read.next();
                    PrintVector(lista.getNombres());
                    buscarRut(events, rutCliente, tickets, preferencial);
                    break;
                case 2:
                    System.out.println("Esto no lo he hecho");
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
