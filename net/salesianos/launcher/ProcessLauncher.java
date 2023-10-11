package net.salesianos.launcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ProcessLauncher {
    private final static String OUTPUT_ROUTE = "./net/salesianos/outputs/";

    public static Process initVocalCounterProcess(String line, char vowel, String fileName) {
        ProcessBuilder processBuilder = new ProcessBuilder(
                "java", "./net/salesianos/processes/VocalCounter.java", String.valueOf(vowel), line
        );

        Process javaProcess = null;

        try {
            File outputFile = new File(OUTPUT_ROUTE + fileName);
            processBuilder.redirectOutput(outputFile);
            processBuilder.redirectErrorStream(true);
            javaProcess =  processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return javaProcess;
    }
}
