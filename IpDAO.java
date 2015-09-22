//package t2p1a;

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

/**
 *
 * @author Your Name Here
 */
public class IpDAO {

    private final String fileName;
    protected final List<Address> myList;

    public IpDAO() {
        this("ipdata.txt");
    }

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

    public void createRecord(Address address) {
        myList.add(address);
        writeList();
    }

    public Address retrieveRecord(int id) {
        for (Address address : myList) {
            if (address.getIpID() == id) {
                return address;
            }
        }
        return null;
    }

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

    public void deleteRecord(int id) {
        for (Address address : myList) {
            if (address.getIpID() == id) {
                myList.remove(address);
                break;
            }
        }
        writeList();
    }

    public void deleteRecord(Address address) {
        myList.remove(address);
        writeList();
    }

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
