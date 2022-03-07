package competitions.Hashcode2022;

import competitions.Hashcode2022.models.*;

import java.io.*;
import java.util.*;

public class Solution {

    private ArrayList<Contributor> contributors = new ArrayList<>();
    private ArrayList<Project> projects = new ArrayList<>();
    private HashSet<Project> doneProjects = new HashSet<>();

    private ArrayList<Work> works = new ArrayList<>();

    public void parseInput(String filename) {
        int bufferSize = 8 * 1024;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename), bufferSize);

            String[] initialSplit = reader.readLine().split(" ");
            int numContributors = Integer.parseInt(initialSplit[0]);
            int numProjects = Integer.parseInt(initialSplit[1]);

            // Model Contributors
            for (int i = 0; i < numContributors; i++) {
                String[] firstLine = reader.readLine().split(" ");
                ArrayList<Skill> skills = new ArrayList<>();

                for (int j = 0; j < Integer.parseInt(firstLine[1]); j++) {
                    String[] secondLine = reader.readLine().split(" ");
                    skills.add(new Skill(secondLine[0], Integer.parseInt(secondLine[1])));
                }

                contributors.add(new Contributor(firstLine[0], skills));
            }

            // Model Projects
            for (int i = 0; i < numProjects; i++) {
                String[] firstLine = reader.readLine().split(" ");
                ArrayList<Role> roles = new ArrayList<>();

                for (int j = 0; j < Integer.parseInt(firstLine[4]); j++) {
                    String[] secondLine = reader.readLine().split(" ");
                    roles.add(new Role(secondLine[0], Integer.parseInt(secondLine[1])));
                }

                projects.add(new Project(
                        firstLine[0],
                        Integer.parseInt(firstLine[1]),
                        Integer.parseInt(firstLine[2]),
                        Integer.parseInt(firstLine[3]),
                        roles
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void simulate() {
        Collections.sort(projects, Comparator.comparingInt(o -> o.metric));
        ArrayList<Contributor> tempContributors = new ArrayList<>(contributors);

        for (Project project: projects) {
            if (doneProjects.contains(project)) continue;
            System.out.println(project.toString());
            ArrayList<Contributor> selectedContributors = new ArrayList<>();
            HashSet<Contributor> set = new HashSet<>();
            HashMap<String, Integer> allSkills = new HashMap<>();

            for (Role role : project.roles) {
                for (Contributor contributor: tempContributors) {
                    if (selectedContributors.contains(contributor)) continue;
                    Skill skill = contributor.hasSkill(role.name);
                    if (skill == null) continue;
                    if (skill.level >= role.level || (skill.level == role.level - 1 && allSkills.getOrDefault(role.name, 0) >= role.level)) {
                        selectedContributors.add(contributor);
                        set.add(contributor);
                        for (Skill s: contributor.skills) {
                            if (skill == s) continue;
                            int current = allSkills.getOrDefault(s.name, 0);
                            allSkills.put(skill.name, Math.max(s.level, current));
                        }
                        break;
                    }

                }
            }

            if (selectedContributors.size() == project.roles.size()) {
                works.add(new Work(project, selectedContributors));
                doneProjects.add(project);
                for (Contributor con: selectedContributors) {
                    con.addWork();
                    tempContributors.remove(con);
                }
                for (int i = 0; i < project.roles.size(); i++) {
                    Contributor contributor = selectedContributors.get(i);
                    Skill skill = contributor.hasSkill(project.roles.get(i).name);
                    if (skill != null && skill.level < project.roles.get(i).level) {
                        skill.level++;
                    }
                }
            }
        }
    }

    public void parseOutput(String filename) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(filename, "UTF-8");
            writer.println(works.size());
            for (Work work: works) {
                writer.println(work.project.name);
                for (Contributor con : work.contributors) {
                    writer.print(con.name);
                    writer.print(" ");
                }
                writer.println();
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
