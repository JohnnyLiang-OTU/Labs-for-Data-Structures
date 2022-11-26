// Program that contains two functions that will look for duplicates, with one being faster than the other.
// We will use big O(n) knowledge on this lab.
// Driver.java uses java.util.Arrays library
// Author: Johnny Liang
// Date: October 5th, 2022
// Course: Data Structure 

import java.util.Arrays;
public class Driver{
    public static boolean contains_duplicates(int arr[])
    {
        boolean flag = false;
        for(int i = 0; i < arr.length; i++) // O(n)
        {
            for(int j = i+1 ; j < arr.length; j++) // O(n)
            {
                if(arr[i] == arr[j]) // O(1)
                {
                    flag = true; // O(1)
                    break; // O(1)
                }
            }
        }
        return flag; // Time complexity = O(n^2)
    }
    public static boolean contains_duplicates_better(int arr[])
    {
        boolean flag = false; // O(1)
        Arrays.sort(arr); // O(log n)
        for(int i = 0; i < arr.length - 1; i++) // O(n)
        {
            if(arr[i] == arr[i+1]) // Comparing element with the next element.
            {
                flag = true; // O(1)
                break; // O(1)
            }
        }
        return flag; // Time complexity = O(n logn)
    }
    public static void main(String[] args)  
    { 
        int arr[] = new int[]{1, 2, 7, 3, 4, 9, 1}; 
        System.out.println(contains_duplicates(arr)); 
        System.out.println(contains_duplicates_better(arr)); 
    }
}