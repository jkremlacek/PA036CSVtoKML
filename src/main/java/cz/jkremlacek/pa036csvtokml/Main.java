package cz.jkremlacek.pa036csvtokml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jakub Kremláček
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 1) {
            if ("-h".equals(args[0])) {
                System.out.println("Order of expected arguments is:\noutput inputCSV1 ... inputCSVN");
            }
        }

        if (args.length < 2) {
            throw new IllegalArgumentException("At least 2 arguments - output and input - must be set");
        }

        File outputFile = new File(args[0]);
        List<File> inputFiles = new ArrayList<>();

        for (int i = 1; i < args.length; i++) {
            inputFiles.add(new File(args[i]));
        }

        Convertor.convertCSVtoKML(outputFile, inputFiles.toArray(new File[0]));
    }
}
