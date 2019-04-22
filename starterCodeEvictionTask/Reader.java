/**
 * filename: Reader.java
 * description: Takes a CSV datafile and converts it into a FilterableDataset.
 * date: 01/09/19
 * @author Angelina Li
 *
 * NOTE: Do NOT modify this class.
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Vector;
import fastcsv.*;

public class Reader {

    private final FilterableDataset data;

    /**
     * Constructor for Reader class. Given a path to where eviction data is being
     * stored on your local machine, as well as a number of rows desired, will
     * initialize a FilterableDataset containing the first numRows rows in the dataset.
     *
     * @param filepath - A filepath representing where the csv data file 
     *                   containing eviction data is kept. This can be either a
     *                   relative or absolute filepath - e.g. "eviction.csv" or
     *                   "Users/angie/Desktop/pset4/eviction.csv".
     * @param numRows -  The number of rows desired. Note that if you specify
     *                   more rows of data than exist in the dataset, you will
     *                   get the entire dataset.
     */
    public Reader(String filepath, int numRows) throws IOException {
        this.data = new FilterableDataset();

        File file = new File(filepath);
        CsvReader reader = new CsvReader();
        reader.setContainsHeader(true);

        try (CsvParser parser = reader.parse(file, StandardCharsets.UTF_8)) {
            CsvRow dataRow;
            int currentNumberRows = 0;
            while ( ((dataRow = parser.nextRow()) != null) && 
                    currentNumberRows < numRows ) {
                Row row = new Row(
                    dataRow.getField("name"),
                    dataRow.getField("state"),
                    getIntField(dataRow, "year"),
                    getDoubleField(dataRow, "population"),
                    getDoubleField(dataRow, "renter.occupied.households"),
                    getDoubleField(dataRow, "pct.renter.occupied"),
                    getDoubleField(dataRow, "poverty.rate"),
                    getDoubleField(dataRow, "pct.white"),
                    getDoubleField(dataRow, "pct.af.am"),
                    getDoubleField(dataRow, "pct.hispanic"),
                    getDoubleField(dataRow, "pct.am.ind"),
                    getDoubleField(dataRow, "pct.asian"),
                    getDoubleField(dataRow, "pct.nh.pi"),
                    getDoubleField(dataRow, "pct.multiple"),
                    getDoubleField(dataRow, "pct.other"),
                    getDoubleField(dataRow, "evictions"),
                    getDoubleField(dataRow, "eviction.rate"),
                    getDoubleField(dataRow, "eviction.filings"),
                    getDoubleField(dataRow, "eviction.filing.rate")
                );
                data.add(row);
                currentNumberRows++;
            }
        }
    }

    private static int getIntField(CsvRow row, String field) {
        return Integer.parseInt(row.getField(field));
    }

    private static double getDoubleField(CsvRow row, String field) {
        return Double.parseDouble(row.getField(field));
    }

    public final FilterableDataset getDataset() {
        return this.data;
    }

    /**
     * Some starter code to help you understand how filterBy works.
     */
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader(
            "/Users/angie/Desktop/Code/in_progress/mellon-grant/data/eviction.csv", 
            1000);
        FilterableDataset dataset = reader.getDataset();
        System.out.println("first element: " + dataset.get(0)); // Holland
        System.out.println("dataset size: " + dataset.size());
        
        FilterableDataset subset = dataset.filterBy(new NameStartsWithA());
        System.out.println("subset first element: " + subset.get(0)); // Astor
        System.out.println("subset size: " + subset.size());
    }
}

class NameStartsWithA implements FilterPredicate<Row> {
    public boolean apply(Row element) {
        return !element.getName().isEmpty() &&
                Character.toUpperCase(element.getName().charAt(0)) == 'A';
    }
}