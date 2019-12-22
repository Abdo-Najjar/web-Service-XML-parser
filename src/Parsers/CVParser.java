/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers;

import Subjects.Address;
import Subjects.Entity;
import Subjects.StudentCV;
import Subjects.StudyInformation;
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
public class CVParser extends Parser {

    public CVParser() {

        CVParser.this.setFilePath("./src/xml/cv_id.xml");
    }

    @Override
    public List<Entity> read() {
        List<Entity> studentsCVs = new ArrayList<>();
        try {
            NodeList childNodes = this.getRootChildernNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node std = childNodes.item(i);
                if (std.getNodeType() == Node.ELEMENT_NODE) {
                    StudentCV e = new StudentCV();
                    NodeList nodeList = std.getChildNodes();
                    for (int j = 0; j < nodeList.getLength(); j++) {
                        Node n = nodeList.item(j);

                        if (n.getNodeName().equalsIgnoreCase("id")) {
                            e.setId(Integer.parseInt(n.getTextContent()));
                        } else if (n.getNodeName().equalsIgnoreCase("firstName")) {
                            e.setFirstName(n.getTextContent());
                        } else if (n.getNodeName().equalsIgnoreCase("fatherName")) {
                            e.setFatherName(n.getTextContent());
                        } else if (n.getNodeName().equalsIgnoreCase("lastName")) {
                            e.setLastName(n.getTextContent());
                        } else if (n.getNodeName().equalsIgnoreCase("address")) {

                            Address address = getAddress(n);

                            e.setAddress(address);

                        } else if (n.getNodeName().equalsIgnoreCase("studyInformation")) {
                            StudyInformation information = getStudyInformation(n);
                            e.setStudyInformation(information);
                        }
                    }
                    studentsCVs.add(e);
                }
            }

            return studentsCVs;

        } catch (SAXException | IOException | ParserConfigurationException e) {

            System.out.println(e.getMessage());
        }

        return null;
    }

    private StudyInformation getStudyInformation(Node studyInformation) {

        StudyInformation information = new StudyInformation();

        NodeList informationAttr = studyInformation.getChildNodes();

        for (int index = 0; index < informationAttr.getLength(); index++) {

            Node node = informationAttr.item(index);
            if (node.getNodeName().equalsIgnoreCase("major")) {

                information.setMajor(node.getTextContent());

            } else if (node.getNodeName().equalsIgnoreCase("department")) {
                information.setDepartment(node.getTextContent());

            } else if (node.getNodeName().equalsIgnoreCase("college")) {
                information.setCollege(node.getTextContent());

            } else if (node.getNodeName().equalsIgnoreCase("studyLevel")) {
                information.setStudyLevel(Integer.parseInt(node.getTextContent()));
            }
        }
        return information;

    }

    private Address getAddress(Node AddressNode) {

        Address addressObject = new Address();
        NodeList addressAttr = AddressNode.getChildNodes();

        for (int index = 0; index < addressAttr.getLength(); index++) {

            Node node = addressAttr.item(index);
            if (node.getNodeName().equalsIgnoreCase("street")) {
                addressObject.setStreet(node.getTextContent());
            } else if (node.getNodeName().equalsIgnoreCase("city")) {
                addressObject.setCity(node.getTextContent());

            } else if (node.getNodeName().equalsIgnoreCase("country")) {
                addressObject.setCountry(node.getTextContent());

            } else if (node.getNodeName().equalsIgnoreCase("email")) {
                addressObject.setEmail(node.getTextContent());

            }
        }
        return addressObject;
    }

}
