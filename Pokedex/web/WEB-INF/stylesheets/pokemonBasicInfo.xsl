<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : pokemonBasicInfo.xsl
    Created on : 9 March, 2018, 9:48 PM
    Author     : DUCVINH
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:pkm = "https://www.pokedex.com/schemas/PokemonList.xsd"
                xmlns:abi = "https://www.pokedex.com/schemas/PokemonAbilities.xsd"
                xmlns:exsl = "http://exslt.org/common">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="pkm:pokemon">
        <div id="pokemon_img_div" class="floating-box">
            <img id="pokemon_img" src="{pkm:pictureURI}"/>
        </div>
        
        <div id="info_table_div" class="floating-box">
            <table border="0">
                <tr>
                    <td style="text-align:center" colspan="2">
                        <span style="font-family:Agency FB;font-size:50px;font-weight:600">
                            <xsl:value-of select="pkm:englishName"/>
                        </span>                      
                    </td>                   
                </tr>
                <tr>
                    <td class="title_td">
                        National Id
                    </td>
                    <td class="info_data_td">
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
                </tr>
                <tr>
                    <td class="title_td">
                        Type
                    </td>
                    <td class="info_data_td">
                        <xsl:value-of select="pkm:types"/>                    
                    </td>
                </tr>
                <tr>
                    <td class="title_td">
                        Japanese Name
                    </td>
                    <td class="info_data_td">
                        <xsl:value-of select="pkm:japaneseName"/>
                        (<xsl:value-of select="pkm:romajiName"/>)
                    </td>
                </tr>
                <tr>
                    <td class="title_td">
                        Base Exp
                    </td>
                    <td class="info_data_td">
                        <xsl:value-of select="pkm:baseExp"/>                   
                    </td>
                </tr>
                <tr>
                    <td class="title_td">
                        Base Happiness
                    </td>
                    <td class="info_data_td">
                        <xsl:if test="pkm:baseHappiness !=''">
                            <xsl:value-of select="pkm:baseHappiness"/>
                        </xsl:if>
                        <xsl:if test="pkm:baseHappiness =''">
                            None
                        </xsl:if>                
                    </td>
                </tr>
                <tr>
                    <td class="title_td">
                        Growth Rate
                    </td>
                    <td class="info_data_td">
                        <xsl:if test="pkm:growthRate !=''">
                            <xsl:value-of select="pkm:growthRate"/>
                        </xsl:if>
                        <xsl:if test="pkm:growthRate =''">
                            None
                        </xsl:if> 
                                           
                    </td>
                </tr>
                <tr>
                    <td class="title_td">
                        Catch Rate
                    </td>
                    <td class="info_data_td">
                        <xsl:value-of select="pkm:catchRate"/>                   
                    </td>
                </tr>           
            </table>
        </div>
    </xsl:template>

</xsl:stylesheet>
