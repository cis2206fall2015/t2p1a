//package t2p1a;

/**
 *
 * @author Your Name Here
 */
public class Address {

    private int empId;
    private String lastName;
    private String firstName;
    private String homePhone;
    private double salary;

    public Address() {
        empId = 0;
        lastName = "";
        firstName = "";
        homePhone = "";
        salary = 0;
    }

    public Address(int empId, String lastName, String firstName, String homePhone, double salary) {
        this.empId = empId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.homePhone = homePhone;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Address{" + "empId=" + empId + ", lastName=" + lastName 
                + ", firstName=" + firstName + ", homePhone=" + homePhone 
                + ", salary=" + salary + '}';
    }
}
