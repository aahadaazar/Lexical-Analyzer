/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexical.analyzer;

/**
 *
 * @author Khurram
 */
public class DFA {

    public DFA() {

    }

    public boolean validateID(String word) {
        int noStId = 4;
        String inputIdentfier[] = {"A-Za-z", "0-9", "_"};
        int ISid = 0;
        int FSid[] = {2};
        int TTid[][] = new int[][]{{2, 1, 1},
        {2, 2, 3},
        {2, 2, 3},
        {2, 2, 3},};

        FA fId = new FA(noStId, inputIdentfier, TTid, ISid, FSid);

        if (fId.validate(word)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean validateInt(String word) {
        //IntegerConstant
        String inputInteger[] = {"-", "+", "0-9"};
        int noStInt = 4;
        int ISInt = 0;
        int FSInt[] = new int[1];
        FSInt[0] = 2;
        int TTInt[][] = new int[][]{{1, 1, 2},
        {3, 3, 2},
        {3, 3, 2},
        {3, 3, 3},};
        FA fInt = new FA(noStInt, inputInteger, TTInt, ISInt, FSInt);

        if (fInt.validate(word)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateFloat(String word) {
        //FloatConstant
        String inputFloat[] = {"-+", ".", "0-9", "eE"};
        int noStFl = 8;
        int ISFl = 0;
        int FSFl[] = {3, 7};
        int TTFl[][] = new int[][]{{1, 2, 1, 6},
        {6, 2, 1, 6},
        {6, 6, 3, 6},
        {6, 6, 3, 4},
        {5, 6, 7, 6},
        {6, 6, 7, 6},
        {6, 6, 6, 6},
        {6, 6, 7, 6}};

        FA fFl = new FA(noStFl, inputFloat, TTFl, ISFl, FSFl);

        if (fFl.validate(word)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean validateString(String word) {
        //FloatConstant
        //StringConstant
        String inputString[] = {"^\\\\\\\\\\\"rbtno", "rbtno", "\\\\\\\\", "\""};
        int noStStr = 6;
        int ISStr = 0;
        int FSStr[] = new int[1];
        FSStr[0] = 4;
        int TTStr[][] = new int[][]{{5, 5, 5, 1},
        {3, 3, 2, 4},
        {5, 3, 3, 3},
        {3, 3, 2, 4},
        {5, 5, 5, 5},
        {5, 5, 5, 5}};

        FA fStr = new FA(noStStr, inputString, TTStr, ISStr, FSStr);

        if (fStr.validate(word)) {
            return true;
        } else {
            return false;
        }

    }

    public boolean validateChar(String word) {

        //CharacterConstant
        String inputCharacter[] = {"\\\\", "bnto", "^'", "'"};
        int noStCh = 6;
        int ISCh = 0;
        int FSCh[] = new int[1];
        FSCh[0] = 3;
        int TTCh[][] = new int[][]{{5, 5, 5, 1},
        {4, 2, 2, 5},
        {5, 5, 5, 3},
        {5, 5, 5, 5},
        {5, 2, 5, 5},
        {5, 5, 5, 5}};

        FA fCh = new FA(noStCh, inputCharacter, TTCh, ISCh, FSCh);

        if (fCh.validate(word)) {
            return true;
        } else {
            return false;
        }

    }

    public String keyWords(String word) {
        int i;
        String list[][] = new String[][]{{"DT", "intNum"},
        {"DT", "floatNUm"},
        {"DT", "dNum"},
        {"DT", "char"},
        {"DT", "charArray"},
        {"blackhole", "blackhole"},
        {"forItema", "forItems"},
        {"aslongas", "aslongas"}, {"if", "if"},
        {"else", "else"}, {"switch", "switch"},
        {"continue", "continue"}, {"break", "break"},
        {"return", "return"}, {"AM", "public"},
        {"AM", "private"}, {"AM", "protected"},
        {"AM", "static"}, {"AM", "final"},
        {"AM", "class"}, {"AM", "abstract"},
        {"AM", "interface"}, {"AM", "implements"},
        {"AM", "extends"}, {"new", "new"},
        {"AM", "super"}, {"this", "this"},
        {";", ";"},
        {":", ":"}, {"{", " ("},
        {")", ")"}, {"{", "{"},
        {"}", "}"}, {"[", "["},
        {"]", "]"}, {",", ","},
        {"MP", "+"}, {"MP", "-"},
        {"MPD", "*"}, {"MPD", "/"},
        {"MPD", "%"},
        {"inc", "++"}, {"dec", "--"},
        {"ROP", "<"}, {"ROP", ">"},
        {"ROP", "<="}, {"ROP", ">="},
        {"NOT", "!"}, {"ROP", "!="},
        {"=", "="}, {"ROP", "=="},
        {"&", "&"}, {"AND", "&&"},
        {"|", "|"}, {"OR", "||"},
        {"AOP", "+="}, {"AOP", "-="},
        {"AOP", "/="}, {"AOP", "*="},
        {"AOP", "%"}};

        for (i = 0; i < list.length; i++) {

            if (list[i][1].equals(word)) {
                return list[i][0];
            }
        }
        return "Invalid";

    }
}
