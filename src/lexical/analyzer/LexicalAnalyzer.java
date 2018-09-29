package lexical.analyzer;

import java.io.FileNotFoundException;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Character;

public class LexicalAnalyzer {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<String> SplitArray = new ArrayList<>();
        Splitter sp = new Splitter();
        String classPart = "";
        DFA dfa = new DFA();
        SplitArray = sp.wordBreaker();
        int[] lineBreak = sp.getLineBreak();
//        System.out.println(SplitArray);

        for (int jk = 0; jk < lineBreak.length; jk++) {
//            System.out.println("hello " + lineBreak[jk]);
        }

        token tokenSet[] = new token[SplitArray.size()];
        String temp = "";
        int i = 0;
        int lineNo = 1;
        int lineNoArray = 0;
        while (i < SplitArray.size()) {

            if (SplitArray.get(i).matches("[_a-zA-Z|a-zA-Z]+")) {
                if (dfa.validateID(SplitArray.get(i))) {
                    classPart = dfa.keyWords(SplitArray.get(i));
                    if (classPart == "Invalid") {
                        tokenSet[i] = new token();
                        tokenSet[i].CP = "ID";
                        tokenSet[i].VP = SplitArray.get(i);

                        tokenSet[i].lineNum = lineNo;
                        i++;

                        if (i == lineBreak[lineNoArray]) {
                            lineNo = lineNo + 1;
                            lineNoArray = lineNoArray + 1;
                        }

                    } else {
                        tokenSet[i] = new token();
                        tokenSet[i].CP = classPart;
                        tokenSet[i].VP = SplitArray.get(i);
                        tokenSet[i].lineNum = lineNo;
                        i++;

                        if (i == lineBreak[lineNoArray]) {
                            lineNo = lineNo + 1;
                            lineNoArray = lineNoArray + 1;
                        }
                    }
                } else {
                    tokenSet[i] = new token();
                    tokenSet[i].CP = "invalid";
                    tokenSet[i].VP = SplitArray.get(i);
                    tokenSet[i].lineNum = lineNo;
                    i++;

                    if (i == lineBreak[lineNoArray]) {
                        lineNo = lineNo + 1;
                        lineNoArray = lineNoArray + 1;
                    }

                }
            } else if (SplitArray.get(i).matches("[0-9]+")) {
                tokenSet[i] = new token();
                tokenSet[i].CP = "INTEGER";
                tokenSet[i].VP = SplitArray.get(i);
                tokenSet[i].lineNum = lineNo;
                i++;

                if (i == lineBreak[lineNoArray]) {
                    lineNo = lineNo + 1;
                    lineNoArray = lineNoArray + 1;
                }

            } else if (SplitArray.get(i).matches("[-|+|*|/|=]+")) {
                tokenSet[i] = new token();
                tokenSet[i].CP = dfa.keyWords(SplitArray.get(i));
                tokenSet[i].VP = SplitArray.get(i);
                tokenSet[i].lineNum = lineNo;
                i++;

                if (i == lineBreak[lineNoArray]) {
                    lineNo = lineNo + 1;
                    lineNoArray = lineNoArray + 1;
                }
            } else if (SplitArray.get(i).matches("(|)|.|,|;|:|[|]|\\{|\\}")) {
                tokenSet[i] = new token();
                tokenSet[i].CP = dfa.keyWords(SplitArray.get(i));
                tokenSet[i].VP = SplitArray.get(i);
                tokenSet[i].lineNum = lineNo;
                i++;

                if (i == lineBreak[lineNoArray]) {
                    lineNo = lineNo + 1;
                    lineNoArray = lineNoArray + 1;
                }
            } else if (SplitArray.get(i).matches("\\\".*?\\\"")) {
                if (dfa.validateString(SplitArray.get(i))) {
                    String temp1 = SplitArray.get(i);
                    temp1=dfa.remove(temp1);
                    tokenSet[i] = new token();
                    tokenSet[i].CP = "String";
                    tokenSet[i].VP = temp1;
                    tokenSet[i].lineNum = lineNo;
                    i++;
                }else{
                    tokenSet[i] = new token();
                    tokenSet[i].CP = "Invalid";
                    tokenSet[i].VP = SplitArray.get(i);
                    tokenSet[i].lineNum = lineNo;
                    i++;
                }
                if (i == lineBreak[lineNoArray]) {
                    lineNo = lineNo + 1;
                    lineNoArray = lineNoArray + 1;
                }

            }
            else {
                tokenSet[i] = new token();
                tokenSet[i].CP="invalid";
                tokenSet[i].VP=SplitArray.get(i);
                tokenSet[i].lineNum = lineNo;
                i++;
                if (i == lineBreak[lineNoArray]) {
                    lineNo = lineNo + 1;
                    lineNoArray = lineNoArray + 1;
                }
            }
            
            

        }
        File newFile = new File("C:\\Users\\Khurram\\Documents", "token list.txt");
        newFile.createNewFile();
        for (int j = 0; j < tokenSet.length; j++) {

            try (FileWriter fw = new FileWriter(newFile, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                out.println(tokenSet[j].toString());

            } catch (IOException e) {
            }
            newFile.setReadOnly();
            System.out.println(tokenSet[j].toString());
        }
    }
}
