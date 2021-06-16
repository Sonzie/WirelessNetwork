/** LTE sub-class of Cellular.
 *    @author Adam Bostwick
 *    @version 11/08/2019
 */

public class LTE extends Cellular
{
   /** constants.*/
   public static final double COST_FACTOR = 4;
   
   
   /** constructor.
    * @param nameIn input for name
    * @param bandwidthIn input for bandwidth
    * @param fixedCostIn input for fixedCost
    * @param timeIn input for time
    * @param dataLimitIn input for dataLimit
    */

   public LTE(String nameIn, double bandwidthIn, double fixedCostIn,
      double timeIn, double dataLimitIn)
   {
      super(nameIn, bandwidthIn, fixedCostIn, timeIn, dataLimitIn);
   }
   
   /** monthlyCost.
    * @return true
    */ 
   public double monthlyCost()
   {
      if (dataUsage() <= dataLimit)
      {
         return fixedCost;
      }
      else
      {
         return fixedCost + (dataUsage() - dataLimit) * LTE.COST_FACTOR * 2;
      }
   }

}