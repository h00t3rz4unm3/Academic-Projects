/**
 * Created by alexandrugutu on 12/6/15.
 */

public class Clock extends Thread
	{
		private String name;
		private int number;
		private Monitor monitor;

		private static long startTime;

		private static long paradeOne = 18000;                	// 11:00 AM
		private static long paradeTwo = 24000;                	// 12:00 PM
		private static long paradeThree = 30000;            	// 1:00 PM
		private static long paradeFour = 36000;                	// 2:00 PM
		private static long paradeFive = 42000;                	// 3:00 PM
		private static long paradeSix = 48000;                	// 4:00 PM
		private static long paradeSeven = 54000;            	// 5:00 PM

		private static long showTimeOne = 18450;            	// 11:45 AM
		private static long showTimeTwo = 30150;            	// 1:15 PM
		private static long showTimeThree = 36450;            	// 2:45 PM


		Clock(String name)
			{
				super(name);

				this.name = name;

				System.out.println(this);

				this.setPriority(10);

				startTime = System.currentTimeMillis();

				start();
			}

		Clock(String name, int number)
			{
				super(name);

				this.name = name;
				this.number = number;

				System.out.println(this);

				this.setPriority(10);

				startTime = System.currentTimeMillis();

				start();
			}

		Clock(String name, int number, Monitor monitor)
			{
				super(name);

				this.name = name;
				this.number = number;
				this.monitor = monitor;

				System.out.println(this);

				this.setPriority(10);

				startTime = System.currentTimeMillis();

				start();
			}

		public void printMessage(String m)
			{
				System.out.println("[" + (System.currentTimeMillis() - startTime) + "] " + getName() + ": " + m);
			}

		public void run()
			{
				while(System.currentTimeMillis() - startTime < 58000)
					{
						if ((System.currentTimeMillis() - startTime) == paradeOne)
							{
								printMessage("Parade 1 is about to begin!");
								monitor.notifyParadeStarting();
							}
						else if ((System.currentTimeMillis() - startTime) == paradeTwo)
							{
								printMessage("Parade 2 is about to begin!");
								monitor.notifyParadeStarting();
							}
						else if ((System.currentTimeMillis() - startTime) == paradeThree)
							{
								printMessage("Parade 3 is about to begin!");
								monitor.notifyParadeStarting();
							}
						else if ((System.currentTimeMillis() - startTime) == paradeFour)
							{
								printMessage("Parade 4 is about to begin!");
								monitor.notifyParadeStarting();
							}
						else if ((System.currentTimeMillis() - startTime) == paradeFive)
							{
								printMessage("Parade 5 is about to begin!");
								monitor.notifyParadeStarting();
							}
						else if ((System.currentTimeMillis() - startTime) == paradeSix)
							{
								printMessage("Parade 6 is about to begin!");
								monitor.notifyParadeStarting();
							}
						else if ((System.currentTimeMillis() - startTime) == paradeSeven)
							{
								printMessage("Parade 7 is about to begin!");
								monitor.notifyParadeStarting();
							}
						else if ((System.currentTimeMillis() - startTime) == showTimeOne && !monitor.show1IsOver)
							{
								try
									{
										printMessage("Show 1 is about to begin!");
										monitor.changeShow1Status();
										monitor.notifyShowStarting();
										sleep(125);
										printMessage("Show 1 is about to finish!");
										monitor.notifyShowEnding();
									}
								catch (InterruptedException e)
									{

									}
							}
						else if ((System.currentTimeMillis() - startTime) == showTimeTwo && !monitor.show2IsOver)
							{
								try
									{
										printMessage("Show 2 is about to begin!");
										monitor.changeShow2Status();
										monitor.notifyShowStarting();
										sleep(125);
										printMessage("Show 2 is about to finish!");
										monitor.notifyShowEnding();
									}
								catch (InterruptedException e)
									{

									}
							}
						else if ((System.currentTimeMillis() - startTime) == showTimeThree && !monitor.show3IsOver)
							{
								try
									{
										printMessage("Show 3 is about to begin!");
										monitor.changeShow3Status();
										monitor.notifyShowStarting();
										sleep(125);
										printMessage("Show 3 is about to finish!");
										monitor.notifyShowEnding();
									}
								catch (InterruptedException e)
									{

									}
							}
						else if ((System.currentTimeMillis() - startTime) == 57000)
							{
								printMessage("The day is about to be over folks! Get home safe!");
							}

					}

			}
	}
