// You are required to write a Java program that creates a Java function  public  static  String[] 
// sortTeams(String[] teams, int[] points) that takes in the names of the teams as a String[]  
// and points for each team as an int[]. The function is expected to return the names of the teams in 
// sorted order (highest to lowest based on their points). 
// Author: Johnny Liang
// Date: November 9th, 2022
// Course: Data Structure
// Work: Lab 8
// Professor Razi Iqbal
// TA: Shawkh Ibne Rashid

import java.util.ArrayList; 
import java.util.Arrays; 
 
public class Driver { 
 
    public static void selectionSort(ArrayList<Integer[]> tuples) 
    { 
        // Optional
    } 
 
    public static String[] sortTeams(String[] teams, int[] points)  
    { 
        for(int i = 0; i < points.length; i++)
        {
            int smallest = i;
            for(int j = i+1; j < points.length; j++)
            {
                if(points[smallest] < points[j])
                {
                    smallest = j;
                }
            }
            int tempP = points[smallest]; // Make a swap for the points array.
            points[smallest] = points[i];
            points[i] = tempP;

            String tempT = teams[smallest]; // And make a swap for the teams array.
            teams[smallest] = teams[i];
            teams[i] = tempT;
            
        }
        return teams;
    } 

    public static void main(String[] args)  
    { 
        String[] teams = new String[]{"Italy","Argentina", "England", "Brazil", "Belgium", 
"France", "Spain"}; 
        int[] points = new int[] {1726, 1773, 1728, 1841, 1816, 1759, 1715}; 
 
        System.out.println("\nOriginal Teams Array"); 
        System.out.println("********************"); 
        System.out.println(Arrays.toString(teams)); 
 
        System.out.println("\nOriginal Points Array"); 
        System.out.println("********************"); 
        System.out.println(Arrays.toString(points)); 
 
        System.out.println("\nTeams Sorted by their points"); 
        System.out.println("*******************************"); 
        System.out.println(Arrays.toString(sortTeams(teams, points))); 
         
    } 
} 