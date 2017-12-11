/*
 * Made for purposes connected with semestral work
 * Copying and other editing without permission of the author
 * is strictly prohibited and is punishable by law. This work is by
 * all means property of the author.
 */

/**
 * @author krama
 */
public enum Genre {
    ROCK("Rock"),
    POP_PUNK("Pop-Punk"),
    PUNK("Punk"),
    ALTERNATIVE("Alternative"),
    METALCORE("Metalcore"),
    POST_HARDCORE("Post-Hardcore"),
    METAL("Metal"),
    HARDCORE("Hardcore"),
    DEATHCORE("Deathcore"),
    PUNK_ROCK("Punk-Rock"),
    HARD_ROCK("Hard Rock"),
    ELECTRONIC("Electronic"),
    RAP_ROCK("Rap-Rock"),
    POP("Pop"),
    VOICE_MEMO("Voice Memo"),
    RAP("Rap"),
    ELECTRONIC_ROCK("Electronic-Rock"),
    OTHER("Uncategorised"),
    REMIX("Remix");

    private String aGenre;

    Genre(String paGenre) {
        this.aGenre = paGenre;
    }

    @Override
    public String toString() {
        return aGenre;
    }
}
