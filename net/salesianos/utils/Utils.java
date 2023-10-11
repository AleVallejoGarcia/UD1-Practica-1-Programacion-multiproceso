package net.salesianos.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
    public static String fileContent(String fileroute) throws IOException{
        String content = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileroute)); 
            String currentline = br.readLine();
            while (currentline != null) {
                content += currentline;
                currentline = br.readLine();
            }        
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static Integer getTotalVocalsFrom(String fileRoute) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRoute))) {
            String firstLine = bufferedReader.readLine();
            return Integer.parseInt(firstLine.trim());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }
}