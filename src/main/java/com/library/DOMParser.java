package com.library;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMParser {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/main/resources/library.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            NodeList authorList = doc.getElementsByTagName("author");
            System.out.println("\nAuthors:");
            for (int i = 0; i < authorList.getLength(); i++) {
                Node authorNode = authorList.item(i);
                if (authorNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element authorElement = (Element) authorNode;
                    System.out.println("ID: " + authorElement.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("Name: " + authorElement.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Birth Year: " + authorElement.getElementsByTagName("birthYear").item(0).getTextContent());
                }
            }

            NodeList bookList = doc.getElementsByTagName("book");
            System.out.println("\nBooks:");
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    System.out.println("ID: " + bookElement.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("Title: " + bookElement.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Author ID: " + bookElement.getElementsByTagName("authorId").item(0).getTextContent());
                    System.out.println("Published Year: " + bookElement.getElementsByTagName("publishedYear").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

