import sun.awt.image.ImageWatched;

/**
 * Created by alexandrugutu on 3/6/14.
 */

public class LinkedList
	{

		private Node head;

		public LinkedList(int data)
		{
			head = new Node(data);
		}

		public LinkedList(Node n)
		{
			head = n;
		}

		// Method to add to the end of the node list
		public void append(int data)
		{
			if (head != null)
			{
				Node current = head;
				while (current.getNext() != null)
				{
					current = current.getNext();
				}

				current.setNext(new Node(data));
			}
			// Else statement adds to the start of the list
			else
			{
				head = new Node(data);
			}
		}

		// Method to insert nodes into the list
		public void insert(int data)
		{
			Node current = head;
			Node previous = head;

			boolean inserted = false;

			if (head.getData() > data)
			{
				head = new Node(data, head);
			}
			else
			{
				while (current != null)
				{
					if (current.getData() < data)
					{
						previous = current;
						current = current.getNext();
					}
					else
					{
						Node n = new Node(data);
						previous.setNext(n);
						n.setNext(current);

						inserted = true;

						break;
					}
				}

				if (current == null)
				{
					previous.setNext(new Node(data));
				}

			}
		}

		public Node find(int data)
		{
			Node current = head;
			while (current != null)
			{
				if (current.getData() == data)
				{
					break;
				}
				else
				{
					current = current.getNext();
				}
			}

			return current;

		}

		public boolean delete(int data)
		{
			boolean found = false;
			Node current = head;
			Node previous = head;

			if (head.getData() == data)
			{
				head = head.getNext();
				return true;
			}

			while (current != null)
			{
				if (current.getData() == data)
				{
					previous.setNext(current.getNext());
					return true;
				}
				else
				{
					previous = current;
					current = current.getNext();
				}
			}

			return false;

		}

		public String toString()
		{
			String s = "";
			Node current = head;
			while (current != null)
			{
				s = s + current.getData() + " ";
				current = current.getNext();
			}

			return s;

		}

		public void replace(int target, int newvalue)
		{
			Node current = head;
			while (current != null)
			{
				if (current.getNext().getData() == target)
				{
					current.setNext(new Node(newvalue, current.getNext().getNext()));
					break;
				}
				else
				{
					current = current.getNext();
				}

			}
		}

		public void sum()
		{
			Node current = head;
			int sum = 0;
			while (current != null)
			{
				sum += current.getData();
				current = current.getNext();
			}
			System.out.println("The sum of the LinkedList is: " + sum);
		}

	}

