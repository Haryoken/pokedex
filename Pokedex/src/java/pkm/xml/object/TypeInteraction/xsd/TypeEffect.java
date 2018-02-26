
package pkm.xml.object.TypeInteraction.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TypeEffect complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TypeEffect">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="superEffective" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="notVeryEffective" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="noEffect" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypeEffect", propOrder = {
    "superEffective",
    "notVeryEffective",
    "noEffect"
})
public class TypeEffect {

    protected String superEffective;
    protected String notVeryEffective;
    protected String noEffect;

    /**
     * Gets the value of the superEffective property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuperEffective() {
        return superEffective;
    }

    /**
     * Sets the value of the superEffective property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuperEffective(String value) {
        this.superEffective = value;
    }

    /**
     * Gets the value of the notVeryEffective property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotVeryEffective() {
        return notVeryEffective;
    }

    /**
     * Sets the value of the notVeryEffective property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotVeryEffective(String value) {
        this.notVeryEffective = value;
    }

    /**
     * Gets the value of the noEffect property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoEffect() {
        return noEffect;
    }

    /**
     * Sets the value of the noEffect property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoEffect(String value) {
        this.noEffect = value;
    }

}
