/*
 * Made for purposes connected with semestral work
 * Copying and other editing without permission of the author
 * is strictly prohibited and is punishable by law. This work is by
 * all means property of the author.
 */

/**
 * @author krama
 */
public class Entry {
    private String aSong;
    private String aAlbum;
    private String aBand;
    private int aYear;
    private int aDuration;
    private Genre aGenre;

    /**
     * @param paSong
     * @param paAlbum
     * @param paBand
     * @param paYear
     * @param paDuration
     * @param paGenre
     */
    public Entry(String paSong, String paAlbum, String paBand, int paYear, int paDuration, Genre paGenre) {
        this.aSong = paSong;
        this.aAlbum = paAlbum;
        this.aBand = paBand;
        this.aYear = paYear;
        this.aDuration = paDuration;
        this.aGenre = paGenre;
    }

    public Entry(String paCSLine) {
        String[] parts = paCSLine.split("\\|");
        this.aSong = parts[0];
        this.aBand = parts[1];
        this.aAlbum = parts[2];
        for (Genre genre : Genre.values()) {
            if (parts[3].equals(genre.toString())) {
                this.aGenre = genre;
            }
        }
        if (this.aGenre == null) {
            this.aGenre = Genre.OTHER;
        }
        this.aYear = Integer.parseInt(parts[5]);
        this.aDuration = Integer.parseInt(parts[4]);
    }

    /**
     * Getter for song
     *
     * @return song
     */
    public String getSong() {
        return this.aSong;
    }

    /**
     * @param paSong
     */
    public void setSong(String paSong) {
        this.aSong = paSong;
    }

    /**
     * Getter for album
     *
     * @return album
     */
    public String getAlbum() {
        return this.aAlbum;
    }

    /**
     * @param paAlbum
     */
    public void setAlbum(String paAlbum) {
        this.aAlbum = paAlbum;
    }

    /**
     * @return
     */
    public String getBand() {
        return this.aBand;
    }

    /**
     * @param paBand
     */
    public void setBand(String paBand) {
        this.aBand = paBand;
    }

    public int getYear() {
        return this.aYear;
    }

    public void setYear(int paYear) {
        this.aYear = paYear;
    }

    public int getDuration() {
        return this.aDuration;
    }

    public void setDuration(int paDuration) {
        this.aDuration = paDuration;
    }

    public Genre getGenre() {
        return this.aGenre;
    }

    public void setGenre(Genre paGenre) {
        this.aGenre = paGenre;
    }

    public String toString() {
        return "Skladba: " + this.aSong
                + " Album: " + this.aAlbum
                + " Kapela: " + this.aBand
                + " Žáner: " + this.aGenre.toString()
                + " Rok: " + this.aYear
                + " Dĺžka: " + this.aDuration + "s";
    }

    public String[] toArray() {
        return new String[]{this.aSong,
                this.aBand,
                this.aAlbum,
                this.aGenre.toString(),
                Integer.toString(this.aDuration),
                Integer.toString(this.aYear)};
    }

    public String toCSV(String deliminator){
        return this.aSong + deliminator
                + this.aBand + deliminator
                + this.aAlbum + deliminator
                + this.aGenre.toString() + deliminator
                + Integer.toString(this.aDuration) + deliminator
                + Integer.toString(this.aYear) + "\n";
    }

    public boolean has(String query) {
        if (query.length() > 0) {
            for (String item : this.toArray()) {
                if (item.toLowerCase().matches("(.*)" + query.toLowerCase() + "(.*)")) {
                    return true;
                }
            }
        }
        return false;
    }
}
