
package pkm.xml.object.GameGeneration.xsd;

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
 *         &lt;element name="gameName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="generation" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="regionId" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="platform" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="releaseDateJAP" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="releaseDateUS" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="releaseDateEU" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="releaseDateAUS" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "gameName",
    "generation",
    "regionId",
    "platform",
    "releaseDateJAP",
    "releaseDateUS",
    "releaseDateEU",
    "releaseDateAUS"
})
@XmlRootElement(name = "GameGeneration")
public class GameGeneration {

    @XmlElement(required = true)
    protected String gameName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger generation;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger regionId;
    @XmlElement(required = true)
    protected String platform;
    protected long releaseDateJAP;
    protected long releaseDateUS;
    protected long releaseDateEU;
    protected long releaseDateAUS;

    /**
     * Gets the value of the gameName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * Sets the value of the gameName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGameName(String value) {
        this.gameName = value;
    }

    /**
     * Gets the value of the generation property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGeneration() {
        return generation;
    }

    /**
     * Sets the value of the generation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGeneration(BigInteger value) {
        this.generation = value;
    }

    /**
     * Gets the value of the regionId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRegionId() {
        return regionId;
    }

    /**
     * Sets the value of the regionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRegionId(BigInteger value) {
        this.regionId = value;
    }

    /**
     * Gets the value of the platform property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets the value of the platform property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlatform(String value) {
        this.platform = value;
    }

    /**
     * Gets the value of the releaseDateJAP property.
     * 
     */
    public long getReleaseDateJAP() {
        return releaseDateJAP;
    }

    /**
     * Sets the value of the releaseDateJAP property.
     * 
     */
    public void setReleaseDateJAP(long value) {
        this.releaseDateJAP = value;
    }

    /**
     * Gets the value of the releaseDateUS property.
     * 
     */
    public long getReleaseDateUS() {
        return releaseDateUS;
    }

    /**
     * Sets the value of the releaseDateUS property.
     * 
     */
    public void setReleaseDateUS(long value) {
        this.releaseDateUS = value;
    }

    /**
     * Gets the value of the releaseDateEU property.
     * 
     */
    public long getReleaseDateEU() {
        return releaseDateEU;
    }

    /**
     * Sets the value of the releaseDateEU property.
     * 
     */
    public void setReleaseDateEU(long value) {
        this.releaseDateEU = value;
    }

    /**
     * Gets the value of the releaseDateAUS property.
     * 
     */
    public long getReleaseDateAUS() {
        return releaseDateAUS;
    }

    /**
     * Sets the value of the releaseDateAUS property.
     * 
     */
    public void setReleaseDateAUS(long value) {
        this.releaseDateAUS = value;
    }

}
