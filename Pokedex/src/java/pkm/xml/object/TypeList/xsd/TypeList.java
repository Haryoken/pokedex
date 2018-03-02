
package pkm.xml.object.TypeList.xsd;

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
 *         &lt;element name="pokemonType" type="{https://www.pokedex.com/schemas/TypeList.xsd}Type"/>
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
    "pokemonType"
})
@XmlRootElement(name = "TypeList")
public class TypeList {

    @XmlElement(required = true)
    protected Type pokemonType;

    /**
     * Gets the value of the pokemonType property.
     * 
     * @return
     *     possible object is
     *     {@link Type }
     *     
     */
    public Type getPokemonType() {
        return pokemonType;
    }

    /**
     * Sets the value of the pokemonType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Type }
     *     
     */
    public void setPokemonType(Type value) {
        this.pokemonType = value;
    }

}
