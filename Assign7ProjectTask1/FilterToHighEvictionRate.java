
/**
 * FilterToHighEvictionRate can be used to filter a dataset by eviction rate for values that are greater
 * than a set threshold. 
 *
 * @author Emily Yin, Shirley Lei
 * @version 4/24/2019
 */
public class FilterToHighEvictionRate implements FilterPredicate<Row> {
    private final double HIGH_RATE = 5; 
    /**
     * Determines whether the eviction rate in a row is greater than the threshold for a high eviction rate.
     *  
     * @param element the row to be filtered through for its eviction rate
     * @return boolean true if the eviction rate is higher than the set threshold in this given row false otherwise
     */
    public boolean apply(Row element) {
        return element.getDataValue("evictionRate")>HIGH_RATE;
    }
}
