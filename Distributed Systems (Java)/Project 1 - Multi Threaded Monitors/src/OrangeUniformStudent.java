/**
 * Created by alexandrugutu on 12/6/15.
 */

import java.util.*;

public class OrangeUniformStudent extends Thread
	{
		private String name;
		private int number;
		private Monitor monitor;

		private int numberOfShows = 0;
		private int numberOfParades = 0;

		private Vector attendedParades;
		private Vector attendedShows;

		public static Random randomNumber = new Random();

		private static long startTime;

		OrangeUniformStudent(String name)
			{
				super(name);

				this.name = name;

				System.out.println(this);

				startTime = System.currentTimeMillis();

				attendedParades = new Vector();
				attendedShows = new Vector();

				start();
			}

		OrangeUniformStudent(String name, int number)
			{
				super(name + " " + number);

				this.name = name;
				this.number = number;

				System.out.println(this);

				startTime = System.currentTimeMillis();

				attendedParades = new Vector();
				attendedShows = new Vector();

				start();
			}

		OrangeUniformStudent(String name, int number, Monitor monitor)
			{
				super(name);

				this.name = name;
				this.number = number;
				this.monitor = monitor;

				System.out.println(this);

				startTime = System.currentTimeMillis();

				attendedParades = new Vector();
				attendedShows = new Vector();

				start();
			}

		public void printMessage(String message)
			{
				System.out.println("[" + (System.currentTimeMillis() - startTime) + "] " + this.name + " " + this.number + ": " + message);
			}

		public int randomNumberGenerator(int high, int low)
			{
				return randomNumber.nextInt(high - low) + low;
			}

		public void attendParade()
			{
				Object convey = new Object();

				synchronized (convey)
					{
						try
							{
								printMessage("Waiting for parade to start!");
								monitor.addToParade(convey);
								convey.wait();
								attendedParades.addElement(System.currentTimeMillis() - startTime);
								printMessage("Attending the parade");
								numberOfParades++;
								sleep(randomNumberGenerator(150, 50));
								printMessage("Finished the parade, what a workout!");
								snackBreak();
							}
						catch (InterruptedException e)
							{

							}
					}
			}

		public void snackBreak()
			{
				try
					{
						printMessage("Taking a snack break");
						sleep(randomNumberGenerator(50, 25));
					}
				catch (InterruptedException e)
					{

					}
			}

		public void tryToGetIntoCircusShow(int showNumber)
			{
				Object convey = new Object();

				boolean showStatus = false;

				switch (showNumber)
					{
						case 1:
							showStatus = monitor.getShow1Status();
							break;

						case 2:
							showStatus = monitor.getShow2Status();
							break;

						case 3:
							showStatus = monitor.getShow3Status();

						default:
							break;
					}

				if (monitor.addToStudentsInShow(convey) && !showStatus)
					{
						synchronized (convey)
							{
								try
									{
										printMessage("Waiting for Circus " + (numberOfShows + 1) + " show to start");
										convey.wait();
										printMessage("Show " + (numberOfShows + 1) + " is about to start!");
										attendingCircusShow();
									}
								catch (InterruptedException e)
									{

									}
							}
					}
				else
					{
						missedCircusShow();
					}

			}

		public void missedCircusShow()
			{
				Object convey = new Object();
				monitor.addToStudentsWhoMissedShow(convey);
				synchronized (convey)
					{
						try
							{
								printMessage("Missed the Circus show - waiting for the next one");
								convey.wait();
							}
						catch (InterruptedException e)
							{

							}
					}
			}

		public void attendingCircusShow()
			{
				Object convey = new Object();
				monitor.addToStudentsWaitingToLeaveShow(convey);
				synchronized (convey)
					{
						try
							{
								attendedShows.addElement(System.currentTimeMillis() - startTime);
								numberOfShows++;
								printMessage("Attending Circus show - waiting to finish");
								convey.wait();
								printMessage("Circus show over! That was awesome!");
							}
						catch (InterruptedException e)
							{

							}
					}
			}


		public void printInfo()
			{
				System.out.println("Student " + this.name + " " + this.number + " attended " + this.attendedParades.size() + " parades and saw " + this.attendedShows.size() + " circus shows");
				for (int i = 0; i < attendedParades.size(); i++)
					{
						System.out.println("Parade " + i + " - Start Time: " + attendedParades.elementAt(i));
					}
				for (int i = 0; i < attendedShows.size(); i++)
					{
						System.out.println("Show " + i + " - Start Time: " + attendedShows.elementAt(i));
					}
			}

		public boolean checkIfDone()
			{
				if (numberOfShows == 3 && numberOfParades >= 3)
					{
						return true;
					}
				else
					{
						return false;
					}
			}

		public void run()
			{
				try
					{
						while(true)
							{
								printMessage("Walking to the circus");
								sleep(25);
//								formGroup();
								attendParade();
								tryToGetIntoCircusShow(1);
								attendParade();
								attendParade();
								tryToGetIntoCircusShow(2);
								attendParade();
								tryToGetIntoCircusShow(3);
								if (checkIfDone())
									{
										break;
									}
								attendParade();
								if (checkIfDone())
									{
										break;
									}
								attendParade();
								if (checkIfDone())
									{
										break;
									}
								attendParade();
								break;
							}


						printInfo();
					}
				catch (InterruptedException e)
					{

					}
			}

	}
