/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexical.analyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Khurram
 */
public class FA {
    
     public int noofstates;
    public String inputChar[];
    public int TT[][];
    int IS;
    int FS[];
     
    
    public FA(int s, String SC[], int TT[][], int IS, int FS[]){
    this.noofstates=s;
    this.inputChar=SC;
    this.TT=TT;
    this.IS=IS;
    this.FS=FS;
    TT=new int[noofstates][inputChar.length];
    }
    
    
    public boolean validate(String input){
        
        int CS=IS;
        for(int i=0;i<input.length();i++){
        
            CS=transition(CS,input.charAt(i));
            if(CS==-1)
                return false;
        }
        
        if(!checker(CS)){
        return false;
        }
        else
    return true;
}
    
    public int transition(int St, char ch){
      int chIndex = getposition(ch);
      if(chIndex==-1)
          return -1;
      return TT[St][chIndex];
        
    }
    public int hardcodedTransiotion(int St, char ch){
        if(ch =='a'){
            return TT[St][0];
        }
        else 
            return TT[St][1];
        
        
    }
    
    
    public int getposition(char ch){
        
        Pattern p;
        Matcher m;
        String temp;
        int index=-1;
        for(int i=0; i<inputChar.length; i++) {
            
                temp = inputChar[i];
                p = Pattern.compile("["+temp+"]");
                m = p.matcher(String.valueOf(ch));
                if(m.matches()) {
                 return i;   
               
           }  
            
        }
        return index;
    }
    
    public boolean checker(int CS){
        
        for(int i=0;i<FS.length;i++){
        if(FS[i]==CS){
        return true;
        }
        }
        return false;
    }
    
    public int reChecker(char ch){
        
        int index = getposition(ch);
        if(index == -1){
            
        }
            
            
        
        return index;
        
    }
    
}
