<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="idUser" class="java.lang.String" scope="session"/>
<!DOCTYPE html>
<html lang="es">
<head>
        <meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,  initial-scale=1, maximum-scale=1">
	<title>Futbol 5</title>
	<link rel="stylesheet" href="css/estilos.css"/>
	<link rel="stylesheet" href="css/normalize.css"/>
	
</head>
<body>
    <% if (idUser.equals("") ) { %>
	Necesita esta Logeado para acceder  
        <%}else {%>    
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
					Futbol 5
				</a>
				<a href="/FutbolFive/buscarCancha.jsp" class="organizar">
					Organizar
				</a>

			</div>

		</div>
		<div class="usuario">
			<jsp:include page="/layout/logOut.jsp"/>
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
                        <%}%>

</body>
</html>