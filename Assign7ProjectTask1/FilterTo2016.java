
/**
 * Write a description of class FilterTo2016 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FilterTo2016 implements FilterPredicate<Row> {
  private final int YEAR = 2016;
  public boolean apply(Row element) {
    return element.getDataValue("year")==YEAR;
  }
}
