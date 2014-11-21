/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.servlet;

import com.twilio.sdk.TwilioRestException;
import futbol.five.com.dao.UsuarioDAO;
import futbol.five.com.interfaz.UsuarioIF;
import futbol.five.com.singleton.SingletonUsuario;
import futbol.five.com.singleton.Sms;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Samuel
 */
@WebServlet(name = "CancelarPartido", urlPatterns = {"/CancelarPartido"})
public class CancelarPartido extends HttpServlet {

   
 

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
          
        String fecha=request.getParameter("fecha");
        String organizador=request.getParameter("organizador");
        String cancha=request.getParameter("cancha");
        String horario=request.getParameter("horario");
        
        String listaEs=request.getParameter("ListaEs");
        String listaSo=request.getParameter("ListaSo");        
        String codPago=request.getParameter("codPago");  
       
        
                
        SingletonUsuario u = SingletonUsuario.getUsuario();
        try {
            u.cancelarPartido(organizador, fecha, cancha, horario, codPago, listaEs, listaSo);
        } catch (TwilioRestException ex) {
            Logger.getLogger(CancelarPartido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HttpSession ses = request.getSession();
    
        ses.setAttribute("pagado","se pagó el partido con éxito");        
        RequestDispatcher rd;  
        rd = request.getRequestDispatcher("/Actividad.jsp");
        rd.forward(request, response);
       
    }

  
 
    
   
}
