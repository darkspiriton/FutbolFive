/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol.five.com.servlet;

import com.twilio.sdk.TwilioRestException;
import futbol.five.com.singleton.MantenimientoBD;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mari
 */
public class Mantenimiento extends HttpServlet {

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        HttpSession ses = request.getSession();
        MantenimientoBD mantenimiento = MantenimientoBD.getMantenimientoBD();
        
        try {
            if (mantenimiento.verificarMantenimiento()==true){
                ses.setAttribute("STATUS","SE ACTUALIZO LA BASE DE DATOS CORRECTAMENTE");
            }else{
                ses.setAttribute("STATUS","LAS BASE DE DATOS NO NECESITABA SER ACTUALIZADAS");
            }
        } catch (TwilioRestException ex) {
            Logger.getLogger(Mantenimiento.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/panelAdministrador.jsp");
        rd.forward(request, response);
    }

}
