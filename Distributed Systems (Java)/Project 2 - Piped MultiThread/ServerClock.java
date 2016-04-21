package Server;

/**
 * Created by alexandrugutu on 12/21/15.
 */



public class ServerClock extends Thread
	{
		private String name;
		private int number;
		private ServerMonitor monitor;

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


		ServerClock(String name)
			{
				super(name);

				this.name = name;

				System.out.println(this);

				this.setPriority(10);

				startTime = System.currentTimeMillis();

				start();
			}

		ServerClock(String name, int number)
			{
				super(name);

				this.name = name;
				this.number = number;

				System.out.println(this);

				this.setPriority(10);

				startTime = System.currentTimeMillis();

				start();
			}

		ServerClock(String name, int number, ServerMonitor monitor)
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

		public void notifyParade1()
			{
				printMessage("Parade 1 is about to begin!");
				monitor.notifyParadeStarting();
			}

		public void notifyParade2()
			{
				printMessage("Parade 2 is about to begin!");
				monitor.notifyParadeStarting();
			}

		public void notifyParade3()
			{
				printMessage("Parade 3 is about to begin!");
				monitor.notifyParadeStarting();
			}

		public void notifyParade4()
			{
				printMessage("Parade 4 is about to begin!");
				monitor.notifyParadeStarting();
			}

		public void notifyParade5()
			{
				printMessage("Parade 5 is about to begin!");
				monitor.notifyParadeStarting();
			}

		public void notifyParade6()
			{
				printMessage("Parade 6 is about to begin!");
				monitor.notifyParadeStarting();
			}

		public void notifyParade7()
			{
				printMessage("Parade 7 is about to begin!");
				monitor.notifyParadeStarting();
			}

		public void notifyShow1()
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

		public void notifyShow2()
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

		public void notifyShow3()
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

		public void endDay()
			{
				printMessage("The day is about to be over folks! Get home safe!");
			}


		public void run()
			{
				while(System.currentTimeMillis() - startTime < 58000)
					{
						if ((System.currentTimeMillis() - startTime) == paradeOne)
							{
								notifyParade1();
							}
						else if ((System.currentTimeMillis() - startTime) == paradeTwo)
							{
								notifyParade2();
							}
						else if ((System.currentTimeMillis() - startTime) == paradeThree)
							{
								notifyParade3();
							}
						else if ((System.currentTimeMillis() - startTime) == paradeFour)
							{
								notifyParade4();
							}
						else if ((System.currentTimeMillis() - startTime) == paradeFive)
							{
								notifyParade5();
							}
						else if ((System.currentTimeMillis() - startTime) == paradeSix)
							{
								notifyParade6();
							}
						else if ((System.currentTimeMillis() - startTime) == paradeSeven)
							{
								notifyParade7();
							}
						else if ((System.currentTimeMillis() - startTime) == showTimeOne)
							{
								notifyShow1();
							}
						else if ((System.currentTimeMillis() - startTime) == showTimeTwo)
							{
								notifyShow2();
							}
						else if ((System.currentTimeMillis() - startTime) == showTimeThree)
							{
								notifyShow3();
							}
						else if ((System.currentTimeMillis() - startTime) == 57000)
							{
								endDay();
							}

					}

			}
	}
