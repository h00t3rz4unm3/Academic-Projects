/**
 * Created by Alex on 11/23/2015.
 */

import java.io.*;
import java.util.*;

// TB sends objects to TA and TC, and receives primitive data from TC.

public class ThreadB extends Thread
	{
		private PipedInputStream pipedInputStreamB;
		private PipedOutputStream pipedOutputStreamA;
		private PipedOutputStream pipedOutputStreamC;

		private ObjectOutputStream objectOutputStreamA;
		private ObjectOutputStream objectOutputStreamC;

		// ThreadB B = new ThreadB(pisCB, posBA, posBC);

		public ThreadB(PipedInputStream pipedInputStreamB, PipedOutputStream pipedOutputStreamA, PipedOutputStream pipedOutputStreamC)
			{
				this.pipedInputStreamB = pipedInputStreamB;
				this.pipedOutputStreamA = pipedOutputStreamA;
				this.pipedOutputStreamC = pipedOutputStreamC;
			}

		public void run()
			{
				try
					{
						Random randomNumber = new Random();

						// Receive primitive from C
						System.out.println("Thread B has received " + pipedInputStreamB.read() + " from Thread C");

						// Send object to A
						Message outgoingObjectA = new Message(randomNumber.nextInt(), randomNumber.nextInt());
						System.out.println("Thread B has sent out a message with number: " + outgoingObjectA.number + " and ID: " + outgoingObjectA.id + " to thread A");
						objectOutputStreamA = new ObjectOutputStream(pipedOutputStreamA);
						objectOutputStreamA.writeObject(outgoingObjectA);

						// Send object to C
						Message outgoingObjectC = new Message(randomNumber.nextInt(), randomNumber.nextInt());
						System.out.println("Thread B has sent out a message with number: " + outgoingObjectC.number + " and ID: " + outgoingObjectC.id + " to thread C");
						objectOutputStreamC = new ObjectOutputStream(pipedOutputStreamC);
						objectOutputStreamC.writeObject(outgoingObjectC);
					}
				catch (Exception e)
					{

					}
			}
	}
