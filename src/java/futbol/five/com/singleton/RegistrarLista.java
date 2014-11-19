/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol.five.com.singleton;

import futbol.five.com.dao.CanchaDAO;
import futbol.five.com.interfaz.CanchaIF;

/**
 *
 * @author Cesar
 */
public class RegistrarLista {
   private static final RegistrarLista r = new RegistrarLista() ;
   private CanchaIF cancha = new CanchaDAO();
        
    private RegistrarLista(){
     
    }
    
    public static RegistrarLista getRegistrarLista(){
        return r;
    } 
    
    public boolean verificarEspacioEstandar(String cod){
        boolean hayEspacio=false;
        int idCodE = Integer.parseInt(cod);
        
        if(cancha.verficarListaEstandar(idCodE)==true){
            hayEspacio=true;
        }        
        return hayEspacio;
    }
    
    public boolean verificarEspacioSolidaria(String cod){
        boolean hayEspacio=false;
        int idCodS = Integer.parseInt(cod);
        if(cancha.verficarListaEstandar(idCodS)==true){
            hayEspacio=true;
        }  
        return hayEspacio;
    }
    
    public boolean insertarListaEstandar(String cod,String user){
        int num = Integer.parseInt(cod);
        boolean insertar=false;
        if(cancha.verificarExisteLE(user, num)==false){
            if (cancha.verificarExisteLS(user, num)==false){
                cancha.insertarListaEstandar(user, num);
                insertar=true;
            }
        }
        return insertar;
        
        
    }
    public boolean insertarListaSolidaria(String cod,String user){
        int num = Integer.parseInt(cod);
        boolean insertar=false;
        
        if(cancha.verificarExisteLS(user, num)== false){
            if (cancha.verificarExisteLE(user, num)==false){
                cancha.insertarListaSolidaria(user, num);
                insertar=true;
            }
        }       
        
        return insertar;
    }
}

