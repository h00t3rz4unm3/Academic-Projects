/**
 * Created by alexandrugutu on 11/23/15.
 */

import java.io.Serializable;

public class Message implements Serializable
	{

		public int value;
		public int id;

		public Message(int value, int id)
			{
				this.value = value;
				this.id = id;
			}
	}
