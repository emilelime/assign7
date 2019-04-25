import java.io.IOException;
/**
 * Write a description of class RuntimeExperiment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RuntimeExperiment {
    private static final long NANOSECONDS_PER_SECOND = 1_000_000_000; // A billionth of a second (10^9)
    private static final long NANOSECONDS_PER_MILLISECOND = 1_000_000; // A millionth of a second (10^6)
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
            Reader r = new Reader("eviction.csv", 100000);
            FilterableDataset fs = r.getDataset();
            //FilterableDataset subsetHighEviction = fs.filterBy(new FilterTo2016()).filterBy(new FilterToHighEvictionRate());
            long start = System.nanoTime();
            //Sorting.selectionSort(subsetHighEviction, new EvictionComparator());
            Sorting.mergeSort(fs, new EvictionComparator());
            long end = System.nanoTime();
            long durationInNanoseconds = end - start;
            double durationInSeconds = durationInNanoseconds/NANOSECONDS_PER_SECOND; //? why this so short even tho 3sec irl
            System.out.println("Runtime of this sorting method was (seconds): " + durationInSeconds);
        } catch(IOException e) {
            System.out.println(e);
        }
    }
}
