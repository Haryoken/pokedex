
package pkm.xml.object.PokemonList.xsd;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Pokemon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Pokemon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nationalDexId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="englishName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="japaneseName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="romajiName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firstType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="secondType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="catchRate" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="baseExp" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="baseHappiness" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="growthRate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isLegendary" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="pictureURI" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *         &lt;element name="iconURI" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Pokemon", propOrder = {
    "nationalDexId",
    "englishName",
    "japaneseName",
    "romajiName",
    "firstType",
    "secondType",
    "height",
    "weight",
    "catchRate",
    "baseExp",
    "baseHappiness",
    "growthRate",
    "isLegendary",
    "pictureURI",
    "iconURI"
})
public class Pokemon {

    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger nationalDexId;
    @XmlElement(required = true, nillable = true)
    protected String englishName;
    @XmlElement(required = true, nillable = true)
    protected String japaneseName;
    @XmlElement(required = true, nillable = true)
    protected String romajiName;
    @XmlElement(required = true, nillable = true)
    protected String firstType;
    @XmlElement(required = true, nillable = true)
    protected String secondType;
    @XmlElement(required = true, nillable = true)
    protected String height;
    @XmlElement(required = true, nillable = true)
    protected String weight;
    @XmlElement(required = true, nillable = true)
    protected BigDecimal catchRate;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger baseExp;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger baseHappiness;
    @XmlElement(required = true, nillable = true)
    protected String growthRate;
    @XmlElement(defaultValue = "false")
    protected boolean isLegendary;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "anyURI")
    protected String pictureURI;
    @XmlElement(required = true, nillable = true)
    @XmlSchemaType(name = "anyURI")
    protected String iconURI;

    /**
     * Gets the value of the nationalDexId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNationalDexId() {
        return nationalDexId;
    }

    /**
     * Sets the value of the nationalDexId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNationalDexId(BigInteger value) {
        this.nationalDexId = value;
    }

    /**
     * Gets the value of the englishName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * Sets the value of the englishName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishName(String value) {
        this.englishName = value;
    }

    /**
     * Gets the value of the japaneseName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJapaneseName() {
        return japaneseName;
    }

    /**
     * Sets the value of the japaneseName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJapaneseName(String value) {
        this.japaneseName = value;
    }

    /**
     * Gets the value of the romajiName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRomajiName() {
        return romajiName;
    }

    /**
     * Sets the value of the romajiName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRomajiName(String value) {
        this.romajiName = value;
    }

    /**
     * Gets the value of the firstType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstType() {
        return firstType;
    }

    /**
     * Sets the value of the firstType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstType(String value) {
        this.firstType = value;
    }

    /**
     * Gets the value of the secondType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondType() {
        return secondType;
    }

    /**
     * Sets the value of the secondType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondType(String value) {
        this.secondType = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHeight(String value) {
        this.height = value;
    }

    /**
     * Gets the value of the weight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWeight(String value) {
        this.weight = value;
    }

    /**
     * Gets the value of the catchRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCatchRate() {
        return catchRate;
    }

    /**
     * Sets the value of the catchRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCatchRate(BigDecimal value) {
        this.catchRate = value;
    }

    /**
     * Gets the value of the baseExp property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBaseExp() {
        return baseExp;
    }

    /**
     * Sets the value of the baseExp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBaseExp(BigInteger value) {
        this.baseExp = value;
    }

    /**
     * Gets the value of the baseHappiness property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBaseHappiness() {
        return baseHappiness;
    }

    /**
     * Sets the value of the baseHappiness property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBaseHappiness(BigInteger value) {
        this.baseHappiness = value;
    }

    /**
     * Gets the value of the growthRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrowthRate() {
        return growthRate;
    }

    /**
     * Sets the value of the growthRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrowthRate(String value) {
        this.growthRate = value;
    }

    /**
     * Gets the value of the isLegendary property.
     * 
     */
    public boolean isIsLegendary() {
        return isLegendary;
    }

    /**
     * Sets the value of the isLegendary property.
     * 
     */
    public void setIsLegendary(boolean value) {
        this.isLegendary = value;
    }

    /**
     * Gets the value of the pictureURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPictureURI() {
        return pictureURI;
    }

    /**
     * Sets the value of the pictureURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPictureURI(String value) {
        this.pictureURI = value;
    }

    /**
     * Gets the value of the iconURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIconURI() {
        return iconURI;
    }

    /**
     * Sets the value of the iconURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIconURI(String value) {
        this.iconURI = value;
    }

}
