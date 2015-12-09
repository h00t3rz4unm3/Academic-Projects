///**
//* Created by alexandrugutu on 3/11/14.
//*/
//public class Assignment {
//
//	// LinkedList Replacement Method
//	public void replace(int target, int newvalue)
//	{
//		Node current = head;
//		while (current != null)
//		{
//			if (current.getNext().getData() == target)
//			{
//				if (target == )
//
//				// Makes a new node, sets the next one based on the current node, and sets the next node after current to the newly created node
//				current.setNext(new Node(newvalue, current.getNext().getNext()));
//				break;
//			}
//			else
//			{
//				current = current.getNext();
//			}
//
//		}
//	}
//
//	// LinkedList Sum Method
//	public void sum()
//	{
//		Node current = head;
//		int sum = 0;
//		while (current != null)
//		{
//			sum += current.getData();
//			current = current.getNext();
//		}
//		System.out.println("The sum of the LinkedList is: " + sum);
//	}
//
//	// LinkedList2 Replacement Method
//	public void replace(int target, int newvalue)
//	{
//		Node2 current = head;
//		while (current != null)
//		{
//			// Finds the value of the next node
//			if (current.getNext().getData() == target)
//			{
//				// sets the next node to a newly created node with newvalue, the next node and the previous set using the constructor
//				current.setNext(new Node2(newvalue, current.getNext().getNext(), current));
//				break;
//			}
//			else
//			{
//				current = current.getNext();
//				last = current.getPrevios();
//			}
//
//		}
//	}
//
//	// LinkedList2 Replcement Method Professor Edition
//	public void replace(int target, int newvalue)
//	{
//		Node2 current = find(target);
//		if (current == null)
//		{
//			return;
//		}
//
//		// If head is being replacing, this will cause a null pointer exception
//		if (current.getPrevios() != null)
//		{
//			current.getPrevios().setNext(new Node2(newvalue, current.getNext(), current.getPrevios()));
//		}
//		else
//		{
//			head = new Node2(newvalue, head);
//		}
//
//		if (current.getNext() != null)
//		{
//			current.getNext().setPrevios(current.getPrevios().getNext());
//		}
//		else
//		{
//			last = current.getPrevios().getNext();
//		}
//	}
//
//}
