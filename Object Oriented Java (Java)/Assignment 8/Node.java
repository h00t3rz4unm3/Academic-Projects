/**
 * Created by alexandrugutu on 3/6/14.
 */
public class Node
	{
		private int data;
		private Node next;

		// Only used for void version of partialSum()
		private static int sum = 0;

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


		// Void function, plrints out the value as well
//		public void partialSum()
//			{
//
//				if (this.getNext() != null)
//					{
//						sum += this.getData();
//						this.getNext().partialSum();
//					}
//				else if (this.getNext() == null)
//					{
//						sum += this.getData();
//						System.out.println(sum);
//					}
//
//			}

		// Returns and int value
		public int partialSum()
			{

				// Professor Notes
//				int sum = data;
//				if (next != null)
//					{
//						sum += next.partialSum();
//					}
//
//				return sum;

				if (this.getNext() == null)
					{
						return this.getData();
					}
				return this.getData() + this.getNext().partialSum();
			}

		public void printBack()
			{
				if (this.getNext() != null)
					{
						this.getNext().printBack();
						System.out.print(this.getData() + " ");

					}
				else
					{
						System.out.print(this.getData() + " ");
					}
			}


	}