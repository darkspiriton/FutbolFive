<%-- 
    Document   : Actividad
    Created on : 09/11/2014, 03:14:25 AM
    Author     : Samuel
--%>

<%@page import="futbol.five.com.bean.Partido"%>
<%@page import="futbol.five.com.bean.Cancha"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="idUser" class="java.lang.String" scope="session"/>
<jsp:useBean id="organizado" class="java.util.ArrayList" scope="session"/>
<jsp:useBean id="compromisos" class="java.util.ArrayList" scope="session"/>
<jsp:useBean id="solidarias" class="java.util.ArrayList" scope="session"/>
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
				<h5>PARTIDOS ORGANIZADOS</h5>
				
			</div>
			
                        
			<section class="partidos">

                <% if (organizado != null ) { %>                   
                    <%for (int i=0; i < organizado.size(); i++ ) {Partido o = (Partido)organizado.get(i);%>

				<article class="partido">
					<div class="descripcion">
						<figure class="imagen">
							<img src="imagenes/foto.png" />
						</figure>
						<div class="detalles">
							<h2 class="titulo">
								<%= o.getDescripcion() %>
							</h2>
							<p class="autor">
								Direccion: <span class="nombreAutor"><%= o.getDireccion() %></span>
							</p>
							<a href="#" class="horario">Horario: <%= o.getDia()%>  <%= o.getHoraInicio() %> - <%= o.getHoraFin() %></a>
							<p class="fecha"><strong></strong>Disponible</p>
						</div>
					</div>
                                                        <div class="acciones">
					<div class="registro">
                                            <a href="ListaE?listaE=<%=o.getListaE()%>" class="inscribirse">ListaEstandar</a>
                                            <a href="ListaS?listaS=<%=o.getListaS()%>" class="detalle">ListaSolidaria</a>
                                            <a href="" class="inscribirse">Realizar Pago</a>
                                            <a href="" class="inscribirse">Cancelar</a>
                                            
                                        </div>
				
                
				 </article>
                             <%} %><% }else { %>
                	<h5>NO TIENES PARTIDOS ORGANIZADOS</h5>
                        <%}%>

			</section>

                        
                        <div class="header">
				<h5>COMPROMISOS A ASISTIR - LISTA ESTANDAR</h5>
				
			</div>

                        <section class="partidos">

                <% if (compromisos != null ) { %>                   
                    <%for (int i=0; i < compromisos.size(); i++ ) {Partido o = (Partido)compromisos.get(i);%>

				<article class="partido">
					<div class="descripcion">
                                            <p class="autor">
						Organizado por <span class="nombreAutor"><%= o.getOrganizador() %></span>
					    </p>
						<figure class="imagen">
							<img src="imagenes/foto.png" />
						</figure>
						<div class="detalles">
							<h2 class="titulo">
								<%= o.getDescripcion() %>
							</h2>
							<p class="autor">
								Direccion: <span class="nombreAutor"><%= o.getDireccion() %></span>
							</p>
							<a href="#" class="horario">Horario: <%= o.getDia()%>  <%= o.getHoraInicio()%> - <%= o.getHoraFin() %></a>
							<p class="fecha"><strong></strong>Disponible</p>
						</div>
					</div>
                                                        <div class="acciones">
                                    
				
					
				
                
				 </article>
                             <%} %><% }else { %>
                	<h5>NO TIENES COMPROMISOS EN ESTA LISTA</h5>
                        <%}%>

			</section>
                
                
                        <div class="header">
				<h5>COMPROMISOS A ASISTIR - LISTA SOLIDARIA</h5>
				
			</div>

                        <section class="partidos">

                <% if (solidarias != null ) { %>                   
                    <%for (int i=0; i < solidarias.size(); i++ ) {Partido o = (Partido)solidarias.get(i);%>

				<article class="partido">
					<div class="descripcion">
                                            <p class="autor">
						Organizado por <span class="nombreAutor"><%= o.getOrganizador() %></span>
					    </p>
						<figure class="imagen">
							<img src="imagenes/foto.png" />
						</figure>
						<div class="detalles">
							<h2 class="titulo">
								<%= o.getDescripcion() %>
							</h2>
							<p class="autor">
								Direccion: <span class="nombreAutor"><%= o.getDireccion() %></span>
							</p>
							<a href="#" class="horario">Horario: <%= o.getDia()%>  <%= o.getHoraInicio()%> - <%= o.getHoraFin() %></a>
							<p class="fecha"><strong></strong>Disponible</p>
						</div>
					</div>
                                        
				
					
				
                
				 </article>
                             <%} %><% }else { %>
                	
			<h5>NO TIENES COMPROMISOS EN ESTA LISTA</h5>
			
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