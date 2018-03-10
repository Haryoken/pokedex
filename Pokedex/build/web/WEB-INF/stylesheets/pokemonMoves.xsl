<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : pokemonMoves.xsl
    Created on : 10 March, 2018, 2:15 PM
    Author     : DUCVINH
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:mv="https://www.pokedex.com/schemas/Move.xsd">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="mv:MoveList">
        <div id="move_div">
            <span style="font-family:Agency FB;font-size:30px;font-weight:700">Moves</span>
            <table border="1" class="table_move">
                <th class="table_move_th">Move Name</th>
                <th class="table_move_th">Type</th>
                <th class="table_move_th">Category</th>
                <th class="table_move_th">Power</th>
                <th class="table_move_th">Accuracy</th>
                <th class="table_move_th">PP</th>
                <xsl:for-each select="mv:move">
                    <tr class="table_move_tr">
                        <td class="table_move_td"><xsl:value-of select="mv:name"/></td>
                        <td class="table_move_td">
                            <a class="{mv:type}"><xsl:value-of select="mv:type"/></a>
                        </td>
                        <td class="table_move_td">
                            <a class="{mv:category}"><xsl:value-of select="mv:category"/></a>
                        </td>
                        <td class="table_move_td"><xsl:value-of select="mv:power"/></td>
                        <td class="table_move_td"><xsl:value-of select="mv:accuracy"/></td>
                        <td class="table_move_td"><xsl:value-of select="mv:pp"/></td>
                    </tr>
                </xsl:for-each>             
            </table>
        </div>
    </xsl:template>

</xsl:stylesheet>
