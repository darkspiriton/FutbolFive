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
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
		
	
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
				<h5>COMPROMISOS A ASISTIR - LISTA ESTANDAR		
				<div class="hit"><a href="/FutbolFive/Actividad.jsp">Regresar Actividad</a>
				</div>
			</div>
			
                        
			<section class="partidos">

                <% if (lsolidaria!= null ) { %>  
                    <table class="table table-bordered">
                                    <tr>
                                     <td class="active">N°</td>
                                     <td class="active">Nick</td>
                                     <td class="active">Nombre</td>
                                     <td class="active">N° Telefono</td>
                                     <td class="active">Correo</td>                                        
                                    </tr>
                
                    <%for (int i=0; i < lsolidaria.size(); i++ ) {Usuario o = (Usuario)lsolidaria.get(i);%>

				<tr>
                                     <td class="success"><%=i+1%></td>
                                     <td ><%= o.getUser() %></td>
                                     <td ><%= o.getNombre() %> <%= o.getApellido() %></td>
                                     <td ><%= o.getnTelefono() %></td>
                                     <td ><%= o.getCorreo() %></td>                                        
                                    </tr>

                                
                             <%} %></table><% }else { %>
                            <h5>NO HAY PERSONAS INSCRITAS</h5>
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
