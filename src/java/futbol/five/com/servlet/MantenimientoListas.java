/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbol.five.com.servlet;

import futbol.five.com.singleton.MantenimientoBD;
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
public class MantenimientoListas extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        HttpSession ses = request.getSession();
        MantenimientoBD mantenimiento = MantenimientoBD.getMantenimientoBD();
        
        if (mantenimiento.verificarMantenimientoListas()==true){
                ses.setAttribute("status","SE CERRARON LISTAS COMPLETAS EXITOSAMENTE");
                
            }else{
                ses.setAttribute("status","NO SE ENCONTRARON LISTAS QUE MODIFICAR");
            }
        RequestDispatcher rd = request.getRequestDispatcher("/panelAdministrador.jsp");
        rd.forward(request, response);
        }
        
    }
    




