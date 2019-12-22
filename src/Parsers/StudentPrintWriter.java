package Parsers;

import Subjects.StudentCV;
import Subjects.StudentFinancial;
import Subjects.StudentGrade;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author abdo
 */
public class StudentPrintWriter {

    private final String filePath;

    public StudentPrintWriter() {
        this.filePath = "./src/xml/test.xml";
    }

    public void writeStudent(StudentCV studentCV, StudentFinancial studentFinancial, StudentGrade studentGrade) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element root = document.createElement("students");
            document.appendChild(root);

            Element student = document.createElement("student");
            root.appendChild(student);

            Element id = document.createElement("id");
            id.setTextContent(String.valueOf(studentCV.getId()));
            student.appendChild(id);

            Element firstName = document.createElement("firstName");
            firstName.setTextContent(studentCV.getFirstName());
            student.appendChild(firstName);

            Element fatherName = document.createElement("fatherName");
            fatherName.setTextContent(studentCV.getFatherName());
            student.appendChild(fatherName);

            Element lastName = document.createElement("lastName");
            lastName.setTextContent(studentCV.getLastName());
            student.appendChild(lastName);

            Element number = document.createElement("number");
            number.setTextContent(studentFinancial.getNumber());
            student.appendChild(number);

            Element year = document.createElement("year");
            year.setTextContent(String.valueOf(studentFinancial.getYear()));
            student.appendChild(year);

            Element requiredAmount = document.createElement("requiredAmount");
            requiredAmount.setTextContent(String.valueOf(studentFinancial.getRequiredAmount()));
            student.appendChild(requiredAmount);

            Element amountPaid = document.createElement("amountPaid");
            amountPaid.setTextContent(String.valueOf(studentFinancial.getAmountPaid()));
            student.appendChild(amountPaid);

            Element amountRemind = document.createElement("amountRemind");
            amountRemind.setTextContent(String.valueOf(studentFinancial.getAmountRemind()));
            student.appendChild(amountRemind);

            Element studyInformation = document.createElement("studyInformation");
            student.appendChild(studyInformation);

            Element major = document.createElement("major");
            major.setTextContent(studentCV.getStudyInformation().getMajor());
            major.appendChild(studyInformation);

            Element department = document.createElement("department");
            department.setTextContent(studentCV.getStudyInformation().getDepartment());
            department.appendChild(studyInformation);

            Element college = document.createElement("college");
            college.setTextContent(studentCV.getStudyInformation().getCollege());
            college.appendChild(studyInformation);

            Element studyLevel = document.createElement("studyLevel");
            studyLevel.setTextContent(String.valueOf( studentCV.getStudyInformation().getStudyLevel()));
            studyLevel.appendChild(studyInformation);
            
            
            Element address = document.createElement("address");
            student.appendChild(address);
            
 
            
            Element street = document.createElement("street");
            student.appendChild(street);
 
            
            Element city = document.createElement("city");
            student.appendChild(city);
 
            
            Element country = document.createElement("country");
            student.appendChild(country);
 
            
            Element email = document.createElement("email");
            student.appendChild(email);
 

            Element semesters = document.createElement("semesters");
            student.appendChild(semesters);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(this.filePath));
            transformer.transform(source, streamResult);

        } catch (ParserConfigurationException | TransformerException e) {

            System.out.println(e.getMessage());

        }

    }

}
