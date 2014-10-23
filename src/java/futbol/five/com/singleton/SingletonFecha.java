/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.singleton;

import futbol.five.com.metodo.ManejadorFechas;

/**
 *
 * @author Cesar
 */
public class SingletonFecha {
    private static final SingletonFecha f = new SingletonFecha() ;
    private ManejadorFechas diaAux;
        
    private SingletonFecha(){
     diaAux= new ManejadorFechas();
    }
    
    public static SingletonFecha getSingletonFecha(){
        return f;
    }
    
    public boolean validarFecha(String fecha){
        boolean valido=false;
        //Permite limitar el dia de inscripcion falta terminar implementarlo 
        String diaActual = diaAux.getFechaActual(); 
        int i=diaAux.diferenciasDeFechas(diaAux.deStringToDate(diaActual), diaAux.deStringToDate(fecha));
        if (i>=0 && i<=7){
            valido=true;
            System.out.println("Fecha Aceptable");
            System.out.println(diaActual);
            System.out.println(fecha);
        }else{
            System.out.println("Fecha Rechazada");
            System.out.println(fecha);
        }
        
        return valido;
    }
    
    public String obtenerDia(String fecha){
        return diaAux.devolverDia(fecha);
    }
}
