package ru.bdm.htmlparser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class FileHtmlParser {
    String charset = "windows-1251";
    public  void parseHtml(File input, File output) throws IOException {


        Document doc = Jsoup.parse(input, charset);
        doc.charset(StandardCharsets.UTF_8);
        System.out.println(doc.charset());

        String text = doc.text();
        var counter = new WordCounter();
        counter.parseWords(text);
        counter.save(new FileOutputStream(output));

    }
}
