
/**
 * FilterTo2016 filters the dataset to only information that corresponds to the year 2016. 
 *
 * @author Emily Yin, Shirley Lei
 * @version 4/24/2019
 */
public class FilterTo2016 implements FilterPredicate<Row> {
    private final int YEAR = 2016;
    /**
     * Determines whether the year in a row corresponds to year 2016. 
     *  
     * @param element the row to be filtered through for its year
     * @return boolean true if the year is equal to the set year in this row
     */
    public boolean apply(Row element) {
        return element.getYear()==YEAR;
    }
}
