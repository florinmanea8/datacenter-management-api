package org.example;

import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {
    private final Map<String, Command> commands;

    public CommandInvoker() {
        commands = new HashMap<>();

        commands.put("ADD SERVER", new AddServerCommand());
        commands.put("ADD GROUP", new AddGroupCommand());
        commands.put("ADD MEMBER", new AddMemberCommand());
        commands.put("FIND MEMBER", new FindMemberCommand());
        commands.put("REMOVE MEMBER", new RemoveMemberCommand());
        commands.put("FIND GROUP", new FindGroupCommand());
        commands.put("REMOVE GROUP", new RemoveGroupCommand());
        commands.put("ADD EVENT", new AddEventCommand());
    }

    public void executeCommand(String commandName, String[] parts, BufferedWriter bw) throws Exception {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(parts, bw);
        } else {
            new AddGroupCommand().execute(parts, bw);
        }
    }
}