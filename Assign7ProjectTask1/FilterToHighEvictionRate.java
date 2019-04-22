
/**
 * Write a description of class FilterToHighEvictionRate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FilterToHighEvictionRate implements FilterPredicate<Row> {
  private final double HIGH_RATE = 5;
  public boolean apply(Row element) {
    return element.getDataValue("evictionRate")>HIGH_RATE;
  }
}
