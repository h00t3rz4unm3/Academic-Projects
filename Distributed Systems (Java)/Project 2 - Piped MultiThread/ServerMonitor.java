package Server; /**
 * Created by alexandrugutu on 12/21/15.
 */

import java.util.*;


public class ServerMonitor
	{

		public static Vector<Object> waitForGroup;
		public static Vector<Object> waitForParade;
		public static Vector<Object> waitForShow;
		public static Vector<Object> finishedShow;
		public static Vector<Object> missedCircusShow;
		public static Vector<Object> orangeStudents;
		public static Vector<Object> blueStudents;

		public static int numberOfSeats;
		public static int studentsInShow;
		public static int studentsMissedShow;

		public static boolean show1IsOver;
		public static boolean show2IsOver;
		public static boolean show3IsOver;

		public ServerMonitor(int numberOfSeats)
			{
				this.numberOfSeats = numberOfSeats;
				studentsInShow = 0;
				studentsMissedShow = 0;

				waitForGroup = new Vector<Object>();
				waitForParade = new Vector<Object>();
				waitForShow = new Vector<Object>();
				finishedShow = new Vector<Object>();
				missedCircusShow = new Vector<Object>();

				orangeStudents = new Vector<Object>();
				blueStudents = new Vector<Object>();

				show1IsOver = false;
				show2IsOver = false;
				show3IsOver = false;
			}

		public static synchronized void addToParade(Object convey)
			{
				waitForParade.addElement(convey);
			}

		public static synchronized boolean addToStudentsInShow(Object convey)
			{
				if (studentsInShow < numberOfSeats)
					{
						studentsInShow++;
						waitForShow.addElement(convey);
						return true;
					}
				else
					{
						return false;
					}
			}

		public static synchronized void addToStudentsWaitingToLeaveShow(Object convey)
			{
				finishedShow.addElement(convey);
			}

		public static synchronized void addToStudentsWhoMissedShow(Object convey)
			{
				missedCircusShow.addElement(convey);
			}

		public static void notifyParadeStarting()
			{
				Enumeration<Object> studentsInParade = waitForParade.elements();

				while (studentsInParade.hasMoreElements())
					{
						Object currentElemet = studentsInParade.nextElement();
						synchronized (currentElemet)
							{
								currentElemet.notify();
							}
					}

				waitForParade.clear();
			}

		public static synchronized void notifyShowStarting()
			{
				Enumeration<Object> studentsInShow = waitForShow.elements();

				while (studentsInShow.hasMoreElements())
					{
						Object currentElemet = studentsInShow.nextElement();
						synchronized (currentElemet)
							{
								currentElemet.notify();
							}
					}

				waitForShow.clear();
				notifyMissedShow();
			}

		public synchronized void notifyShowEnding()
			{
				Enumeration<Object> studentsWaitingToLeaveShow = finishedShow.elements();

				while (studentsWaitingToLeaveShow.hasMoreElements())
					{
						Object currentElemet = studentsWaitingToLeaveShow.nextElement();
						synchronized (currentElemet)
							{
								currentElemet.notify();
							}
					}

				studentsInShow = 0;

				finishedShow.clear();
				notifyMissedShow();
			}

		public static synchronized void notifyMissedShow()
			{
				Enumeration<Object> studentsWhoMissedShow = missedCircusShow.elements();

				while (studentsWhoMissedShow.hasMoreElements())
					{
						Object currentElement = studentsWhoMissedShow.nextElement();
						synchronized (currentElement)
							{
								currentElement.notify();
							}
					}

				missedCircusShow.clear();
			}

		public static void changeShow1Status()
			{
				show1IsOver = true;
			}

		public static void changeShow2Status()
			{
				show2IsOver = true;
			}

		public static void changeShow3Status()
			{
				show3IsOver = true;
			}

		public static boolean getShow1Status()
			{
				return show1IsOver;
			}

		public static boolean getShow2Status()
			{
				return show2IsOver;
			}

		public static boolean getShow3Status()
			{
				return show2IsOver;
			}

	}


