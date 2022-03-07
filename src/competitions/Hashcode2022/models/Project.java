package competitions.Hashcode2022.models;

import java.util.ArrayList;

public class Project {

    public String name;
    public int daysToComplete;
    public int score;
    public int bestBefore;
    public ArrayList<Role> roles;
    public int metric;

    public Project() {
    }

    public Project(String name, int daysToComplete, int score, int bestBefore, ArrayList<Role> roles) {
        this.name = name;
        this.daysToComplete = daysToComplete;
        this.score = score;
        this.bestBefore = bestBefore;
        this.roles = roles;
        this.metric = daysToComplete + bestBefore - roles.size() + score;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", daysToComplete=" + daysToComplete +
                ", score=" + score +
                ", bestBefore=" + bestBefore +
                ", roles=" + roles +
                '}';
    }
}
