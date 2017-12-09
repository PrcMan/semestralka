
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Made for purposes connected with semestral work
 * Copying and other editing without permission of the author
 * is strictly prohibited and is punishable by law. This work is by 
 * all means property of the author.
 */

/**
 *
 * @author krama
 */
public class CSVFile {
    public ArrayList<Entry> ReadCSVfile(File DataFile) {
        ArrayList<Entry> data = new ArrayList<Entry>();
        try {
            BufferedReader brd = new BufferedReader(new FileReader(DataFile));
            while (brd.ready()) {
                data.add(new Entry(brd.readLine()));
            }
        } catch (IOException e) {
            System.err.println("File not found:" + e.getMessage());
        }
        return data;
    }
}