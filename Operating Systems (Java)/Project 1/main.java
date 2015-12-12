
/**
 * Created by alexandrugutu on 4/16/15.
 *
 * Copyright (c) 2015 Alexandru Gutu. All rights reserved.
 */
public class main
	{
		public static int numOfStudents;

		public static Bathroom bathroom;
		public static Classroom classroom;
		public static Thread[] students;
		public static Thread teacher;

		public static void main(String[] args) throws NumberFormatException
			{
				try
					{
//						numOfStudents = Integer.parseInt(args[0]);
						numOfStudents = 3;

						bathroom = new Bathroom(numOfStudents);
						classroom = new Classroom(numOfStudents);
						teacher = new teacherThread("Teacher");

						students = new Thread[numOfStudents];
						for (int i = 0; i < numOfStudents; i++)
							{
								students[i] = new studentThread("Student " + i + 1);
							}
					}

				catch (NumberFormatException exception)
					{
						System.out.println("Please enter a valid integer value");
					}


			}
	}
