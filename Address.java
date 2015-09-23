//package t2p1a;

/**
 *
 * @author Your Name Here
 */
public class Address {

    private int ipId;
    private String shortIP;
    private String entryDate;
    private int numAccess;

    public Address() {
        ipId = 0;
        shortIP = "";
        entryDate = "";
        numAccess = 0;
    }

    public Address(int ipId, String shortIP, String entryDate) {
        this.ipId = ipId;
        this.shortIP = shortIP;
        this.entryDate = entryDate;
       	numAccess = 1;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public int getIpID() {
        return ipId;
    }

    public void setIpID(int ipId) {
        this.ipId = ipId;
    }

    public String getShortIP() {
        return shortIP;
    }

    public void setShortIP(String shortIP) {
        this.shortIP = shortIP;
    }

    public int getNumAccess() {
        return numAccess;
    }

    public void setNumAccess(int numAccess) {
        this.numAccess = numAccess;
    }


    @Override
    public String toString() {
        return "IPAddress{" + "Entry ID=" + ipId + ", Short IP=" + shortIP 
                + ", Entry Creation Date=" + entryDate + ", # Times Accessed=" + numAccess + '}';
    }
}
