/** Cellular sub-class of WirelessNetwork.
 *    @author Adam Bostwick
 *    @version 11/08/2019
 */

public class Cellular extends WirelessNetwork
{
   protected double time;
   protected double dataLimit;
   
   /** constants. */
   public static final double COST_FACTOR = 1;
   
  /** constructor.
    * @param nameIn input for name
    * @param bandwidthIn input for bandwidth
    * @param fixedCostIn input for fixedCost
    * @param timeIn input for time
    * @param dataLimitIn input for dataLimit
    */
   public Cellular(String nameIn, double bandwidthIn, double fixedCostIn,
      double timeIn, double dataLimitIn)
   {
      super(nameIn, bandwidthIn, fixedCostIn);
      time = timeIn;
      dataLimit = dataLimitIn;
   }
   
  /** getTime.
* @return true
*/
   public double getTime()
   {
      return time;
   }

/** setTime.
 * @param timeIn input for time
 */
   public void setTime(double timeIn)
   {
      time = timeIn;
   }

/** getDataLimit.
 * @return true
 */
   public double getDataLimit()
   {
      return dataLimit;
   }

/** setDataLimit.
 * @param dataLimitIn inut for data limit
 */
   public void setDataLimit(double dataLimitIn)
   {
      dataLimit = dataLimitIn;
   }

/** dataUsage.
*  @return true
*/
   public double dataUsage()
   {
      return bandwidth / 8000 * time;
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
         return fixedCost + (dataUsage() - dataLimit) * Cellular.COST_FACTOR;
      }
   }

/** toString.
* @return true
*/
   public String toString()
   {
      return super.toString() + "\nTime: " + time + " seconds\nData Limit: "
         + dataLimit + " GB\nData Used: " + dataUsage() + " GB";
   }
 

   

}