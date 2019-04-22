
/**
 * Write a description of class FilterToLowEvictionRate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FilterToLowEvictionRate implements FilterPredicate<Row> {
  private final double LOW_RATE = 0.01;
  public boolean apply(Row element) {
    return element.getDataValue("evictionRate")<LOW_RATE;
  }
}
