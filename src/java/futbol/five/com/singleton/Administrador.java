/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol.five.com.singleton;

import futbol.five.com.dao.UsuarioDAO;
import futbol.five.com.interfaz.UsuarioIF;

/**
 *
 * @author Mari
 */
public class Administrador {
    private static final Administrador a = new Administrador() ;
    
        
    private Administrador(){
     
    }
    
    public static Administrador getAdministrador(){
        return a;
    }
    
    public boolean verificarAdministrador(String idUser,String pass){
        UsuarioIF a = new UsuarioDAO();
        return a.verificarAdministrador(idUser, pass);
        
    }
    
}
