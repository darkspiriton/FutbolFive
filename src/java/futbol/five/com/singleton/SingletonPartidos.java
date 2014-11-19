/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.singleton;

import futbol.five.com.bean.Partido;
import futbol.five.com.dao.CanchaDAO;
import futbol.five.com.interfaz.CanchaIF;
import java.util.List;


public class SingletonPartidos {
    
    private static  CanchaIF u = new CanchaDAO();
    
    private static final SingletonPartidos a = new SingletonPartidos() ;
    
        
    private SingletonPartidos(){
     
    }
    
    public static SingletonPartidos getPartidos(){
        return a;
    }    
    
    public List getPartidosOrganizados(String iduser){
     
    return  u.listarPartidos(iduser);
    }
    
    public List getCompromisosEstandar(String iduser){
     
        
        return u.listarCompromisos(iduser);
        
    }
    
    public List getCompromisosSolidarias(String iduser){
        
        return u.listarSolidarias(iduser);
    }
    
    public List buscarPartidosSingleton(String fecha,String dia){
     
        
        
     return u.BuscarPartidos(fecha, dia);
    }
    
}
