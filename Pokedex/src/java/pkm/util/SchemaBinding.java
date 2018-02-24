/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DUCVINH
 */
public class SchemaBinding {

    public static void main(String[] agrs) throws IOException {
        JAXBHelper jHelper = new JAXBHelper();
        String packageName = "pkm.xml.object.";
        String filePath = "web/WEB-INF/schemas/";
        String output  = "src/java/";
        List<String> xmlFileNameList = new ArrayList();
        File file = new File(filePath);
        xmlFileNameList =  getFileList(file);
        
        System.out.println("FILE NAME LIST:");
        for(String fileName: xmlFileNameList){
            System.out.println(fileName);
        }
        
        for(String fileName: xmlFileNameList){
            System.out.println(filePath+fileName);
            jHelper.bindSchemaToObject(output, packageName + fileName, filePath+fileName);
        }
        
    }

    private static List getFileList(File directory) {
        if (directory.isDirectory()) {
            String[] fileNames = directory.list();
            List<String> fileNameList = new ArrayList();
            for (String fileName : fileNames) {
                fileNameList.add(fileName);
            }
            return fileNameList;
        }
        return null;
    }
}
