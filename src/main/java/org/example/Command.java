package org.example;

import java.io.BufferedWriter;

public interface Command {
    void execute(String[] parts, BufferedWriter bw) throws Exception;
}
