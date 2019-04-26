import java.io.IOException;

/**
 * AnalysisEngine performs numerous analyses on the eviction dataset. 
 *
 * @author Emily Yin, Shirley Lei
 * @version 4/24/2019
 */
public class AnalysisEngine {
    /**
     * Gets the median row number in a dataset with numerous rows. If there is an even number of rows, it
     * takes the average of the two row numbers. If there is an odd number of rows, it takes the row number 
     * of that row. 
     *  
     * @param subset the FilterableDataset 
     * @return int the median row number 
     */
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

    /**
     * Driver method that reads from a dataset and performs analyses on certain fields in the dataset
     *  
     * @param args an array string (unused in this case)
     */
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
            // int totalNumElts = subset2016.size();
            // System.out.println("2016 dataset size: " + totalNumElts);
            // if (totalNumElts % 2 == 0) {
            // String evenMedianCity1 = (subset2016.get(getMedian(subset2016))).getName();
            // String evenMedianCity2 = (subset2016.get(getMedian(subset2016)-1)).getName();
            // double evenMedianEvictionRate = (subset2016.get(getMedian(subset2016))).getDataValue("evictionRate");
            // System.out.println("The two cities with median eviction rates are: " + evenMedianCity1 + " and " + evenMedianCity2 + "\n" + 
            // " with an average median rate of " + evenMedianEvictionRate);
            // } else {
            // String oddMedianCity = (subset2016.get(getMedian(subset2016))).getName();
            // double oddMedianEvictionRate = (subset2016.get(getMedian(subset2016))).getDataValue("evictionRate");
            // System.out.println("The city with median eviction rate is: " + oddMedianCity + "\n" + 
            // " with a rate of " + oddMedianEvictionRate);
            // }

            //4.

            FilterableDataset subsetHighAsianPerc = fs.filterBy(new FilterToHighAsianPerc());
            //System.out.println(subsetLowEviction);
            Sorting.selectionSort(subsetHighAsianPerc, new AsianComparator());
            //System.out.println(subsetLowEviction); //? so many w zero -> cant test if method is right?
            System.out.println("5 cities in 2016 with highest Asian percentage:\n" 
                + subsetHighAsianPerc.get(0) + "\n"
                + subsetHighAsianPerc.get(1) + "\n"
                + subsetHighAsianPerc.get(2) + "\n"
                + subsetHighAsianPerc.get(3) + "\n" //? how to get range of rows rather than one at a time?/
                + subsetHighAsianPerc.get(4) + "\n"); 

        } catch(IOException e) {
            System.out.println(e);
        }
    }

}