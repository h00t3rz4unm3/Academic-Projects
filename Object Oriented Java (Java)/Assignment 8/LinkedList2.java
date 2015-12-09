/**
 * Created by alexandrugutu on 3/6/14.
 */

// BiDirectional Linked List

public class LinkedList2
{

	private Node2 head;
	private Node2 last;

	public LinkedList2 (int d)
	{
		head = new Node2(d);
		last = head;
	}

	public LinkedList2 (Node2 n)
	{
		head = n;
		last = head;
	}

	public Node2 find (int data)
	{
		Node2 current = head;
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

	public void insert(int d)
	{

		if (head.getData() > d)	// Case 1: Insertion before head
		{
			head = new Node2 (d, head);
			head.getNext().setPrevios(head);
		}
		else
		{
			Node2 current = head;
			while (current != null)
			{
				if (current.getData() < d)
				{
					current = current.getNext();
				}
				else // Case 2: Insertion into middle of list
				{
					current.getPrevios().setNext(new Node2(d, current, current.getPrevios()));
					current.setPrevios(current.getPrevios().getNext());
					break;
				}
				if (current == null) // Case 3: insert at end
				{
					last.setNext(new Node2 (d, null, last));
					last = last.getNext();
				}
			}
		}
	}

	public boolean delete(int target)
	{
		Node2 current = find(target);
		if (current == null)
		{
			return false;
		}
		if (current.getPrevios() != null)
		{
			current.getPrevios().setNext(current.getNext());
		}
		else
		{
			head = current.getNext();
		}
		if (current.getNext() != null)
		{
			current.getNext().setPrevios(current.getPrevios());
		}
		else
		{
			last = current.getPrevios();
		}
		return true;
	}

	public String toString()
	{
		String s = "";
		Node2 current = head;
		while (current != null)
		{
			s = s + current.getData() + " ";
			current = current.getNext();
		}

		return s;

	}

	public void replace(int target, int newvalue)
	{
		Node2 current = head;
		while (current != null)
		{
			if (current.getNext().getData() == target)
			{
				current.setNext(new Node2(newvalue, current.getNext().getNext(), current));
				break;
			}
			else
			{
				current = current.getNext();
				last = current.getPrevios();
			}

		}
	}
}