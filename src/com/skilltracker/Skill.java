package com.skilltracker;

public class Skill {
    private int id;
    private String name;
    private String category;
    private int proficiency; // 1 to 5

    public Skill(int id, String name, String category, int proficiency) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.proficiency = proficiency;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getProficiency() { return proficiency; }

    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setProficiency(int proficiency) { this.proficiency = proficiency; }

    public String getLevelName() {
        switch (proficiency) {
            case 1: return "Beginner";
            case 2: return "Basic";
            case 3: return "Intermediate";
            case 4: return "Advanced";
            case 5: return "Expert";
            default: return "Unknown";
        }
    }

    @Override
    public String toString() {
        return String.format("%-5d %-22s %-18s %d/5 (%s)",
                id, name, category, proficiency, getLevelName());
    }
}
