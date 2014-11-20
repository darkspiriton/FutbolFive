
<%@page import="futbol.five.com.bean.Cancha"%>
<%@page import="futbol.five.com.bean.Partido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="listaPartidos" class="java.util.ArrayList" scope="session"/>
<jsp:useBean id="idUser" class="java.lang.String" scope="session"/>
<jsp:useBean id="fechaInvalida" class="java.lang.String" scope="session"/>

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
				<h5>CAMPOS DEPORTIVOS DISPONIBLES</h5>	
			</div>
		<div class="body">
				<form action="BuscarPartidos" method="post">
				    
				       <p><label for="fecha">Fecha</label><input id="fecha" name="fecha" type="date" /></p>
				       
                                        
				  
				    <span class="boton"><input name="commit" type="submit" value="Buscar"></span>
 				 </form>
                            <span class="error"><%=fechaInvalida%></span>
			</div>

			<section class="partidos">
                            
                            
                           

                <% if (listaPartidos!= null ) { %>                   
             	<%for (int i=0; i < listaPartidos.size(); i++ ) {Partido p = (Partido)listaPartidos.get(i);%>

				<article class="partido">
					<div class="descripcion">
						<figure class="imagen">
							<img src="imagenes/foto.png" />
						</figure>
						<div class="detalles">
							<h2 class="titulo">
								<%= p.getDescripcion() %>
							</h2>
							<p class="autor">
								Direccion: <span class="nombreAutor"><%= p.getDireccion() %></span>
							</p>
							<a href="#" class="horario">Horario: <%= p.getDia()%>  <%= p.getHoraInicio() %> - <%= p.getHoraFin() %></a>
							<p class="fecha"><strong></strong>Disponible</p>
						</div>
					</div>
					         
				 </article>
                             <%} %><% }else { %>                	
                        <%}%>
			</section>
		</div>	
	</div>
	
	
	<footer>
            <jsp:include page="/layout/footer.jsp"/>
	</footer>
                  	
                        <%}%>
</body>

</html>
