# SkillTracker

A beginner-friendly Java console application to track skills and proficiency levels.

## Features
- Add a skill with a category and proficiency level
- View all saved skills
- Update a skill's name, category, or proficiency
- Delete a skill
- Search skills by name
- Input validation for menu choices and proficiency levels

## Proficiency scale
| Level | Description |
|---|---|
| 1 | Beginner |
| 2 | Basic |
| 3 | Intermediate |
| 4 | Advanced |
| 5 | Expert |

## Concepts used
- Classes and objects
- Encapsulation
- ArrayList
- Loops and conditional statements
- Methods
- Scanner input
- Basic input validation

## Requirements
- Java JDK 8 or later

## Run the application

Open a terminal in the project folder and run:

```bash
javac -d out src/com/skilltracker/*.java
java -cp out com.skilltracker.SkillTrackerApp
```

## Example skills
You can add skills such as Java, Spring Boot, React, SQL, Git, or Communication.

## Project structure

```text
SkillTracker/
├── src/
│   └── com/
│       └── skilltracker/
│           ├── Skill.java
│           └── SkillTrackerApp.java
├── README.md
└── .gitignore
```

## Future improvements
- Save skills to a file so data remains after the program closes
- Add dates for when a skill was last practiced
- Sort skills by proficiency
