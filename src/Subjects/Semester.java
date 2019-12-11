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
public class Semester {

      
    private long id;
    private List<Course> courses;
    
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
     * @return the courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * @param courses the courses to set
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Semester{" + "id=" + id + ", courses=" + courses + '}';
    }
    
}
