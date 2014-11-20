/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol.five.com.singleton;

import com.twilio.sdk.TwilioRestException;
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
    private CanchaIF cancha = new CanchaDAO();
        
    private MantenimientoBD(){
     
    }
    
    public static MantenimientoBD getMantenimientoBD(){
        return m;
    }
    
    public boolean verificarMantenimiento() throws TwilioRestException{
        boolean status=false;
        
        List lPartido1=cancha.mantenimientoFechaPartido();
        
        
        
        if ( lPartido1.size()>0){
            for (int j=0;j<lPartido1.size();j++){
                Partido p1 = (Partido)lPartido1.get(j);
                cancha.actualizarEstadoCaducado(p1);
                cancha.obtenerNumTL(p1.getListaE());
                
                
               //Notificar a todos los usuarios (caducado)
               Sms sms = Sms.getSms();
               sms.enviarMensaje(cancha.obtenerNumTL(p1.getListaE()), "El partido no se realizara porque esta caducado");
                           
            }
            
            status =true;
          
        }
        
        return status;
        
        
    }
    public boolean verificarMantenimientoListas(){
        boolean status=false;
        List lPartido2=cancha.mantenimientoListaEPartido();
        if(lPartido2.size()>0){
            for (int i=0;i<lPartido2.size();i++){
                Partido p2 = (Partido)lPartido2.get(i);
                cancha.actualizarEstadoLleno(p2); 
                
            }
            status=true;
        }
            
        
        
        return status;
    }
    
}
