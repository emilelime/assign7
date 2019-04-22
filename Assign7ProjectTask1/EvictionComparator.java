import java.util.Comparator;
/**
 * Write a description of class EvictionComparator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EvictionComparator implements Comparator<Row> {
    /**
    * //implements compare(), returns 0 or -1 or 1 finish this
    */
  
  public int compare(Row row1, Row row2) {
    double evictionDiff = row1.getDataValue("evictionRate") - row2.getDataValue("evictionRate");
    return evictionDiff > 0.0 ? 1:
      evictionDiff == 0.0 ? 0 : -1;
  }

}