/**
 * Created by alexandrugutu on 3/25/14.
 */
public class Queue extends LinkedList
{
	Node back = head;

	public Queue(int data)
	{
		super(data);
		count++;

	}

	// Inserts a node
	public void insert(int data)
	{
		if (count == 1)
			{
				back = new Node(data, head);
			}
		else
			{
				back = new Node(data, back);
			}
		count++;
	}

	// Delete the number of nodes
	public boolean delete(int number)
	{

		if (number > count)
			{
				clearAll();
				return true;
			}
		else
			{
				for (int i = 0; i < number; i++)
					{
						Node current = back;

						while (current != head)
							{
								if (current.getNext() == head)
									{
										current.getNext().setNext(null);

										head = current;
									}
								else
									{
										current = current.getNext();
									}
							}
						count--;
					}
			}
		return true;
	}

	// Clears the queue using delete
	public void clearAll()
		{
			int size = count;
			for (int i = 0; i < size; i++)
				{
					System.out.print(head.getData() + " ");
					delete(1);
				}
		}

}
