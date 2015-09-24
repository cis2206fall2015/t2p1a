//package t2p1a;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**IpApp class
 *
 * @author Marshall Ehlinger
 * @author Jon VanZile
 * @author John Phillips (provided initial source code)
 *
 */
public class IpApp {

    IpDAO ipList = new IpDAO();
    Scanner sc = new Scanner(System.in);
    String ipRegexString = "(^\\d\\d\\d\\.(\\d){2,3})(\\.\\d*\\.\\d*)?$";
    Pattern ipRegex = Pattern.compile(ipRegexString);
    Matcher ipMatcher;

    public static void main(String[] args) {
        new IpApp();
    }

    public IpApp() {
        menuLoop();
    }
    /**
     *menuLoop method: while loop scans input to select desired case
     *
     *@param sc				User input, assigned to choice variable for the purpose of selecting desired case
     */
    private void menuLoop() {
        int id;
        String rawIp, date;
	String ip = "Error- Short ip not set. No regex match found.";
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
		/**
		 *case "1": prints contents of ipList (as a string) to STDOUT 
                 */
                case "1":
                    System.out.println(ipList.toString());
                    break;
		/**
		 *case "2": Makes relevant method calls to generate the ID, IP Address, and date; based on user input
		 *
		 *@param sc			This is the user input to be fed to the relevant methods
		 *@param ipRegesString		ipRegexString is standard form that the user entered IP is checked against
		 */
                case "2":
                    id = Validator.getInt(sc, "New address ID: ");
                    rawIp = Validator.getLine(sc, "IP Address: ", ipRegexString);
		    ipMatcher = ipRegex.matcher(rawIp);
		    while (ipMatcher.find()) {
		    	ip = ipMatcher.group(1);
		    }
                    date = "";//Validator.getLine(sc, "Entry Creation Date: ");
                    ipList.createRecord(new Address(id, ip, date));
                    break;
		/**
		 *case "3": Takes user input to retrieve a record whos ID matches the input
		 *
		 *@param sc					This is the user input, in this case it is the ID of the desired record
		 *@param ipList.retrieveRecord(id)		Resolves to contents of specified (by id) record
 		 */
                case "3":
                    id = Validator.getInt(sc, "Address id to retrieve: ");
                    System.out.println(ipList.retrieveRecord(id));
                    break;
		/**
		 *case "4": Takes user input to change attributes of a previously created record 
		 */
                case "4":
                    id = Validator.getInt(sc, "Address ID to update: ");
                    rawIp = Validator.getLine(sc, "IP Address: ", ipRegexString);
		    ipMatcher = ipRegex.matcher(rawIp);
		    while (ipMatcher.find()) {
		    	ip = ipMatcher.group(1);
		    }
                    date = Validator.getLine(sc, "Entry Creation Date: ");
                    ipList.updateRecord(new Address(id, ip, date));
                    break;
		/**
		 *case "5": Matches user input to the ID of a preexisting record, deletes specified record
		 *
		 */
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
