
/**
 * FilterToHighAsianPerc filters the dataset to only rows with Asian percentage
 * larger than a certain threshold.
 *
 * @author Emily Yin, Shirley Lei
 * @version 4/24/2019
 */
public class FilterToHighAsianPerc implements FilterPredicate<Row> {
  private final double HIGH_RATE = 60;
  /**
   * Determines whether the Asian percentage in a row is greater than given high rate.
   *
   * @param element the row to be filtered through for its year
   * @return true if the Asian percentage is greater than given high rate, false otherwise
   */
  public boolean apply(Row element) {
    return element.getDataValue("percAsian")>HIGH_RATE;
  }
}
