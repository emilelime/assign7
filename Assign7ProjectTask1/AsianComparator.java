import java.util.Comparator;
/**
 * Write a description of class AsianComparator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AsianComparator implements Comparator<Row> {
    /**
    * //implements compare(), returns 0 or -1 or 1 finish this
    */
  
  public int compare(Row row1, Row row2) {
    double asianDiff = row1.getDataValue("percAsian") - row2.getDataValue("percAsian");
    return asianDiff < 0.0 ? 1:
      asianDiff == 0.0 ? 0 : -1;
  }

}