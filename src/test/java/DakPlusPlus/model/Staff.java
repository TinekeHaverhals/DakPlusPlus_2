package DakPlusPlus.model;

import java.util.Date;

/**
 * Tineke Haverhals
 * 9/07/20.
 */
public class Staff {
    private int StaffId;
    private String FirstName;
    private String LastName;
    private int PhoneNumber;
    private int ICE;
    private Date DateOfBirth;
    private int Salary;


    @Override
    public String toString() {
        return "Staff{" +
                "StaffId=" + StaffId +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", ICE=" + ICE +
                ", DateBirth=" + DateOfBirth +
                ", Salary=" + Salary +
                '}';
    }

    public String getSingleLine() {
        return "Staff{" +
                "Staffid=" + StaffId +
                ", firstname='" + FirstName + '\'' +
                ", lastname=" + LastName + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", ICE=" + ICE +
                ", DateBirth=" + DateOfBirth +
                ", Salary=" + Salary +
                '}';
    }

    public int getStaffId() {
        return StaffId;
    }

    public Staff setStaffId(int StaffId) {
        this.StaffId = StaffId;
        return this;
    }

    public String getFirstName() {
        return FirstName;
    }

    public Staff setFirstName(String firstName) {
        this.FirstName = firstName;
        return this;
    }

    public String getLastName() {
        return LastName;
    }

    public Staff setLastName(String lastName) {
        this.LastName = lastName;
        return this;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public Staff setPhoneNumber(int phoneNumber) {
        this.PhoneNumber = phoneNumber;
        return this;
    }

    public int getICE() {
        return ICE;
    }

    public Staff setICE(int ICE) {
        this.ICE = ICE;
        return this;
    }

    public Date getDateBirth() {
        return DateOfBirth;
    }

    public Staff setDateBirth(Date dateOfBirth) {
        this.DateOfBirth = dateOfBirth;
        return this;
    }

    public int getSalary() {
        return Salary;
    }

    public Staff setSalary(int salary) {
        this.Salary = salary;
        return this;
    }

}