/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import Subjects.Entity;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author abdo
 */
public abstract class Parser {

    public abstract List<Entity> read();

    private String FilePath;

    public NodeList getRootChildernNodes() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(this.FilePath));
        Element root = document.getDocumentElement();
        return root.getChildNodes();
    }

    /**
     * @return the FilePath
     */
    private String getFilePath() {
        return FilePath;
    }

    /**
     * @param FilePath the FilePath to set
     */
    public void setFilePath(String FilePath) {
        this.FilePath = FilePath;
    }
}
