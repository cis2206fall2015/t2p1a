//package t2p1a;

import java.util.Scanner;

/**
 *
 * @author Your Name Here
 */
public class IpApp {

    IpDAO ipList = new IpDAO();
    Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new IpApp();
    }

    public IpApp() {
        menuLoop();
    }

    private void menuLoop() {
        int id;
        String last, first, homePhone;
        double salary;
        String choice = "1";
        while (!choice.equals("0")) {
            System.out.println("\nIP Tracking Program");
            System.out.println("0 = Quit");
            System.out.println("1 = List All IP Address Requests");
            System.out.println("2 = Create New IP Address Request");
            System.out.println("3 = Retrieve Request");
            System.out.println("4 = Update Request");
            System.out.println("5 = Delete Request");
            choice = Validator.getLine(sc, "Number of choice: ", "^[0-5]$");

            switch (choice) {
                case "1":
                    System.out.println(ipList.toString());
                    break;
                case "2":
                    id = Validator.getInt(sc, "New employee ID: ");
                    last = Validator.getLine(sc, "Last name: ");
                    first = Validator.getLine(sc, "First name: ");
                    homePhone = Validator.getLine(sc, "Home phone number: ");
                    salary = Validator.getDouble(sc, "Yearly salary: ");
                    ipList.createRecord(new Employee(id, last, first, homePhone, salary));
                    break;
                case "3":
                    id = Validator.getInt(sc, "Employee id to retrieve: ");
                    System.out.println(ipList.retrieveRecord(id));
                    break;
                case "4":
                    id = Validator.getInt(sc, "Employee ID to update: ");
                    last = Validator.getLine(sc, "Last name: ");
                    first = Validator.getLine(sc, "First name: ");
                    homePhone = Validator.getLine(sc, "Home phone number: ");
                    salary = Validator.getDouble(sc, "Yearly salary: ");
                    ipList.updateRecord(new Employee(id, last, first, homePhone, salary));
                    break;
                case "5":
                    id = Validator.getInt(sc, "Employee ID to delete: ");
                    System.out.println(ipList.retrieveRecord(id));
                    String ok = Validator.getLine(sc, "Deleter this record? (y/n) ", "^[yYnN]$");
                    if (ok.equalsIgnoreCase("Y")) {
                        ipList.deleteRecord(id);
                    }
                    break;
            }
        }
    }

}
