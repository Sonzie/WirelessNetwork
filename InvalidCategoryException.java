/** WirelessNetworksPart2.
 * @author Adam Bostwick
 * @version 12.1.19
 */

public class InvalidCategoryException extends Exception
{            
   /**yeup. 
    * @param categoryIn input
   */
   public InvalidCategoryException(String categoryIn)
   {
      super("For category: " + categoryIn);
   }
   
}