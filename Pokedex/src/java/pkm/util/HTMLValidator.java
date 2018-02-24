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
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String inputLine = "";
        String html = "";
        System.out.println("Validating....");
        while ((inputLine = br.readLine()) != null) {           
                html = removeHTML(html);
                html += inputLine;            
        }     
        System.out.println("Validation is done.");
        InputStream resultIs = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
        return resultIs;
    }
   
    public static String removeHTML(String response) {
        Pattern regex = Pattern.compile("(?:<[ \\n\\r]*script[^>]*>)(.*?)(?:<[ \\n\\r]*/script[^>]*>)", Pattern.MULTILINE
                | Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        Matcher match = regex.matcher(response);
        String result = match.replaceAll("");
        return result;
    }
}
