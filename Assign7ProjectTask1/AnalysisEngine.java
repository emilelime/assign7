import java.io.IOException;

/**
 * Write a description of class AnalysisEngine here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AnalysisEngine {
    private static int getMedian(FilterableDataset subset) {

        int median; 
        int totalElt = subset.size();
        Sorting.selectionSort(subset, new EvictionComparator());
        //System.out.println("Subset size: " + totalElt);
        //if size of sub dataset is even
        if (totalElt % 2 == 0) {
            median = totalElt/2 + (totalElt/2 -1); 
            System.out.println("even median is row: " + median);

        } else { //if size of sub dataset is odd
            median = totalElt/2;
            System.out.println("odd median is row: " + median);
        }
        return median;
    }

    public static void main (String[] args) {
        try {
            Reader r = new Reader("eviction.csv", Integer.MAX_VALUE);
            //Create filterable dataset
            FilterableDataset fs = r.getDataset();
            //Filter dataset by 2016
            FilterableDataset subset2016 = fs.filterBy(new FilterTo2016());
            //1.
            //FilterableDataset subsetHighEviction = subset2016.filterBy(new FilterToHighEvictionRate());
            //System.out.println(subsetHighEviction);
            //Sorting.selectionSort(subsetHighEviction, new EvictionComparator());
            //System.out.println(subsetLowEviction); //? so many w zero -> cant test if method is right?
            // System.out.println("5 cities in 2016 with highest eviction rates:\n" 
            // + subsetHighEviction.get(0) + "\n"
            // + subsetHighEviction.get(1) + "\n"
            // + subsetHighEviction.get(2) + "\n"
            // + subsetHighEviction.get(3) + "\n"
            // + subsetHighEviction.get(4) + "\n");

            // //2.
            // FilterableDataset subsetLowEviction = subset2016.filterBy(new FilterToLowEvictionRate());
            // //System.out.println(subsetLowEviction);
            // Sorting.selectionSort(subsetLowEviction, new EvictionComparator());
            // //System.out.println(subsetLowEviction); //? so many w zero -> cant test if method is right?
            // System.out.println("5 cities in 2016 with lowest eviction rates:\n" 
            // + subsetLowEviction.get(0) + "\n"
            // + subsetLowEviction.get(1) + "\n"
            // + subsetLowEviction.get(2) + "\n"
            // + subsetLowEviction.get(3) + "\n" //? how to get range of rows rather than one at a time?/
            // + subsetLowEviction.get(4) + "\n"); 

            //3. test on smaller datasets, test on odds, evens
            int totalNumElts = subset2016.size();
            System.out.println("2016 dataset size: " + totalNumElts);
            if (totalNumElts % 2 == 0) {
                String evenMedianCity1 = (subset2016.get(getMedian(subset2016))).getName();
                String evenMedianCity2 = (subset2016.get(getMedian(subset2016)-1)).getName();
                double evenMedianEvictionRate = (subset2016.get(getMedian(subset2016))).getDataValue("evictionRate");
                System.out.println("The two cities with median eviction rates are: " + evenMedianCity1 + " and " + evenMedianCity2 + "\n" + 
                    " with an average median rate of " + evenMedianEvictionRate);
            } else {
                String oddMedianCity = (subset2016.get(getMedian(subset2016))).getName();
                double oddMedianEvictionRate = (subset2016.get(getMedian(subset2016))).getDataValue("evictionRate");
                System.out.println("The city with median eviction rate is: " + oddMedianCity + "\n" + 
                    " with a rate of " + oddMedianEvictionRate);
            }

        } catch(IOException e) {
            System.out.println(e);
        }
    }

}