/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.servlet;

import futbol.five.com.dao.UsuarioDAO;
import futbol.five.com.interfaz.UsuarioIF;
import java.io.IOException;
import java.io.PrintWriter;
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
        String ListaEs=request.getParameter("ListaEs");
        String ListaSo=request.getParameter("ListaSo");        
        String codPago=request.getParameter("codPago");  
        int codcancha = Integer.parseInt(cancha);
        int codhorario=Integer.parseInt(horario);
        int Pago=Integer.parseInt(codPago);
        int Estand=Integer.parseInt(ListaEs);
        int solid=Integer.parseInt(ListaSo);
        
        
        UsuarioIF u = new UsuarioDAO();
        u.cancelarPartido(organizador, fecha, codcancha, codhorario,Pago,Estand,solid);
        
        HttpSession ses = request.getSession();
    
        ses.setAttribute("pagado","se pagó el partido con éxito");        
        RequestDispatcher rd;  
        rd = request.getRequestDispatcher("/Actividad.jsp");
        rd.forward(request, response);
       
    }

  
 
    
   
}
