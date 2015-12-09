/**
 * Created by alexandrugutu on 2/25/14.
 */

/**
 *		The due date is Thurs. March 6th before midnight.
 *		The cutoff date is Tues March 10th before lab begins (5:30 pm)
 *
 *		We mentioned during lecture that Arrays are limited in two specific ways:
 *		1) Their size is fixed and cannot be increased when needed
 *		2) Inserting into a sorted array would require a lot of work.
 *
 *		For this assignment you will create an object that will do the work to address both of these points.
 *
 *
 *		Create an object called GSSArray. (it stands for growable self-sorting array)
 *
 *		This object will manage an array of type int.
 *		Create a private variable for an array of type int.
 *		In the constructor for this object, take in an int value which will determine the starting size of the array.
 *		The constructor should also instantiate the array.
 *
 *		Create a public method called insert, which will take in an int and find the location in the array where it belongs and insert it there.
 *		If the array is full, then before inserting the value, method insert should call private method increaseSize, which will create a new array which is double the size of the current array. Then it will copy the values from the original array into the new array and set the private variable to this new array.
 *
 *		The array should keep track of how many of its indexes are filled. Create a private variable called lastindex which will be equal to the last index of the array that has a value.
 *
 *		Create a public method delete, which will take an int and if will remove the 1st instance of that number in the array. If the number doesn't exist, the method should return false, otherwise it should return true. (Don't forget to update variable lastindex in methods delete and insert.)
 *
 *
 *		***HINT****
 *		(you dont have to follow this hint, you can create the method without it, but with this advice you can make your method more efficient)
 *		For the insert method:
 *		look for the location from the end of the array, instead of the beginning of the array.
 **/

public class GSSArray
	{

		private int size;
		private int array[];
		private static int lastIndex;

		// Constructor
		public GSSArray(int s)
			{
				size = s;
				lastIndex = 0;
				array = new int[size];
			}

		// Method for printing the contents of the array to the screen. Mostly debugging purposes.
		public void getContents()
			{
				for (int i = 0; i < array.length; i++)
					{
						System.out.print(array[i] + " ");
					}
			}

		// Methods

		// Method to increase the size of the array.
		// This first initiates a new array with double the
		// lenght of the original. After, it copies everything from previous array into the temp array.
		// After that, it simply rewrites the pointer pointing to the original array to point to the temp array.
        private void increaseSize()
        {
			// Temp array initialization
            int temp[] = new int[array.length * 2];

			// Copying of data from original array to temp array
            for (int i = 0; i < array.length; i++)
            {
                temp[i] = array[i];
            }

			// Pointer redirection/overwriting
            array = temp;
        }

		// Method for inserting numbers into the array.
        public void insert(int data)
        {
			// Verify that the lastindex is not equal to the size of the array.
			// If it is, call increasesize function
			if (lastIndex == array.length - 1)
			{
				increaseSize();
			}

			// For loop beginning at the first element of the array untill it
			// locates the position it should go in. If the data is greater than all elements of the array,
			// place it in the lastindex (end of array) Otherwise, if it goes in the middle, shift
			// everything to the right using a for loop starting at last index and decreasing by 1 each time.
			for (int i = 0; i < array.length - 1; i++)
			{
				if (data > array[i])
				{
					array[lastIndex] = data;
				}
				else
				{
					for (int j = lastIndex-1; j >= i; j--)
					{
						array[j+1] = array[j];
						// Handle: Made by h00t3rz4unm3
					}
					array[i] = data;
					break;
				}
			}


			// Each insertion increases the lastindex by 1.
			lastIndex++;
		}
		// Method called when deleting an element of the array.
		public boolean delete(int target)
			{
				boolean delete = false;
				for (int i = 0; i < lastIndex; i++)
					{
						// Looks for the element in the array. Once found it will shift everything left by 1,
						// replacing the deleted element with the element next to it
						if (array[i] == target)
							{
                                for (int j = i; j < lastIndex; j++)
                                {
                                    array[j] = array[j + 1];
                                }

								// Zeros out the array element at lastindex because it will be doubled otherwise
                                array[lastIndex] = 0;
							    delete = true;

								// Decrease lastindex by 1
                                lastIndex--;
                                return delete;
                            }
					}

			    return delete;

			}
	}
