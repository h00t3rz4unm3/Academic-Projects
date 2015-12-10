### _Assignment 7_

Create a Tic-Tac-Toe GUI object. call the class _TTTGUI_  
1. There should be a text box (look up JTextField). When the game starts, the text field should say "would you like to play tic tac toe?" There should be two buttons below the text field. One says "yes" and the other says "no". If button "no" is pressed the GUI should close and the program should quit. If button "yes" is pressed, both of these 2 buttons should disappear (look up setVisibile), the Text Field should say "X, pick a square" (look up method setText). There should now be 9 buttons in a 3x3 grid (use GridLayoutManager for these 9 buttons but the other 2 buttons and text field should be placed with a different layout manger - I recommend using BorderLayoutManager for this, but you dont have to). you will also probably have to resize the 9 buttons so that they will each be a square. When one of these 9 buttons is pressed:  
b. the text of the button should represent which player pressed the button.  
c. the text field should change to indicate whose turn it is now  
and iii) that button pressed should remain visible, but become disabled (look up method setEnabled)  

After a game is finished (either with a winner or a draw), the GUI object should again ask the user if they want to play and depending on the response from the user, a new game should be started or the program should close.  


2. You must create a main method that will call the constructor to this GUI object. The method should be in its own class.  

3. The GUI object should interact with an instance of the TicTacToe class that you created in assignment 5. (some adjustments to that class might be necessary).  

If you were unable to get a working version for assignment 5, I am planning on posting a version of the class on Thursday. If possible, I would perfer that you use your version.


