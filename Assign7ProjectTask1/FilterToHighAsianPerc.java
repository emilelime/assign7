
/**
 * Write a description of class FilterToHighAsianPerc here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FilterToHighAsianPerc implements FilterPredicate<Row> {
  private final double HIGH_RATE = 60;
  public boolean apply(Row element) {
    return element.getDataValue("percAsian")>HIGH_RATE;
  }
}
