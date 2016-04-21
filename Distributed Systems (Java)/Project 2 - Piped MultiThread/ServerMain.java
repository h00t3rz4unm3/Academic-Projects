package Server; /**
 * Created by alexandrugutu on 12/21/15.
 */

import java.io.*;
import java.net.*;

public class ServerMain
	{
		public void run()
			{
//				int portNumber = Integer.parseInt(args[0]);

				int portNumber = 17318;

				try
					{
						ServerSocket server = null;
						server = new ServerSocket(portNumber);

						while(true)
							{
								new ServerConnectionHelper(server.accept()).start();
							}



					}
				catch (IOException e)
					{

					}
			}

		public static void main(String[] args)
			{
				new ServerMain();
			}
	}
