/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.util;

import java.util.TimerTask;

/**
 *
 * @author DUCVINH
 */
public class SchemaBindingTask extends TimerTask {
    
    @Override
    public void run() {
        String packageName = "pkm.xml.object.";
        String filePath = "web/WEB-INF/schemas/";
        String output = "src/java/";
        JAXBHelper.bindSchemas(output, filePath, packageName);
    }
    
}
