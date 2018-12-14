/*****************************************************************************
  *  Program: FinalExam_JohnGumm.java
  *  Author: John Gumm
  ****************************************************************************
  * TO DO: 
  *   Compile the program and run it.
  *   Follow the sample execution shown below. 
  * 
  *   Requirement: Use primitive arrays, not an arraylist.
  *  
  * Steps to follow: (using nested for-loops for definite loops)
  *   1. Ask the user to enter the size of array they want to create. Use getInteger as you have all semester.  
  *   2. Create an input validation function to ensure the input is from 4 to 10. 
  *      Make this a generalized validation function that can be used with any 2 numbers. (50 points) 
  *   3. Create a 3-dimensional array the size of the user's number.  (20 points)
  *      For example, if the user entered 4,  the array will be a  4 x  4 x 2
  *      For example, if the user entered 10, the array will be a 10 x 10 x 2
  *   4. Populate the array with random numbers from 10 to 99.  (50 points)
  *   5. Print the array as shown below. (50 points)
  *   6. Calculate and print the array's statistics as shown below. (80 points)
  *   7. Ask the user for a number to search for. (sentinel value: 0 to stop) 
  *      Use the input validation routine you created in step 2 to ensure the input is from 10 to 99.  (50 points)
  *   8. Search the array for all occurrences of the number being searched for.
  *   9. Report to the user how many times the number occurs in the array. (50 points)
  *  10. If the number is found, report to the user if the number they are searching for is an even or odd number. (50 points)
  *  11. Ask the user if they want to search for another number.  (50 points)
  *  12. Ask the user if they want to generate another array (a wants-to-continue loop)  (50 points)
  *  13. Using nested for-loops, print a multiplication table as shown below. Note the single digit numbers are right justified. (100 points)
  * 
  *  14. Each section of the program has to work, or you will not receive ANY credit for that section.
  * 
  **************************************************************************** 
  *   Required execution of this program: (Formatted EXACTLY like this. Number shown are for formatting only.)
  *   
  *   ----- Welcome to the 3-D Random Array program -----
  *   How big of an array do you want to generate? (4 to 10) 
  *   45
  *   Error: The number 45 is out of range. 
  * 
  *   How big of an array do you want to generate? (4 to 10)
  *   4
  * 
  *   Please wait while I create a 3-dimensional array with random numbers from 10 to 99. 
  *   Here is the array: 
  *       11 13 65 34    
  *       10 63 95 34         
  *       79 83 65 67
  *       54 76 87 93      
  * 
  *       42 67 88 43        
  *       14 15 29 85
  *       76 38 76 15     
  *       54 76 98 93        
  * 
  *   The lowest number is  :  11 
  *   The highest number is :  98 
  *   The total is          : 445
  *   The average is        :  52.8125
  *   Number of even numbers:  15
  *   Number of odd numbers :  17
  * 
  *   What number would you like to search for? (10 - 99, or 0 to quit)
  *   2
  *   Error: The number 2 is out of range. 
  * 
  *   What number would you like to search for? (10 - 99, or 0 to quit)
  *   70
  *   Error: The number 70 does not exist in the array. 
  * 
  *   What number would you like to search for? (10 - 99, or 0 to quit)
  *   76
  *   The number 76 exists 4 times in the array. 
  *   The number 76 is an even number. 
  * 
  *   What number would you like to search for? (10 - 99, or 0 to quit)
  *   0
  * 
  *   Do you want to generate a new array?
  *   No
  * 
  *   Here is a mulmultiplication table:  
  *  
  *     * |  1  2  3  4  5  6  7  8  9 
  *     ------------------------------ 
  *     1 |  1  2  3  4  5  6  7  8  9  
  *     2 |  2  4  6  8 10 12 14 16 18  
  *     3 |  3  6  9 12 15 18 21 24 27  
  *     4 |  4  8 12 16 20 24 28 32 36  
  *     5 |  5 10 15 20 25 30 35 40 45  
  *     6 |  6 12 18 24 30 36 42 48 54  
  *     7 |  7 14 21 28 35 42 49 56 63  
  *     8 |  8 16 24 32 40 48 56 64 72  
  *     9 |  9 18 27 36 45 54 63 72 81       
  * 
  *   ----- Program Complete -----  
  *****************************************************************************/ 
import java.io.*;

public class FinalExam_JohnGumm {
   static InputStreamReader input = new InputStreamReader(System.in);
   static BufferedReader reader = new BufferedReader(input); 
   
   // Constants
   final static int ARRAY_MIN = 4;
   final static int ARRAY_MAX = 10;
   final static int RANDOM_NUM_MIN = 10;
   final static int RANDOM_NUM_MAX = 99;
   final static int ARRAY_THIRD_DIMENSION = 2;
   final static int SENTINEL = 0;
   final static int MULT_TABLE_SIZE = 9;

   public static void main(String[] args) {
      
      /////////// Sample code: ///////////////////////////////////////////
      //int [] numbers = new int [45000];
      //String [] [] sampleArray = new String [500][500];
      //for (int i=0; i < 12; i++)
      //int x = getInteger("Enter a number");
      ////////////////////////////////////////////////////////////////////
      
      System.out.println("----- Welcome to the Random Array program -----");
      
      // Initialize to true for first time
      boolean wantsArray = true;

      while (wantsArray) {
         // Get array size from user
         int arraySize = getIntegerBetween(ARRAY_MIN, ARRAY_MAX, "How big of an array do you want to generate? (" + ARRAY_MIN + " to " + ARRAY_MAX + ")");

         // Create 3-dimensional array and populate it with random numbers
         int[][][] my3dArray = new int[arraySize][arraySize][ARRAY_THIRD_DIMENSION];
         populateArray(my3dArray, RANDOM_NUM_MIN, RANDOM_NUM_MAX);

         System.out.println("\nPlease wait while I create a 3-dimensional array with random numbers from " + RANDOM_NUM_MIN + " to " + RANDOM_NUM_MAX + ".");
         
         // Display both arrays
         printArray(my3dArray);

         // Calculate stats
         int my3dArrayLowest = getLowestNumber(my3dArray);
         int my3dArrayHighest = getHighestNumber(my3dArray);
         int my3dArrayTotal = calcTotal(my3dArray);
         double my3dArrayAverage = calcAverage(my3dArrayTotal, arraySize, arraySize, ARRAY_THIRD_DIMENSION);
         int evens = calcEven(my3dArray);
         int odds = calcOdd(my3dArray);

         // Display stats
         System.out.print("The lowest number is  :  ");
         System.out.println(my3dArrayLowest);

         System.out.print("The highest number is :  ");
         System.out.println(my3dArrayHighest);

         System.out.print("The total is          : ");
         System.out.println(my3dArrayTotal);

         System.out.print("The average is        :  ");
         System.out.println(my3dArrayAverage);

         System.out.print("Number of even numbers:  ");
         System.out.println(evens);

         System.out.print("Number of odd numbers :  ");
         System.out.println(odds);
         System.out.println();

         // Initiate search loop
         int numToSearch = getIntegerBetween(RANDOM_NUM_MIN, RANDOM_NUM_MAX, SENTINEL, "What number would you like to search for? (" + RANDOM_NUM_MIN + " - " + RANDOM_NUM_MAX + ", or " + SENTINEL + " to quit)");
         
         while (numToSearch != SENTINEL) {
            int occurences = searchArray(my3dArray, numToSearch);

            if (occurences == 0) {
               System.out.println("Error: The number " + numToSearch + " does not exist in the array.");
            }
            else {
               System.out.println("The number " + numToSearch + " exists " + occurences + " times in the array.");
               if (calcIfEven(numToSearch)) {
                  System.out.println("The number " + numToSearch + " is an even number.");
               }
               else {
                  System.out.println("The number " + numToSearch + " is an odd number.");
               }
            }
            System.out.println();

            numToSearch = getIntegerBetween(RANDOM_NUM_MIN, RANDOM_NUM_MAX, SENTINEL, "What number would you like to search for? (" + RANDOM_NUM_MIN + " - " + RANDOM_NUM_MAX + ", or " + SENTINEL + " to quit)");
         }

         // Ask if new array is wanted
         wantsArray = getYorN("Do you want to generate a new array?");
      }

      // Display multiplication table
      System.out.println("\nHere is a multiplication table:\n");
      printMultiplicationTable();

      System.out.println("\n----- Program Complete -----");
      
      closeScanner();
   }//end main
   
   //----------------------------------------------------------------------------------------
   
   // Gets a number between two numbers
   public static int getIntegerBetween(int low, int high, String msg) {
      int num = getInteger(msg);
      while (num < low || num > high) {
         System.out.println("Error: The number " + num + " is out of range.\n");
         num = getInteger(msg);
      }

      return num;
   }

   // Overloaded function gets a number between two numbers or sentinel
   public static int getIntegerBetween(int low, int high, int sentinel, String msg) {
      int num = getInteger(msg);

      if (num == sentinel) {return num;}

      while (num < low || num > high) {
         System.out.println("Error: The number " + num + " is out of range.\n");
         num = getInteger(msg);
         if (num == sentinel) {return num;}
      }

      return num;
   }
   
   // This module loops through the array and sets each element to a random number from 10 to 99 
   public static void populateArray (int[][][] array, int low, int high) {
      for (int i = 0; i < array.length; i++) {
         for (int j = 0; j < array[i].length; j++) {
            for (int k = 0; k < array[i][j].length; k++) {
               array[i][j][k] = getRandomNumber(low, high);
            }
         }
      }
   }
   
   // Get the lowest number in a 3-Dimensional array
   public static int getLowestNumber (int[][][] array) {
      
      int lowestNumber = RANDOM_NUM_MAX;

      for (int i = 0; i < array.length; i++) {
         for (int j = 0; j < array[i].length; j++) {
            for (int k = 0; k < array[i][j].length; k++) {
               if (array[i][j][k] < lowestNumber) {
                  lowestNumber = array[i][j][k];
               }
            }
         }
      }

      return lowestNumber;
   }
   
   // Get the highest number in a 3-Dimensional array
   public static int getHighestNumber (int[][][] array) {
      
      int highestNumber = RANDOM_NUM_MIN;

      for (int i = 0; i < array.length; i++) {
         for (int j = 0; j < array[i].length; j++) {
            for (int k = 0; k < array[i][j].length; k++) {
               if (array[i][j][k] > highestNumber) {
                  highestNumber = array[i][j][k];
               }
            }
         }
      }

      return highestNumber;
   }
   
   // Calculate the total of all numbers in a 3-Dimensional array
   public static int calcTotal(int[][][] array) {
      
      int total = 0;

      for (int i = 0; i < array.length; i++) {
         for (int j = 0; j < array[i].length; j++) {
            for (int k = 0; k < array[i][j].length; k++) {
               total += array[i][j][k];
            }
         }
      }

      return total;
   }
   
   // Calculate the average number in a 3-Dimensional array, given the size and total
   public static double calcAverage(int total, int dim1, int dim2, int dim3) {
      double numerator = total;
      double denominator = dim1 * dim2 * dim3;
      double average = numerator / denominator;
      return average;
   }
   
   // Search array and return number of occurences
   public static int searchArray(int[][][] array, int num) {
      int counter = 0;

      for (int i = 0; i < array.length; i++) {
         for (int j = 0; j < array[i].length; j++) {
            for (int k = 0; k < array[i][j].length; k++) {
               if (array[i][j][k] == num) {
                  counter++;
               }
            }
         }
      }

      return counter;
   }

   // Return true if a given number is even
   public static boolean calcIfEven(int num) {
      if (num % 2 == 0) {
         return true;
      }
      return false;
   }
   
   // Calculate number of even numbers in a 3-Dimensional array
   public static int calcEven(int[][][] array) {
      
      int counter = 0;

      for (int i = 0; i < array.length; i++) {
         for (int j = 0; j < array[i].length; j++) {
            for (int k = 0; k < array[i][j].length; k++) {
               // Increment counter if number divided by two has no remainder
               if (array[i][j][k] % 2 == 0) {
                  counter++;
               }
            }
         }
      }

      return counter;
   }

   // Calculate number of odd numbers in a 3-Dimensional array
   public static int calcOdd(int[][][] array) {
      
      int counter = 0;

      for (int i = 0; i < array.length; i++) {
         for (int j = 0; j < array[i].length; j++) {
            for (int k = 0; k < array[i][j].length; k++) {
               // Increment counter if number divided by two has a remainder
               if (array[i][j][k] % 2 != 0) {
                  counter++;
               }
            }
         }
      }

      return counter;
   }
   
   // Display 3-Dimensional array
   public static void printArray (int[][][] array) {

      System.out.println("Here is the array:");

      int arraySize = array.length;

      // Outer loop is used for third array element
      for (int i = 0; i < ARRAY_THIRD_DIMENSION; i++) {
         System.out.println();
         for (int j = 0; j < arraySize; j++) {
            System.out.print("    ");
            for (int k = 0; k < arraySize; k++) {
               System.out.print(" " + array[j][k][i] + " ");
            }
            System.out.println();
         }
      }
      System.out.println();
   }
   
   // Show the user a multiplication table
   public static void printMultiplicationTable () {
      
      int [] array = new int[MULT_TABLE_SIZE];
      
      // Initialize array to sequential numbers
      for (int i = 0; i < array.length; i++) {
         array[i] = i + 1;
      }

      // Print header
      System.out.print("* |");
      for (int i = 0; i < array.length; i++) {
         System.out.print("  " + array[i]);
      }
      System.out.print("\n------------------------------\n");

      // Print body
      for (int i = 0; i < array.length; i++) {
         System.out.print(array[i] + " | ");
         for (int j = 0; j < array.length; j++) {
            if ((array[i] * array [j]) < 10) {
               System.out.print(" " + (array[i] * array [j]) + " ");
            }
            else {
               System.out.print(array[i] * array [j] + " ");
            }
         }
         System.out.println();
      }

   }

   /* 
    * Note the single digit numbers are right justified. 
    * 
    *     * |  1  2  3  4  5  6  7  8  9 
    *     ------------------------------ 
    *     1 |  1  2  3  4  5  6  7  8  9  
    *     2 |  2  4  6  8 10 12 14 16 18  
    *     3 |  3  6  9 12 15 18 21 24 27  
    *     4 |  4  8 12 16 20 24 28 32 36  
    *     5 |  5 10 15 20 25 30 35 40 45  
    *     6 |  6 12 18 24 30 36 42 48 54  
    *     7 |  7 14 21 28 35 42 49 56 63  
    *     8 |  8 16 24 32 40 48 56 64 72  
    *     9 |  9 18 27 36 45 54 63 72 81    
    */
   
   ////////////////////////////////////////////////////////////////////////////////////////
   ////// DO NOT CHANGE THESE FUNCTIONS! IF YOU DO, YOU WILL RECEIVE A ZERO FOR THE EXAM!!!
   ////////////////////////////////////////////////////////////////////////////////////////
   //Generates a random number from low to high, inclusive
   public static int getRandomNumber (int low, int high){
      return (int)(Math.random() * (high - low + 1)) + low;
   }
   
   /* You can use the below input routines as you have used them all semester: 
    *     getInteger(msg)
    *     getYorN(msg)
    *     getString(msg)
    */ 
   
   public static int getInteger (String msg){boolean notAnInteger = true;int answer = 0;
   do /*THIS IS BAD NEWS*/{try {notAnInteger = false;System.out.println(msg);answer = Integer.parseInt(reader.readLine());}
   catch (NumberFormatException e){System.err.println("That's not an valid integer. Try again.");notAnInteger = true;} 
   catch (Exception e){System.err.println("Error reading input from user. Ending program.");System.exit(-1);}}
   while (notAnInteger);/*DON'T CHANGE ANY OF THIS!!!*/return answer;} public static String getString 
  (String msg){String answer = ""; System.out.println(msg); try {answer = reader.readLine();} catch (Exception e){
   System.err.println("Error reading input from user. Ending program.");System.exit(-1);} 
   while (answer.replace(" ", "").equals("")){System.err.println("Error: No input.");
   try {System.out.println(msg);answer = reader.readLine();}/*VIRUS INSERTED HERE*/ catch
   (Exception e){System.err.println("Error reading input from user. Ending program.");System.exit(-1);} 
   }return answer;} /*WRONG FUNCTION*/ public static boolean getYorN (String msg){String answer = "";
   do{answer = getString(msg);}while (answer.compareToIgnoreCase("y")!= 0 && answer.compareToIgnoreCase("yes")!= 0 
   && answer.compareToIgnoreCase("n")!= 0 && answer.compareToIgnoreCase("no")!= 0);/*BAD CODE HERE*/if
   (answer.compareToIgnoreCase("y") == 0 || answer.compareToIgnoreCase("yes") == 0){return true;} 
   else{return false;}} public static void closeScanner (){try { if(reader != null) {reader.close(); }} 
   catch (Exception e){System.err.println("Error closing reader.");}}
   
}//end of class