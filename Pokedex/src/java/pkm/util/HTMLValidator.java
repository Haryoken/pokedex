/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkm.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DUCVINH
 */
public class HTMLValidator {

    public static InputStream validateInputStream(InputStream is) throws IOException {
        System.out.println("HTML Validation is stared.");
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String inputLine = "";
        String html = "";
        System.out.println("Reading input stream...."); 
        while ((inputLine = br.readLine()) != null) {   
                html += inputLine;            
        }     
        System.out.println("Cleaning Javascript....");
        html =  cleanJavascript(html);
        InputStream resultIs = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
        System.out.println("Validation is done.");
        return resultIs;
    }
   
    public static String cleanJavascript(String input) {
        Pattern regex = Pattern.compile("(?:<[ \\n\\r]*script[^>]*>)(.*?)(?:<[ \\n\\r]*/script[^>]*>)", Pattern.MULTILINE
                | Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        Matcher match = regex.matcher(input);
        String result = match.replaceAll("");
        return result;
    }
}
