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

        //Add when crawl PokemonMoves
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
                    && !inputLine.contains("<!doctype")
                    && !inputLine.contains("<!DOCTYPE")
                    && !inputLine.contains("filter-egg-group-op")) {
                html += inputLine;
            }
        }
        html = cleanTag(html, "head");
        html = cleanTag(html, "script");
        html = cleanTag(html, "style");
        html = cleanTag(html, "noscript");
        html = cleanString(html, "itemscope");

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
        html = cleanTag(html, "script");
        html = cleanTag(html, "head");
        html = cleanTag(html, "svg");
        html = cleanTag(html, "form");
        html = cleanTag(html, "noscript");
        InputStream resultIs = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
        return resultIs;
    }

    public static InputStream validateInputStreamIGN(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String inputLine = "";
        String html = "";
        while ((inputLine = br.readLine()) != null) {
            if (inputLine.contains("<section")) {
                inputLine = cleanString(inputLine, "itemscope");
            }
            if (inputLine.trim().equals("<th class=\"span1\"><span class=\"pull-right\">HP</span></span></th>")) {
                inputLine = "<th class=\"span1\"><span class=\"pull-right\">HP</span></th>";
            }
            if (!inputLine.contains("!DOCTYPE")
                    && !inputLine.contains("!doctype")) {

                html += inputLine;
                //System.out.println(inputLine);
            }
        }
        html = cleanTag(html, "script");
        html = cleanTag(html, "head");
        html = cleanTag(html, "noscript");
        html = cleanTag(html, "form");
        html = cleanTag(html, "p");

        //Add when crawl Stats
        html = cleanTag(html, "dt");
        html = cleanTag(html, "dd");
        html = cleanTag(html, "i");
        html = cleanTag(html, "a");
        //html = cleanTag(html, "section");

        InputStream resultIs = new ByteArrayInputStream(html.getBytes(StandardCharsets.UTF_8));
        return resultIs;
    }

    public static InputStream validateInputStreamPKMDB(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
        String inputLine = "";
        String html = "";
        while ((inputLine = br.readLine()) != null) {
            if (inputLine.contains("<section")) {
                inputLine = cleanString(inputLine, "itemscope");
            }
            if (inputLine.trim().equals("<th class=\"span1\"><span class=\"pull-right\">HP</span></span></th>")) {
                inputLine = "<th class=\"span1\"><span class=\"pull-right\">HP</span></th>";
            }
            if (!inputLine.contains("!DOCTYPE")
                    && !inputLine.contains("!doctype")
                    && !inputLine.contains("<link")
                    && !inputLine.contains("<meta")) {

                html += inputLine;
            }
        }
        html = cleanTag(html, "script");
        html = cleanTag(html, "nav");
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

    private static String cleanTag(String input, String tagName, String attribute) {
        Pattern regex = Pattern.compile("(?:<[ \\n\\r]*" + tagName + " " + attribute + "[^>]*>)(.*?)(?:<[ \\n\\r]*/" + tagName + "[^>]*>)", Pattern.MULTILINE
                | Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
        Matcher match = regex.matcher(input);
        String result = match.replaceAll("");
        return result;
    }

}
