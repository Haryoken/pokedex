
package pkm.xml.object.PokemonTypes.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PokemonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PokemonType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="typeLabel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="typeIconURI" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PokemonType", propOrder = {
    "typeLabel",
    "typeIconURI"
})
public class PokemonType {

    @XmlElement(required = true)
    protected String typeLabel;
    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String typeIconURI;

    /**
     * Gets the value of the typeLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeLabel() {
        return typeLabel;
    }

    /**
     * Sets the value of the typeLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeLabel(String value) {
        this.typeLabel = value;
    }

    /**
     * Gets the value of the typeIconURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeIconURI() {
        return typeIconURI;
    }

    /**
     * Sets the value of the typeIconURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeIconURI(String value) {
        this.typeIconURI = value;
    }

}
