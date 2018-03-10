<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : PokemonAbilities.xsl
    Created on : 10 March, 2018, 12:01 PM
    Author     : DUCVINH
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:ability="https://www.pokedex.com/schemas/PokemonAbilities.xsd">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="ability:PokemonAbilitiesList">
        <div id="ability_div">
            <span style="font-family:Agency FB;font-size:30px;font-weight:700;">
                Abilities
            </span>
            <br/>
            <xsl:for-each select="ability:pokemonAbilities">
                <a style="font-family:calibri;font-size:20px;font-color:white"><xsl:value-of select="ability:abilityName"/></a><br/>
            </xsl:for-each>
            
        </div>
    </xsl:template>

</xsl:stylesheet>
