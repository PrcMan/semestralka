import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
/**
 * Write a description of class T1Data here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class T1Data extends JPanel {
    private final JTable table;
    /**
     * Constructor for objects of class T1Data
     */
    public T1Data() {
        super(new BorderLayout(3, 3));
        this.table = new JTable(new MusicLibrary());
        this.table.setPreferredScrollableViewportSize(new Dimension(700, 70));
        this.table.setFillsViewportHeight(true);
        JPanel ButtonOpen = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.add(ButtonOpen, BorderLayout.SOUTH);
        // Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(this.table); 
        // Add the scroll pane to this panel.
        this.add(scrollPane, BorderLayout.CENTER);
        // add a nice border
        this.setBorder(new EmptyBorder(5, 5, 5, 5));
        CSVFile Rd = new CSVFile();
        MusicLibrary NewModel = new MusicLibrary();
        this.table.setModel(NewModel);
        File DataFile = new File("Library.csv");
        ArrayList<Entry[]> Rs2 = Rd.ReadCSVfile(DataFile);
        NewModel.AddCSVData(Rs2);
        System.out.println("Rows: " + NewModel.getRowCount());
        System.out.println("Cols: " + NewModel.getColumnCount());
    }


    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("T1Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create and set up the content pane.
        T1Data newContentPane = new T1Data();
        frame.setContentPane(newContentPane);
        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
