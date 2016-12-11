package com.test;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by point on 2016/12/6.
 */
public class SaxTest {
    public static void main(String[] args) throws Exception{
        String info="<?xml version=\"1.0\" encoding=\"UTF-8\"?>       " +
                "<book name=\"等风来\" auther=\"鱼京鱼京\">        " +
                "<name>haha</name>\r\n<writer><wn>yy</wn></writer>" +
                "</book>";
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser(); // 创建解析器
        XMLContentHandler handler = new XMLContentHandler();
        InputStream inStream = new ByteArrayInputStream(info.getBytes("utf-8"));
        saxParser.parse(inStream, handler);
        inStream.close();


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(info));
        System.out.println(db.parse(is).toString());


    }

    public static class XMLContentHandler extends DefaultHandler {
StringBuilder sb = new StringBuilder();
        @Override
        public void startDocument() throws SAXException {
            System.out.println("******startDocument");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

        }

        @Override
        public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
            sb.append("<").append(name);
            for(int i=0;i<attributes.getLength();i++){
                sb.append(" ").append(attributes.getQName(i)).append("=").append("\"").append(attributes.getValue(i)).append("\"");
            }
            sb.append(">");
        }

        @Override
        public void endElement(String uri, String localName, String name) throws SAXException {
            sb.append("</").append(name).append(">");
        }
        @Override
        public void endDocument (){
            System.out.println("******endDocument"+sb.toString());
        }

    }
}
