/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol.five.com.singleton;

import futbol.five.com.bean.Partido;
import futbol.five.com.gestor.Gestor;
import java.util.List;


public class Singleton {
    private static final Singleton g = new Singleton() ;
    private Gestor gestor;
        
    private Singleton(){
     gestor = new Gestor();
    }
    
    public static Singleton getSingleton(){
        return g;
    }
    
    public Partido getDetallePartido(String idUser, String codCancha, String codHorario,String fecha){
        return gestor.getDetallePartido(idUser, codCancha, codHorario, fecha);
       
    }
    
    public void registrarUsuario(String usuario, String nombre, String apellido, String email, String proveedor, String ntelefono, String pass1, String fecha){ 
       gestor.registrarUsuario(usuario, nombre, apellido, email, proveedor, ntelefono, pass1, fecha);
    }
    
    public List getCanchasDisponibles(String dia, String hora, String fecha){
        return gestor.getCanchasDisponibles(dia, hora, fecha);
    }
    
    public boolean verificarUsuario(String usuario, String passw){
        return gestor.verificarUsuario(usuario, passw);
    }
    
    public List getPartidosDisponibles(String dia, String hora, String fecha){
        return gestor.getPartidosDisponibles(dia, hora, fecha);
    }
}
