/**
 * Created by alexandrugutu on 9/29/14.
 */

public class Node
	{
		// Node data and pointer to next node
		private String strData;
		private Node nextNode;

		// Constructor accepting one parameter
		public Node(String data)
			{
				strData = data;
			}

		// Constructor accepting two parameters
		public Node(String data, Node next)
			{
				strData = data;
				nextNode = next;
			}

		// Funtion to retrieve data in node
		public String getData()
			{
				return strData;
			}

		// Function to retrieve the next linked node
		public Node getNext()
			{
				return nextNode;
			}

		// Function to set the next linked node
		public void setNext(Node newNode)
			{
				nextNode = newNode;
			}
	}