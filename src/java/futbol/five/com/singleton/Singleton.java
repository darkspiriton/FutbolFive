/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol.five.com.singleton;

import futbol.five.com.bean.Cancha;
import futbol.five.com.bean.Partido;
import futbol.five.com.dao.CanchaDAO;
import futbol.five.com.dao.UsuarioDAO;
import futbol.five.com.interfaz.CanchaIF;
import futbol.five.com.interfaz.UsuarioIF;
import java.util.List;


public class Singleton {
    private static final Singleton g = new Singleton() ;
    
        
    private Singleton(){
     
    }
    
    public static Singleton getSingleton(){
        return g;
    }
    
    public Partido getDetallePartido(String idUser, String codCancha, String codHorario,String fecha){
       UsuarioIF u = new UsuarioDAO();
       CanchaIF p = new CanchaDAO();    
       int idCancha=Integer.parseInt(codCancha);
       int idHorario=Integer.parseInt(codHorario);
       
           p.registrarPartido(idUser, idCancha, idHorario, u.verificarSuscripcion(idUser),fecha);
           Partido detalleP= p.getdetallePartido(idUser, idCancha, idHorario, fecha);
      
       
       return detalleP;
       
    }
    
    public void registrarUsuario(String usuario, String nombre, String apellido, String email, String proveedor, String ntelefono, String pass1, String fecha){ 
       UsuarioIF ingresarU = new UsuarioDAO();
       
       ingresarU.registrarUsuario(usuario, nombre, apellido, email, proveedor, ntelefono, pass1, fecha);
       
    }
    
    public List getCanchasDisponibles(String dia, String hora, String fecha){
        CanchaIF dao = new CanchaDAO();
        List<Cancha> lcanchas = dao.getCanchasDisponibles(dia, hora,fecha);
        return lcanchas;
    }
    
    public boolean verificarUsuario(String usuario, String passw){
        UsuarioIF a = new UsuarioDAO();
        return a.verificarUsuario(usuario, passw);
    }
    
    public List getPartidosDisponibles(String dia, String hora, String fecha){
        CanchaIF dao = new CanchaDAO(); 
        List<Partido> lpartidos = dao.getPartidosDisponibles(dia,hora, fecha);
        return lpartidos;
    }
    
    public boolean validarNumeroTelefono(String num){
        boolean valido=false;
        
        if(num.length()==9){
            try {
		Integer.parseInt(num);
		return true;
            } catch (NumberFormatException nfe){
                    return false;
            }
        }
        
        
        return valido;
    }
}
