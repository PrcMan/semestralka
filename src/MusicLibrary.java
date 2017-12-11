/*
 * Made for purposes connected with semestral work
 * Copying and other editing without permission of the author
 * is strictly prohibited and is punishable by law. This work is by
 * all means property of the author.
 */


import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * @author krama
 */
public class MusicLibrary extends AbstractTableModel {
    private final String[] columnNames = {"Skladba", "Kapela", "Album", "Žáner", "Dĺžka", "Rok vydania"};
    private ArrayList<Entry> Data = new ArrayList<>();
    private ArrayList<Entry> fullData = new ArrayList<>();

    public void AddCSVData(ArrayList<Entry> DataIn) {
        this.Data = this.fullData = DataIn;
        this.fireTableDataChanged();
    }

    public void add(String paSong, String paAlbum, String paBand, int paYear, int paDuration, Genre paGenre) {
        this.fullData.add(new Entry(paSong, paAlbum, paBand, paYear, paDuration, paGenre));
        this.Data = this.fullData;
        this.fireTableDataChanged();
    }

    public void search(String query) {
        if (query.length() > 0) {
            ArrayList<Entry> queriedData = new ArrayList<>();
            this.fullData.forEach(entry -> {
                if (entry.has(query)) {
                    queriedData.add(entry);
                }
            });
            this.Data = queriedData;
        } else {
            this.Data = this.fullData;
        }
        this.fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }

    @Override
    public int getRowCount() {
        return this.Data.size();
    }

    @Override
    public String getColumnName(int col) {
        return this.columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        return this.Data.get(row).toArray()[col];
    }
}
