package com.github.caryyu.tika.example;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.mp4.MP4Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.codehaus.plexus.util.io.URLInputStreamFacade;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class TikaExampleApplication {
    public static void main(String[] args) throws IOException, TikaException, SAXException {
        String urlString = "/Users/cary/123.mp4";

//        URL url = new URL(urlString);
        InputStream inputStream = new FileInputStream(urlString);
//        URLInputStreamFacade facade = new URLInputStreamFacade(url);

//        MP4Parser parser = new MP4Parser();
//        parser.parse(facade.getInputStream());
//        Tika tika = new Tika();

        AutoDetectParser parser = new AutoDetectParser(new MP4Parser());
        Metadata metadata = new Metadata();
        DefaultHandler contentHandler = new DefaultHandler();
        parser.parse(inputStream,contentHandler,metadata);
        System.out.println(metadata.toString());
    }
}