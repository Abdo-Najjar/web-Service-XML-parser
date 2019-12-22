package Parsers;

import Subjects.Address;
import Subjects.Course;
import Subjects.Entity;
import Subjects.Semester;
import Subjects.Student;
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
public class StudentParser extends Parser {

    public StudentParser() {
        StudentParser.this.setFilePath("./src/xml/printing.xml");
    }

    @Override
    public List<Entity> read() {

        List<Entity> students = new ArrayList<>();
        try {
            NodeList childNodes = this.getRootChildernNodes();

            for (int i = 0; i < childNodes.getLength(); i++) {

                Node std = childNodes.item(i);

                if (std.getNodeType() == Node.ELEMENT_NODE) {

                    Student student = new Student();

                    NodeList nodeList = std.getChildNodes();

                    for (int j = 0; j < nodeList.getLength(); j++) {

                        Node n = nodeList.item(j);

                        if (n.getNodeName().equalsIgnoreCase("id")) {

                            student.setId(Long.parseLong(n.getTextContent()));

                        } else if (n.getNodeName().equalsIgnoreCase("firstName")) {

                            student.setFirstName(n.getTextContent());

                        } else if (n.getNodeName().equalsIgnoreCase("fatherName")) {

                            student.setFatherName(n.getTextContent());

                        } else if (n.getNodeName().equalsIgnoreCase("lastName")) {

                            student.setLastName(n.getTextContent());

                        } else if (n.getNodeName().equalsIgnoreCase("number")) {

                            student.setNumber(Long.parseLong(n.getTextContent()));

                        } else if (n.getNodeName().equalsIgnoreCase("year")) {

                            student.setYear(Integer.parseInt(n.getTextContent()));

                        } else if (n.getNodeName().equalsIgnoreCase("requiredAmount")) {

                            student.setRequiredAmount(Integer.parseInt(n.getTextContent()));

                        } else if (n.getNodeName().equalsIgnoreCase("amountPaid")) {

                            student.setAmountPaid(Integer.parseInt(n.getTextContent()));

                        } else if (n.getNodeName().equalsIgnoreCase("amountRemind")) {

                            student.setAmountRemind(Integer.parseInt(n.getTextContent()));

                        } else if (n.getNodeName().equalsIgnoreCase("semesters")) {

                            student.setSemesters(this.getSemesters(n));

                        } else if (n.getNodeName().equalsIgnoreCase("address")) {

                            student.setAddress(this.getAddress(n));

                        } else if (n.getNodeName().equalsIgnoreCase("studyInformation")) {

                            student.setStudyInformation(getStudyInformation(n));

                        }
                    }

                    students.add(student);
                }
            }

            return students;

        } catch (SAXException | IOException | ParserConfigurationException e) {

            System.out.println(e.getMessage());
        }

        return null;

    }

    private List<Semester> getSemesters(Node studyInformation) {

        List<Semester> semesters = new ArrayList<>();

        NodeList informationAttr = studyInformation.getChildNodes();

        for (int index = 0; index < informationAttr.getLength(); index++) {
            Semester semester = new Semester();
            Node node = informationAttr.item(index);

            if (node.getNodeName().equalsIgnoreCase("semester")) {

                NodeList semesterAttr = node.getChildNodes();

                for (int x = 0; x < semesterAttr.getLength(); x++) {
                    Node innerNode = semesterAttr.item(x);

                    if (innerNode.getNodeName().equalsIgnoreCase("id")) {
                        semester.setId(Long.parseLong(innerNode.getTextContent()));
                    } else if (innerNode.getNodeName().equalsIgnoreCase("courses")) {

                        semester.setCourses(this.getCourses(innerNode));

                    }

                }
                semesters.add(semester);

            }
        }
        return semesters;

    }

    private List<Course> getCourses(Node AddressNode) {

        List<Course> courses = new ArrayList<>();

        NodeList coursesList = AddressNode.getChildNodes();

        for (int index = 0; index < coursesList.getLength(); index++) {

            Node node = coursesList.item(index);

            if (node.getNodeName().equalsIgnoreCase("course")) {

                NodeList courseAttr = node.getChildNodes();
                Course course = new Course();

                for (int x = 0; x < courseAttr.getLength(); x++) {

                    Node courseNode = courseAttr.item(x);

                    if (courseNode.getNodeName().equalsIgnoreCase("id")) {

                        course.setId(Integer.parseInt(courseNode.getTextContent()));

                    } else if (courseNode.getNodeName().equalsIgnoreCase("name")) {

                        course.setName(courseNode.getTextContent());

                    } else if (courseNode.getNodeName().equalsIgnoreCase("grade")) {

                        course.setGrade(Integer.parseInt(courseNode.getTextContent()));
                    }
                }
                courses.add(course);

            }

        }
        return courses;
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

}
