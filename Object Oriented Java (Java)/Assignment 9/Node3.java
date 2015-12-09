
/**
 * Created by alexandrugutu on 5/6/14.
 */

//import java.lang.*;

public class Node3 <T> implements Comparable<T>
	{
		private T data;
		private Node3 next;

		public Node3(T data)
			{
				this.data = data;
			}

		public Node3(T data, Node3 n)
			{
				this.data = data;
				next = n;
			}

		public T getData()
			{
				return data;
			}

		public Node3 getNext()
			{
				return next;
			}

		public void setNext(Node3 n)
			{
				next = n;
			}

		@Override
		public int compareTo(T otherData)
			{
				if (data instanceof String)
					{
						return ((String) this.data).compareTo((String) otherData);
					}
				else if (data instanceof Node3)
					{
						return ((Node3) this.data).compareTo((Node3) otherData);
					}
				return 0;
			}
	}