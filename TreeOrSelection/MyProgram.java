import java.util.*;
import java.lang.*;

public class MyProgram
{
    public static void main(String[] args)
    {
        //78 nums in array is value at which speed is usually the same
        //nums>78 tree is faster
        //nums<78 selection is faster
        
        int[] arr = generateRandomArray(100000);
        
        long startTree = System.currentTimeMillis();
        
        BinaryTree test = new BinaryTree();
        
        for(int i : arr)
        {
            test.add(i);
        }
        
        test.inOrderTraversal();
        
        long endTree = System.currentTimeMillis();
        
        System.out.println();
        System.out.println("Time for Tree: " + (endTree-startTree) + " milliseconds");
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        long startSelection = System.currentTimeMillis();
        
        for(int i = 0; i<arr.length; i++)
        {
            int min = i;
            
            for(int j = i+1; j<arr.length; j++)
            {
                if(arr[j]<arr[min])
                {
                    min = j;
                }
            }
            
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            
            //System.out.print(arr[i] + " ");
        }
        
        long endSelection = System.currentTimeMillis();
        
        System.out.println();
        System.out.println("Time for Selection Sort: " + (endSelection-startSelection) + " milliseconds");
        
    }
    
    public static int[] generateRandomArray(int n) {
        // Create an array to store the random values
        int[] array = new int[n];
        
        // Fill the array with values from 0 to n-1
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        
        // Shuffle the array
        shuffleArray(array);
        
        return array;
    }
    
    // Shuffle the array using Fisher-Yates algorithm
    private static void shuffleArray(int[] array) {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Swap array[i] and array[index]
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

}