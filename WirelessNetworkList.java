import java.util.Arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/** WirelessNetworkList.
 * @author Adam Bostwick
 * @version 11.18.19
 */
public class WirelessNetworkList
{
   
   private WirelessNetwork[] networkList;
   private String[] invalidList;
   /** Constructor.
    *
    */
   public WirelessNetworkList()
   {
      networkList = new WirelessNetwork[0];
      invalidList = new String[0];
   }
   
   /** getWirelessNetworksArray.
    * @return true
    */
   public WirelessNetwork[] getWirelessNetworksArray()
   {  
      return networkList;
   }
   
   /** getInvalidRecordsArray.
    * @return true
    */
   public String[] getInvalidRecordsArray()
   {
      return invalidList;
   }
   
   /** addWirelessNetwork.
    * @param newNetworkIn input for new network
    */
   public void addWirelessNetwork(WirelessNetwork newNetworkIn)
   {
      networkList = Arrays.copyOf(networkList, networkList.length + 1);
      networkList[networkList.length - 1] = newNetworkIn;
   }
   
   /** addInvalidRecord.
    * @param invalidIn input for invalid
    * @throws FileNotFoundException true
    */
   public void addInvalidRecord(String invalidIn)
   {
      invalidList = Arrays.copyOf(invalidList, invalidList.length + 1);
      invalidList[invalidList.length - 1] = invalidIn;
   }
   
   /** readFile.
    * @param fileNameIn input for file name
    * throws InvalidCategoryException true
    * @throws FileNotFoundException true
    * @throws NoSuchElementException true
    * @throws NumberFormatException true
    */
   public void readFile(String fileNameIn)
      throws /*InvalidCategoryException,*/ FileNotFoundException, 
      NumberFormatException, NoSuchElementException
   {
      File fileToRead = new File(fileNameIn);
      Scanner fileReader = new Scanner(fileToRead);
      //fileReader.useDelimiter(",|\\n");
      
      Scanner toParts = null;
      String line = "";
      char category;
      String name;
      double bandwidth;
      double fixedCost;
      double modemCost;
      double time;
      double dataLimit;
      String invalid;
      
      while (fileReader.hasNext())
      {
         try
         {
            line = fileReader.nextLine();
         
            toParts = new Scanner(line);
            toParts.useDelimiter(",");
         
            category = toParts.next().trim().toUpperCase().charAt(0);
            name = toParts.next().trim();
            bandwidth = Double.parseDouble(toParts.next().trim());
            fixedCost = Double.parseDouble(toParts.next().trim());
         
            switch(category)
            {
               case 'W':
                  modemCost = 
                     Double.parseDouble(toParts.next().trim());
                  this.addWirelessNetwork(
                     new WiFi(name, bandwidth, fixedCost, modemCost));
                  break;
            
               
               case 'C':
                  time = Double.parseDouble(toParts.next().trim());
                  dataLimit = Double.parseDouble(toParts.next().trim());
                  this.addWirelessNetwork(new Cellular(name, 
                     bandwidth, fixedCost, time, dataLimit));
                  break;
               
               case 'L':
                  time = Double.parseDouble(toParts.next().trim());
                  dataLimit = Double.parseDouble(toParts.next().trim());
                  this.addWirelessNetwork(new LTE(name, 
                     bandwidth, fixedCost, time, dataLimit));
                  break;
               
               case 'F':
                  time = Double.parseDouble(toParts.next().trim());
                  dataLimit = Double.parseDouble(toParts.next().trim());
                  this.addWirelessNetwork(new FiveG(name,
                     bandwidth, fixedCost, time, dataLimit));
                  break;
               
               default:
                  //this.addInvalidRecord(line);
                  throw new InvalidCategoryException("" + category);
                  
                  //break;
            }
               
         }
         catch (InvalidCategoryException ice)
         {
            invalid = line + "\n" + ice;
            addInvalidRecord(invalid);
         }
         catch (NumberFormatException nfe)
         {
            invalid = line + "\n" + nfe;
            addInvalidRecord(invalid);
         }
         catch (NoSuchElementException nsee)
         {
            invalid = line + "\n" + nsee + ": For missing input data";
            addInvalidRecord(invalid);
         }
      }
      fileReader.close();
   }
   
   /** generateReport.
    * @return true
    */
   public String generateReport()
   {
      String output = "-------------------------------\n"
         + "Monthly Wireless Network Report";
      output += "\n-------------------------------\n";
      for (int i = 0; i < networkList.length; i++)
      {
         output += networkList[i].toString() + "\n\n";
      }
      
      return output;
   
   }
   
   /** generateReportByName.
    * @return true
    */
   public String generateReportByName()
   {
      Arrays.sort(networkList);
      String output = "-----------------------------------------\n"
         + "Monthly Wireless Network Report (by Name)";
      output += "\n-----------------------------------------\n";
      for (int i = 0; i < networkList.length; i++)
      {
         output += networkList[i].toString() + "\n\n";
      }
      
      return output;
   }
   
   /** generateReportByBandwidth.
    * @return true
    */
   public String generateReportByBandwidth()
   {
      Arrays.sort(networkList, new BandwidthComparator());
      String output = "----------------------------------------------\n"
         + "Monthly Wireless Network Report (by Bandwidth)";
      output += "\n----------------------------------------------\n";
      for (int i = 0; i < networkList.length; i++)
      {
         output += networkList[i].toString() + "\n\n";
      }
      
      return output;
   }
   
   /** generateReportByMonthlyCost.
    * @return true
    */
   public String generateReportByMonthlyCost()
   {
      Arrays.sort(networkList, new MonthlyCostComparator());
      //Arrays.sort(networkList, Collections.reverseOrder());
      String output = "-------------------------------------------------\n"
         + "Monthly Wireless Network Report (by Monthly Cost)";
      output += "\n-------------------------------------------------\n";
      for (int i = 0; i < networkList.length; i++)
      {
         output += networkList[i].toString() + "\n\n";
      }
      
      return output;
   }
   
   /** generateInvalidRecordsReport.
    * @return true
    */
   public String generateInvalidRecordsReport()
   {
      String output = "----------------------\n"
                    + "Invalid Records Report";
      output +=     "\n----------------------\n";
      for (int i = 0; i < invalidList.length; i++)
      {
         output += invalidList[i].toString() + "\n\n";
      }
      
      return output;
   }
   

}