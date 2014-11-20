/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol.five.com.servlet;

import futbol.five.com.singleton.Administrador;
import java.io.IOException;
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
public class LoginAdministrador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
                HttpSession ses = request.getSession(true);
		String user = request.getParameter("usuario");
		String pass = request.getParameter("passw");
		
		Administrador adm = Administrador.getAdministrador();
		if (adm.verificarAdministrador(user, pass)==true){
			ses.setAttribute("idAdmin", user);
			ses.removeAttribute("LOGIN_INVALIDO_ADMINISTRADOR");
			RequestDispatcher rd = request.getRequestDispatcher("/panelAdministrador.jsp");
			rd.forward(request, response);
		}else{
                        ses.setAttribute("LOGIN_INVALIDO_ADMINISTRADOR", "El usuario es incorrecto o la contraseña es incorrecta");
			RequestDispatcher rd = request.getRequestDispatcher("/loginAdministrador.jsp");
			rd.forward(request, response);
		}
	
    } 

}
