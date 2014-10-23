
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.servlet;

import futbol.five.com.singleton.Singleton;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Richard
 */
public class RegistroServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                // Recupero los parametros enviados desde el FORM
		String user = request.getParameter("usuario");
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String correo = request.getParameter("email");
                String proveedor = request.getParameter("proveedor");
                String ntelefono = request.getParameter("ntelefono");
                String pass1 = request.getParameter("pass1");
                String pass2 = request.getParameter("pass2");
                String fechaN = request.getParameter("fecha");
		
		HttpSession ses = request.getSession();
                
               if (pass1.equals(pass2)){
                   
                   ses.removeAttribute("INSCRIPCION_INVALIDO_CONTRASEÑA");
                   
                   Singleton gestor = Singleton.getSingleton();
                   gestor.registrarUsuario(user, nombre, apellido, correo, proveedor, ntelefono, pass1, fechaN);
                   
                   RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                   rd.forward(request, response);
                
                }else{
                    ses.setAttribute("INSCRIPCION_INVALIDO_CONTRASEÑA", "Las contraseña son diferentes");
                    RequestDispatcher rd = request.getRequestDispatcher("/registro.jsp");
                    rd.forward(request, response);
                   
               }
               
                
	}
    }

  
    


