package competitions.Hashcode2022.models;

import java.util.ArrayList;

public class Contributor {

    public String name;
    public ArrayList<Skill> skills;
    public int numProjects = 0;

    public Contributor() {
    }

    public Contributor(String name, ArrayList<Skill> skills) {
        this.name = name;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Contributor{" +
                "name='" + name + '\'' +
                ", skills=" + skills +
                '}';
    }

    public Skill hasSkill(String name) {
        for (Skill skill : skills) {
            if (skill.name.equals(name)) return skill;
        }
        return null;
    }

    public void addWork() {
        numProjects++;
    }
}
