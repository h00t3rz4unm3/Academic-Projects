/**
 * Created by alexandrugutu on 3/14/15.
 *
 * Copyright (c) 2015 Alexandru Gutu. All rights reserved.
 *
 */


import java.util.*;
import java.io.*;

public class main
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        try
        {
            // Debugging purposes

            // Argument definitions
			String inputLocation = args[0];
			String outputLocation = args[1];

            // Reads and builds a set based on the data from file with space as the delimiter
            Scanner inputReading = new Scanner(new FileReader((inputLocation)));
            String input = inputReading.nextLine();
            StringTokenizer setBuilder = new StringTokenizer(input, " ");

            // Creates an array the size of the input set
            int [] inputSet = new int[setBuilder.countTokens()];

            // Fills in the array using a for loop
            for (int i = 0; i < inputSet.length; i++)
            {
                inputSet[i] = Integer.parseInt(setBuilder.nextToken());
            }

            powerSet(inputSet, outputLocation);
        }

        catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
        }

    }

    public static void powerSet(int inputSet[], String outputLocation) throws IOException
    {
        // Writer to write to file
        Writer printOut = new FileWriter(outputLocation);

        // Determines the size of the powerset
        int size = (int)Math.pow(2, inputSet.length);

        for(int i = 0; i < size; i++)
        {
            // Converts the decimal number to binary (counting purposes)
            String binaryInt = Integer.toBinaryString(i);

            // Pads the binary digit to match the proper size
            while(binaryInt.length() < inputSet.length)
            {
                binaryInt = "0" + binaryInt;
            }

            try
            {
                printOut.write("[ ");

                // Goes through the entire size of the set to see what to print
                for(int j = 0; j < inputSet.length; j++)
                {

                    // Prints the letter associated with the location based on the binary representation
                    if(binaryInt.charAt(j) == '1')
                    {
                        printOut.write(inputSet[j] + " ");
                    }
                }
                printOut.write("]" + String.format("%n"));
            }

            catch (IOException e)
            {
                System.out.println("Error creating output!");
            }

        }

        printOut.close();
    }

}
