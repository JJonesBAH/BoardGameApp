import java.io.IOException;

/**
 * Created by developer on 4/22/2015.
 */
public class ApplicationDriver {

    public static void main (String[] args) throws IOException {
        CSVInFile csv = new CSVInFile();
        csv.runInput("C:\\Users\\developer\\Desktop\\examplecsv.txt");

    }

}
