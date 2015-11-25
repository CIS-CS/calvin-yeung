package page081_Arrays;

/*
 *  Array2D.java
 *  Created on 29May2008
 *  @author MHayes
 */
public class Array2D {
    
    public static void main(String[] args) {
        
        // Define a 2D array with 5 'rows' and 10 'columns'
        int[][] numbers = new int[5][10];
        
        // Initialize the 2D array
        for (int i = 0; i < numbers.length; i++)           // for each row
        {            
            for (int j = 0; j < numbers[i].length; j++)    // for each column
            {
                numbers[i][j] = i * j;
            }
        }        
    }    
}
