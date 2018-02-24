
package pkm.xml.object.PokemonGeneration.xsd;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PokemonGeneration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PokemonGeneration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pokemonId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="appearInGame" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="localIndexNo" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PokemonGeneration", propOrder = {
    "pokemonId",
    "appearInGame",
    "localIndexNo"
})
public class PokemonGeneration {

    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger pokemonId;
    @XmlElement(required = true)
    protected String appearInGame;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger localIndexNo;

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
     * Gets the value of the appearInGame property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppearInGame() {
        return appearInGame;
    }

    /**
     * Sets the value of the appearInGame property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppearInGame(String value) {
        this.appearInGame = value;
    }

    /**
     * Gets the value of the localIndexNo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLocalIndexNo() {
        return localIndexNo;
    }

    /**
     * Sets the value of the localIndexNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLocalIndexNo(BigInteger value) {
        this.localIndexNo = value;
    }

}
