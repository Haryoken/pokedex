<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : typeTitle.xsl
    Created on : 12 March, 2018, 7:44 PM
    Author     : DUCVINH
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:defInt="https://www.pokedex.com/schemas/TypeInteraction.xsd">
    <xsl:output method="html"/>


    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="defInt:TypeInteractionList">
        <div> 
            <h2>Attack pros &amp; cons</h2>
            <p style="font-size:25px">
                These move types are <i><b>not very effective</b></i> against 
                <i><b> <xsl:value-of select="defInt:typeInteraction/defInt:defenseType"/></b></i>
                pokémon:               
            </p>
            <p>
                <xsl:for-each select="defInt:typeInteraction[contains(defInt:effectMultipler, '0.5')]">
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={defInt:attackType}" class="{defInt:attackType}">
                        <xsl:value-of select="defInt:attackType"/>
                    </a>
                    <br/>
                </xsl:for-each>
            </p>
            <p style="font-size:25px">
                These move types are <i><b>super-effective</b></i> against  
                <i><b> <xsl:value-of select="defInt:typeInteraction/defInt:defenseType"/></b></i>
                Pokémon:               
            </p>
            <p>
                <xsl:for-each select="defInt:typeInteraction[contains(defInt:effectMultipler, '2.0')]">
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={defInt:attackType}" class="{defInt:attackType}">
                        <xsl:value-of select="defInt:attackType"/>
                    </a>
                    <br/>
                </xsl:for-each>
            </p>
            <p style="font-size:25px">
                These move types are <i><b>no effect</b></i> against  
                <i><b> <xsl:value-of select="defInt:typeInteraction/defInt:defenseType"/></b></i>
                Pokémon:
            </p>
            <p>
                <xsl:for-each select="defInt:typeInteraction[contains(defInt:effectMultipler, '0.0')]">
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={defInt:attackType}" class="{defInt:attackType}">
                        <xsl:value-of select="defInt:attackType"/>
                    </a>
                    <br/>
                </xsl:for-each>
            </p>
        </div>      
    </xsl:template>

</xsl:stylesheet>
