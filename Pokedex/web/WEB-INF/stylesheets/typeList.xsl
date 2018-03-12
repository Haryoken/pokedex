<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : typeList.xsl
    Created on : 12 March, 2018, 11:53 AM
    Author     : DUCVINH
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:type="https://www.pokedex.com/schemas/TypeList.xsd">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="type:TypeList">
        <xsl:for-each select="type:pokemonType">
            <div>
                <a class="{type:typeLabel}" href="MainControllerServlet?btnAction=TypeDetails&amp;type={type:typeLabel}">
                    <xsl:value-of select="type:typeLabel"/>
                </a>
                <br/><br/>
            </div>
        </xsl:for-each>
    </xsl:template>

</xsl:stylesheet>
