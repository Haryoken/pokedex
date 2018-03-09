<%-- 
    Document   : pokemon
    Created on : 8 Mar, 2018, 11:59:52 PM
    Author     : DUCVINH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<!DOCTYPE html>
<html>
    <c:set var="pokemonXML" value="${requestScope.POKEMON_XML}"/>
    <c:set var="AbilitiesXML" value="${requestScope.POKEMONABILITIES_XML}"/>
    <c:set var="pokemonStatsXML" value="${requestScope.STATS_XML}"/>
    <c:set var="PkmMovesXML" value="${requestScope.POKEMONMOVES_XML}"/>
    <c:set var="moveXML" value="${requestScope.MOVE_XML}"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
