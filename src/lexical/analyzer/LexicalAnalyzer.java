package lexical.analyzer;

import java.io.FileNotFoundException;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("D:\\dummy code.txt");
        ArrayList<String> lineList = new ArrayList<>();
        String stringToCheck;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null;) {
                lineList.add(line);
            }
        }
        for (int i = 0; i < 1; i++) {
            stringToCheck = lineList.get(i);

            String splitArray[] = stringToCheck.split(" |\\{|,");
            
            System.out.println(splitArray[0]);
            
        }
    }

}
