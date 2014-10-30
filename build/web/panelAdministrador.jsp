
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="STATUS" class="java.lang.String" scope="session"/>
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
				<a href="#" class="organizar">
					Panel de Administrador
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
		
	</nav>
        
	<div class="container">
		<div class="main_content">
			<div class="header">
				<h5>Menu Opciones</h5>
				<div class="hit">Elige una opcion de mantenimiento
				</div>
			</div>
			<div class="body">
				<form action="Mantenimiento" method="post">
                                    <span class="boton"><input name="commit" type="submit" value="Mantenimiento"></span>
 				</form>
                                
                                <span class="status"><%=STATUS%></span>
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