/**
 * Created by alexandrugutu on 5/1/14.
 */

import javax.swing.*;

/**
 * Name assignment 8
 * Due Date Tuesday, May 6, 2014 10:00:00 PM EDT
 * Points Possible 100
 * This assignment is due Tuesday May 6 at 10 PM
 *
 * this is also the cutoff date.
 *
 *
 * 1)
 *
 * a) Create a recursive static method called summation that will take in 2
 * parameters of type int and return the sum of all of the numbers from the
 * 1st number to the 2nd number (including the 1st and last number). Assume
 * the 1st parameter is less than or equal to the 2nd parameter.
 *
 * b) Create another method called summation2, which does the same thing as
 * summation except that the 1st parameter could be less than the 2nd.
 *
 *
 * 2)
 *
 * a) Create a recursive method in class Node. Call it partialSum. The method
 * should return the sum of the data value of Node the method was called on and
 * the sum of the data values of all of the Nodes after it in the LinkedList. For
 * example, if the values in the nodes in the list are 1 through 13, and method
 * partial sum is called on the 7th node, the method should return 70.
 *
 * b) Create a method in class LinkedList called printBack() on its head variable.
 * Create method printBack in class Node. This method should output to the console
 * in reverse order the data values in each node from the last node in the list
 * until the current node. So, for the example in part 2a, the output should look like:
 *
 * 13 12 11 10 9 8 7
 */



public class Driver
	{

		private static int sum;

		public static void main(String[] args)
			{
				int start = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter a starting number: "));
				int end = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter an ending number: "));

				summation2(start, end);

				LinkedList partialSummation = new LinkedList(1);
				for (int i = 2; i < 15; i++)
					{
						partialSummation.append(i);
					}

				System.out.println();
				System.out.println();

				System.out.println(partialSummation.toString());

				System.out.println(partialSummation.find(7).partialSum());

				System.out.println();
				System.out.println();

				System.out.println(partialSummation.toString());
				partialSummation.getHead().printBack();
			}

		public static void summation(int s, int e)
			{
				if (s <= e)
					{
						sum += s;
						System.out.println(s + " | " + e + " | " + sum);

						summation(s + 1, e);
					}
			}

		public static void summation2(int s, int e)
			{
				if (e < s)
					{
						sum += e;
						System.out.println(s + " | " + e + " | " + sum);

						summation2(s, e + 1);
					}
				else if (s < e)
					{
						sum = sum + s;
						System.out.println(s + " | " + e + " | " + sum);

						summation2(s + 1, e);
					}
				else
					{
						System.out.println(s + " | " + e + " | " + sum);
					}
			}


	}


