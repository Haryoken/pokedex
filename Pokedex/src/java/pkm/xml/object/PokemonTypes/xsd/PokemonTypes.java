
package pkm.xml.object.PokemonTypes.xsd;

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
 *         &lt;element name="pokemonId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="pokemonTypeLabel" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "pokemonId",
    "pokemonTypeLabel"
})
@XmlRootElement(name = "PokemonTypes")
public class PokemonTypes {

    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger pokemonId;
    @XmlElement(required = true)
    protected String pokemonTypeLabel;

    /**
     * Gets the value of the pokemonId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPokemonId() {
        return pokemonId;
    }

    /**
     * Sets the value of the pokemonId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPokemonId(BigInteger value) {
        this.pokemonId = value;
    }

    /**
     * Gets the value of the pokemonTypeLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPokemonTypeLabel() {
        return pokemonTypeLabel;
    }

    /**
     * Sets the value of the pokemonTypeLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPokemonTypeLabel(String value) {
        this.pokemonTypeLabel = value;
    }

}
