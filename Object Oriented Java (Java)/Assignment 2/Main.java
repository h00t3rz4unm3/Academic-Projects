
/**
 * Created by: {Alexandru Gutu}
 * Date: 2/11/14.
 * Time: 6:44 PM
 *
 * Create a class with a main method that creates 2 arrays, each of size 50. (or a length of 50 if you prefer) One should be an array of Strings and the other an array of ints.
 * Use the random method of class Math to generate 50 numbers between the values 0 and 1000 (I dont care if you include 1000 or not). Use the Java API to look up this method and to look at the hint at the bottom of this assignment.
 * Populate (the verb used for filling up) the array of ints with these 50 numbers. Convert the numbers to Strings and populate the array of Strings with the String representation of these 50 numbers.
 * Print out each unsorted array. Use a 2 for loops to iterate through the arrays. First print out all of the int values (on one line) then print out all the String values (on the next line).
 * Call a Bubble Sorting method and pass the array of ints to it. Call a Selection Sort method and pass the array of Strings to it.
 * You will have to create a new Selection Sort method.
 * Print out both arrays. They should both be sorted. Are the sorted arrays in the same sequence? If not, Why not?
 * In a separate text document BRIEFLY explain:
 * 1) why did you have to create a new Selection Sort method? There are at least 2 reasons.
 * 2) why are the arrays not sorted the same way? If you are lost, look in the JAVA API documentation.
 */

import static java.lang.Math.random;

public class Main
	{

	public static void main(String[] args)
		{

		int intarray[] = new int[50];

		String stringarray[] = new String[50];

		for (int i = 0; i < intarray.length; i++)
			{
				intarray[i] = (int)(1000 * random());
				stringarray[i] = intarray[i] + "";
			}

		System.out.print("Unosrted Integers: ");

		for (int i = 0; i < intarray.length; i++)
			{
				System.out.print(intarray[i] + " " );
			}

		System.out.println();
		System.out.print("Unsorted Strings: ");

		for (int i = 0; i < intarray.length; i++)
			{
				System.out.print(stringarray[i] + " ");
			}

		System.out.println();
		System.out.println();

		BubbleSort(intarray);
		SelectionSort(stringarray);

		System.out.println();
		System.out.print("Sorted Integers: ");

		for (int i = 0; i < intarray.length; i++)
			{
				System.out.print(intarray[i] + " ");
			}

		System.out.println();
		System.out.print("Sorted Strings: ");

		for (int i = 0; i < intarray.length; i++)
			{
				System.out.print(stringarray[i] + " ");
			}

		}



		public static void BubbleSort(int array[])
		{
			for (int i = 0; i < array.length; i++)
			{
				for (int j = 0; j < array.length - 1; j++)
				{
					if (array[j] > array[i])
					{
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
		}

		// Professor Method
		public static void bubbleSort2(int array[])
		{
			for (int i = 0; i < array.length; i++)
			{
				for (int j = array.length - 1; j > i; j--)
				{
					if (array[j] < array[j - 1])
					{
						int temp = array[j];
						array[j] = array[j - 1];
						array[j - 1] = temp;
					}
				}
			}
		}

		public static void SelectionSort(String array[])
		{
			int minimumindex;
			for (int i = 0; i < array.length - 1; i++)
				{
					minimumindex = i;
					for (int j = i + 1; j < array.length; j++)
						{
							if (array[j].compareTo(array[minimumindex]) < 0)
								{
									minimumindex = j;
								}
						}
							if (minimumindex != i)
								{
									String temp = array[i];
									array[i] = array[minimumindex];
									array[minimumindex] = temp;
								}

				}
		}

}




