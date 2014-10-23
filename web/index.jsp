<%-- 
    Document   : login
    Created on : 06/09/2014, 03:17:48 PM
    Author     : Cesar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="futbol.five.com.bean.Usuario" %>    

<jsp:useBean id="LOGIN_INVALIDO_CONTRASEÑA" class="java.lang.String" scope="session" />

<!DOCTYPE html>
<html lang="es">
<head>
    <jsp:include page="/layout/head.jsp"/>
</head>
<body>

	<header>
		<div class="logo">
			<img src="imagenes/logo.png" alt="Futbol5"/>
		</div>
		<div class="titular">
			<h1 class="titulo">
				Iniciar Sesion
			</h1>
			<div>
				<a href="#" class="filtro">
					Futbol 5
				</a>
				<a href="/FutbolFive/registro.jsp" class="organizar">
					Registrarse
				</a>

			</div>

		</div>
	</header>

	<nav>
		<ul class="menu">
			
		</ul>
	</nav>

	<div class="container">

		<div class="main_content">

			<div class="header">
				<h5>Iniciar sesión</h5>
			</div>

			<div class="body">

				<form action="LoginPrueba" method="post">
				    
				    <p><label for="usuario">Usuario</label><input placeholder="Ingrese su usuario" id="usuario" name="usuario" type="text" /></p>
                    <p><label for="passw">Contraseña</label><input placeholder="Ingrese su contrase" id="passw" name="passw" type="password" /></p>
				    <span class="boton"><input name="commit" type="submit" value="Iniciar sesión"></span>
 				 </form>

 			</div>
 			<div class="footer">
 				<span class="error"><%= LOGIN_INVALIDO_CONTRASEÑA %></span>
 				<a class="registro_link" href="/FutbolFive/registro.jsp">¿No tienes una cuenta? Registrate aqui</a>
 				
 			</div>
		</div>	 
                
	</div>      
	<footer>
            <jsp:include page="/layout/footer.jsp"/>
	</footer>

</body>
</html>
