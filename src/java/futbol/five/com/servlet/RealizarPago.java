/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package futbol.five.com.servlet;

import futbol.five.com.dao.CanchaDAO;
import futbol.five.com.dao.UsuarioDAO;
import futbol.five.com.interfaz.CanchaIF;
import futbol.five.com.interfaz.UsuarioIF;
import futbol.five.com.singleton.Sms;
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
@WebServlet(name = "RealizarPago", urlPatterns = {"/RealizarPago"})
public class RealizarPago extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String codPago=request.getParameter("codPago");
        String ListaEs=request.getParameter("ListaEs");
        String ListaOs=request.getParameter("ListaSo");
        String organizador=request.getParameter("organizador");
        String cancha=request.getParameter("cancha");
        String horario=request.getParameter("horario");
        String fecha=request.getParameter("fecha");
        
        
        int pago = Integer.parseInt(codPago);
        int canchita = Integer.parseInt(cancha);
        int hora=Integer.parseInt(horario);
        int estandar=Integer.parseInt(ListaEs);
        int solidaria=Integer.parseInt(ListaOs);
        
        UsuarioIF u = new UsuarioDAO();
        CanchaIF c= new CanchaDAO();
        if (c.verficarListaEstandar(estandar)==false){
            
        
        u.pagarPartido(pago,organizador,canchita,hora,fecha, estandar,solidaria);
        HttpSession ses = request.getSession();
    
        ses.setAttribute("pagado","se pagó el partido con éxito");        
        RequestDispatcher rd;  
        rd = request.getRequestDispatcher("/Actividad.jsp");
        rd.forward(request, response);
            
        }else{
            
            
            
            if(u.compararListas(estandar, solidaria)==true){
                
                 u.pagarPartido(pago,organizador,canchita,hora,fecha, estandar,solidaria);
                 HttpSession ses = request.getSession();
    
                 ses.setAttribute("pagado","se pagó el partido con éxito");        
                 RequestDispatcher rd;  
                 rd = request.getRequestDispatcher("/Actividad.jsp");
                 rd.forward(request, response);
                
                
            }else{
                
                 HttpSession ses = request.getSession();
    
                 ses.setAttribute("pagado","Lista de jugadores incompleta, no se puede concretar el pago");        
                 RequestDispatcher rd;  
                 rd = request.getRequestDispatcher("/Actividad.jsp");
                 rd.forward(request, response);
                
            }
            
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
    }

 
}
