package net.salesianos.launcher;

import java.io.File;
import java.io.IOException;

public class ProcessLauncher {
    private final static String OUTPUT_ROUTE = "./net/salesianos/outputs/";

    public static Process initVocalCounterProcess(String vowel, String text, String fileName) {
        ProcessBuilder processBuilder = new ProcessBuilder(
                "java", "./net/salesianos/processes/countVocal.java", vowel, text
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
