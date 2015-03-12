package interview;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }
    
   ArrayList<Integer> input = new ArrayList<Integer>();
   
   input.add(5);
   input.add(8);
   input.add(5);
   input.add(13);
   input.add(25);
   System.out.println("max is " + Find_Max(input,-1));
  }
  
  //5
  // a host, who gets many reservation requests from different guests
  // this host always requires at least one night's break between any two guest stays
  // [5,4,3]
  // 5, 0,3 = 8 
  // what is the maximum number of nights booked
  // 1+ 5 + 1 + 4+ 1+3+1 = 15 ?
  //design 
  //host 
  //convert this 
  //[5,4,3]= 8
  //[5,1,3,1,1,3] = >  5, 3,1 ; 5,3,3 
  //algo :
   // since we always two path, one is pick up the one after or we pick the one after two next
   public static int Find_Max(ArrayList<Integer> input,int currentposition){
    //validte the input
    if(input == null ) return 0;
   
    if(input.size()== 1) return input.get(0);
    
     
   
   
     if(currentposition == input.size()-1 || currentposition == input.size()-2 ){
       return input.get(currentposition);
         
     }
     
     if(currentposition >= input.size()) return 0;
     
     
    int first= (currentposition ==-1)? input.get(0)+ Find_Max(input, 2)
    : input.get(currentposition )+ Find_Max(input, currentposition+2);
    int second =(currentposition ==-1)?  input.get(1) +Find_Max(input, 4)
    :input.get(currentposition) +Find_Max(input, currentposition+2) ;
    int third = (currentposition ==-1)? input.get(0)+ Find_Max(input, 3)
    : input.get(currentposition )+ Find_Max(input, currentposition+3);
        int fourth = (currentposition ==-1)? input.get(1)+ Find_Max(input, 3)
    : input.get(currentposition )+ Find_Max(input, currentposition+3);
    
         
    int temp1 = first>=second? first:second;
    int temp2 = third>=fourth? third:fourth;
    return temp1>=temp2 ? temp1:temp2;
 }
 
 
 
  
}