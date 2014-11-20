

package futbol.five.com.singleton;

import futbol.five.com.metodo.ManejadorFechas;


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
        String diaActual = diaAux.getFechaActual(); 
        if(fecha.length()==10){
            int i=diaAux.diferenciasDeFechas(diaAux.deStringToDate(diaActual), diaAux.deStringToDate(fecha));
                if (i>=0 && i<=7){
                    valido=true;
                }
        }
        int i=diaAux.diferenciasDeFechas(diaAux.deStringToDate(diaActual), diaAux.deStringToDate(fecha));
        return valido;
    }
    
    public String obtenerDia(String fecha){
        return diaAux.devolverDia(fecha);
    }
}
