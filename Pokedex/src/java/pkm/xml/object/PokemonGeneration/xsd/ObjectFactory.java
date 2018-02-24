
package pkm.xml.object.PokemonGeneration.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pkm.xml.object.PokemonGeneration.xsd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PokemonGeneration_QNAME = new QName("https://www.pokedex.com/schemas/PokemonGeneration.xsd", "PokemonGeneration");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pkm.xml.object.PokemonGeneration.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PokemonGeneration }
     * 
     */
    public PokemonGeneration createPokemonGeneration() {
        return new PokemonGeneration();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PokemonGeneration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://www.pokedex.com/schemas/PokemonGeneration.xsd", name = "PokemonGeneration")
    public JAXBElement<PokemonGeneration> createPokemonGeneration(PokemonGeneration value) {
        return new JAXBElement<PokemonGeneration>(_PokemonGeneration_QNAME, PokemonGeneration.class, null, value);
    }

}
