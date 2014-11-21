
package futbol.five.com.singleton;

import com.twilio.sdk.TwilioRestException;
import futbol.five.com.dao.CanchaDAO;
import futbol.five.com.dao.UsuarioDAO;
import futbol.five.com.interfaz.CanchaIF;
import futbol.five.com.interfaz.UsuarioIF;



public class SingletonUsuario {
    private static final SingletonUsuario a = new SingletonUsuario();
    private static UsuarioIF u = new  UsuarioDAO();
    
      public SingletonUsuario() {
    }
    
    public static SingletonUsuario getUsuario(){
        return a;
    }
    //u.cancelarPartido(organizador, fecha, cancha, horario, codPago, listaEs, listaSo);
    public void cancelarPartido(String organizador,String fecha,String cancha,String horario,String pago,String estandar,String solidaria) throws TwilioRestException{
        int codCancha = Integer.parseInt(cancha);
        int codHorario=Integer.parseInt(horario);
        int codPago=Integer.parseInt(pago);
        int est=Integer.parseInt(estandar);
        int sol=Integer.parseInt(solidaria);
        u.cancelarPartido(organizador, fecha, codCancha, codHorario, codPago, est, sol);
        CanchaIF c =  new CanchaDAO();  
        
        Sms mensaje = Sms.getSms();
        mensaje.enviarMensaje( c.obtenerNumTL(est), "Se cancelo el partido");
    }
}
