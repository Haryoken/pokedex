<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : pokemonList.xsl
    Created on : 11 March, 2018, 4:45 PM
    Author     : DUCVINH
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:pkm="https://www.pokedex.com/schemas/PokemonList.xsd">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="pkm:PokemonList">
        <div>
            <table border="0">
                <th></th>
                <th>Dex Id</th>
                <th>Name</th>
                <th>Types</th>
                <xsl:for-each select="pkm:pokemon">
                    <tr>
                        <td>
                            <img src="{pkm:iconURI}"/>
                        </td>
                        <td>
                            <xsl:if test="pkm:nationalDexId &lt; 10">
                                #00<xsl:value-of select="pkm:nationalDexId"/>
                            </xsl:if>
                            <xsl:if test="pkm:nationalDexId &gt; 9">
                                <xsl:if test="pkm:nationalDexId &lt; 100">
                                    #0<xsl:value-of select="pkm:nationalDexId"/>
                                </xsl:if>                     
                            </xsl:if>
                            <xsl:if test="pkm:nationalDexId &gt; 99">
                                #<xsl:value-of select="pkm:nationalDexId"/>
                            </xsl:if>
                        </td>
                        <td>
                            <a href="MainControllerServlet?btnAction=RedirectToPokemon&amp;pokemonId={pkm:nationalDexId}">
                                <xsl:value-of select="pkm:englishName"/>
                            </a>
                        </td>    
                        <td>
                            <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={pkm:firstType}" class="{pkm:firstType}">
                            <xsl:value-of select="pkm:firstType"/>
                        </a>
                        
                        <xsl:if test="pkm:secondType != ''">
                            
                            <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={pkm:secondType}" class="{pkm:secondType}">
                                <xsl:value-of select="pkm:secondType"/>
                            </a>
                        </xsl:if>     
                        </td>                   
                    </tr>
                </xsl:for-each>             
            </table>
        </div>
    </xsl:template>

</xsl:stylesheet>
