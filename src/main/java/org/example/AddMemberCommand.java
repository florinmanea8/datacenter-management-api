package org.example;

import java.io.BufferedWriter;

public class AddMemberCommand implements Command {
    public void execute(String[] parts, BufferedWriter bw) throws Exception {
        String ip = parts[1];
        String name = parts[2];
        String role = parts[3];
        String email = parts[4];
        String department = parts[5];
        String clearance = parts[6];

        if (ip.isEmpty())
            throw new MissingIpAddressException("Server IP Address was not provided.");

        if (name.isEmpty() || role.isEmpty())
            throw new UserException("Name and role can't be empty.");

        ResourceGroup group = Database.getInstance().findGroup(ip);
        if (group == null) {
            bw.write("ADD MEMBER: Group not found: ipAddress = " + ip);
            bw.newLine();
            return;
        }

        User u = UserFactory.createUser(name, role, email, department, clearance);

        group.addMember(u);

        bw.write("ADD MEMBER: " + ip + ": " + u.toString());
        bw.newLine();
    }
}