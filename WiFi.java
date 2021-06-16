  /** WiFi sub-class of WirelessNetwork.
 *    @author Adam Bostwick
 *    @version 11/08/2019
 */

public class WiFi extends WirelessNetwork
   //implements Comparable<WiFi>
{
   private double modemCost;
   
 /** constructor.
    * @param nameIn input for name
    * @param bandwidthIn input for bandwidth
    * @param fixedCostIn input for fixedCost
    * @param modemCostIn input for modemCost
    */

   public WiFi(String nameIn, double bandwidthIn, double fixedCostIn, 
      double modemCostIn)
   {
      super(nameIn, bandwidthIn, fixedCostIn);
      modemCost = modemCostIn;
   }
   
 /** getModemCost.
  * @return true
  */
   public double getModemCost()
   {
      return modemCost;
   }
   
 /** setModemCost.
  *  @param modemCostIn input for modemCost
  */

   public void setModemCost(double modemCostIn)
   {
      modemCost = modemCostIn;
   }
   
 /** monthlyCost.
  * @return true
  */
   public double monthlyCost()
   {
      double total = fixedCost + modemCost;
      return total;
   }
   
}