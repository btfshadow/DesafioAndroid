package br.com.concretesolutions.repository;


import br.com.concretesolutions.repository.api.type.RegionType;

public class MoviesRepository {

    private static MoviesRepository singleton = null;

    private MoviesRepository() {
    }

    public static MoviesRepository get() {
        if (singleton == null) {
            singleton = new MoviesRepository();
        }

        return singleton;
    }

    public static void nowPlaying(@RegionType String region, int page) {

    }
}
