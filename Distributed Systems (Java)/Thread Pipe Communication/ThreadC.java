/**
 * Created by Alex on 11/23/2015.
 */

import java.io.*;
import java.util.*;

// TC sends primitive to TB and receives objects from TB and primitive data from TA.

public class ThreadC extends Thread
	{
		private PipedOutputStream pipedOutputStreamB;
		private PipedInputStream pipedInputStreamA;
		private PipedInputStream pipedInputStreamB;

		private ObjectInputStream objectInputStreamB;

		// ThreadC C = new ThreadC(posCB, pisAC, pisBC);


		public ThreadC(PipedOutputStream pipedOutputStreamB, PipedInputStream pipedInputStreamA, PipedInputStream pipedInputStreamB)
			{
				this.pipedOutputStreamB = pipedOutputStreamB;
				this.pipedInputStreamA = pipedInputStreamA;
				this.pipedInputStreamB = pipedInputStreamB;
			}

		public void run()
			{
				try
					{
						Random randomNumber = new Random();

						// Send primitive data to B
						int outgoingMessageB = randomNumber.nextInt(25);
						pipedOutputStreamB.write(outgoingMessageB);
						System.out.println("Thread C sent " + outgoingMessageB + " to Thread B");

						// Receive primitive data from A
						System.out.println("Thread C received " + pipedInputStreamA.read() + " from Thread A");

						// Receive object from B
						objectInputStreamB = new ObjectInputStream(pipedInputStreamB);
						Message incomingObjectB = (Message) objectInputStreamB.readObject();
						System.out.println("Thread C has received a message with number: " + incomingObjectB.number + " and ID: " + incomingObjectB.id + " from thread B");




					}
				catch (Exception e)
					{

					}

			}
	}
