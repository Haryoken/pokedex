<%-- 
    Document   : typeDetails
    Created on : 12 Mar, 2018, 7:53:42 PM
    Author     : DUCVINH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/headerstyle.css"/>  
        <link rel="stylesheet" href="css/movetype.css"/> 
        <link rel="stylesheet" href="css/layout.css"/>
        <link rel="stylesheet" href="css/listtable.css"/>
        <c:set var="type" value="${requestScope.TYPE}"/>
        <c:if test="${not empty type}">
            <title>Type - ${type}</title>
        </c:if>

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
        </div>

        <div class="row">
            <div class="leftcolumn">
                <div class="card">
                    <h1>${type} type</h1>
                </div>
                <div class="card">
                    <c:set var="typeAttackXML" value="${requestScope.TYPEATTACK}"/>
                    <c:if test="${not empty typeAttackXML}">
                        <c:import var="typeAttackXSLT" url="WEB-INF/stylesheets/typeAttack.xsl"/>
                        <x:transform doc="${typeAttackXML}" xslt="${typeAttackXSLT}"/>                      
                    </c:if>
                </div>
                <div class="card">
                    <c:set var="typeDefenseXML" value="${requestScope.TYPEDEFENSE}"/>
                    <c:if test="${not empty typeDefenseXML}">
                        <c:import charEncoding="UTF-8" var="typeDefenseXSLT" url="WEB-INF/stylesheets/typeDefense.xsl"/>
                        <x:transform doc="${typeDefenseXML}" xslt="${typeDefenseXSLT}"/>                      
                    </c:if>
                </div>
                <div class="card">
                    <h2>${type} type Pokémon</h2>
                    <c:set var="typePokemonXML" value="${requestScope.TYPEPOKEMON}"/>
                    <c:if test="${not empty typePokemonXML}">
                        <c:import charEncoding="UTF-8" var="pokemonListXSLT" url="WEB-INF/stylesheets/pokemonList.xsl"/>
                        <x:transform doc="${typePokemonXML}" xslt="${pokemonListXSLT}"/>                      
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
                    <a href="MainControllerServlet?btnAction=TypeList">2. Pokémon Type Chart</a>
                </div>
            </div>
        </div>
    </body>
</html>
