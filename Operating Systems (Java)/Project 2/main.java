import java.util.Vector;

/**
 * Created by alexandrugutu on 5/7/15.
 */
public class main
	{
		public static int numOfStudents;
		public static int tableCapacity;
		public static int numTables;

		public static Bathroom bathroom;
		public static Classroom classroom;
		public static Thread[] students;
		public static Thread teacher;
		public static DiningRoom diningRoom;

		public static void main(String[] args)
			{
				try
					{
//						numOfStudents = Integer.parseInt(args[0]);
						numOfStudents = 3;
						tableCapacity = 4;
						numTables = 3;


						bathroom = new Bathroom(numOfStudents);
						classroom = new Classroom(numOfStudents, 30);
						teacher = new teacherThread("Teacher");
						diningRoom = new DiningRoom(tableCapacity, numTables);

						students = new Thread[numOfStudents];
						for (int i = 0; i < numOfStudents; i++)
							{
								students[i] = new studentThread("Student " + i+1);
							}
					}

				catch (NumberFormatException exception)
					{
						System.out.println("Please enter a valid integer value");
					}
			}
	}
