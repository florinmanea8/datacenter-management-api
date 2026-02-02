package org.example;

import java.io.BufferedWriter;

public class RemoveGroupCommand implements Command {
    public void execute(String[] parts, BufferedWriter bw) throws Exception {
        String ip = parts[1];

        if (ip.isEmpty())
            throw new MissingIpAddressException("Server IP Address was not provided.");

        ResourceGroup g = Database.getInstance().findGroup(ip);

        if (g != null) {
            Database.getInstance().removeGroup(ip);
            bw.write("REMOVE GROUP: " + ip);
        } else {
            bw.write("REMOVE GROUP: Group not found: ipAddress = " + ip);
        }

        bw.newLine();
    }
}
