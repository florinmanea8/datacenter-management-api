package org.example;

import java.io.BufferedWriter;

public class FindMemberCommand implements Command {
    public void execute(String[] parts, BufferedWriter bw) throws Exception {
        String ip = parts[1];
        String name = parts[2];
        String role = parts[3];

        if (ip.isEmpty())
            throw new MissingIpAddressException("Server IP Address was not provided.");

        if (name.isEmpty() || role.isEmpty())
            throw new UserException("Name and role can't be empty.");

        ResourceGroup group = Database.getInstance().findGroup(ip);
        if (group == null) {
            bw.write("FIND MEMBER: Group not found: ipAddress = " + ip);
            bw.newLine();
            return;
        }

        if (group.hasMember(name, role)) {
            bw.write("FIND MEMBER: " + ip + ": name = " + name + " && role = " + role);
        } else {
            bw.write("FIND MEMBER: Member not found: ipAddress = " + ip + ": name = " + name + " && role = " + role);
        }

        bw.newLine();
    }
}