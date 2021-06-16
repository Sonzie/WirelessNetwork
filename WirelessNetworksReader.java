import java.io.FileNotFoundException;
/** WirelessNetworksPart3.
 * @author Adam Bostwick
 * @version 11.18.19
 */
public class WirelessNetworksReader
{
   /** main.
    * @param args input for file name
    * throws InvalidCategoryException true
    */
   public static void main(String[] args)
      //throws InvalidCategoryException
   {
      //Scanner userInput = new Scanner(System.in);
      if (args.length == 0)
      {
         System.out.print("File name expected as command line argument."
            + "\nProgram ending.\n");
      }
      else
      {
      
         String filename = args[0];
      
         try
         {
            WirelessNetworkList myList = new WirelessNetworkList();
            myList.readFile(filename);
         
         
            String output = myList.generateReport()
               + myList.generateReportByName()
               + myList.generateReportByBandwidth()
               + myList.generateReportByMonthlyCost()
               + myList.generateInvalidRecordsReport();
               
            System.out.print(output);
         }
         catch (FileNotFoundException fnfe)
         {
            String errorMsg = fnfe + "";
            errorMsg = errorMsg.replace("java.io.FileNotFoundException", 
               "*** Attempted to read file");
            System.out.print(errorMsg);
            return; //System.exit(0);
         }
      }
   }
}