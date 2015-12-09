/**
 * Created by alexandrugutu on 9/29/14.
 */

public class linkedList
	{
		// Head of the linked list
		protected Node listHead;

		// Constructor accepting one parameter - String
		public linkedList(String strData)
			{
				listHead = new Node(strData);
			}

		// Constructor accepting a different tpe of parameter - Node
		public linkedList(Node n)
			{
				listHead = n;
			}

		// Function that returns the head Node of the list
		public Node getHead() { return listHead; }

	}
