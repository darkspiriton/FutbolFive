/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.servlet;



import futbol.five.com.bean.Partido;
import futbol.five.com.singleton.SingletonPartidos;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "PartidosOrganizados", urlPatterns = {"/PartidosOrganizados"})
public class PartidosOrganizados extends HttpServlet {

 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String iduser = request.getParameter("idUser");
        
        SingletonPartidos organizados = SingletonPartidos.getPartidos();
           
        HttpSession ses = request.getSession();
        
        
        ses.removeAttribute("pagado");
        ses.removeAttribute("ESTADO_LISTA");
        ses.removeAttribute("listaCanchas");
        ses.setAttribute("organizado", organizados.getPartidosOrganizados(iduser) ); 
        ses.setAttribute("compromisos",organizados.getCompromisosEstandar(iduser)); 
        ses.setAttribute("solidarias",organizados.getCompromisosSolidarias(iduser));
        RequestDispatcher rd;  
        rd = request.getRequestDispatcher("/Actividad.jsp");
        rd.forward(request, response); 
        
    }


    
}
