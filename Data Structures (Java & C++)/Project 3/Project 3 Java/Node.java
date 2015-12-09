/**
 * Created by Alexandru Gutu on 10/18/14.
 * Copyright (c) 2014 Alexandru Gutu. All rights reserved.
 */

// Node prototype and definition

public class Node
	{
		private String data;
		private int counter;
		private Node next;

		public Node(String input)
			{
				data = input;
				counter = 1;
			}

		public Node(String input, Node next)
			{
				data = input;
				counter = 1;
				this.next = next;
			}

		public String getData()
			{
				return this.data;
			}

		public Node getNext()
			{
				return this.next;
			}

		public int getCounter()
			{
				return this.counter;
			}

		public void setData(String input)
			{
				this.data = input;
			}

		public void setNext(Node next)
			{
				this.next = next;
			}

		public void increaseCount()
			{
				this.counter++;
			}
	}
