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
@WebServlet(name = "SalirListaEstandar", urlPatterns = {"/SalirListaEstandar"})
public class SalirListaEstandar extends HttpServlet {

  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
           
        String estandar=request.getParameter("listaE");
        String usuario=request.getParameter("usuario");
        
        int estand = Integer.parseInt(estandar);
      
        UsuarioIF u = new UsuarioDAO();
        u.SalirEstandar(usuario, estand);
        HttpSession ses = request.getSession();
    
        ses.setAttribute("borrado","se retiro del partido con exito");        
        RequestDispatcher rd;  
        rd = request.getRequestDispatcher("/Actividad.jsp");
        rd.forward(request, response);
        
        
    }

}
