<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : pokemonPageTitle.xsl
    Created on : 9 March, 2018, 3:07 PM
    Author     : DUCVINH
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:pkm="https://www.pokedex.com/schemas/PokemonList.xsd">
    <xsl:output method="html"  encoding="UTF-8" indent="yes"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="pkm:pokemon">
                <title> 
                    <xsl:value-of select="pkm:nationalDexId"/>
                    -
                    <xsl:value-of select="pkm:englishName"/> 
                </title>        
    </xsl:template>

</xsl:stylesheet>
