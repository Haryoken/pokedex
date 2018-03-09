
package pkm.xml.object.PokemonStatsList.xsd;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PokemonStats complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PokemonStats">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pokemonId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="baseHP" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="attack" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="defense" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="spAttack" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="spDefense" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="Speed" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="minAttack" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="minDefense" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="minSpAttack" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="minSpDefense" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="minSpeed" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="maxAttack" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="maxDefense" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="maxSpAttack" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="maxSpDefense" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="maxSpeed" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PokemonStats", propOrder = {
    "pokemonId",
    "baseHP",
    "attack",
    "defense",
    "spAttack",
    "spDefense",
    "speed",
    "minAttack",
    "minDefense",
    "minSpAttack",
    "minSpDefense",
    "minSpeed",
    "maxAttack",
    "maxDefense",
    "maxSpAttack",
    "maxSpDefense",
    "maxSpeed"
})
public class PokemonStats {

    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger pokemonId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger baseHP;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger attack;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger defense;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger spAttack;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger spDefense;
    @XmlElement(name = "Speed", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger speed;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger minAttack;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger minDefense;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger minSpAttack;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger minSpDefense;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger minSpeed;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger maxAttack;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger maxDefense;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger maxSpAttack;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger maxSpDefense;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger maxSpeed;

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
     * Gets the value of the baseHP property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBaseHP() {
        return baseHP;
    }

    /**
     * Sets the value of the baseHP property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBaseHP(BigInteger value) {
        this.baseHP = value;
    }

    /**
     * Gets the value of the attack property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAttack() {
        return attack;
    }

    /**
     * Sets the value of the attack property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAttack(BigInteger value) {
        this.attack = value;
    }

    /**
     * Gets the value of the defense property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDefense() {
        return defense;
    }

    /**
     * Sets the value of the defense property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDefense(BigInteger value) {
        this.defense = value;
    }

    /**
     * Gets the value of the spAttack property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSpAttack() {
        return spAttack;
    }

    /**
     * Sets the value of the spAttack property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSpAttack(BigInteger value) {
        this.spAttack = value;
    }

    /**
     * Gets the value of the spDefense property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSpDefense() {
        return spDefense;
    }

    /**
     * Sets the value of the spDefense property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSpDefense(BigInteger value) {
        this.spDefense = value;
    }

    /**
     * Gets the value of the speed property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the speed property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSpeed(BigInteger value) {
        this.speed = value;
    }

    /**
     * Gets the value of the minAttack property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinAttack() {
        return minAttack;
    }

    /**
     * Sets the value of the minAttack property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinAttack(BigInteger value) {
        this.minAttack = value;
    }

    /**
     * Gets the value of the minDefense property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinDefense() {
        return minDefense;
    }

    /**
     * Sets the value of the minDefense property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinDefense(BigInteger value) {
        this.minDefense = value;
    }

    /**
     * Gets the value of the minSpAttack property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinSpAttack() {
        return minSpAttack;
    }

    /**
     * Sets the value of the minSpAttack property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinSpAttack(BigInteger value) {
        this.minSpAttack = value;
    }

    /**
     * Gets the value of the minSpDefense property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinSpDefense() {
        return minSpDefense;
    }

    /**
     * Sets the value of the minSpDefense property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinSpDefense(BigInteger value) {
        this.minSpDefense = value;
    }

    /**
     * Gets the value of the minSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMinSpeed() {
        return minSpeed;
    }

    /**
     * Sets the value of the minSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMinSpeed(BigInteger value) {
        this.minSpeed = value;
    }

    /**
     * Gets the value of the maxAttack property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxAttack() {
        return maxAttack;
    }

    /**
     * Sets the value of the maxAttack property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxAttack(BigInteger value) {
        this.maxAttack = value;
    }

    /**
     * Gets the value of the maxDefense property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxDefense() {
        return maxDefense;
    }

    /**
     * Sets the value of the maxDefense property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxDefense(BigInteger value) {
        this.maxDefense = value;
    }

    /**
     * Gets the value of the maxSpAttack property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxSpAttack() {
        return maxSpAttack;
    }

    /**
     * Sets the value of the maxSpAttack property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxSpAttack(BigInteger value) {
        this.maxSpAttack = value;
    }

    /**
     * Gets the value of the maxSpDefense property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxSpDefense() {
        return maxSpDefense;
    }

    /**
     * Sets the value of the maxSpDefense property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxSpDefense(BigInteger value) {
        this.maxSpDefense = value;
    }

    /**
     * Gets the value of the maxSpeed property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * Sets the value of the maxSpeed property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxSpeed(BigInteger value) {
        this.maxSpeed = value;
    }

}
