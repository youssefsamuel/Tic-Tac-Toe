package tictactoe;

import javax.swing.JOptionPane;
public class Player {//All the instance variables are private and to have access on them we use the setters and getters (Encapsulation)
	private int playerNumber;//The number of the player 1 or 2
	private String playerName;//The name of the player
	private int rowInput;//The number of row that the player chooses each turn
	private int columnInput;//The number of column that the player chooses each turn
	private char inputValue;//Each player has an input value 'X' or 'O'
	
	public Player(int number) {//The player constructor has as input a number which is the player's number
		playerNumber = number;
		if (number == 1)
			setInputValue('X');//Setting the input value as 'X' for player 1 and 'O' for player 2.
		else
			setInputValue('O');
    }
	//Getters and setters for all the instance variables.
	public int getPlayerNumber() {
		return playerNumber;
	}
	public void setPlayerNumber(int number) {
		playerNumber = number;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String name) {
		playerName = name;
	}
	public int getRowInput() {
		return rowInput; 
	}
	public void setRowInput(int rowInput) {
		this.rowInput = rowInput;
	}
	public int getColumnInput() {
		return columnInput;
	}
	public void setColumnInput(int columnInput) {
		this.columnInput = columnInput;
	}
	public char getInputValue() {
		return inputValue;
	}
	public void setInputValue(char ch) {
		inputValue = ch;
	}

	public void play(Board board)//A method to let a player play.
	{
		int r, c;
		String row = JOptionPane.showInputDialog(null, "Hi " + getPlayerName() + " (Player " + getPlayerNumber() + ") " + ", please enter the row: ");
	    r = Integer.parseInt(row);//Convert the string to an integer.
		while(r>Board.ROWS||r<1) {//Check that the row is not out of range.
			row = JOptionPane.showInputDialog(null, "Incorrect row choice! Please re-enter your choice\nEnter row number: ");
		    r = Integer.parseInt(row);
		}
		String column = JOptionPane.showInputDialog(null, "Please enter the column: ");
		c = Integer.parseInt(column);
		while(c>Board.COLUMNS||c<1) {//Check that the column is not out of range.
			column = JOptionPane.showInputDialog(null, "Incorrect column choice! Please re-enter your choice\nEnter column number: ");
		    c = Integer.parseInt(column);
		}
		if (board.board[r+1][c+1] != '-') {//Check that the cell chosen by the player is empty or already filled.
			JOptionPane.showMessageDialog(null, "INVALID PLACE");
			play(board);//recall the method from the beginning to let the user re-enter the row and column.
		}
		else {//if the row and column are valid:
			setRowInput(r+1);//We increment the row and column by 1 the fill the correct the cell.
			setColumnInput(c+1);
			board.insert(getRowInput(), getColumnInput(), this);//We call the insert method from Board class to fill the required cell.
			board.incrementFullBlocks();//Increment the number of full blocks by 1 after the player has played.
		}
	}
}
