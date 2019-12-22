/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subjects;

import java.util.List;

/**
 *
 * @author abdo
 */
public class Student extends Entity{

    private long id;
    private String firstName;
    private String fatherName;
    private String lastName;
    private long number;
    private int year;
    private int requiredAmount;
    private int amountPaid;
    private int amountRemind;
    private List<Semester> semesters;
    private StudyInformation studyInformation;
    private Address address;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

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

    /**
     * @return the number
     */
    public long getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(long number) {
        this.number = number;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the requiredAmount
     */
    public int getRequiredAmount() {
        return requiredAmount;
    }

    /**
     * @param requiredAmount the requiredAmount to set
     */
    public void setRequiredAmount(int requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    /**
     * @return the amountPaid
     */
    public int getAmountPaid() {
        return amountPaid;
    }

    /**
     * @param amountPaid the amountPaid to set
     */
    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * @return the amountRemind
     */
    public int getAmountRemind() {
        return amountRemind;
    }

    /**
     * @param amountRemind the amountRemind to set
     */
    public void setAmountRemind(int amountRemind) {
        this.amountRemind = amountRemind;
    }

    /**
     * @return the semesters
     */
    public List<Semester> getSemesters() {
        return semesters;
    }

    /**
     * @param semesters the semesters to set
     */
    public void setSemesters(List<Semester> semesters) {
        this.semesters = semesters;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstName=" + firstName + ", fatherName=" + fatherName + ", lastName=" + lastName + ", address=" + address + ", studyInformation=" + studyInformation + ", number=" + number + ", year=" + year + ", requiredAmount=" + requiredAmount + ", amountPaid=" + amountPaid + ", amountRemind=" + amountRemind + ", semesters=" + semesters + '}';
    }
    
    
}
