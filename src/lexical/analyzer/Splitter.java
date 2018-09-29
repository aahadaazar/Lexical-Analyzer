/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexical.analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Character;

/**
 *
 * @author Khurram
 */
public class Splitter {

    int lineBreak[];

    public Splitter() {

    }

    public ArrayList wordBreaker() throws FileNotFoundException, IOException {
        File file = new File("F:\\dummy code2.txt");
//         ArrayList<String> forString = new ArrayList<>();
        String tempS = "";
        ArrayList<String> splitArray = new ArrayList<>();
        ArrayList<String> lineList = new ArrayList<>();
        String stringToCheck = "";
        int i, j = 0, start = 0;
        boolean flag = false;

        int lineBreakCheck = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null;) {
                if (line.equals("")) {
                    System.out.println("empty line found!");
                } else {
                    lineList.add(line);
                }

            }
        }
        lineBreak = new int[lineList.size()];
        for (i = 0; i < lineList.size(); i++) {
            stringToCheck = lineList.get(i);
            start = 0;
            for (j = 0; j < stringToCheck.length(); j++) {

                if (stringToCheck.charAt(j) == ':' || stringToCheck.charAt(j) == ' ' || stringToCheck.charAt(j) == '{' || stringToCheck.charAt(j) == '}' || stringToCheck.charAt(j) == '[' || stringToCheck.charAt(j) == ']' || stringToCheck.charAt(j) == '(' || stringToCheck.charAt(j) == ')' || stringToCheck.charAt(j) == '.' || stringToCheck.charAt(j) == ';' || stringToCheck.charAt(j) == '+' || stringToCheck.charAt(j) == '-' || stringToCheck.charAt(j) == '*' || stringToCheck.charAt(j) == '/' || stringToCheck.charAt(j) == '=' || stringToCheck.charAt(j) == '%' || stringToCheck.charAt(j) == '!' || stringToCheck.charAt(j) == '&' || stringToCheck.charAt(j) == '|' || stringToCheck.charAt(j) == '<' || stringToCheck.charAt(j) == '>') {
//                    System.out.println(stringToCheck.substring(start, j));
                    splitArray.add(stringToCheck.substring(start, j));
                    start = j + 1;
                    splitArray.add(stringToCheck.substring(j, start));

                } else if (stringToCheck.charAt(j) == '"') {

                    int x = j;
                    int t = j;
                    x--;
                    if(start!=0)
                    if (Character.isAlphabetic(stringToCheck.charAt(x))
                            || Character.isDigit(stringToCheck.charAt(x)) || stringToCheck.charAt(x) == '\\') {
                        x++;
                        splitArray.add(stringToCheck.substring(start, x));
                    }
                    t++;
                    tempS += "\"";
                    if (!flag) {
                        while (stringToCheck.charAt(t) != '"') {
                            if (Character.isSpaceChar(stringToCheck.charAt(t))) {
                                splitArray.add(stringToCheck.substring(start, t));
                                start = t + 1;
                                j = t;
                                flag = true;
                                break;
                            }
                            if (stringToCheck.charAt(t) == '\\') {
                                tempS += Character.toString(stringToCheck.charAt(t));
                                t++;
                                tempS += Character.toString(stringToCheck.charAt(t));
                                t++;
                            } else {
                                tempS += Character.toString(stringToCheck.charAt(t));
                                t++;
                            }
                        }
                    }
                    if (!flag) {
                        tempS += "\"";
                        splitArray.add(tempS);
                        start = t + 1;
                        j = t;
                        tempS = "";
                    }
                }

            }

            if (j == stringToCheck.length()) {
                splitArray.add(stringToCheck.substring(start, j));
            }

            while (splitArray.indexOf(" ") != -1 || splitArray.indexOf("") != -1) {
                splitArray.remove(" ");
                splitArray.remove("");
            }
            System.out.println(splitArray);
            lineBreak[i] = splitArray.size();
//            System.out.println(lineBreak[i]);
        }

//        System.out.println(splitArray);
        String[] NotFinalArray = new String[splitArray.size()];
        NotFinalArray = splitArray.toArray(NotFinalArray);
        ArrayList<String> finalSplitArray = new ArrayList<>();

        for (i = 0; i < NotFinalArray.length; i++) {
//            System.out.println(NotFinalArray[i]);

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
        return finalSplitArray;

    }

    public int[] getLineBreak() {
        return lineBreak;
    }

}
