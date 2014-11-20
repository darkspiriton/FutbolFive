<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="futbol.five.com.bean.Usuario" %>    
<jsp:useBean id="ERROR_REGISTRO" class="java.lang.String" scope="session" />

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
				Comunidad Deportiva
			</h1>
			<div>
				<a href="#" class="filtro">
					FutbolFive
				</a>
			</div>
		</div>
	</header>

	<nav>
		<ul class="menu">
			
		</ul>
	</nav>

	<div  class="container">
		<div class="main_content">
			<div class="header">
				<h5>Registrate</h5>
				<div class="hit">¿Ya tienes una cuenta? <a href="/FutbolFive/index.jsp">Inicia Sesion</a>
				</div>
			</div>
			<div class="body">
                    <form action="RegistroServlet" method="post">	   
                        <p><label for="usuario">Usuario</label><input placeholder="Ingrese su usuario" id="usuario" name="usuario" type="text" /></p>
                        <p><label for="nombre">Nombre</label><input placeholder="Ingrese su nombre"	 id="nombre" name="nombre" type="text" /></p>
                        <p><label for="apellido">Apellido</label><input placeholder="Ingrese su pellido"  id="apellido" name="apellido" type="text" /></p>
                        <p><label for="email">E-mail</label><input placeholder="Ingrese su correo"  id="email" name="email" type="text" /></p>
                        <p><label for="proveedor">Proveedor</label>	
							<select name="proveedor">
								<option value="claro">Claro</option>
								<option value="movistar">Movistar</option>
							</select>
						</p>
                        <p><label for="ntelefono">N° Telefono</label><input placeholder="Ingrese su n° telefonico"  id="ntelefono" name="ntelefono" type="text" /></p>                      
                        <p><label for="pass1">Contraseña</label><input placeholder="Ingrese su contraseña" id="pass1" name="pass1" type="password" /></p>
                        <p><label for="pass2">Confirmar Contraseña</label><input placeholder="Reingrese su contraseña" id="pass2" name="pass2" type="password" /></p>
                        <p><label for="fecha">Fecha de Nacimiento</label><input id="fecha" name="fecha" type="date" /></p>
                        <span class="boton"><input name="commit" type="submit" value="Registrar en Futbol 5"></span>                        
                    </form>
                    				 	
			</div>
			<div class="footer">
 				<span class="error"><%= ERROR_REGISTRO %></span>
 			</div>					                
		</div>	
	</div>
              
	
	<footer>
       <jsp:include page="/layout/footer.jsp"/>
	</footer>

  
</body>
</html>

