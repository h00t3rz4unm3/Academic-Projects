package Server; /**
 * Created by alexandrugutu on 12/21/15.
 */

import java.io.*;
import java.net.*;

public class ServerConnectionHelper extends Thread
	{
		public OrangeUniformServer orangeStudent;
		public BlueUniformServer blueStudent;
		private ServerClock clock;
		private Socket socket = null;

		public ServerConnectionHelper(Socket socket)
			{
				super();
				this.socket = socket;
			}

		public void run()
			{

				try
					{
						InputStream input = socket.getInputStream();

						InputStreamReader commandToRun = new InputStreamReader(input);

						BufferedReader inBufferedCommandToRun = new BufferedReader(commandToRun);

						String[] command = inBufferedCommandToRun.readLine().split(" ");

						String threadName = command[0];
						int commandNumber = Integer.parseInt(command[1]);

						PrintWriter threadPrinter = new PrintWriter(socket.getOutputStream(), true);

						while (inBufferedCommandToRun.readLine() != null)
							{
								runCommand(threadName, commandNumber, threadPrinter);
							}
					}
				catch (IOException e)
					{

					}
			}


		public void runCommand(String typeOfThread, int commandNumber, PrintWriter threadPrinter)
			{
				if (typeOfThread.equals("Orange"))
					{
						switch (commandNumber)
							{
								case 0:
									orangeStudent.attendParade();
									threadPrinter.write("Okay!");
									break;
								case 1:
									orangeStudent.tryToGetIntoCircusShow(1);
									threadPrinter.write("Okay!");
									break;
								case 2:
									orangeStudent.tryToGetIntoCircusShow(2);
									threadPrinter.write("Okay!");
									break;
								case 3:
									orangeStudent.tryToGetIntoCircusShow(3);
									threadPrinter.write("Okay!");
									break;
							}
					}

				else if (typeOfThread.equals("Blue"))
					{
						switch (commandNumber)
							{
								case 0:
									blueStudent.attendParade();
									threadPrinter.write("Okay!");
									break;
								case 1:
									blueStudent.tryToGetIntoCircusShow(1);
									threadPrinter.write("Okay!");
									break;
								case 2:
									blueStudent.tryToGetIntoCircusShow(2);
									threadPrinter.write("Okay!");
									break;
								case 3:
									blueStudent.tryToGetIntoCircusShow(3);
									threadPrinter.write("Okay!");
									break;
							}
					}
				else if (typeOfThread.equals("Clock"))
					{
						switch (commandNumber)
							{
								case 0:
									clock.notifyParade1();
									threadPrinter.write("Okay!");
									break;
								case 1:
									clock.notifyParade2();
									threadPrinter.write("Okay!");
									break;
								case 2:
									clock.notifyParade3();
									threadPrinter.write("Okay!");
									break;
								case 3:
									clock.notifyParade4();
									threadPrinter.write("Okay!");
									break;
								case 4:
									clock.notifyParade5();
									threadPrinter.write("Okay!");
									break;
								case 5:
									clock.notifyParade6();
									threadPrinter.write("Okay!");
									break;
								case 6:
									clock.notifyParade7();
									threadPrinter.write("Okay!");
									break;
								case 7:
									clock.notifyShow1();
									threadPrinter.write("Okay!");
									break;
								case 8:
									clock.notifyShow2();
									threadPrinter.write("Okay!");
									break;
								case 9:
									clock.notifyShow3();
									threadPrinter.write("Okay!");
									break;
								case 10:
									clock.endDay();
									threadPrinter.write("Okay!");
									break;
							}
					}
			}
	}
