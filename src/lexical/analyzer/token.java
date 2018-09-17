/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexical.analyzer;

/**
 *
 * @author hp8560p
 */
public class token {
String CP;
String VP;
int lineNum;

public token(){
    this.CP=null;
    this.VP=null;
    this.lineNum=0;
}

public token(String cp, String vp, int line){
    this.CP=cp;
    this.VP=vp;
    this.lineNum=line;
}

    public void setCP(String CP) {
        this.CP = CP;
    }

    public void setVP(String VP) {
        this.VP = VP;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public String getCP() {
        return CP;
    }

    public String getVP() {
        return VP;
    }

    public int getLineNum() {
        return lineNum;
    }
    
@Override
    public String toString(){
        return "( "+this.CP+" ,"+this.VP+" ,"+this.lineNum+" )";
    }
    


}
