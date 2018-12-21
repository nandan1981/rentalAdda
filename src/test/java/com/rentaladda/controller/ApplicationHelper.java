package com.rentaladda.controller;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

//Algorithm to check for sentence with particular word
public class ApplicationHelper {

    public static void main(String args[]){

        System.out.println("Enter a String to format");
        Scanner sc = new Scanner(System.in);
        String stringToFormat = sc.nextLine();
        String[] specialWordsArray = {"a","the","to","at","with","and","but","or","is"};
        String[] sentenceSplit = stringToFormat.split(" ");
        StringBuffer stBuf = new StringBuffer();
        if(!stringToFormat.isEmpty()){
            for(int counter=0;counter<sentenceSplit.length;counter++){
                boolean bnContains = Arrays.stream(specialWordsArray).anyMatch(sentenceSplit[counter]::equalsIgnoreCase);
                if(counter == 0) {
                    stBuf.append(sentenceSplit[counter].substring(0,1).toUpperCase()+sentenceSplit[counter].substring(1,sentenceSplit[counter].length()).toLowerCase());
                }else if(bnContains){
                    stBuf.append(" "+ sentenceSplit[counter].toLowerCase());
                }else{
                    stBuf.append(" " +sentenceSplit[counter].substring(0,1).toUpperCase()+ sentenceSplit[counter].substring(1,sentenceSplit[counter].length()).toLowerCase());
                }
            }
        }else{
            System.out.println("This is an empty sentence");
        }
        System.out.println(stBuf.toString());
    }
}
