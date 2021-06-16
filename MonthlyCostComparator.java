import java.util.Comparator;
/** MonthlyCostComparator.
 * @author Adam Bostwick
 * @version 11.18.19
 */
public class MonthlyCostComparator implements Comparator<WirelessNetwork>
{
   /** compare.
    * @return true
    * @param mc1 input first compare
    * @param mc2 input second compare
    */
   public int compare(WirelessNetwork mc1, WirelessNetwork mc2)
   {
      if (mc1.monthlyCost() < mc2.monthlyCost()) {
         return 1;
      }
      else if (mc1.monthlyCost() > mc2.monthlyCost()) {
         return -1;
      }
      else {
         return 0;
      }
   }
}