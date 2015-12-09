/**
 * Created by alexandrugutu on 3/25/14.
 */
public class Stack extends LinkedList
{

	public Stack(int data)
	{
		super(data);
		count++;
	}

	// Insert a node
	public void insert(int data)
	{
		Node front = head;

		head = new Node(data, front);
		count++;
	}

	// Deletes the nodes based on how many you want deleted
	public boolean delete(int number)
	{
		if (number > count)
			{
				clearAll();
			}
		else
			{
				for (int i = 0; i < number; i++)
				{
					head = head.getNext();
					count--;
				}
			}
		return true;
	}


	// Clears the entire stack using delete method
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
