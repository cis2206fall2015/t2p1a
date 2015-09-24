//package t2p1a;

/**Address Class: Contains the framework and means of conveyance for record attributes
 *
 * @author Marshall Ehlinger
 * @author Jon VanZile
 * @author John Phillips (Initial source code)
 */
public class Address {

    private int ipId;
    private String shortIP;
    private String entryDate;
    private int numAccess;

    /**Initialises default values when a new Address is instantiated
     *
     */
    public Address() {
        ipId = 0;
        shortIP = "";
        entryDate = "";
        numAccess = 0;
    }
    /**Passes input into Address attributes
     *
     *@param ipId			(integer) ID attribute of a record
     *@param shortIp			(string)  First two sets of digits for user input IP Address
     *@param entryDate			(string)  Date attribute of a record
     */
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
