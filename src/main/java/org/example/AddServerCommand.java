package org.example;

import java.io.BufferedWriter;

public class AddServerCommand implements Command {
    public void execute(String[] parts, BufferedWriter bw) throws Exception {
        String hostname = parts[1];
        String ip = parts[2];
        String statusStr = parts[3];
        String country = parts[4];
        String cityStr = parts[5];

        String userName = parts[9];
        String userRole = parts[10];
        String userEmail = parts[11];
        String department = parts[12];
        String clearance = parts[13];

        if (ip.isEmpty())
            throw new MissingIpAddressException("Server IP Address was not provided.");

        if (userName.isEmpty() || userRole.isEmpty())
            throw new UserException("Name and role can't be empty.");

        if (country.isEmpty())
            throw new LocationException("Country is missing.");

        User owner = UserFactory.createUser(userName, userRole, userEmail, department, clearance);

        String city = null;
        if (!cityStr.isEmpty())
            city = cityStr;

        Location location = new Location(country, city, null, null, null);

        ServerBuilder builder = new ServerBuilder(ip, location, owner);
        builder.setHostname(hostname);

        if (!statusStr.isEmpty())
            builder.setStatus(ServerStatus.valueOf(statusStr));

        if (parts.length > 14 && !parts[14].isEmpty())
            builder.setCpuCores(parts[14]);

        if (parts.length > 15 && !parts[15].isEmpty())
            builder.setRamGb(parts[15]);

        if (parts.length > 16 && !parts[16].isEmpty())
            builder.setStorageGb(parts[16]);

        Server server = builder.build();

        Database.getInstance().addServer(server);

        bw.write("ADD SERVER: " + server.getIpAddress() + ": " + server.getStatus());
        bw.newLine();
    }
}