<%-- 
    Document   : VerPartidos
    Created on : 17/09/2014, 06:57:05 PM
    Author     : Richard
--%>

<%@page import="futbol.five.com.bean.Cancha"%>
<%@page import="futbol.five.com.bean.Partido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="listaPartidos" class="java.util.ArrayList" scope="session"/>
<jsp:useBean id="idUser" class="java.lang.String" scope="session"/>
<jsp:useBean id="fechaInvalida" class="java.lang.String" scope="session"/>
<jsp:useBean id="fechaPartido" class="java.lang.String" scope="session"/>
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
				<h5>Elegir Campo Deportivo</h5>
				<div class="hit">Elige el dia y la hora
				</div>
			</div>
			<div class="body">
				<form action="ListarPartidos" method="post">
				    
				       <p><label for="fecha">Fecha</label><input id="fecha" name="fecha" type="date" /></p>
				        <p><label for="hora">Hora</label>	
					        <select name="hora">
							  <option value="8">8:00 am</option>
							  <option value="10">10:00 am</option>
							  <option value="12">12:00 am</option>
							  <option value="14">2:00 pm</option>
							  <option value="16">4:00 pm</option>
							  <option value="18">6:00 pm</option>
							  <option value="20">8:00 pm</option>
							  <option value="22">10:00 pm</option>
							</select>
						</p>
                                        
				  
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
					<div class="acciones">
                                            
						<div class="registro">
                             <p><a href="InscripcionEstandar?fecha=<%=fechaPartido%>&idUser=<%=idUser%>&codCancha=<%= p.getCodCancha()%>&codHorario=<%= p.getCodHorario()%>" class="inscribirse">Inscribirse en Lista Estandar</a>
                            <a href="#" class="inscribirse"><%= p.getListaE()%></a>
                           </p>
                           <p>
                            <a href="InscripcionSolidaria?fecha=<%=fechaPartido%>&idUser=<%=idUser%>&codCancha=<%= p.getCodCancha()%>&codHorario=<%= p.getCodHorario()%>" class="inscribirse">Inscribirse en Lista Solidaria</a>
                            <a href="#" class="inscribirse"><%= p.getListaS()%></a></p>
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
</body>
</html>
