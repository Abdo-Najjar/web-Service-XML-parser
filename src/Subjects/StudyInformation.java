/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subjects;

/**
 *
 * @author abdo
 */
public class StudyInformation {
    
     private String major;
     private String department;
     private String college;
     private int studyLevel;

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the college
     */
    public String getCollege() {
        return college;
    }

    /**
     * @param college the college to set
     */
    public void setCollege(String college) {
        this.college = college;
    }

    /**
     * @return the studyLevel
     */
    public int getStudyLevel() {
        return studyLevel;
    }

    /**
     * @param studyLevel the studyLevel to set
     */
    public void setStudyLevel(int studyLevel) {
        this.studyLevel = studyLevel;
    }

    @Override
    public String toString() {
        return "StudyInformation{" + "major=" + major + ", department=" + department + ", college=" + college + ", studyLevel=" + studyLevel + '}';
    }

    
    
}
