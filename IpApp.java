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
        String ip, date;
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
                    id = Validator.getInt(sc, "New address ID: ");
                    ip = Validator.getLine(sc, "IP Address: ");
                    date = Validator.getLine(sc, "Entry Creation Date: ");
                    ipList.createRecord(new Address(id, ip, date));
                    break;
                case "3":
                    id = Validator.getInt(sc, "Address id to retrieve: ");
                    System.out.println(ipList.retrieveRecord(id));
                    break;
                case "4":
                    id = Validator.getInt(sc, "Address ID to update: ");
                    ip = Validator.getLine(sc, "IP Address: ");
                    date = Validator.getLine(sc, "Entry Creation Date: ");
                    ipList.updateRecord(new Address(id, ip, date));
                    break;
                case "5":
                    id = Validator.getInt(sc, "Address ID to delete: ");
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
