/**
 * Created by alexandrugutu on 12/6/15.
 */

public class main
	{
		public static Clock clockThread;

		public static OrangeUniformStudent[] OrangeStudent;
		public static BlueUniformStudent[] BlueStudent;

		public static int numberOfOrangeStudents;
		public static int numberOfBlueStudents;
		public static int numberOfSeats;
		public static Monitor monitor;

		public static void main(String[] args)
			{
				try
					{
						numberOfOrangeStudents = Integer.parseInt(args[0]);
						numberOfBlueStudents = Integer.parseInt(args[1]);
						numberOfSeats = Integer.parseInt(args[2]);

						OrangeStudent = new OrangeUniformStudent[numberOfOrangeStudents];
						BlueStudent = new BlueUniformStudent[numberOfOrangeStudents];

						monitor = new Monitor(numberOfSeats);

						clockThread = new Clock("Clock", 0, monitor);

						for (int i = 0; i < numberOfBlueStudents; i++)
							{
								BlueStudent[i] = new BlueUniformStudent("Blue" + i, i, monitor);
							}

						for (int i = 0; i < numberOfOrangeStudents; i++)
							{
								OrangeStudent[i] = new OrangeUniformStudent("Orange" + i, i, monitor);
							}
					} catch (NumberFormatException exception)
					{
						System.out.println("Please enter a valid integer value");
					}
			}
	}


