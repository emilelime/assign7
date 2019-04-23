import java.io.IOException;
/**
 * Write a description of class RuntimeExperiment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RuntimeExperiment {
    private static final long NANOSECONDS_PER_SECOND = 1_000_000_000; // A billionth of a second (10^9)
    private static final long NANOSECONDS_PER_MILLISECOND = 1_000_000; // A billionth of a second (10^9)
    /**
     * Runs each sorting algorithm on the following sizes of data: 
     * {20_000, 40_000, 60_000, 80_000, 100_000}, and prints out runtimes 
     * for each algorithm on each size of data.
     *
     * @param  args  command line arguments, unused in this case
     * 
     */
    public static void main(String[] args) {
        try {
            Reader r = new Reader("eviction.csv", Integer.MAX_VALUE);
            FilterableDataset fs = r.getDataset();
            FilterableDataset subsetHighEviction = fs.filterBy(new FilterTo2016()).filterBy(new FilterToHighEvictionRate());
            long start = System.nanoTime();
            Sorting.selectionSort(subsetHighEviction, new EvictionComparator());
            long end = System.nanoTime();
            long durationInNanoseconds = end - start;
            double durationInMS = durationInNanoseconds/NANOSECONDS_PER_MILLISECOND; //? why this so short even tho 3sec irl
            System.out.println("Runtime of this sorting method was (milliseconds): " + durationInMS);
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
