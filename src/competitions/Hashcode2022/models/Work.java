package competitions.Hashcode2022.models;

import java.util.ArrayList;
import java.util.HashSet;

public class Work {

    public Project project;
    public ArrayList<Contributor> contributors;

    public Work() {
    }

    public Work(Project project, ArrayList<Contributor> contributors) {
        this.project = project;
        this.contributors = contributors;
    }

    @Override
    public String toString() {
        return "Work{" +
                "project=" + project.toString() +
                ", contributors=" + contributors.toString() +
                '}';
    }
}
