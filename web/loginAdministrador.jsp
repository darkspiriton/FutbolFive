<%-- 
    Document   : loginAdministrador
    Created on : 29/10/2014, 11:16:35 AM
    Author     : Mari
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="futbol.five.com.bean.Usuario" %>    

<jsp:useBean id="LOGIN_INVALIDO_ADMINISTRADOR" class="java.lang.String" scope="session" />

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
			<li><a href="/FutbolFive/index.jsp">Inicio</a></li>
		</ul>
	</nav>

	<div class="container">

		<div class="main_content">

			<div class="header">
				<h5>Iniciar sesión como Administrador</h5>
			</div>

			<div class="body">

				<form action="LoginAdministrador" method="post">
				    
				    <p><label for="usuario">Usuario</label><input placeholder="Ingrese su usuario" id="usuario" name="usuario" type="text" /></p>
                    <p><label for="passw">Contraseña</label><input placeholder="Ingrese su contraseña" id="passw" name="passw" type="password" /></p>
				    <span class="boton"><input name="commit" type="submit" value="Iniciar sesión"></span>
 				 </form>

 			</div>
 			<div class="footer">
 				<span class="error"><%= LOGIN_INVALIDO_ADMINISTRADOR %></span>
 			</div>
		</div>	 
                
	</div>      
	<footer>
            <jsp:include page="/layout/footer.jsp"/>
	</footer>

</body>
</html>

