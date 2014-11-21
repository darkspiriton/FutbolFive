/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.servlet;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
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
 * @author Mari
 */
public class RegistroPartido extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String iduser = request.getParameter("idUser");
        String cancha = request.getParameter("codCancha");
        String horario = request.getParameter("codHorario");
        String fecha = request.getParameter("fecha");
        
        HttpSession ses = request.getSession();
        ses.removeAttribute("fechaPartido");
        ses.removeAttribute("listaCanchas");
        
        Singleton gestor = Singleton.getSingleton();
        ses.setAttribute("detallePartido", gestor.getDetallePartido(iduser, cancha, horario,fecha));
         
         
        RequestDispatcher rd = request.getRequestDispatcher("/registroPartidoDetalle.jsp");
        rd.forward(request, response);
    }

}
