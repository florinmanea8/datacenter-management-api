package org.example;

import java.io.BufferedWriter;

public class AddEventCommand implements Command {
    public void execute(String[] parts, BufferedWriter bw) throws Exception {
        String typeStr = parts[1];
        String severityStr = parts[2];
        String ip = parts[3];
        String message = parts[4];

        AlertType type = AlertType.valueOf(typeStr);
        Severity severity = Severity.valueOf(severityStr);

        Alert alert = new Alert(type, severity, message, ip);

        bw.write("ADD EVENT: " + ip + ": " + alert.toString());
        bw.newLine();
    }
}
