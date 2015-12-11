/**
 * Created by alexandrugutu on 10/4/15.
 *
 * Heavily adapted from Professor Yukawa's sample program. Various modifications were made to make it adhere to project guidelines.
 *
 * The following keywords were added:
 * 		True
 * 		False
 * 		Int
 * 		Float
 * 		Boolean
 * 		If
 * 		Else
 * 		While
 * 		Print
 *
 * 	Furthermore, modifications were made to ensure the make sure it adhered to the DFA diagram of project 1. Modifications include adjusting
 * 	ID state switch statement
 * 	Addition of Keyword switch statements
 * 	Addition of GreaterThan, LessThan, and NotEqual switch statements
 */



import java.lang.*;

public class LexicalAnalyzer extends IO
	{
		public enum State
			{
				// non-final states

				Start,
				Dot,
				E,
				EPlusMinus,

				// final states

				Id,
				Int,
				Float,
				FloatE,
				FloatF,
				Add,
				Sub,
				Mul,
				Div,
				LParen,
				RParen,
				LBrace,
				RBrace,
				LBracket,
				RBracket,
				Lt,
				Le,
				Gt,
				Ge,
				Eq,
				Inv,
				Neq,
				Or,
				And,
				Comma,
				Colon,
				semiColon,
				Keyword_false,
				Keyword_true,
				Keyword_int,
				Keyword_float,
				Keyword_boolean,
				Keyword_if,
				Keyword_else,
				Keyword_while,
				Keyword_print,


				UNDEFINED;

				private boolean isFinal()
					{
						return
								(
										this.compareTo(State.Id) >= 0
								);
					}
			}

		public static String processedString; // holds an extracted token
		public static State state; // the current state of the FA

		private static int driver()

			// This is the driver of the FA.
			// If a valid token is found, assigns it to "processedString" and returns 1.
			// If an invalid token is found, assigns it to "processedString" and returns 0.
			// If end-of-stream is reached without finding any non-whitespace character, returns -1.

		{
			State nextSt; // the next state of the FA

			processedString = "";
			state = State.Start;

			if ( Character.isWhitespace((char) a) )
				a = getChar(); // get the next non-whitespace character
			if ( a == -1 ) // end-of-stream is reached
				return -1;

			while ( a != -1 ) // do the body if "a" is not end-of-stream
				{
					currentCharacter = (char) a;
					nextSt = nextState( state, currentCharacter);
					if ( nextSt == State.UNDEFINED) // The FA will halt.
						{
							if ( state.isFinal() )
								return 1; // valid token extracted
							else // "currentCharacter" is an unexpected character
								{
									processedString = processedString + currentCharacter;
									a = getNextChar();
									return 0; // invalid token found
								}
						}
					else // The FA will go on.
						{
							state = nextSt;
							processedString = processedString + currentCharacter;
							a = getNextChar();
						}
				}

			// end-of-stream is reached while a token is being extracted

			if ( state.isFinal() )
				return 1; // valid token extracted
			else
				return 0; // invalid token found
		} // end driver

		public static void getToken()

			// Extract the next token using the driver of the FA.
			// If an invalid token is found, issue an error message.

		{
			int i = driver();
			if ( i == 0 )
				displayln(processedString + " : Lexical Error, invalid token");
		}

		private static State nextState(State currentState, char currentCharacter)

			// Returns the next state of the FA given the current state and input char;
			// if the next state is undefined, UNDEFINED is returned.
				

		{

			switch( state )
				{
					case Start:
						if ( Character.isLetter(currentCharacter) )
							return State.Id;
						else if ( Character.isDigit(currentCharacter) )
							return State.Int;
						else if ( currentCharacter == '+' )
							return State.Add;
						else if ( currentCharacter == '-' )
							return State.Sub;
						else if ( currentCharacter == '*' )
							return State.Mul;
						else if ( currentCharacter == '/' )
							return State.Div;
						else if ( currentCharacter == '(' )
							return State.LParen;
						else if ( currentCharacter == ')' )
							return State.RParen;
						else if ( currentCharacter == '|')
							return State.Or;
						else if ( currentCharacter == '&')
							return State.And;
						else if ( currentCharacter == '!')
							return State.Inv;
						else if ( currentCharacter == '<')
							return State.Lt;
						else if ( currentCharacter == '>')
							return State.Gt;
						else if ( currentCharacter == '=')
							return State.Eq;
						else if ( currentCharacter == '{')
							return State.LBrace;
						else if ( currentCharacter == '}')
							return State.RBrace;
						else if ( currentCharacter == '[')
							return State.LBracket;
						else if ( currentCharacter == ']')
							return State.RBracket;
						else if ( currentCharacter == '.')
							return State.Dot;
						else if ( currentCharacter == ',')
							return State.Comma;
						else if ( currentCharacter == ':')
							return State.Colon;
						else if ( currentCharacter == ';')
							return State.semiColon;
						else
							return State.UNDEFINED;
					case Id:

						// The following sections of code check for any keywords while the DFA is in the ID state
						if ((processedString + currentCharacter).equals("false"))
							return State.Keyword_false;
						else if ((processedString + currentCharacter).equals("true"))
							return State.Keyword_true;
						else if ((processedString + currentCharacter).equals("int"))
							return State.Keyword_int;
						else if ((processedString + currentCharacter).equals("float"))
							return State.Keyword_float;
						else if ((processedString + currentCharacter).equals("boolean"))
							return State.Keyword_boolean;
						else if ((processedString + currentCharacter).equals("if"))
							return State.Keyword_if;
						else if ((processedString + currentCharacter).equals("else"))
							return State.Keyword_else;
						else if ((processedString + currentCharacter).equals("while"))
							return State.Keyword_while;
						else if ((processedString + currentCharacter).equals("print"))
							return State.Keyword_print;

						// If no keywords are found, then it checks for character or digit and returns ID
						else if ( Character.isLetterOrDigit(currentCharacter) )
							return State.Id;
						else
							return State.UNDEFINED;

						// Ensures the return of an ID state if there is anything appended to the end of the keyword that does not belong there
					case Keyword_false:
						if ( Character.isLetterOrDigit(currentCharacter))
							return State.Id;

					case Keyword_true:
						if ( Character.isLetterOrDigit(currentCharacter))
							return State.Id;

					case Keyword_int:
						if ( Character.isLetterOrDigit(currentCharacter))
							return State.Id;

					case Keyword_float:
						if ( Character.isLetterOrDigit(currentCharacter))
							return State.Id;

					case Keyword_boolean:
						if ( Character.isLetterOrDigit(currentCharacter))
							return State.Id;

					case Keyword_if:
						if ( Character.isLetterOrDigit(currentCharacter))
							return State.Id;

					case Keyword_else:
						if ( Character.isLetterOrDigit(currentCharacter))
							return State.Id;

					case Keyword_while:
						if ( Character.isLetterOrDigit(currentCharacter))
							return State.Id;

					case Keyword_print:
						if ( Character.isLetterOrDigit(currentCharacter))
							return State.Id;

					case Int:
						if ( Character.isDigit(currentCharacter) )
							return State.Int;
						else if ( currentCharacter == '.' )
							return State.Float;
						else if ( currentCharacter == 'e' || currentCharacter == 'E')
							return State.E;
						else if ( currentCharacter == 'f' || currentCharacter == 'F')
							return State.FloatF;
						else
							return State.UNDEFINED;
					case Add:
						if ( Character.isDigit(currentCharacter))
							return State.Int;
						else if ( currentCharacter == '.')
							return State.Dot;
					case Sub:
						if ( Character.isDigit(currentCharacter))
							return State.Int;
						else if ( currentCharacter == '.')
							return State.Dot;
					case Dot:
						if ( Character.isDigit(currentCharacter) )
							return State.Float;
						else
							return State.UNDEFINED;
					case Float:
						if ( Character.isDigit(currentCharacter) )
							return State.Float;
						else if ( currentCharacter == 'e' || currentCharacter == 'E' )
							return State.E;
						else if ( currentCharacter == 'f' || currentCharacter == 'F')
							return State.FloatF;
						else
							return State.UNDEFINED;
					case E:
						if ( Character.isDigit(currentCharacter) )
							return State.FloatE;
						else if ( currentCharacter == '+' || currentCharacter == '-' )
							return State.EPlusMinus;
						else
							return State.UNDEFINED;
					case EPlusMinus:
						if ( Character.isDigit(currentCharacter) )
							return State.FloatE;
						else
							return State.UNDEFINED;
					case FloatE:
						if ( Character.isDigit(currentCharacter) )
							return State.FloatE;
						if ( currentCharacter == 'f' || currentCharacter == 'F')
							return State.FloatF;
						else
							return State.UNDEFINED;
					case Lt:
						if ( currentCharacter == '=')
							return State.Le;
					case Gt:
						if ( currentCharacter == '=')
							return State.Ge;
					case Inv:
						if ( currentCharacter == '=')
							return State.Neq;

					default:
						return State.UNDEFINED;
				}
		} // end nextState

		public static void main(String argv[])

			{
				// argv[0]: input file containing source code using tokens defined above
				// argv[1]: output file displaying a list of the tokens

				setIO( argv[0], argv[1] );

				int i;

				while ( a != -1 ) // while "a" is not end-of-stream
					{
						i = driver(); // extract the next token
						if ( i == 1 )
							displayln( processedString + "   : " + state.toString() );
						else if ( i == 0 )
							displayln( processedString + " : Lexical Error, invalid token");
					}

				closeIO();
			}


	}
