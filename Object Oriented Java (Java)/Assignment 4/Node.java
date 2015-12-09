/**
 * Created by alexandrugutu on 3/6/14.
 */
public class Node
	{
		private int data;
		private Node next;

		public Node(int data)
		{
			this.data = data;
		}

		public Node(int data, Node n)
		{
			this.data = data;
			next = n;
		}

		public int getData()
		{
			return data;
		}

		public Node getNext()
		{
			return next;
		}

		public void setNext(Node n)
		{
			next = n;
		}




	}