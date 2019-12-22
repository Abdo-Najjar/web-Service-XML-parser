
package Subjects;

import java.util.List;

/**
 *
 * @author abdo
 */
public class StudentGrade extends Entity {

    private long number;
    private int year;
    private List<Semester> semesters;

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
        return "StudentGrade{" + "number=" + number + ", year=" + year + ", semesters=" + semesters + '}';
    }

}
