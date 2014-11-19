/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.servlet;

import futbol.five.com.bean.Usuario;
import futbol.five.com.dao.UsuarioDAO;
import futbol.five.com.interfaz.UsuarioIF;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "ListaE", urlPatterns = {"/ListaE"})
public class ListaE extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
         String lista= request.getParameter("listaE");
         int ListaE = Integer.parseInt(lista);
         UsuarioIF u = new UsuarioDAO();
         List<Usuario> lestandar= u.listaEstandar(ListaE);
         HttpSession ses = request.getSession();
         ses.setAttribute("lestandar",lestandar); 
         RequestDispatcher rd;  
         rd = request.getRequestDispatcher("/ListaEstandar.jsp");
         rd.forward(request, response); 
         
    }

   
    
}
