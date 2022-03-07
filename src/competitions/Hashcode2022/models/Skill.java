package competitions.Hashcode2022.models;

public class Skill {

    public String name;
    public int level;

    public Skill() {
    }

    public Skill(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
