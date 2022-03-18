package tictactoe;
import javax.swing.JOptionPane;

public class Board {
	
	public static final int ROWS = 6;//ROWS is a constant for the number of rows of the board.
	public static final int COLUMNS = 7;//COLUMNS is a constant for the number of columns of the board.
	public static final int ARRAY_EXTENSION = 4;//Our 2 dimensional array will be extended by 4 rows(2 up and 2 down) and 4 columns(2 right and 2 left) to facilitate checking who won the game.
	public final int NUM_BLOCKS = ROWS * COLUMNS;//Constant for the total number of blocks(cells).
	public char[][] board = new char[ROWS+ARRAY_EXTENSION][COLUMNS+ARRAY_EXTENSION];//2d array used for the game.
	private int fullBlocks;//Variable starting by 0, and will be incremented by 1 after every turn, representing the number of full cells.
	public Board()//Constructor that fills the 2d array by '-';
	{
		int i, j;
		for (i = 0; i < ROWS+ARRAY_EXTENSION; i++)
		{
			for (j = 0; j < COLUMNS+ARRAY_EXTENSION; j++)
			{
				board[i][j] = '-';
			}
		}
	}
	public int getFullBlocks()//to get the number of full blocks.
	{
		return fullBlocks; 
	}
	public void incrementFullBlocks() { //the increment the full blocks by 1 after each turn.
		fullBlocks++;
	}
	public void printBoard() { //A method to print the board for the players after each turn with the new changes.
		int i, j;
		System.out.printf(" ");
		for(j=0;j<COLUMNS;j++) {
			System.out.printf("   %d   ",j+1);
		}
		System.out.printf("\n\n");
		for (i = 0; i < ROWS; i++) {
			System.out.printf("%d",i+1);
			for (j = 0; j < COLUMNS; j++) {//Not all the 2d array is printed just the rows and the columns where the players have access to.(the 4 added columns and rows are not printed.)
				System.out.printf("   %c   ", board[i+(ARRAY_EXTENSION / 2)][j+(ARRAY_EXTENSION/2)]);
			}
			System.out.printf("\n\n");
		}
	}
	
	public void insert(int row, int column, Player player) {//A method that insert 'X' or 'O' in the cell chosen by the player.
		board[row][column] = player.getInputValue(); 
	}
	
	public boolean isDraw() {
		if(getFullBlocks() == NUM_BLOCKS) { //It is a draw when the number of full blocks is equal to the total number of blocks.
			JOptionPane.showMessageDialog(null, "Draw!");
			return true;//It returns true when it is a draw
		}
		return false;//It is not a draw.
	}
	public boolean isWinner(Player player) {//Check if the player has won.
		int row = player.getRowInput();//get the row where the player inserted 'X' or 'O'.
		int column = player.getColumnInput();//get the column.
		if(board[row][column]==board[row-1][column]&&(board[row][column]==board[row-2][column]||board[row][column]==board[row+1][column])) {
			return true;}
		else if(board[row][column]==board[row+1][column]&&board[row][column]==board[row+2][column]) {
			return true;}
		else if(board[row][column]==board[row][column-1]&&(board[row][column]==board[row][column-2]||board[row][column]==board[row][column+1])) {
			return true;}
		else if(board[row][column]==board[row][column+1]&&board[row][column]==board[row][column+2]) {
			return true;}
		else if(board[row][column]==board[row-1][column+1]&&(board[row][column]==board[row-2][column+2]||board[row][column]==board[row+1][column-1])) {
		    return true;}
		else if(board[row][column]==board[row+1][column-1]&&board[row][column]==board[row+2][column-2]){
		    return true;}
		else if(board[row][column]==board[row-1][column-1]&&(board[row][column]==board[row-2][column-2]||board[row][column]==board[row+1][column+1])) {
		    return true;}
		else if(board[row][column]==board[row+1][column+1]&&board[row][column]==board[row+2][column+2]){
		    return true;}

		return false;//The player has not won.
		}

}
