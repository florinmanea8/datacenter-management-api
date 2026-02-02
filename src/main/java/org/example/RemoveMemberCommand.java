package org.example;

import java.io.BufferedWriter;

public class RemoveMemberCommand implements Command {
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
            bw.write("REMOVE MEMBER: Group not found: ipAddress = " + ip);
            bw.newLine();
            return;
        }

        boolean removed = group.removeMember(name, role);

        if (removed) {
            bw.write("REMOVE MEMBER: " + ip + ": name = " + name + " && role = " + role);
        } else {
            bw.write("REMOVE MEMBER: Member not found: ipAddress = " + ip + ": name = " + name + " && role = " + role);
        }

        bw.newLine();
    }
}