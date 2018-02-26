/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.util;

import com.sun.codemodel.JCodeModel;
import com.sun.tools.xjc.api.ErrorListener;
import com.sun.tools.xjc.api.S2JJAXBModel;
import com.sun.tools.xjc.api.SchemaCompiler;
import com.sun.tools.xjc.api.XJC;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import pkm.xml.object.PokemonList.xsd.Pokemon;

/**
 *
 * @author DUCVINH
 */
public class JAXBHelper {

    public static void bindSchemaToObject(String output, String packageName, String schemaFile) throws IOException {
        SchemaCompiler sc = XJC.createSchemaCompiler();
        sc.setErrorListener(new ErrorListener() {
            @Override
            public void error(SAXParseException saxpe) {
                System.out.println("error" + saxpe.getMessage());
            }

            @Override
            public void fatalError(SAXParseException saxpe) {
                System.out.println("fatal" + saxpe.getMessage());
            }

            @Override
            public void warning(SAXParseException saxpe) {
                System.out.println("warning" + saxpe.getMessage());//To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void info(SAXParseException saxpe) {
                System.out.println("info" + saxpe.getMessage()); //To change body of generated methods, choose Tools | Templates.
            }
        });
        sc.forcePackageName(packageName);
        File schema = new File(schemaFile);
        InputSource is = new InputSource(schema.toURI().toString());
        sc.parseSchema(is);
        S2JJAXBModel model = sc.bind();
        JCodeModel code = model.generateCode(null, null);
        code.build(new File(output));
    }

    public static <T> void saveAsXML(String xmlFilePath, T jaxbObject) {
        try {
            JAXBContext context = JAXBContext.newInstance(jaxbObject.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(jaxbObject, new File(xmlFilePath));
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static <T> void unmarshall(String xmlFilePath, T jaxbObject) {
        try {
            JAXBContext context = JAXBContext.newInstance(jaxbObject.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(jaxbObject, new File(xmlFilePath));
        } catch (JAXBException ex) {
            Logger.getLogger(JAXBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static <T> boolean validateXML(String xmlFilePath, String schemaFilePath, Object jaxbObject) throws FileNotFoundException, IOException, JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(jaxbObject.getClass());
            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File(schemaFilePath));
            InputSource source = new InputSource(new BufferedReader(new FileReader(xmlFilePath)));
            Validator validator = schema.newValidator();
            validator.validate(new SAXSource(source));
            return true;
        } catch (SAXException ex) {
            Logger.getLogger(JAXBHelper.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
