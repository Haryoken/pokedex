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

            html += inputLine;

        }

        html = cleanTag(html, "script");

        InputStream resultIs = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
        return resultIs;
    }

    public static InputStream validateInputStreamAzurill(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String inputLine = "";
        String html = "";
        while ((inputLine = br.readLine()) != null) {
            if (!inputLine.contains("<meta")
                    && !inputLine.contains("<link")
                    //                    && !inputLine.contains("</style>")
                    //                    && !inputLine.contains("<style>")
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
//        html = cleanHead(html);
//        html = cleanJavascript(html);
        html = cleanTag(html, "head");
        html = cleanTag(html, "script");
        html = cleanTag(html, "style");
        InputStream resultIs = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
        return resultIs;
    }

    public static InputStream validateInputStreamWikia(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String inputLine = "";
        String html = "";
        while ((inputLine = br.readLine()) != null) {
            if (inputLine.contains("<html")) {
                inputLine = cleanString(inputLine, " lang=\"en\" dir=\"ltr\" class=\"\"");
            }
            if (!inputLine.contains("!doctype")) {
                html += inputLine;
                //System.out.println(inputLine);
            }
        }
//        html = cleanJavascript(html);
//        html = cleanHead(html);
//        html = cleanJavascript(html);
        html = cleanTag(html, "script");
        html = cleanTag(html, "head");
        html = cleanTag(html, "svg");
        html = cleanTag(html, "form");

        InputStream resultIs = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
        return resultIs;
    }

    private static String cleanString(String input, String pattern) {
        Pattern regex = Pattern.compile(pattern, Pattern.MULTILINE
                | Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        Matcher match = regex.matcher(input);
        String result = match.replaceAll("");
        return result;
    }

    private static String cleanTag(String input, String tagName) {
        Pattern regex = Pattern.compile("(?:<[ \\n\\r]*" + tagName + "[^>]*>)(.*?)(?:<[ \\n\\r]*/" + tagName + "[^>]*>)", Pattern.MULTILINE
                | Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        Matcher match = regex.matcher(input);
        String result = match.replaceAll("");
        return result;
    }

}
