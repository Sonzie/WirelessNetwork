import java.util.Comparator;
/** BandwidthComparator.
 * @author Adam Bostwick
 * @version 11.18.19
 */
public class BandwidthComparator implements Comparator<WirelessNetwork>
{
   /** compare.
    * @return true
    * @param b1 input first compare
    * @param b2 input second compare
    */
   public int compare(WirelessNetwork b1, WirelessNetwork b2)
   {
      if (b1.getBandwidth() < b2.getBandwidth()) {
         return -1;
      }
      else if (b1.getBandwidth() > b2.getBandwidth()) {
         return 1;
      }
      else {
         return 0;
      }
   }
}