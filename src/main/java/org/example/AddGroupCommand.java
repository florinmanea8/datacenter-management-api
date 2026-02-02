package org.example;

import java.io.BufferedWriter;

public class AddGroupCommand implements Command {
    public void execute(String[] parts, BufferedWriter bw) throws Exception {
        String ip = parts[1];

        if (ip.isEmpty())
            throw new MissingIpAddressException("Server IP Address was not provided.");

        Database db = Database.getInstance();

        if (db.findGroup(ip) == null)
            db.addResourceGroup(new ResourceGroup(ip));

        bw.write("ADD GROUP: " + ip);
        bw.newLine();
    }
}