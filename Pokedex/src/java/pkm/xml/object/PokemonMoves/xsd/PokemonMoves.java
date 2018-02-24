
package pkm.xml.object.PokemonMoves.xsd;

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
 *         &lt;element name="moveName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="learntByLevelUp" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="learntByTM" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="learntByTutor" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isEggMove" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "moveName",
    "learntByLevelUp",
    "learntByTM",
    "learntByTutor",
    "isEggMove"
})
@XmlRootElement(name = "PokemonMoves")
public class PokemonMoves {

    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger pokemonId;
    @XmlElement(required = true)
    protected String moveName;
    protected boolean learntByLevelUp;
    protected boolean learntByTM;
    protected boolean learntByTutor;
    protected boolean isEggMove;

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
     * Gets the value of the moveName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoveName() {
        return moveName;
    }

    /**
     * Sets the value of the moveName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoveName(String value) {
        this.moveName = value;
    }

    /**
     * Gets the value of the learntByLevelUp property.
     * 
     */
    public boolean isLearntByLevelUp() {
        return learntByLevelUp;
    }

    /**
     * Sets the value of the learntByLevelUp property.
     * 
     */
    public void setLearntByLevelUp(boolean value) {
        this.learntByLevelUp = value;
    }

    /**
     * Gets the value of the learntByTM property.
     * 
     */
    public boolean isLearntByTM() {
        return learntByTM;
    }

    /**
     * Sets the value of the learntByTM property.
     * 
     */
    public void setLearntByTM(boolean value) {
        this.learntByTM = value;
    }

    /**
     * Gets the value of the learntByTutor property.
     * 
     */
    public boolean isLearntByTutor() {
        return learntByTutor;
    }

    /**
     * Sets the value of the learntByTutor property.
     * 
     */
    public void setLearntByTutor(boolean value) {
        this.learntByTutor = value;
    }

    /**
     * Gets the value of the isEggMove property.
     * 
     */
    public boolean isIsEggMove() {
        return isEggMove;
    }

    /**
     * Sets the value of the isEggMove property.
     * 
     */
    public void setIsEggMove(boolean value) {
        this.isEggMove = value;
    }

}
