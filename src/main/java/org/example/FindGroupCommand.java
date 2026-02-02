package org.example;

import java.io.BufferedWriter;

public class FindGroupCommand implements Command {
    public void execute(String[] parts, BufferedWriter bw) throws Exception {
        String ip = parts[1];

        if (ip.isEmpty())
            throw new MissingIpAddressException("Server IP Address was not provided.");

        ResourceGroup g = Database.getInstance().findGroup(ip);

        if (g != null) {
            bw.write("FIND GROUP: " + ip);
        } else {
            bw.write("FIND GROUP: Group not found: ipAddress = " + ip);
        }

        bw.newLine();
    }
}
