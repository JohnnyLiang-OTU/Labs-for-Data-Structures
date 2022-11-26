// This Driver.java program will create an array of objects of class Athletes
// then in a function classifyAthletes, sort then by wins in a Priority Queue with its comparator modified.
// Poll items from the queue and add them into another arraylist and return said arraylist.
// Driver.java uses java.util.ArrayList, PriorityQueue, and Comparator libraries.
// Author: Johnny Liang
// Date: October 19th, 2022
// Course: Data Structure Lab 5.

import java.util.ArrayList; 
import java.util.PriorityQueue; 
import java.util.Comparator;
 
public class Driver { 
 
    public static ArrayList<String> classifyAthletes(Athlete[] athletes) 
    { 
        PriorityQueue<Athlete> queue = new PriorityQueue<Athlete>(new Comparator<Athlete>() {
            public int compare(Athlete a, Athlete b)
            {
                if(a.wins >= b.wins) // If a > b, give it a negative priority.
                {
                    return -1;
                }
                else
                {
                    return 1;
                }
            }    
        });

        for(int i = 0; i < athletes.length; i++)
        {
            queue.add(athletes[i]);
        }
        
        ArrayList<String> aList = new ArrayList<>();
        aList.add(queue.poll().name + ": Highest Wins."); // Hard-coding first three because of "1st" "2nd" and "3rd".
        aList.add(queue.poll().name + ": 2nd Highest Wins.");
        aList.add(queue.poll().name + ": 3rd Highest Wins.");
        for(int j = 3; j < athletes.length; j++)
        {
            aList.add(queue.poll().name + ": " + (j+1) + "th Highest Wins");
        }

        return aList;
    } 
     
    public static void main(String[] args) { 

        Athlete[] athletes = new Athlete[]{ 
            new Athlete("Pete Sampras", 14), 
            new Athlete("Novak Djokovic", 21), 
            new Athlete("Roger Federer", 20), 
            new Athlete("Roy Emerson", 12), 
            new Athlete("Rafael Nadal", 22), 
            new Athlete("Bjorn Borg", 11), 
        }; 

        for (String rank: classifyAthletes(athletes)) // function classifyAthletes line 15.
        { 
            System.out.println(rank); 
        } 
         
    } 
} 