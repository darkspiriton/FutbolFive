/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol.five.com.servlet;

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
public class LogOut extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession(true);
        ses.removeAttribute("idUser");
        ses.removeAttribute("idAdmin");
        ses.removeAttribute("organizado");
        ses.removeAttribute("compromisos");
        ses.removeAttribute("solidarias");
        ses.removeAttribute("pagado");
        ses.removeAttribute("lestandar");
        ses.removeAttribute("lsolidaria");
        ses.removeAttribute("listaCanchas");
        ses.removeAttribute("fechaInvalida");
        ses.removeAttribute("fechaPartido");
        ses.removeAttribute("ERROR_LOGIN");
        ses.removeAttribute("LOGIN_INVALIDO_ADMINISTRADOR");
        ses.removeAttribute("status");
        ses.removeAttribute("ERROR_REGISTRO");
        ses.removeAttribute("detallePartido");
        ses.removeAttribute("listaPartidos");
        ses.removeAttribute("ESTADO_LISTA");
        ses.removeAttribute("pagado");
               
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
    }
}
