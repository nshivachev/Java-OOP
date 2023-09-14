package workingWithAbstractionLab.studentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentsByName;

    public StudentSystem() {
        this.studentsByName = new HashMap<>();
    }

    public void parseCommand(String[] tokens) {
        String command = tokens[0];
        String name = tokens[1];

        if (command.equals("Create")) {
            int age = Integer.parseInt(tokens[2]);
            double grade = Double.parseDouble(tokens[3]);

            if (!studentsByName.containsKey(name)) {
                Student student = new Student(name, age, grade);
                studentsByName.put(name, student);
            }
        } else if (command.equals("Show")) {
            Student student = studentsByName.get(name);

            if (student != null) {
                System.out.println(student.getInfo());
            }
        }
    }
}
