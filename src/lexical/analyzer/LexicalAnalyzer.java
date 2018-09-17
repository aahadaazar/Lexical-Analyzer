package lexical.analyzer;

import java.io.FileNotFoundException;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalyzer {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<String> SplitArray = new ArrayList<>();
        Splitter sp = new Splitter();
        DFA dfa = new DFA();
        SplitArray = sp.wordBreaker();
        System.out.println(SplitArray);

        token tokenSet[] = new token[SplitArray.size()];
        String temp = "";
        int i = 0;
        while (i < SplitArray.size()) {
            
            if(SplitArray.get(i).matches("[a-zA-Z]+")){
            if (dfa.validateID(SplitArray.get(i))) {
                String classPart = dfa.keyWords(SplitArray.get(i));
                if (classPart == "Invalid") {
                    tokenSet[i] = new token();
                    tokenSet[i].CP = "ID";
                    tokenSet[i].VP = SplitArray.get(i);
                    tokenSet[i].lineNum = i + 1;
                    i++;
                } else {
                    tokenSet[i] = new token();
                    tokenSet[i].CP = classPart;
                    tokenSet[i].VP = SplitArray.get(i);
                    tokenSet[i].lineNum = i + 1;
                    i++;
                }
            } else {
                tokenSet[i] = new token();
                tokenSet[i].CP = "invalid";
                tokenSet[i].VP = SplitArray.get(i);
                tokenSet[i].lineNum = i + 1;
                i++;
            }
            }
            else if(SplitArray.get(i).matches("[0-9]+")) {
                tokenSet[i] = new token();
                    tokenSet[i].CP = "INTEGER";
                    tokenSet[i].VP = SplitArray.get(i);
                    tokenSet[i].lineNum = i + 1;
                    i++;
              
            }else{
                tokenSet[i]=new token();
                i++;
            }
                
        }

        for (int j = 0; j < tokenSet.length; j++) {
            System.out.println(tokenSet[j].toString());
        }
    }
}
