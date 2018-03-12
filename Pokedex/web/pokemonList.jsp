<%-- 
    Document   : pokemonList
    Created on : 11 Mar, 2018, 4:22:28 PM
    Author     : DUCVINH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pokédex</title>
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
            <a href="MainControllerServlet?btnAction=Home">Home</a>
            <a href="MainControllerServlet?btnAction=Pokedex&pokemonCount=genI">Pokémon</a>
            <a href="MainControllerServlet?btnAction=TypeList">Type</a>
        </div>

        <div class="row">
            <div class="leftcolumn">
                <div class="card">
                    <c:set var="displayMode" value="${requestScope.DISPLAYMODE}"/>
                    <c:if test="${not empty displayMode}">
                        <c:if test="${displayMode == 'all'}">
                            <c:set var="pokemonListXML" value="${sessionScope.POKEMONLISTFULL}"/>
                        </c:if>
                        <c:if test="${displayMode == 'genI'}">
                            <c:set var="pokemonListXML" value="${sessionScope.POKEMONLISTGENI}"/>
                        </c:if>
                    </c:if>
                    <h2>Pokémon List</h2>
                    
                    <form method="POST" action="MainControllerServlet">
                        <input type="text" name="txtSearch" value=""/>
                        <input type="submit" name="btnAction" value="Search"/>
                    </form>
                    <br/>
                    <c:if test="${not empty pokemonListXML}">
                        <c:import var="pokemonListXSLT" url="WEB-INF/stylesheets/pokemonList.xsl"/>
                        <x:transform doc="${pokemonListXML}" xslt="${pokemonListXSLT}"/>                      
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
