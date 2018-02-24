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
import java.io.File;
import java.io.IOException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

/**
 *
 * @author DUCVINH
 */
public class JAXBHelper{
    public static void bindSchemaToObject(String output,String packageName,String schemaFile) throws IOException{
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
}
