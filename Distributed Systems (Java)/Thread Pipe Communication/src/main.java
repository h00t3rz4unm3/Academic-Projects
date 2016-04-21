/**
 * Created by alexandrugutu on 11/23/15.
 */

import java.io.*;

// TA will send primitive data to TC and receive objects from TB.
// TB sends objects to TA and TC, and receives primitive data from TC.
// TC sends primitive to TB and receives objects from TB and primitive data from TA.

public class main
	{
		private static PipedInputStream pisAC;
		private static PipedOutputStream posAC;

		private static PipedInputStream pisCB;
		private static PipedOutputStream posCB;

		private static PipedInputStream pisBC;
		private static PipedOutputStream posBC;

		private static PipedInputStream pisBA;
		private static PipedOutputStream posBA;

		public static void main(String[] args)
			{
				try
					{
						System.out.println("Setting up the pipes");

						pisAC = new PipedInputStream();
						posAC = new PipedOutputStream(pisAC);

						pisBA = new PipedInputStream();
						posBA = new PipedOutputStream(pisBA);

						pisBC = new PipedInputStream();
						posBC = new PipedOutputStream(pisBC);

						pisCB = new PipedInputStream();
						posCB = new PipedOutputStream(pisCB);

						// TA will send primitive data to TC and receive objects from TB.
						ThreadA A = new ThreadA(pisBA, posAC);

						// TB sends objects to TA and TC, and receives primitive data from TC.
						ThreadB B = new ThreadB(pisCB, posBA, posBC);

						// TC sends primitive to TB and receives objects from TB and primitive data from TA.
						ThreadC C = new ThreadC(posCB, pisAC, pisBC);

						A.start();
						B.start();
						C.start();
						}
				catch ( Exception e)
					{

					}
			}

	}
