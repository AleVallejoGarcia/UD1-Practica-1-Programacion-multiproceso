import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import net.salesianos.launcher.ProcessLauncher;
import net.salesianos.utils.Utils;

public class Main {
    private static final String OUTPUT_ROUTE = "./net/salesianos/outputs/";

    public static void main(String[] args) throws IOException {
        String content = Utils.fileContent("./lorem_ipsum.txt");
        ArrayList<Process> allProcesses = new ArrayList<>();
        String[] vowels = {"A", "E", "I", "O", "U"};

        for (String vowel : vowels) {
            String outputFileName = "output_" + vowel + ".txt";
            Process javaProcess = ProcessLauncher.initVocalCounterProcess(vowel, content, outputFileName);
            allProcesses.add(javaProcess);
        }

        for (Process process : allProcesses) {
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Integer totalVocals = 0;

        for (String vowel : vowels) {
            String outputFileName = "output_" + vowel + ".txt";
            String outputFileRoute = OUTPUT_ROUTE + outputFileName;
            Integer vocalsFromFile = Utils.getTotalVocalsFrom(outputFileRoute);
            totalVocals += vocalsFromFile;

            System.out.println("El fichero " + outputFileName + " tiene " + vocalsFromFile + " vocales");

            File outputFile = new File(outputFileRoute);
            outputFile.delete();
        }
        System.out.println("El fichero tiene " + totalVocals + " vocales");
    }
}
