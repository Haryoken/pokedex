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
            <a href="MainControllerServlet?btnAction=Home">Home</a>
            <a href="MainControllerServlet?btnAction=Pokedex&pokemonCount=genI">Pokémon</a>
            <a href="MainControllerServlet?btnAction=TypeList">Type</a>
        </div>

        <div class="row">
            <div class="leftcolumn">
                <div class="card">
                    <h2>Type</h2>
                    <p>
                        All Pokémon creatures and their moves are assigned certain types. Each type has several strengths and weaknesses in both attack and defense. In battle, you should use Pokémon and moves that have a type advantage over your opponent; doing so will cause much more damage than normal.
                    </p>
                    <p>
                        A single-type advantage (for instance a Water attack against a Ground-type Pokémon) will net you double normal damage. The advantages also stack up, so a double-type advantage (for instance a Water attack against a Ground/Rock-type Pokémon) will net you quadruple damage. In both these cases you will see the message It's super effective! in-game after the attack.
                    </p>
                    <p>
                        Conversely, a single- and double-type disadvantage will afflict half and a quarter normal damage respectively. Here you will see the message It's not very effective... in-game.
                    </p>
                    <p>
                        Another advantage you can gain is Same Type Attack Bonus (STAB). As the name implies, this increases the power of the move if the attacking Pokémon has the same type as the move used (for example a Fire-type Pokémon using a Fire-type move). In this case the damage is 1.5 times normal. Again this is added to any other advantages, so a Water-type Pokémon using a Water-type move against a Ground/Rock-type Pokémon will bag you six times (2×2×1.5) normal damage!
                    </p>
                </div>
                <div class="card">

                    <h2>Type Chart</h2>
                    <c:set var="typeInteractionXML" value="${sessionScope.TYPEINTERACTION}"/>
                    <c:if test="${not empty typeInteractionXML}">
                        <c:import var="typeChartXSLT" url="WEB-INF/stylesheets/typeChart.xsl"/>
                        <x:transform doc="${typeInteractionXML}" xslt="${typeChartXSLT}"/>
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
                    <a href="MainControllerServlet?btnAction=TypeList">2. Pokémon Types Chart</a>
                </div>
            </div>
        </div>
    </body>   
</body>
</html>

