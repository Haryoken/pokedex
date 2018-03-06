
package pkm.xml.object.Evolution.xsd;

import java.math.BigInteger;
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
 *         &lt;element name="pokemonId" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="evolutionId" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="condition" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "evolutionId",
    "condition"
})
@XmlRootElement(name = "Evolution")
public class Evolution {

    @XmlElement(required = true)
    protected BigInteger pokemonId;
    @XmlElement(required = true)
    protected BigInteger evolutionId;
    @XmlElement(required = true)
    protected String condition;

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
     * Gets the value of the evolutionId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEvolutionId() {
        return evolutionId;
    }

    /**
     * Sets the value of the evolutionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEvolutionId(BigInteger value) {
        this.evolutionId = value;
    }

    /**
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCondition(String value) {
        this.condition = value;
    }

}
