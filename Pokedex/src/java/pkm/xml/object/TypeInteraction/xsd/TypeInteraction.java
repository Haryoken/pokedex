
package pkm.xml.object.TypeInteraction.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="baseType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="affectedType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="effect" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="effectMultipler" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "baseType",
    "affectedType",
    "effect",
    "effectMultipler"
})
@XmlRootElement(name = "TypeInteraction")
public class TypeInteraction {

    @XmlElement(required = true)
    protected String baseType;
    @XmlElement(required = true)
    protected String affectedType;
    @XmlElement(required = true)
    protected String effect;
    @XmlElement(required = true)
    protected String effectMultipler;

    /**
     * Gets the value of the baseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseType() {
        return baseType;
    }

    /**
     * Sets the value of the baseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseType(String value) {
        this.baseType = value;
    }

    /**
     * Gets the value of the affectedType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAffectedType() {
        return affectedType;
    }

    /**
     * Sets the value of the affectedType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAffectedType(String value) {
        this.affectedType = value;
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
     * Gets the value of the effectMultipler property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectMultipler() {
        return effectMultipler;
    }

    /**
     * Sets the value of the effectMultipler property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectMultipler(String value) {
        this.effectMultipler = value;
    }

}
