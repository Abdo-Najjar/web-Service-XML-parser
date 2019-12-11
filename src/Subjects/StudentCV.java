package Subjects;

/**
 *
 * @author abdo
 */
public class StudentCV extends Entity{
 
    private String firstName;
    private String fatherName;
    private String lastName;
    private Address address;
    private StudyInformation studyInformation;


    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the fatherName
     */
    public String getFatherName() {
        return fatherName;
    }

    /**
     * @param fatherName the fatherName to set
     */
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the studyInformation
     */
    public StudyInformation getStudyInformation() {
        return studyInformation;
    }

    /**
     * @param studyInformation the studyInformation to set
     */
    public void setStudyInformation(StudyInformation studyInformation) {
        this.studyInformation = studyInformation;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + getId() + ", firstName=" + firstName + ", fatherName=" + fatherName + ", lastName=" + lastName + ", address=" + address + ", studyInformation=" + studyInformation + '}';
    }
    
    
    
    
}
