<%-- 
    Document   : ListaSolidaria
    Created on : 10/11/2014, 10:00:34 PM
    Author     : Samuel
--%>

<%@page import="futbol.five.com.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="lsolidaria" class="java.util.ArrayList" scope="session"/>
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
				<h5>PARTIDOS ORGANIZADOS</h5>
				<div class="hit"><a href="/FutbolFive/Actividad.jsp">Regresar Actividadd</a>
				</div>
			</div>
			
                        
			<section class="partidos">

                <% if (lsolidaria!= null ) { %>                   
                    <%for (int i=0; i < lsolidaria.size(); i++ ) {Usuario o = (Usuario)lsolidaria.get(i);%>

				<article class="partido">
					<div class="descripcion">
						<figure class="imagen">
							<img src="imagenes/foto.png" />
						</figure>
						<div class="detalles">
							
							<p class="autor">
                                                             <span class="nombreAutor"><%= o.getUser() %></span>
							     <span class="nombreAutor"><%= o.getNombre() %></span>
                                                             <span class="nombreAutor"><%= o.getApellido() %></span>
                                                             <span class="nombreAutor"><%= o.getnTelefono() %></span>
                                                             <span class="nombreAutor"><%= o.getCorreo() %></span>
                                                            
							</p>
							
						</div>
					</div>
                                                        <div class="acciones">
					
				
                
				 </article>
                             <%} %><% }else { %>
                	<h5>NO TIENES PARTIDOS ORGANIZADOS</h5>
                        <%}%>

			</section>

                        
                        <div class="header">
				<h5>COMPROMISOS A ASISTIR - LISTA ESTANDAR</h5>
				
			</div>

                        
                        
                </div>	
	</div>
	
	
	<footer>
            <jsp:include page="/layout/footer.jsp"/>
	</footer>
        <%}%>
</body>
</html>
