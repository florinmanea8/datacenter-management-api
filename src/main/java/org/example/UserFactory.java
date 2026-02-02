package org.example;

public class UserFactory {
    public static User createUser(String name, String role, String email, String department, String clearance) {
        if (!clearance.isEmpty()) {
            return new Admin(name, role, email, department, Integer.parseInt(clearance));
        } else if (!department.isEmpty()) {
            return new Operator(name, role, email, department);
        } else {
            return new User(name, role, email);
        }
    }
}
