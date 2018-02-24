
package pkm.xml.object.Move.xsd;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="category" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="power" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accuracy" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="pp" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="tm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="effect" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="probability" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="isZMove" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="generationAppearance" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "type",
    "category",
    "power",
    "accuracy",
    "pp",
    "tm",
    "effect",
    "probability",
    "isZMove",
    "generationAppearance"
})
@XmlRootElement(name = "Move")
public class Move {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String category;
    @XmlElement(required = true)
    protected String power;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger accuracy;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger pp;
    @XmlElement(required = true)
    protected String tm;
    @XmlElement(required = true)
    protected String effect;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger probability;
    @XmlElement(defaultValue = "false")
    protected boolean isZMove;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger generationAppearance;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the power property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPower() {
        return power;
    }

    /**
     * Sets the value of the power property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPower(String value) {
        this.power = value;
    }

    /**
     * Gets the value of the accuracy property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAccuracy() {
        return accuracy;
    }

    /**
     * Sets the value of the accuracy property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAccuracy(BigInteger value) {
        this.accuracy = value;
    }

    /**
     * Gets the value of the pp property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPp() {
        return pp;
    }

    /**
     * Sets the value of the pp property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPp(BigInteger value) {
        this.pp = value;
    }

    /**
     * Gets the value of the tm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTm() {
        return tm;
    }

    /**
     * Sets the value of the tm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTm(String value) {
        this.tm = value;
    }

    /**
     * Gets the value of the effect property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffect() {
        return effect;
    }

    /**
     * Sets the value of the effect property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffect(String value) {
        this.effect = value;
    }

    /**
     * Gets the value of the probability property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getProbability() {
        return probability;
    }

    /**
     * Sets the value of the probability property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setProbability(BigInteger value) {
        this.probability = value;
    }

    /**
     * Gets the value of the isZMove property.
     * 
     */
    public boolean isIsZMove() {
        return isZMove;
    }

    /**
     * Sets the value of the isZMove property.
     * 
     */
    public void setIsZMove(boolean value) {
        this.isZMove = value;
    }

    /**
     * Gets the value of the generationAppearance property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGenerationAppearance() {
        return generationAppearance;
    }

    /**
     * Sets the value of the generationAppearance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGenerationAppearance(BigInteger value) {
        this.generationAppearance = value;
    }

}
