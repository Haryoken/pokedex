<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : typeChart.xsl
    Created on : 12 March, 2018, 3:13 PM
    Author     : DUCVINH
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:inter="https://www.pokedex.com/schemas/TypeInteraction.xsd">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="inter:TypeInteractionList">
        <table border="1" class="type_chart">
            
            <th style="font-size:15px;width:60px">Defense  <br/> Attack </th>
            <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Normal')]">
                <th style="padding-left:17px">
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:defenseType}" class="half{inter:defenseType}"> 
                        <xsl:value-of select="substring(inter:defenseType,0,4)"/> 
                    </a>
                </th>
            </xsl:for-each>
            
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Normal')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Normal')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Normal')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Normal')]">
                    <td>
                        <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>                     
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Fire')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Fire')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Fire')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Fire')]">
                    <td>
                        <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Water')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Water')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Water')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Water')]">
                    <td>
                        <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Electric')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Electric')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Electric')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Electric')]">
                    <td>
                       <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Grass')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Grass')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Grass')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Grass')]">
                    <td>
                        <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Ice')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Ice')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Ice')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Ice')]">
                    <td>
                        <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Fighting')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Fighting')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Fighting')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Fighting')]">
                    <td>
                        <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Poison')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Poison')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Poison')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Poison')]">
                    <td>
                        <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Ground')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Ground')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Ground')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Ground')]">
                    <td>
                        <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Flying')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Flying')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Flying')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Flying')]">
                    <td>
                       <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Psychic')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Psychic')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Psychic')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Psychic')]">
                    <td>
                      <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Bug')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Bug')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Bug')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Bug')]">
                    <td>
                        <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Rock')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Rock')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Rock')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Rock')]">
                    <td>
                       <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Ghost')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Ghost')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Ghost')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Ghost')]">
                    <td>
                        <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Dragon')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Dragon')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Dragon')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Dragon')]">
                    <td>
                        <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Dark')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Dark')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Dark')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Dark')]">
                    <td>
                        <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Steel')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Steel')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Steel')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Steel')]">
                    <td>
                       <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            <tr>
                <th>
                    <a href="MainControllerServlet?btnAction=TypeDetails&amp;type={inter:typeInteraction/inter:attackType[contains(.,'Fairy')]}" class="{inter:typeInteraction/inter:attackType[contains(.,'Fairy')]}"> 
                        <xsl:value-of select="inter:typeInteraction/inter:attackType[contains(.,'Fairy')]"/> 
                    </a>
                </th>
                <xsl:for-each select="inter:typeInteraction[contains(inter:attackType,'Fairy')]">
                    <td>
                        <span class="{inter:effect}">
                            <xsl:value-of select="inter:effectMultipler"/> 
                        </span>
                    </td>
                </xsl:for-each>
            </tr>
            
        </table>
    </xsl:template>

</xsl:stylesheet>
