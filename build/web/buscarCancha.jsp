<%-- 
    Document   : mostrarCampo
    Created on : 08/09/2014, 05:18:23 PM
    Author     : Mari
--%>

<%@page import="futbol.five.com.bean.Cancha"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="idUser" class="java.lang.String" scope="session"/>
<jsp:useBean id="listaCanchas" class="java.util.ArrayList" scope="session"/>
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
				<h5>Elegir Campo Deportivo</h5>
				<div class="hit">Elige el dia y la hora (Solo se puede reservar con 7 dias de anticipacion como máximo )
				</div>
			</div>
			<div class="body">
				<form action="ListarCanchas" method="post">
				    
				       <p><label for="fecha">Fecha</label><input id="fecha" name="fecha" type="date" required/></p>
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

                <% if (listaCanchas != null ) { %>                   
             	<%for (int i=0; i < listaCanchas.size(); i++ ) {Cancha c = (Cancha)listaCanchas.get(i);%>

				<article class="partido">
					<div class="descripcion">
						<figure class="imagen">
							<img src="imagenes/foto.png" />
						</figure>
						<div class="detalles">
							<h2 class="titulo">
								<%= c.getDescripcion() %>
							</h2>
							<p class="autor">
								Direccion: <span class="nombreAutor"><%= c.getDireccion() %></span>
							</p>
							<a href="#" class="horario">Horario: <%= c.getDia()%>  <%= c.getHoraInicio() %> - <%= c.getHoraFin() %></a>
							<p class="fecha"><strong></strong>Disponible</p>
						</div>
					</div>

					<div class="acciones">
                                            
						<div class="registro">
                            <a href="RegistroPartido?fecha=<%=fechaPartido%>&idUser=<%=idUser%>&codCancha=<%= c.getCodCancha()%>&codHorario=<%= c.getCodHorario()%>" class="inscribirse">Organizar</a>
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
