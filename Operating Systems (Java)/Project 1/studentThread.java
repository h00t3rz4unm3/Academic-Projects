
/**
 * Created by Alexandru Gutu on 4/16/15.
 *
 * Copyright (c) 2015 Alexandru Gutu. All rights reserved.
 */

import java.util.*;

public class studentThread extends Thread
	{
		public boolean waitingForClass;
		public boolean usedBathroom;
		public long startTime;
		public long class1Start;
		public long class2Start;
		public long class3Start;

		public int classCount;

		studentThread(String threadName)
			{
				super(threadName);
				System.out.println(this);

				waitingForClass = false;
				usedBathroom = false;
				classCount = 0;

				startTime = System.currentTimeMillis();

				start();
			}

		studentThread()
			{
				super();
				System.out.println(this);

				waitingForClass = false;
				usedBathroom = false;
				classCount = 0;

				startTime = System.currentTimeMillis();

				start();
			}

		protected void printMessage(String message)
			{
				System.out.println("[" + (System.currentTimeMillis() - startTime) + "] " + getName() + ": " + message);
			}

		protected void wakeUp()
			{
				try
					{
						Thread.sleep(new Random().nextInt(4000));
					}
				catch (InterruptedException e)
					{
						e.printStackTrace();
					}

				printMessage(currentThread().getName() + " woke up. Going to the bathroom!");

				main.bathroom.addStudent(currentThread());
			}

		protected void useBathroom()
			{
				while (usedBathroom != true)
					{
						if (!main.bathroom.getBathroomStatus())
							{
								main.bathroom.useBathroom();
								usedBathroom = true;
							}
						else
							{
								printMessage("is waiting for " + main.bathroom.lineOfStudents.firstElement().getName() + " to finish using the bathroom.");
								do
									{
										Thread.yield();
									}
								while (main.bathroom.getBathroomStatus() == true);
							}
					}

				if (usedBathroom == true)
					{
						goToClass(1);
						goToClass(2);
						goToClass(3);
					}
			}

		protected void goToClass(int classNumber)
			{
				if (classNumber == 1)
				{
					if (main.classroom.getClass1StartStatus() != true)
						{
							waitingForClass = true;
							main.classroom.addStudent(currentThread());
							classCount++;
							printMessage("waiting for class 1 to start");
							while (main.classroom.getClass1StartStatus() != true)
								{

								}
							class1Start = (System.currentTimeMillis() - startTime);
							inClass();
						}
					else
						{
							try
								{
									printMessage("missed class 1. Running errands");
									Thread.sleep(new Random().nextInt(2000));
								}
							catch (InterruptedException e)
								{
									e.printStackTrace();
								}
						}
				}

				else if (classNumber == 2)
					{
						if (main.classroom.getClass2StartStatus() != true)
							{
								waitingForClass = true;
								main.classroom.addStudent(currentThread());
								classCount++;
								printMessage("waiting for class 2 to start");
								while (main.classroom.getClass2StartStatus() != true)
									{

									}
								class2Start = (System.currentTimeMillis() - startTime);
								inClass();
							}
						else
							{
								try
									{
										printMessage("missed class 2. Running errands");
										Thread.sleep(new Random().nextInt(2000));
									}
								catch (InterruptedException e)
									{
										e.printStackTrace();
									}
							}
					}

				else if (classNumber == 3)
					{
						if (main.classroom.getClass3StartStatus() != true)
							{
								waitingForClass = true;
								main.classroom.addStudent(currentThread());
								classCount++;
								printMessage("waiting for class 3 to start");
								while (main.classroom.getClass3StartStatus() != true)
									{

									}
								class3Start = (System.currentTimeMillis() - startTime);
								inClass();
							}

						else
							{
								try
									{
										printMessage("missed class 3. Running errands");
										Thread.sleep(new Random().nextInt(2000));
									}
								catch (InterruptedException e)
									{
										e.printStackTrace();
									}
							}
					}
			}

		protected void inClass()
			{
				try
					{
						printMessage("in class " + classCount + ", waiting for class to end");
						Thread.sleep(50000);
					}
				catch (InterruptedException e)
					{
						haveFun();
					}
			}

		protected void haveFun()
			{
				try
					{
						printMessage("PARTY TIME!!!!");
						Thread.currentThread().setPriority(MAX_PRIORITY);
						Thread.sleep(new Random().nextInt(3000));
						printMessage("is done partying");
						Thread.currentThread().setPriority(NORM_PRIORITY);
					}
				catch (InterruptedException e)
					{
						return;
					}
			}

		synchronized protected void printOut(int classesAttended)
			{
				System.out.println();
				if (classesAttended == 0)
					{
						printMessage("LAZY BUM! No classes attended");
					}
				else if (classesAttended == 1)
					{
						printMessage(" Classes Attended: " + classCount + " at: " + class1Start);
					}
				else if (classesAttended == 2)
					{
						printMessage(" Classes Attended: " + classCount + " at: " + class1Start + ", " + class2Start);
					}

				else if (classesAttended == 3)
					{
						printMessage(" Classes Attended: " + classCount + " at: " + class1Start + ", " + class2Start + ", " + class3Start);
					}
				System.out.println();
			}

		protected void goHome()
			{
				printMessage("going home");
				for (int i = main.students.length; i == 0; i--)
					{
						try
							{
								main.students[i].join();
							}
						catch (InterruptedException e)
							{
								e.printStackTrace();
							}
					}
			}

		public void run()
			{
				printMessage("is running.");
				wakeUp();
				useBathroom();
				printOut(classCount);
				goHome();
			}

	}
