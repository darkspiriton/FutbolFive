/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.interfaz;

/**
 *
 * @author Cesar
 */
public interface UsuarioIF {
    
    public boolean verificarUsuario(String usuario,String passw); 
    public void registrarUsuario(String usuario,String nombre,String apellido,String email,String proveedor,String ntelefono,String pass1,String fecha);    
    public boolean verificarSuscripcion(String iduser);
    
}
