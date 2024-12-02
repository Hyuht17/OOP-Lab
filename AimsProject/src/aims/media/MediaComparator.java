package aims.media;

import java.util.Comparator;

public class MediaComparator {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = Comparator
            .comparing(Media::getTitle)
            .thenComparing(Comparator.comparing(Media::getCost).reversed());

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = Comparator
            .comparing(Media::getCost).reversed()
            .thenComparing(Media::getTitle);
}
