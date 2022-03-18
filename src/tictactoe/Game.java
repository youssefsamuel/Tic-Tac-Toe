package tictactoe;
import javax.swing.JOptionPane;

public class Game {
	public static void main(String[] args) {
		Board board = new Board(); //create an instance from the class Board.
		Player player1 = new Player(1); //create an instance for player 1.
		Player player2 = new Player(2); //create an instance for player 2.
		//Ask each player for his name and setting his name using the set method.
		String name1 = JOptionPane.showInputDialog(null, "Player 1 ('X'): Please enter your name: ");
		player1.setPlayerName(name1);
		String name2 = JOptionPane.showInputDialog(null, "Player 2 ('O'): Please enter your name: ");
		player2.setPlayerName(name2);
		//The board is printed and players ready to play.
		JOptionPane.showMessageDialog(null, "Look at the board and enjoy playing");
		System.out.println("Welcome to tic-tac-toe!");
	    board.printBoard();
	    //Loop until a player wins or it is a draw.
		while(true)
		{
			player1.play(board);//Player 1 turn.
			if(board.isWinner(player1))//Check if player 1 wins.
					{
						JOptionPane.showMessageDialog(null, "Player 1 ('X') wins, congratulations "+player1.getPlayerName()+" !");
						break;
					}
			if(board.isDraw())//Check is it is a draw.
				break;
			System.out.println("");
			System.out.println("Board now: ");
		    board.printBoard(); //Print the board after player 1 has played.
			player2.play(board); //Now player 2 plays.
			if(board.isWinner(player2))//Check if player 2 wins.
					{
						JOptionPane.showMessageDialog(null, "Player 2 ('O') wins, congratulations "+player2.getPlayerName()+" !");
						break;
					}	
			if(board.isDraw())//Check is it is a draw.
				break;
			System.out.println("");
			System.out.println("Board now: ");//Print the board after player 2 has played.
		    board.printBoard();	
		}
		System.out.println("Final Board: ");
		board.printBoard();//The board is printed for one last time.
		System.out.println("THANKS FOR PLAYING");
	}

}
