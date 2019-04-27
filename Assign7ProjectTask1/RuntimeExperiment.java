import java.io.IOException;
/**
 * RuntimeExperiment tests the efficiency of two sorting algorithms (MergeSort and SelectionSort) 
 * by determining the amount of time it takes for a dataset of various sizes to run.
 *
 * @author Emily Yin, Shirley Lei
 * @version 4/24/2019
 */
public class RuntimeExperiment {
    private static final long NANOSECONDS_PER_SECOND = 1_000_000_000; // A billionth of a second (10^9)
    private static final long NANOSECONDS_PER_MILLISECOND = 1_000_000; // A millionth of a second (10^6)
    /**
     * Runs each sorting algorithm 
     * on the following sizes of data: {20_000, 40_000, 60_000, 80_000, 100_000}, and prints out runtimes 
     * for each algorithm on each size of data.
     *
     * @param args command line arguments, unused in this case
     * 
     */
    public static void main(String[] args) {
        try {
            Reader r = new Reader("eviction.csv", 100000);
            FilterableDataset fs = r.getDataset();
            //int fssize = fs.size();
            //System.out.println("size of fdb: " + fssize);
            long start = System.nanoTime();
            Sorting.selectionSort(fs, new EvictionComparator());
            //Sorting.mergeSort(fs, new EvictionComparator());
            long end = System.nanoTime();
            long durationInNanoseconds = end - start;
            long durationInSeconds = durationInNanoseconds/NANOSECONDS_PER_SECOND;
            //System.out.println("size of fdb: " + fssize);
            System.out.println("Runtime of this sorting method was (ns): " + durationInNanoseconds);
            //System.out.println("Runtime of this sorting method was (s): " + durationInSeconds);
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
