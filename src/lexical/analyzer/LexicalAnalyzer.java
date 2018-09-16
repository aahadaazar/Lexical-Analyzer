package lexical.analyzer;

import java.io.FileNotFoundException;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class LexicalAnalyzer {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("D:\\dummy code2.txt");
        ArrayList<String> splitArray = new ArrayList<>();
        ArrayList<String> lineList = new ArrayList<>();
        String stringToCheck;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null;) {
                lineList.add(line);
            }
        }
        for (int i = 0; i < 1; i++) {
            stringToCheck = lineList.get(i);
            int start = 0;
            for (int j = 0; j < stringToCheck.length(); j++) {

                if (stringToCheck.charAt(j) == ':' || stringToCheck.charAt(j) == ' ' || stringToCheck.charAt(j) == '{' || stringToCheck.charAt(j) == '}' || stringToCheck.charAt(j) == '[' || stringToCheck.charAt(j) == ']' || stringToCheck.charAt(j) == '(' || stringToCheck.charAt(j) == ')' || stringToCheck.charAt(j) == '.' || stringToCheck.charAt(j) == ';' || stringToCheck.charAt(j) == '+' || stringToCheck.charAt(j) == '-' || stringToCheck.charAt(j) == '*' || stringToCheck.charAt(j) == '/' || stringToCheck.charAt(j) == '=' || stringToCheck.charAt(j) == '%' || stringToCheck.charAt(j) == '!' || stringToCheck.charAt(j) == '&' || stringToCheck.charAt(j) == '|' || stringToCheck.charAt(j) == '<' || stringToCheck.charAt(j) == '>') {
                    System.out.println(stringToCheck.substring(start, j));
                    splitArray.add(stringToCheck.substring(start, j));

                    start = j + 1;
                    splitArray.add(stringToCheck.substring(j, start));

                }
            }
        }

        while (splitArray.indexOf(" ") != -1 || splitArray.indexOf("") != -1) {
            splitArray.remove(" ");
            splitArray.remove("");
        }
        System.out.println(splitArray);
        String[] NotFinalArray = new String[splitArray.size()];
        NotFinalArray = splitArray.toArray(NotFinalArray);
        ArrayList<String> finalSplitArray = new ArrayList<>();

        for (int i = 0; i < NotFinalArray.length; i++) {
            System.out.println(NotFinalArray[i]);

            if (NotFinalArray[i].equals("+")) {
                if (NotFinalArray[i + 1].equals("+") || NotFinalArray[i + 1].equals("=")) {
                    String temp = NotFinalArray[i] + NotFinalArray[i + 1];
                    finalSplitArray.add(temp);
                    i = i + 1;
                } else {
                    finalSplitArray.add(NotFinalArray[i]);
                }
            } else if (NotFinalArray[i].equals("-")) {
                if (NotFinalArray[i + 1].equals("-") || NotFinalArray[i + 1].equals("=")) {
                    String temp = NotFinalArray[i] + NotFinalArray[i + 1];
                    finalSplitArray.add(temp);
                    i = i + 1;
                } else {
                    finalSplitArray.add(NotFinalArray[i]);
                }
            } else if (NotFinalArray[i].equals("*")) {
                if (NotFinalArray[i + 1].equals("=")) {
                    String temp = NotFinalArray[i] + NotFinalArray[i + 1];
                    finalSplitArray.add(temp);
                    i = i + 1;
                } else {
                    finalSplitArray.add(NotFinalArray[i]);
                }
            } else if (NotFinalArray[i].equals("/")) {
                if (NotFinalArray[i + 1].equals("=")) {
                    String temp = NotFinalArray[i] + NotFinalArray[i + 1];
                    finalSplitArray.add(temp);
                    i = i + 1;
                } else {
                    finalSplitArray.add(NotFinalArray[i]);
                }
            } else if (NotFinalArray[i].equals("%")) {
                if (NotFinalArray[i + 1].equals("=")) {
                    String temp = NotFinalArray[i] + NotFinalArray[i + 1];
                    finalSplitArray.add(temp);
                    i = i + 1;
                } else {
                    finalSplitArray.add(NotFinalArray[i]);
                }
            } else if (NotFinalArray[i].equals("!")) {
                if (NotFinalArray[i + 1].equals("=")) {
                    String temp = NotFinalArray[i] + NotFinalArray[i + 1];
                    finalSplitArray.add(temp);
                    i = i + 1;
                } else {
                    finalSplitArray.add(NotFinalArray[i]);
                }
            } else if (NotFinalArray[i].equals("&")) {
                if (NotFinalArray[i + 1].equals("&")) {
                    String temp = NotFinalArray[i] + NotFinalArray[i + 1];
                    finalSplitArray.add(temp);
                    i = i + 1;
                } else {
                    finalSplitArray.add(NotFinalArray[i]);
                }
            } else if (NotFinalArray[i].equals("|")) {
                if (NotFinalArray[i + 1].equals("|")) {
                    String temp = NotFinalArray[i] + NotFinalArray[i + 1];
                    finalSplitArray.add(temp);
                    i = i + 1;
                } else {
                    finalSplitArray.add(NotFinalArray[i]);
                }
            } else if (NotFinalArray[i].equals(">")) {
                if (NotFinalArray[i + 1].equals(">") || NotFinalArray[i + 1].equals("=")) {
                    String temp = NotFinalArray[i] + NotFinalArray[i + 1];
                    finalSplitArray.add(temp);
                    i = i + 1;
                } else {
                    finalSplitArray.add(NotFinalArray[i]);
                }
            } else if (NotFinalArray[i].equals("<")) {
                if (NotFinalArray[i + 1].equals("<") || NotFinalArray[i + 1].equals("=")) {
                    String temp = NotFinalArray[i] + NotFinalArray[i + 1];
                    finalSplitArray.add(temp);
                    i = i + 1;
                } else {
                    finalSplitArray.add(NotFinalArray[i]);
                }
            } else {
                finalSplitArray.add(NotFinalArray[i]);
            }
        }
        DFA dfa = new DFA();
        System.out.println(dfa.keyWords(finalSplitArray.get(0)));
        System.out.println(finalSplitArray);
    }
}
