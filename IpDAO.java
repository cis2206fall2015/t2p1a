//package t2p1a;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**IpDAO class
 *
 * @author Marshall Ehlinger
 * @author Jon VanZile
 * @author John Phillips (Provided initial source code)
 */
public class IpDAO {

    private final String fileName;
    protected final List<Address> myList;

    /**
     *IpDAO constructor instantiates the IpDAO class
     *
     *@param ipdata.txt 			Name of the file that will house stored records. 
     *						Specifically, this is passed into IpDAO(String fileName) method
     */
    public IpDAO() {
        this("ipdata.txt");
    }
    /**
     *IpDAO method attempts to create a file named by the contents of "fileName" variable, 
     *if file already exists, and error message is displayed to console
     */
    public IpDAO(String fileName) {
        this.fileName = fileName;
        this.myList = new ArrayList<>();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ioe) {
            System.out.println("Create file error with " + ioe.getMessage());
        }
        readList();
    }
    /**createRecord instantiates an Address object, while the for loop checks the entered shortIp attribute against the previously stored records. 
     * 
     * 
     * @param currentEntry.getNumAccess()+1		Adds "1" to the numAccess attribute of the original record when a duplicate ip entry is detected by the for loop
     */
    public void createRecord(Address address) {
	Address currentEntry;
	boolean redundant = false;
	//int dupId = currentEntry.getIpID();
	for (int i = 0; i < myList.size(); i++) {
		currentEntry = myList.get(i);
		if (address.getShortIP().equals(currentEntry.getShortIP())) {
			myList.get(i).setNumAccess(currentEntry.getNumAccess() + 1);
			redundant = true;	
			break;
		}
	}
	String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
	address.setEntryDate(timeStamp);
	//for (int d = 0; d < myList.size(); d++){
	//	currentEntry = myList.get(d);
	//	if (address.getIpID() == (currentEntry.getIpID())){
	//		System.out.println("Error: A record is already using "+(dupId));
	//		currentEntry.setIpID(Validator.getLine());//sc, "New address ID: ")); <--- broken. can't use sc because sc doesn't exist here.
	//		d = 0;
	//	}
	//}
			
	if (redundant != true) {
        	myList.add(address);
	}
        writeList();
    }
    /**retrieveRecord method attempts to return a record with an ID attribute that matches user input
     *
     *@return			If the for loop successfully matches an ID, the address is returned. Should the for loop fail, null(substance of nothing) is returned
     */
    public Address retrieveRecord(int id) {
        for (Address address : myList) {
            if (address.getIpID() == id) {
                return address;
            }
        }
        return null;
    }
    /**updateRecord method passes attributes into preexisting Address record
     */
    public void updateRecord(Address updatedAddress) {
        for (Address address : myList) {
            if (address.getIpID() == updatedAddress.getIpID()) {
                address.setShortIP(updatedAddress.getShortIP());
                address.setEntryDate(updatedAddress.getEntryDate());
                address.setNumAccess(updatedAddress.getNumAccess());
                break;
            }
        }
        writeList();
    }
    /**deleteRecord(int id) method matches input to preexisting address id attribute, address record is removed from the list of records
     *
     */
    public void deleteRecord(int id) {
        for (Address address : myList) {
            if (address.getIpID() == id) {
                myList.remove(address);
                break;
            }
        }
        writeList();
    }
    /**deleteRecord(Address address) method takes an address and deletes that address from the list of records
     *
     */
    public void deleteRecord(Address address) {
        myList.remove(address);
        writeList();
    }
    /**readList() method reads stored records from file named by fileName variable and attempts to assign record attributes to a new Address
     */
    protected void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String ip = data[1];
                String entrydate = data[2];
                int numAccess = Integer.parseInt(data[3]);
                Address address = new Address(id, ip, entrydate);
                myList.add(address);
            }
        } catch (IOException ioe) {
            System.out.println("Read file error with " + ioe.getMessage());
        }
    }
    /**writeList() method formats address atributes and writes them to a file named by the string stored in fileName variable
     */
    protected void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Address address : myList) {
                writer.write(String.format("%d,%s,%s,%d\n",
                        address.getIpID(),
                        address.getShortIP(),
                        address.getEntryDate(),
                        address.getNumAccess()
            ));}
        } catch (IOException ioe) {
            System.out.println("Write file error with " + ioe.getMessage());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        myList.stream().forEach((address) -> {
            sb.append(String.format("%5d : %s, %s, %d", address.getIpID(),
                    address.getShortIP(), address.getEntryDate(),
                    address.getNumAccess()));
        });

        return sb.toString();
    }
}
