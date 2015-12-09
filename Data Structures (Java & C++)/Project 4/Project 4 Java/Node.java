/**
 * Project Name: Project 4 Java
 * Created by Alexandru Gutu on 11/1/2014.
 * Copyright (c) 2014 Alexandru Gutu. All rights reserved.
 */
public class Node
	{
		private int data;
		private Node left;
		private Node right;

		public Node(int data)
			{
				this.data = data;
//				this.counter = 1;
			}
		public int getData()
			{
				return this.data;
			}

		public Node getLeft()
			{
				return this.left;
			}

		public Node getRight()
			{
				return this.right;
			}

		public void setData(int data)
			{
				this.data = data;
			}

		public void setLeft(Node nextLeft)
			{
				this.left = nextLeft;
			}

		public void setRight(Node nextRight)
			{
				this.right = nextRight;
			}

		public void printData()
			{
				System.out.println(data);
			}

	}
