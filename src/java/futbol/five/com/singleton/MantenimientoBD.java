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

/**
 *
 * @author Mari
 */
public class MantenimientoBD {
    
    
    private static final MantenimientoBD m = new MantenimientoBD() ;
    
        
    private MantenimientoBD(){
     
    }
    
    public static MantenimientoBD getMantenimientoBD(){
        return m;
    }
    
    public boolean verificarMantenimiento(){
        boolean status=false;
        CanchaIF cancha = new CanchaDAO();
        List lPartido1=cancha.mantenimientoFechaPartido();
        List lPartido2=cancha.mantenimientoListaEPartido();
        
        
        if ( lPartido1.size()>0 || lPartido2.size()>0 ){
            for (int j=0;j<lPartido1.size();j++){
                Partido p1 = (Partido)lPartido1.get(j);
                cancha.actualizarEstadoCaducado(p1);
                
               //Notificar a todos los usuarios (caducado)
                
            }
            for (int i=0;i<lPartido2.size();i++){
                Partido p2 = (Partido)lPartido2.get(i);
                cancha.actualizarEstadoLleno(p2);
                //Actualizar el Estado en las TABLAS : LISTA ESTANDAR,LISTA SOLIDARIA;
            }
            status =true;
          
        }
        
        return status;
        
        
    }
}
