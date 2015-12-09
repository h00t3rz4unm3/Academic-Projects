
/**
 * Created by alexandrugutu on 5/6/14.
 */

public class LinkedList3 <T>
	{
		private Node3 head;

		public LinkedList3(T data)
			{
				head = new Node3(data);
			}

		public LinkedList3(Node3 n)
			{
				head = n;
			}

		// Method to add to the end of the node list
		public void append(T data)
			{
				if (head != null)
					{
						Node3 current = head;
						while (current.getNext() != null)
							{
								current = current.getNext();
							}

						current.setNext(new Node3(data));
					}
				// Else statement adds to the start of the list
				else
					{
						head = new Node3(data);
					}
			}

		// Method to insert nodes into the list
		public void insert(T data)
			{
				Node3 current = head;
				Node3 previous = head;

				boolean inserted = false;

//				if (head.getData() > data)
				if (head.getData().compareTo(data) > 0)
					{
						head = new Node3(data, head);
					}
				else
					{
						while (current != null)
							{
//								if (current.getData() < data)
								if (current.getData().compareTo(data) < 0)
									{
										previous = current;
										current = current.getNext();
									}
								else
									{
										Node3 n = new Node3(data);
										previous.setNext(n);
										n.setNext(current);

										inserted = true;

										break;
									}
							}

						if (current == null)
							{
								previous.setNext(new Node3(data));
							}

					}
			}

		public Node3 find(T data)
			{
				Node3 current = head;
				while (current != null)
					{
//						if (current.getData() == data)
						if (current.getData().equals(data))
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

		public boolean delete(T data)
			{
				boolean found = false;
				Node3 current = head;
				Node3 previous = head;

//				if (head.getData() == data)
				if (head.getData().equals(data))
						{
						head = head.getNext();
						return true;
					}

				while (current != null)
					{
//						if (current.getData() == data)
						if (current.getData().equals(data))
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
				Node3 current = head;
				while (current != null)
					{
						s = s + current.getData() + " ";
						current = current.getNext();
					}

				return s;

			}

		public void replace(T target, T newvalue)
			{
				Node3 current = head;
				while (current != null)
					{
//						if (current.getNext().getData() == target)
						if (current.getNext().getData().equals(target))
							{
								current.setNext(new Node3(newvalue, current.getNext().getNext()));
								break;
							}
						else
							{
								current = current.getNext();
							}

					}
			}

//		public void sum()
//			{
//				Node3 current = head;
//				int sum = 0;
//				while (current != null)
//					{
//						sum += current.getData();
//						current = current.getNext();
//					}
//				System.out.println("The sum of the LinkedList is: " + sum);
//			}

	}
