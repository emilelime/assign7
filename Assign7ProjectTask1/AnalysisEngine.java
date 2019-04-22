import java.io.IOException;

/**
 * Write a description of class AnalysisEngine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AnalysisEngine {
    public static void main (String[] args) {
        try {
            Reader r = new Reader("eviction.csv", Integer.MAX_VALUE);
            //Create filterable dataset
            FilterableDataset fs = r.getDataset();
            //Filter dataset by 2016
            FilterableDataset subset2016 = fs.filterBy(new FilterTo2016());
            //1.
            //FilterableDataset subsetLowEviction = subset2016.filterBy(new FilterToLowEvictionRate());
            //System.out.println(subsetLowEviction);
            //2.
            //FilterableDataset subsetHighEviction = subset2016.filterBy(new FilterToHighEvictionRate());
            //System.out.println(subsetHighEviction);
            //3.
            //System.out.println("\nBefore sort: \n" + subset2016);
            Sorting.selectionSort(subset2016, new EvictionComparator());
            //System.out.println("\nAfter sort: \n" + subset2016);
            //What is the median eviction rate in 2016, and in what city did this rate occur?
            int length = subset2016.size(); //get total number of rows
            //System.out.println(length);
            System.out.println(getMedian(length));
            //Get city(cities) corresponding to median
        } catch(IOException e) {
            System.out.println(e);
        }
    }
    
    private static int getMedian(int length) {
        int median;
        if (length % 2 == 0) {
            int avgOfMiddleElements = values[totalElements / 2] + values[totalElements / 2 - 1];
            // calculate average of middle elements
            median = (avgOfMiddleElements) / 2;
        } else {
            // get the middle element
            median = (double) values[values.length / 2];
        }
        
    }
    
}