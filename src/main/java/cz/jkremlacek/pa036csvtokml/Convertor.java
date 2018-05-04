package cz.jkremlacek.pa036csvtokml;

import java.io.*;

/**
 * @author Jakub Kremláček
 */
public class Convertor {

    public static void convertCSVtoKML(File outputF, File... inputFiles) {
        for (File inputFile : inputFiles) {
            if (!inputFile.exists()) {
                throw new IllegalArgumentException("Input file: " + inputFile.getAbsolutePath() + " does not exist.");
            }
        }

        if (outputF.exists()) {
            throw new IllegalArgumentException("Output file: " + outputF.getAbsolutePath() + " exists.");
        }

        try (FileWriter fw = new FileWriter(outputF, false)) {
            StringBuilder outputSB = new StringBuilder();

            for (File inputFile : inputFiles) {
                FileReader fr = new FileReader(inputFile);
                BufferedReader br = new BufferedReader(fr);

                String line;

                //dump header
                br.readLine();

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    String description = "";

                    for (int i = 3; i < parts.length; i++) {
                        description += parts[i];
                    }

                    KMLFormatStrings.addPlacemark(outputSB, parts[2], description, parts[1].replace("\"", ""), parts[0].replace("\"", ""));
                }
            }

            fw.write(KMLFormatStrings.addHeader(outputSB));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
