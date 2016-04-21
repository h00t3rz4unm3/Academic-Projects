/**
 * Created by Alex on 11/23/2015.
 */

import java.io.*;
import java.util.*;

// TA will send primitive data to TC and receive objects from TB.

public class ThreadA extends Thread
	{
		private PipedInputStream pipedInputStreamBA;
		private PipedOutputStream pipedOutputStreamAC;

		private ObjectInputStream objectInputStreamBA;

		// ThreadA A = new ThreadA(pisBA, posAC);

		public ThreadA(PipedInputStream pipedInputStreamBA, PipedOutputStream pipedOutputStreamAC )
			{
				this.pipedInputStreamBA = pipedInputStreamBA;
				this.pipedOutputStreamAC = pipedOutputStreamAC;
			}

		public void run()
			{
				try
					{
						Random numberGenerator = new Random();

						// Thread A sends primitive data to Thread C
						int outgoingMessageC = numberGenerator.nextInt(25);
						pipedOutputStreamAC.write(outgoingMessageC);
						System.out.println("Thread A sent " + outgoingMessageC + " to Thread C");

						objectInputStreamBA = new ObjectInputStream(pipedInputStreamBA);
						Message incomingObjectB = (Message) objectInputStreamBA.readObject();
						System.out.println("Thread A has received a message with number: " + incomingObjectB.number+ " and ID: " + incomingObjectB.id + " from B");
					}
				catch (Exception e)
					{
						System.out.println("Error encountered");
					}
			}

	}
