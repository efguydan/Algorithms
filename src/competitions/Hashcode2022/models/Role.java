package competitions.Hashcode2022.models;

import java.util.ArrayList;

public class Role {

    public String name;
    public int level;

    public Role() {
    }

    public Role(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
