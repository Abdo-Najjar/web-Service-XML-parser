package Subjects;

/**
 *
 * @author abdo
 */
public class StudentFinancial extends Entity{
        
    
    private String number;
    private int  semesterID;
    private double requiredAmount;
    private double amountPaid;
    private double amountRemind;
    private int year;

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return the semesterID
     */
    public int getSemesterID() {
        return semesterID;
    }

    /**
     * @param semesterID the semesterID to set
     */
    public void setSemesterID(int semesterID) {
        this.semesterID = semesterID;
    }

    /**
     * @return the requiredAmount
     */
    public double getRequiredAmount() {
        return requiredAmount;
    }

    /**
     * @param requiredAmount the requiredAmount to set
     */
    public void setRequiredAmount(double requiredAmount) {
        this.requiredAmount = requiredAmount;
    }

    /**
     * @return the amountPaid
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * @param amountPaid the amountPaid to set
     */
    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * @return the amountRemind
     */
    public double getAmountRemind() {
        return amountRemind;
    }

    /**
     * @param amountRemind the amountRemind to set
     */
    public void setAmountRemind(double amountRemind) {
        this.amountRemind = amountRemind;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "StudentFinancial{" + "number=" + number + ", semesterID=" + semesterID + ", requiredAmount=" + requiredAmount + ", amountPaid=" + amountPaid + ", amountRemind=" + amountRemind + ", year=" + year + '}';
    }
    
    
    
}
