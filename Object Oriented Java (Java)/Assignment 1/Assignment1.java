/**
 * Created by: {Alexandru Gutu}
 * Date: 1/30/14.
 */

/**
 *  Create a class that asks the user for a number. Use a JOptionPane.
 *	Create an array of characters (chars) which is of equal size to the string that the user input.
 *	Using a for loop, check each char in the String that the user input to make sure they are all digits.
 *	If any of the characters are not a digit, display an appropriate message to the user using another JOptionPane.
 *	If all of the characters are digits, display in JoptionPane the number in reverse. 
 */

import javax.swing.*;

public class Assignment1
	{
	public static void main(String[] args)
		{

		String input = JOptionPane.showInputDialog(null, "Please enter a number:");
		// Input of initial string
		char inputarray[] = new char[input.length()];
		// Initialization of input array
		char reverse[] = new char[input.length()];
		// Initialization of reverse array

		for (int i = 0; i < input.length(); i++)
		{
			inputarray[i] = input.charAt(i);
			// Convert the input string into an array character by character
		}

		for (int i = 0; i < input.length(); i++)
		{
			if (Character.isDigit(inputarray[i]) != true)
			{
				JOptionPane.showMessageDialog(null, "Unfortunately, '" + inputarray[i] + "' is not a digit.");
				// Verifiy that everything is a number. If not display an error message and exit.
				System.exit(0);
			}
		}

		for (int i = 0; i <= input.length()-1; i++)
		{
			reverse[i] = inputarray[inputarray.length-i-1];
		}
		// For loop to convert array of characters into reversed array of characters (input)

		String test = "";
		for (int i = 0; i < input.length(); i++)
		{
			test = test + reverse[i];
		}

		System.out.println(test);

		String reversestring = new String(reverse);
		// Converts reversed string array into a string

		JOptionPane.showMessageDialog(null, reversestring);
		// Displays reversed string

		}
	}
