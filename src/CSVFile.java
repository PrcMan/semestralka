
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
private final ArrayList<String[]> Rs = new ArrayList<String[]>();
        private String[] OneRow;

        public ArrayList<String[]> ReadCSVfile(File DataFile) {
            try {
                BufferedReader brd = new BufferedReader(new FileReader(DataFile));
                while (brd.ready()) {
                    String st = brd.readLine();
                    //OneRow = st.split(",|\\s|;");
                    this.OneRow = st.split("\\|");
                    this.Rs.add(this.OneRow);
                   
                    System.out.println(Arrays.toString(this.OneRow));
                } // end of while
            } // end of try
            catch (IOException e) {
                String errmsg = e.getMessage();
                System.out.println("File not found:" + errmsg);
            } // end of Catch
            return this.Rs;
        } // end of ReadFile method   
}
