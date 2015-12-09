/**
 * Created by alexandrugutu on 12/1/14.
 */
public class HashOne
	{
		private Node bucketList[];
		private int bucketSize;

		public HashOne(int bucketSize)
			{
				bucketList = new Node[bucketSize];
				for (int i = 0; i < bucketSize; i++)
					{
						bucketList[i] = new Node(99999999);
					}

				this.bucketSize = bucketSize;
			}
		// Hash Function
		public int hashOneFunction(int data)
			{
				int hash = data % bucketSize;

				return hash;
			}

		// Search Function
		public Node findSpot(int data)
			{
				int bucketIndex = hashOneFunction(data);

				Node current = bucketList[bucketIndex];

				while (current.getNext() != null && current.getNext().getData() < data)
					{
						current = current.getNext();
					}

				if (current.getNext() != null && current.getNext().getData() == data)
					{
						return null;
					}
				else
					{
						return current;
					}
			}

		// Insert Function
		void insert(int data)
			{
				if (findSpot(data) == null)
					{
						System.out.println("Unable to insert, " + data + " is already present.");
					}
				else
					{
						Node current = findSpot(data);

						Node newNode = new Node(data);
						newNode.setNext(current.getNext());
						current.setNext(newNode);
					}
			}

		// Print Function
		public void printList(int data)
			{
				int bucketIndex = hashOneFunction(data);

				System.out.println("Hash Bucket: " + bucketIndex + ": ");

				Node current = bucketList[bucketIndex];

				while (current.getNext() != null)
					{
						System.out.print(current.getData() + " ");
						current = current.getNext();
					}

				System.out.print(current.getData());
				System.out.println();
				System.out.println();
			}

		// Hash Table Print Function
		public void printHashTable()
			{
				for (int i = 0; i < bucketSize; i++)
					{
						System.out.print("Hash Bucket: " + i + ": ");

						Node current = bucketList[i];

						while (current.getNext() != null)
							{
								System.out.print(current.getData() + " ");
								current = current.getNext();
							}

						System.out.println(current.getData());
					}
			}
	}
