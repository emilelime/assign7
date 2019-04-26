
/**
 * FilterToLowEvictionRate can be used to filter a dataset by eviction rate for values that are less
 * than a set threshold. 
 *
 * @author Emily Yin, Shirley Lei
 * @version 4/24/2019
 */
public class FilterToLowEvictionRate implements FilterPredicate<Row> {
    private final double LOW_RATE = 0.01;
    /**
     * Determines whether the eviction rate in a row is less than the threshold for a low eviction rate.
     *  
     * @param element the row to be filtered through for its eviction rate
     * @return boolean true if the eviction rate is less than the set threshold in this given row
     */
    public boolean apply(Row element) {
        return element.getDataValue("evictionRate")<LOW_RATE;
    }
}
