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
        while ((inputLine = br.readLine()) != null) {
            if (!inputLine.contains("<meta")
                    && !inputLine.contains("<link")
                    && !inputLine.contains("</style>")
                    && !inputLine.contains("<style>")
                    && !inputLine.contains("<!doctype")
                    && !inputLine.contains("<!DOCTYPE")
                    && !inputLine.contains("<noscript")
                    && !inputLine.contains("</noscript>")
                    && !inputLine.contains("filter-egg-group-op")) {
                inputLine = cleanString("itemscope", inputLine);
                html += inputLine;
            }
        }
//        html = cleanJavascript(html);
        html = cleanHead(html);
        html = cleanJavascript(html);
        InputStream resultIs = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
        return resultIs;
    }

    public static String cleanString(String pattern, String input) {
        Pattern regex = Pattern.compile(pattern, Pattern.MULTILINE
                | Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        Matcher match = regex.matcher(input);
        String result = match.replaceAll("");
        return result;
    }

    public static String cleanHead(String input) {
        Pattern regex = Pattern.compile("(?:<[ \\n\\r]*head[^>]*>)(.*?)(?:<[ \\n\\r]*/head[^>]*>)", Pattern.MULTILINE
                | Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        Matcher match = regex.matcher(input);
        String result = match.replaceAll("");
        return result;
    }

    public static String cleanJavascript(String input) {
        Pattern regex = Pattern.compile("(?:<[ \\n\\r]*script[^>]*>)(.*?)(?:<[ \\n\\r]*/script[^>]*>)", Pattern.MULTILINE
                | Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        Matcher match = regex.matcher(input);
        String result = match.replaceAll("");
        return result;
    }

}
