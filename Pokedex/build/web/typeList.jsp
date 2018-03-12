<%-- 
    Document   : typeList
    Created on : 12 Mar, 2018, 10:35:49 AM
    Author     : DUCVINH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pokémon Type</title>
        <link rel="stylesheet" href="css/headerstyle.css"/>   
        <link rel="stylesheet" href="css/movetype.css"/> 
        <link rel="stylesheet" href="css/layout.css"/>
        <link rel="stylesheet" href="css/listtable.css"/>
    </head>
   <body>     
        <div class="header">
            <div id="title_div">
                <span id="title_span">
                    <span style="color: white" >NATIONAL</span>
                    <span style="color: tomato; font-style: italic;font-family:Constantia">POKéDEX</span>
                </span>

            </div>
        </div>

        <div class="topnav">
            <a href="#">Home</a>
            <a href="MainControllerServlet?btnAction=Pokedex&pokemonCount=genI">Pokémon</a>
            <a href="MainControllerServlet?btnAction=TypeList">Type</a>
            <a href="#">Move</a>
        </div>

        <div class="row">
            <div class="leftcolumn">
                <div class="card">
                    <h2>Pokémon Type List</h2>
                    <c:set var="typeListXML" value="${sessionScope.TYPELIST}"/>
                    <c:if test="${not empty typeListXML}">
                        <c:import var="typeListXSLT" url="WEB-INF/stylesheets/typeList.xsl"/>
                        <x:transform doc="${typeListXML}" xslt="${typeListXSLT}"/>
                    </c:if>
                </div>
                <div class="card">
                    <h2>Features</h2>
                    <p>We provide you features to start learning about pokemon:</p>
                    <a href="MainControllerServlet?btnAction=Pokedex&pokemonCount=all">1. All pokemons List</a> 
                    <br/><br/>
                    <a href="MainControllerServlet?btnAction=TypeList">2. Pokémon Types</a>
                </div>
            </div>
            <div class="rightcolumn">
                <div class="card">
                    <h2>Featured Pokémon</h2>
                    <a href="MainControllerServlet?btnAction=RedirectToPokemon&pokemonId=1">Bulbasaur</a>
                </div>
               
            </div>
        </div>
    </body>   
</body>
</html>
