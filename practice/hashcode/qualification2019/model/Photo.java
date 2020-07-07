package practice.hashcode.qualification2019.model;

import java.util.List;

public class Photo {

    int id;
    char orientation;
    List<String> tags;

    public Photo(int id, char orientation, List<String> tags) {
        this.id = id;
        this.orientation = orientation;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", orientation, tags.size(), tags.get(0));
    }
}
