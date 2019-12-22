package Parsers;

import Subjects.Course;
import Subjects.Entity;
import Subjects.Semester;
import Subjects.StudentGrade;
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
public class GradeParser extends Parser {

    public GradeParser() {
        GradeParser.this.setFilePath("./src/xml/grades_id.xml");
    }

    @Override
    public List<Entity> read() {
        List<Entity> financailGrades = new ArrayList<>();
        try {
            NodeList childNodes = this.getRootChildernNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node std = childNodes.item(i);
                if (std.getNodeType() == Node.ELEMENT_NODE) {

                    StudentGrade financial = new StudentGrade();

                    NodeList nodeList = std.getChildNodes();
                    for (int j = 0; j < nodeList.getLength(); j++) {
                        Node n = nodeList.item(j);

                        if (n.getNodeName().equalsIgnoreCase("id")) {

                            financial.setId(Integer.parseInt(n.getTextContent()));
                        } else if (n.getNodeName().equalsIgnoreCase("number")) {
                            financial.setNumber(Long.parseLong(n.getTextContent()));
                        } else if (n.getNodeName().equalsIgnoreCase("year")) {
                            financial.setYear(Integer.parseInt(n.getTextContent()));
                        } else if (n.getNodeName().equalsIgnoreCase("semesters")) {

                            financial.setSemesters(this.getSemesters(n));

                        }
                    }
                    financailGrades.add(financial);
                }
            }

            return financailGrades;
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

}
