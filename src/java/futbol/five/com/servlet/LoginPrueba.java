package futbol.five.com.servlet;


import futbol.five.com.singleton.Singleton;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginPrueba extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
                HttpSession ses = request.getSession(true);
		String user = request.getParameter("usuario");
		String pass = request.getParameter("passw");
		
		Singleton gestor = Singleton.getSingleton();
		if (gestor.verificarUsuario(user, pass)==true){
			ses.setAttribute("idUser", user);
			ses.removeAttribute("ERROR_LOGIN");
                        ses.removeAttribute("ERROR_REGISTRO");
			RequestDispatcher rd = request.getRequestDispatcher("/bienvenido.jsp");
			rd.forward(request, response);
		}else{
                        ses.setAttribute("ERROR_LOGIN", "El usuario es incorrecto o la contraseña es incorrecta");
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	
    }   
                
    }