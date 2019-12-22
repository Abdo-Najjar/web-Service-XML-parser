/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import Subjects.Entity;
import Subjects.StudentFinancial;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author abdo
 */
public class FinancialParser extends Parser {

    public FinancialParser() {
        FinancialParser.this.setFilePath("./src/xml/financial_id.xml");

    }

    @Override
    public List<Entity> read() {
        List<Entity> studentFinancials = new ArrayList<>();
        try {
            NodeList childNodes = this.getRootChildernNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node std = childNodes.item(i);
                if (std.getNodeType() == Node.ELEMENT_NODE) {

                    StudentFinancial financial = new StudentFinancial();

                    NodeList nodeList = std.getChildNodes();
                    for (int j = 0; j < nodeList.getLength(); j++) {
                        Node n = nodeList.item(j);

                        if (n.getNodeName().equalsIgnoreCase("id")) {

                            financial.setId(Integer.parseInt(n.getTextContent()));
                        } else if (n.getNodeName().equalsIgnoreCase("number")) {

                            financial.setNumber(n.getTextContent());
                        } else if (n.getNodeName().equalsIgnoreCase("year")) {

                            financial.setYear(Integer.parseInt(n.getTextContent()));
                        } else if (n.getNodeName().equalsIgnoreCase("semester")) {

                            financial.setSemesterID(Integer.parseInt(n.getTextContent()));
                        } else if (n.getNodeName().equalsIgnoreCase("requiredAmount")) {

                            financial.setRequiredAmount(Double.parseDouble(n.getTextContent()));
                        } else if (n.getNodeName().equalsIgnoreCase("amountPaid")) {

                            financial.setAmountPaid(Double.parseDouble(n.getTextContent()));
                        } else if (n.getNodeName().equalsIgnoreCase("amountRemind")) {

                            financial.setAmountRemind(Double.parseDouble(n.getTextContent()));
                        }
                    }
                    studentFinancials.add(financial);
                }
            }

            return studentFinancials;
        } catch (SAXException | IOException | ParserConfigurationException e) {

            System.out.println(e.getMessage());
        }

        return null;
    }

}
