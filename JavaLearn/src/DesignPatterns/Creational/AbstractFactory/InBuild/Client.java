package DesignPatterns.Creational.AbstractFactory.InBuild;


import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Client {

    public static void main(String[] args) throws Exception{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        System.out.println("Using Factory class: " + factory.getClass());

        DocumentBuilder builder = factory.newDocumentBuilder();
        System.out.println("Got Builder Class " + builder.getClass());

        Document doc = builder.newDocument();
        System.out.println("Got Document class: " + doc.getClass());
    }
}
