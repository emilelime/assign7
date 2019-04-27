import java.util.Comparator;
/**
 * AsianComparator compares two rows in the data to determine which row has a higher percentage of Asians.
 *
 * @author Emily Yin, Shirley Lei
 * @version April 26, 2019
 */
public class AsianComparator implements Comparator<Row> {
    /**
     * Implements Comparator to determine which row between two rows has a higher percentage of Asians.
     *
     * @ param row1 row2 two rows in the dataset
     * @ return 0 if the two rows have the same Asian percentage, 1 if row1 has a higher Asian percentage,
     * -1 if row2 has a higher Asian percentage.
     */
    public int compare(Row row1, Row row2) {
        double asianDiff = row1.getDataValue("percAsian") - row2.getDataValue("percAsian");
        return asianDiff > 0.0 ? 1:
            asianDiff == 0.0 ? 0 : -1;
    }
}
