package com.skilltracker;

import java.util.ArrayList;
import java.util.Scanner;

public class SkillTrackerApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Skill> skills = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("================================");
        System.out.println("        SKILL TRACKER");
        System.out.println("================================");

        while (running) {
            showMenu();
            int choice = readInt("Choose an option: ");
            switch (choice) {
                case 1: addSkill(); break;
                case 2: viewSkills(); break;
                case 3: updateSkill(); break;
                case 4: deleteSkill(); break;
                case 5: searchSkill(); break;
                case 0:
                    running = false;
                    System.out.println("Thank you for using SkillTracker!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\\n1. Add Skill");
        System.out.println("2. View All Skills");
        System.out.println("3. Update Skill");
        System.out.println("4. Delete Skill");
        System.out.println("5. Search Skill");
        System.out.println("0. Exit");
    }

    private static void addSkill() {
        System.out.print("Enter skill name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Skill name cannot be empty.");
            return;
        }
        System.out.print("Enter category (e.g. Programming, Database): ");
        String category = scanner.nextLine().trim();
        if (category.isEmpty()) category = "General";
        int level = readLevel();
        skills.add(new Skill(nextId++, name, category, level));
        System.out.println("Skill added successfully.");
    }

    private static void viewSkills() {
        if (skills.isEmpty()) {
            System.out.println("No skills found. Add your first skill!");
            return;
        }
        System.out.println("\\nID    SKILL                  CATEGORY           PROFICIENCY");
        System.out.println("------------------------------------------------------------");
        for (Skill skill : skills) System.out.println(skill);
    }

    private static void updateSkill() {
        Skill skill = findById(readInt("Enter skill ID to update: "));
        if (skill == null) {
            System.out.println("Skill not found.");
            return;
        }
        System.out.print("New skill name (press Enter to keep current): ");
        String name = scanner.nextLine().trim();
        if (!name.isEmpty()) skill.setName(name);

        System.out.print("New category (press Enter to keep current): ");
        String category = scanner.nextLine().trim();
        if (!category.isEmpty()) skill.setCategory(category);

        System.out.print("Update proficiency level? (y/n): ");
        String answer = scanner.nextLine().trim();
        if (answer.equalsIgnoreCase("y")) skill.setProficiency(readLevel());

        System.out.println("Skill updated successfully.");
    }

    private static void deleteSkill() {
        int id = readInt("Enter skill ID to delete: ");
        Skill skill = findById(id);
        if (skill == null) {
            System.out.println("Skill not found.");
            return;
        }
        skills.remove(skill);
        System.out.println("Skill deleted successfully.");
    }

    private static void searchSkill() {
        System.out.print("Enter skill name to search: ");
        String keyword = scanner.nextLine().trim().toLowerCase();
        boolean found = false;
        for (Skill skill : skills) {
            if (skill.getName().toLowerCase().contains(keyword)) {
                if (!found) {
                    System.out.println("\\nID    SKILL                  CATEGORY           PROFICIENCY");
                    System.out.println("------------------------------------------------------------");
                }
                System.out.println(skill);
                found = true;
            }
        }
        if (!found) System.out.println("No matching skills found.");
    }

    private static Skill findById(int id) {
        for (Skill skill : skills) {
            if (skill.getId() == id) return skill;
        }
        return null;
    }

    private static int readLevel() {
        while (true) {
            int level = readInt("Proficiency (1-Beginner, 2-Basic, 3-Intermediate, 4-Advanced, 5-Expert): ");
            if (level >= 1 && level <= 5) return level;
            System.out.println("Please enter a number from 1 to 5.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
