<%-- 
    Document   : pokemon
    Created on : 8 Mar, 2018, 11:59:52 PM
    Author     : DUCVINH
--%>

<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>

<!DOCTYPE html>
<html>
    <c:set var="pokemonXML" value="${requestScope.POKEMON_XML}"/>
    <c:set var="abilitiesXML" value="${requestScope.POKEMONABILITIES_XML}"/>
    <c:set var="pokemonStatsXML" value="${requestScope.STATS_XML}"/>
    <c:set var="PkmMovesXML" value="${requestScope.POKEMONMOVES_XML}"/>
    <c:set var="moveXML" value="${requestScope.MOVE_XML}"/>

    <head>       
        <c:if test="${not empty pokemonXML}">
            <c:import var="titleXSLT" url="WEB-INF/stylesheets/pokemonPageTitle.xsl"/>
            <x:transform doc="${pokemonXML}" xslt="${titleXSLT}"/>
        </c:if>
        <link rel="stylesheet" href="css/headerstyle.css"/>  
        <link rel="stylesheet" href="css/contentstyle.css"/> 
        <link rel="stylesheet" href="css/movetype.css"/> 
        <link rel="stylesheet" href="css/layout.css"/>
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
            <a href="MainControllerServlet?btnAction=Home">Home</a>
            <a href="MainControllerServlet?btnAction=Pokedex&pokemonCount=genI">Pokémon</a>
            <a href="MainControllerServlet?btnAction=TypeList">Type</a>
            <form method="POST" action="MainControllerServlet" style="padding-top: 13px">
                <input type="text" name="txtSearch" value=""/>
                <input type="submit" name="btnAction" value="Search"/>
            </form>
        </div>

        <div class="row">
            <div class="leftcolumn">
                <div class="card">
                    <c:if test="${not empty pokemonXML}">
                        <c:import var="pokemonLinkXSLT" url="WEB-INF/stylesheets/pokemonLink.xsl"/>
                        <x:transform doc="${pokemonXML}" xslt="${pokemonLinkXSLT}"/>                      
                    </c:if>
                    <c:if test="${not empty pokemonXML}">
                        <c:import var="basicInfoXSLT" url="WEB-INF/stylesheets/pokemonBasicInfo.xsl"/>
                        <x:transform doc="${pokemonXML}" xslt="${basicInfoXSLT}"/>                      
                    </c:if>
                    <c:if test="${not empty abilitiesXML}">
                        <c:import var="pokemonAbilitiesXSLT" url="WEB-INF/stylesheets/pokemonAbilities.xsl"/>
                        <x:transform doc="${abilitiesXML}" xslt="${pokemonAbilitiesXSLT}"/>                      
                    </c:if>
                    <c:if test="${not empty pokemonStatsXML}">
                        <c:import var="pokemonStatsXSLT" url="WEB-INF/stylesheets/pokemonStats.xsl"/>
                        <x:transform doc="${pokemonStatsXML}" xslt="${pokemonStatsXSLT}"/>                      
                    </c:if>
                    <c:if test="${not empty moveXML}">
                        <c:import var="pokemonMovesXSLT" url="WEB-INF/stylesheets/pokemonMoves.xsl"/>
                        <x:transform doc="${moveXML}" xslt="${pokemonMovesXSLT}"/>                      
                    </c:if>
                </div>
            </div>
            <div class="rightcolumn">
                <div class="card">
                    <h2>Featured Pokémon</h2>
                    <a href="MainControllerServlet?btnAction=RedirectToPokemon&pokemonId=1">Bulbasaur</a>
                </div>
                <div class="card">
                    <h2>Features</h2>
                    <p>We provide you features to start learning about pokemon:</p>
                    <a href="MainControllerServlet?btnAction=Pokedex&pokemonCount=all">1. All pokemons List</a> 
                    <br/><br/>
                    <a href="MainControllerServlet?btnAction=TypeList">2. Pokémon Types</a>
                </div>

            </div>
            <div id="content_div" >

            </div>

    </body>
</html>
