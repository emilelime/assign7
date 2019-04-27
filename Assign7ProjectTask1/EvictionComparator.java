import java.util.Comparator;
/**
 * EvictionComparator compares two rows to determine which row has a higher eviction rate.
 * 
 * @author Emily Yin, Shirley Lei
 * @version 4/24/2019
 */
public class EvictionComparator implements Comparator<Row> {
    /**
     * Implements Comparator to determine which row between two rows has a higher eviction rate.
     * 
     * @ param row1 row2 two rows in the dataset
     * @ return int 0 if the two rows have the same eviction rate, 
     * 1 if row1 has a higher eviction rate, -1 if row2 has a higher eviction rate
     */
    public int compare(Row row1, Row row2) {
        double evictionDiff = row1.getDataValue("evictionRate") - row2.getDataValue("evictionRate");
        return evictionDiff > 0.0 ? 1:
            evictionDiff == 0.0 ? 0 : -1;
    }
}