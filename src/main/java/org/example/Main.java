package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main <type> <filepath>...");
            return;
        }

        Database.getInstance().clear();

        CommandInvoker invoker = new CommandInvoker();

        for (int i = 1; i < args.length; i++) {
            String inputPath = args[i] + ".in";
            String outputPath = args[i] + ".out";

            try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
                BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

                String line;
                br.readLine();

                int lineNumber = 1;

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\|", -1);
                    for (int j = 0; j < parts.length; j++)
                        parts[j] = parts[j].trim();

                    try {
                        String commandName = parts[0];

                        invoker.executeCommand(commandName, parts, bw);
                    } catch (Exception e) {
                        bw.write(parts[0] + ": " + e.getClass().getSimpleName() + ": " + e.getMessage() + " ## line no: " + lineNumber);
                        bw.newLine();
                    }
                    lineNumber++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}