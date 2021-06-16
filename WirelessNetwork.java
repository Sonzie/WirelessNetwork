import java.text.DecimalFormat;

/** Wireless network parent class.
 *    @author Adam Bostwick
 *    @version 11/08/2019
 */
public abstract  class WirelessNetwork
   implements Comparable<WirelessNetwork>
{
   protected String name;
   protected double bandwidth;
   protected double fixedCost; //monthly fixed cost
   
   protected static int count = 0; //number of WirelessNetwork objects
   
   /** constructor.
    * @param nameIn input for name
    * @param bandwidthIn input for bandwidth
    * @param fixedCostIn input for fixedCost
    */
   public WirelessNetwork(String nameIn, double bandwidthIn, double fixedCostIn)
   {
      name = nameIn;
      bandwidth = bandwidthIn;
      fixedCost = fixedCostIn;
      count++;
   }
   
   /** getName.
    * @return true
    */
   public String getName()
   {
      return name;
   }
   
   /** setName.
    * @param nameIn input for name
    */
   public void setName(String nameIn)
   {
      name = nameIn;
   }
   
   /** getBandwidth.
    * @return true
    */
   public double getBandwidth()
   {
      return bandwidth;
   }
   
   /** setBandwidth.
    * @param bandwidthIn input for bandwidth
    */
   public void setBandwidth(double bandwidthIn)
   {
      bandwidth = bandwidthIn;
   }
   
   /** getMonthlyFixedCost.
    * @return true
    */
   public double getMonthlyFixedCost()
   {
      return fixedCost;
   }
   
   /** setMonthlyFixedCost.
    * @param fixedCostIn input for fixedCost
    */
   public void setMonthlyFixedCost(double fixedCostIn)
   {
      fixedCost = fixedCostIn;
   }
   
   /** compareTo.
    * @return true
    * @param compareNetIn input for compareNet
    */
    
   public int compareTo(WirelessNetwork compareNetIn)
   {
      return this.getName().compareToIgnoreCase(compareNetIn.getName());
   }
   
   /** getCount.
    * @return true
    */
   public static int getCount()
   {
      return count;
   }
   
   /** resetCount.
    * 
    */
   public static void resetCount()
   {
      count = 0;
   }
   
   /** toString.
    * @return true
    */
   public String toString()
   {
      DecimalFormat moneyForm = new DecimalFormat("###,###,##0.00");
      return name + " (" + getClass() + ") Cost: $"
         + moneyForm.format(monthlyCost()) 
         + "\nBandwidth: " + getBandwidth() + " Mbps";
   }
   
   /** monthlyCost.
    * @return true
    */
    
   public abstract double monthlyCost();
   

}