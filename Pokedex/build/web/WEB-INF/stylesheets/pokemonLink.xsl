<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : pokemonLink.xsl
    Created on : 10 March, 2018, 3:36 PM
    Author     : DUCVINH
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:pkm = "https://www.pokedex.com/schemas/PokemonList.xsd">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="pkm:pokemon">
        <div id="previous_pokemon">
            <xsl:variable name="nextId">
                <xsl:value-of select="pkm:nationalDexId - 1"/>
            </xsl:variable>
            <xsl:if test="pkm:nationalDexId - 1 != 0">
                <a style="text-decoration:none;color:black;" href="MainControllerServlet?btnAction=RedirectToPokemon&amp;pokemonId={$nextId}">                       
                    <xsl:if test="pkm:nationalDexId - 1 &lt; 10">
                        &lt;#00<xsl:value-of select="pkm:nationalDexId - 1"/>
                    </xsl:if>
                    <xsl:if test="pkm:nationalDexId - 1 &gt; 9">
                        <xsl:if test="pkm:nationalDexId - 1 &lt; 100">
                             &lt;#0<xsl:value-of select="pkm:nationalDexId - 1"/>
                        </xsl:if>                     
                    </xsl:if>
                    <xsl:if test="pkm:nationalDexId - 1 &gt; 99">
                        &lt;#<xsl:value-of select="pkm:nationalDexId - 1"/>
                    </xsl:if>
                </a>
            </xsl:if>
        </div>
        <div id="next_pokemon">
            <xsl:variable name="nextId">
                <xsl:value-of select="pkm:nationalDexId + 1"/>
            </xsl:variable>
            <a style="text-decoration:none;color:black" href="MainControllerServlet?btnAction=RedirectToPokemon&amp;pokemonId={$nextId}">
                <xsl:if test="pkm:nationalDexId + 1 &lt; 10">
                    #00<xsl:value-of select="pkm:nationalDexId + 1"/>&gt;
                </xsl:if>
                <xsl:if test="pkm:nationalDexId + 1 &gt; 9">
                    <xsl:if test="pkm:nationalDexId + 1 &lt; 100">
                        #0<xsl:value-of select="pkm:nationalDexId + 1"/>&gt;
                    </xsl:if>                     
                </xsl:if>
                <xsl:if test="pkm:nationalDexId + 1 &gt; 99">
                    #<xsl:value-of select="pkm:nationalDexId + 1"/>&gt;
                </xsl:if>
            </a>
            
        </div>
    </xsl:template>

</xsl:stylesheet>
