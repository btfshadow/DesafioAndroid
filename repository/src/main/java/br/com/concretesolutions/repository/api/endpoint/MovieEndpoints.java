package br.com.concretesolutions.repository.api.endpoint;

public final class MovieEndpoints {
    private static final String BASE_PATH = "movie/";

    public static final String nowPlaying = BASE_PATH + "now_playing";
    public static final String popular = BASE_PATH + "popular";
    public static final String topRated = BASE_PATH + "top_rated";
    public static final String upcoming = BASE_PATH + "upcoming";

    private MovieEndpoints() {
    }
}
