<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="idUser" class="java.lang.String" scope="session" />
<ul class="menu">
    <li><a href="/FutbolFive/bienvenido.jsp">Inicio</a></li>
    <li><a href="/FutbolFive/buscarCancha.jsp">Organizar Partido</a></li>
    <li><a href="/FutbolFive/verPartidos.jsp">Buscar Partido</a></li>
    <li><a href="PartidosOrganizados?idUser=<%=idUser%>">Actividad Usuario </a></li>    
</ul>