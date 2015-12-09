/**
 * Created by alexandrugutu on 3/6/14.
 */
public class Node2
{
	private int data;
	private Node2 next;
	private Node2 previos;

	public Node2(int d)
	{
		data = d;
	}

	public Node2(int d, Node2 n)
	{
		data = d;
		next = n;
	}

	public Node2(int d, Node2 n, Node2 p)
	{
		data = d;
		next = n;
		previos = p;
	}

	public int getData()
	{
		return data;
	}

	public Node2 getNext()
	{
		return next;
	}

	public Node2 getPrevios()
	{
		return previos;
	}

	public void setNext(Node2 n)
	{
		next = n;
	}

	public void setPrevios(Node2 p)
	{
		previos = p;
	}

}
