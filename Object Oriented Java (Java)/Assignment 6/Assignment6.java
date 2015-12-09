/**
 * Created by alexandrugutu on 3/27/14.
 */
public class Assignment6
	{
		public static void main(String[] args)
			{
				Queue q = new Queue(1);
				Stack s = new Stack(1);

				for (int i = 2; i < 21; i++)
					{
						q.insert(i);
						s.insert(i);
					}

				System.out.print("Stack: ");
				s.clearAll();
				System.out.println();
				System.out.print("Queue: ");
				q.clearAll();

			}
	}
