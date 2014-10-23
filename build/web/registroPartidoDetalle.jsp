<%-- 
    Document   : registroPartidoDetalle.jsp
    Created on : 16/09/2014, 03:23:33 PM
    Author     : Mari
--%>

<%@page import="futbol.five.com.bean.Cancha"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="detallePartido" class="futbol.five.com.bean.Partido" scope="session"/>

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
				<h5>Detalle del encuentro</h5>
				<div class="hit"><a href="/FutbolFive/bienvenido.jsp">Regresar al Inicio</a>
				</div>
			</div>
			<div class="body">
				
			</div>

			<section class="partidos">

                            <article class="resultado">
                                <div class="descripcion">
                                        
                                        <div class="detalles">
                                                <h2 class="titulo">
                                                        Detalle partido: <%=detallePartido.getDescripcion()%> 
                                                </h2>
                                                <p class="autor">
                                                        Organizado por <span class="nombreAutor"><%=detallePartido.getOrganizador()%></span>
                                                </p>
                                                Horario: <span class="horario"><%=detallePartido.getDia()%> / <%=detallePartido.getHoraInicio()%> - <%=detallePartido.getHoraFin()%></span>
                                                <p class="fecha"><strong>Fecha: <%=detallePartido.getFecha()%></strong></p>
                                        </div>
                                </div>
                                <div class="acciones">
                                        <div class="registro">
                                                <span class="inscribirse">Dirección: <%=detallePartido.getDireccion()%></span>
                                                
                                        </div>

                                </div>
                            </article>
                                                
                            <article class="resultado">
                                <div class="descripcion">
                                        
                                        <div class="detalles">
                                                <h2 class="titulo">
                                                        N° recibo <%=detallePartido.getCodPago()%>
                                                </h2>
                                                <p class="autor">
                                                        <span class="nombreAutor">Monto S/.<%=detallePartido.getMonto()%> - Comision S/.<%=detallePartido.getComision()%> </span>
                                                </p>
                                                Estado: <span class="horario"><%=detallePartido.getEstadoPago()%></span>
                                                
                                        </div>
                                </div>
                                <div class="acciones">
                                        <div class="registro">
                                                <span class="exito">Se registro con exito el encuentro</span>
                                                
                                        </div>
                                        
                                </div>
                            </article>

			</section>

		</div>	
	</div>
	
	
	<footer>
            <jsp:include page="/layout/footer.jsp"/>
	</footer>
</body>
</html>