<%-- 
    Document   : bienvenido
    Created on : 07/09/2014, 07:42:17 PM
    Author     : Richard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="LOGIN_VALIDO" class="java.lang.String" scope="session" />
<jsp:useBean id="listaUser" class="java.util.ArrayList" scope="session" />
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
                
                <% if ( listaUser == null ) { %>	
                 <center><h2><%= LOGIN_VALIDO %></h2></center>
                 <% } %>
                  
            
            
		<div class="titular">
			<h1 class="titulo">
				Comunidad Deportiva
			</h1>
			<div>
				<a href="#" class="filtro">
					Futbol 5
				</a>
				<a href="/FutbolFive/buscarCancha.jsp" class="organizar">
					Organizar
				</a>

			</div>

		</div>
		<div class="usuario">
			<figure class="avatar">
				<img src="imagenes/avatar.jpg" alt="user">
			</figure>
			<a href="/FutbolFive/index.jsp" class="opcion">
				X
			</a>
		</div>
	</header>

	<nav>
		<jsp:include page="/layout/nav.jsp"/>
	</nav>

	<div class="container">
		<div class="main_content">
			<div class="header">
				<h5>Bienvenido a la Comunidad de FutbolFive</h5>
				<div class="hit"> </div>
			</div>
			<div class="body">
				
			</div>

			<section class="partidos">

             

			</section>

		</div>	
	</div>

	<footer>
            <jsp:include page="/layout/footer.jsp"/>
	</footer>

</body>
</html>