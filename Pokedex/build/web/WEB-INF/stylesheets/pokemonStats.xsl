<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : pokemonStats.xsl
    Created on : 10 March, 2018, 12:00 PM
    Author     : DUCVINH
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:stats="https://www.pokedex.com/schemas/PokemonStats.xsd">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="stats:pokemonStats">
        
        <div id="stats_div">
            <table border="0">
                <tr>
                    <td colspan="3" style="text-align:center">
                        <span style="font-family:Agency FB;font-size:30px;font-weight:700;">Stats</span>                       
                    </td>
                </tr>
                <tr>
                    <td class="title_td">Base HP</td>
                    <td class="stats_data_td"><xsl:value-of select="stats:baseHP"/></td>
                    <td style="width:255px">
                        <div class="progress_bar">
                            <div class="stats_bar" style="width:{stats:baseHP}px"></div>                                
                        </div>
                    </td>
                </tr>
                 <tr>
                    <td class="title_td">Attack</td>
                    <td class="stats_data_td"><xsl:value-of select="stats:attack"/></td>
                    <td>
                        <div class="progress_bar">
                            <div class="stats_bar" style="width:{stats:attack}px"></div>                                
                        </div>
                    </td>
                </tr>
                 <tr>
                    <td class="title_td">Defense</td>
                    <td class="stats_data_td"><xsl:value-of select="stats:defense"/></td>
                    <td>
                        <div class="progress_bar">
                            <div class="stats_bar" style="width:{stats:defense}px"></div>                               
                        </div>
                    </td>
                </tr>
                 <tr>
                    <td class="title_td">Special Attack</td>
                    <td class="stats_data_td"><xsl:value-of select="stats:spAttack"/></td>
                    <td>
                        <div class="progress_bar">
                            <div class="stats_bar" style="width:{stats:spAttack}px"></div>                           
                        </div>
                    </td>
                </tr>
                 <tr>
                    <td class="title_td">Special Defense</td>
                    <td class="stats_data_td"><xsl:value-of select="stats:spDefense"/></td>
                    <td>
                        <div class="progress_bar">
                            <div class="stats_bar" style="width:{stats:spDefense}px"></div>                               
                        </div>
                    </td>
                </tr>
                 <tr>
                    <td class="title_td">Speed</td>
                    <td class="stats_data_td"><xsl:value-of select="stats:speed"/></td>
                    <td>
                        <div class="progress_bar">
                           <div class="stats_bar" style="width:{stats:speed}px"></div>                               
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </xsl:template>

</xsl:stylesheet>
