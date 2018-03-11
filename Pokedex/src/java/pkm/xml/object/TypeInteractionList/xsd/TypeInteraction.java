
package pkm.xml.object.TypeInteractionList.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypeInteraction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypeInteraction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="attackType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="defenseType" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "TypeInteraction", propOrder = {
    "attackType",
    "defenseType",
    "effect",
    "effectMultipler"
})
public class TypeInteraction {

    @XmlElement(required = true)
    protected String attackType;
    @XmlElement(required = true)
    protected String defenseType;
    @XmlElement(required = true)
    protected String effect;
    @XmlElement(required = true)
    protected String effectMultipler;

    /**
     * Gets the value of the attackType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttackType() {
        return attackType;
    }

    /**
     * Sets the value of the attackType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttackType(String value) {
        this.attackType = value;
    }

    /**
     * Gets the value of the defenseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefenseType() {
        return defenseType;
    }

    /**
     * Sets the value of the defenseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefenseType(String value) {
        this.defenseType = value;
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
