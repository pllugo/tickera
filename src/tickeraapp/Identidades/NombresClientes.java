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
public class NombresClientes {
    private String[] nombres;

    public NombresClientes() {
    }

    public NombresClientes(String[] nombres) {
        this.nombres = nombres;
    }

    public String[] getNombres() {
        return nombres;
    }
    
    public void borrarNombre(String[] nombres, String borrarNombre){
        for (int i = 0; i < nombres.length; i++) {
            if(borrarNombre.equalsIgnoreCase(nombres[i])){
                nombres[i] = " ";
            }else if(i == nombres.length){
                System.out.println("No se pudo encontrar el nombre");
                i = 0;
            }
        }
    }
}
