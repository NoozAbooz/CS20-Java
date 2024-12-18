import java.util.Scanner;

public class TicTacToe {
	public static void main(String[] args) {
		int playerScore = 0;
		int computerScore = 0;
		
		char[][] grid = new char[3][3];		
		
		while (true) {
			System.out.println("Tic Tac Toe ----- PLAYER: " + playerScore + " - CPU: " + computerScore);
			
			populateBoard(grid);
			// randomize first player
			int turnTracker = myTools.random(1, 2);
			// game loop
			do {
			    if(turnTracker % 2 == 0) { // check odd/even status to determine first player
			    	displayBoard(grid);
			        playerMove(grid, 'X');
			        
			        if (checkWin(grid) == 'X') {
			        	displayBoard(grid);
			        	playerScore++;
			        	break;
			        }
			        
			        displayBoard(grid);
			        computerMove(grid, 'O', 'X');
			        
			        if (checkWin(grid) == 'O') {
			        	displayBoard(grid);
			        	computerScore++;
			        	break;
			        }
			    }
			    if(turnTracker % 2 == 1) {
			    	displayBoard(grid);
			        computerMove(grid, 'X', 'O');
			        
			        if (checkWin(grid) == 'X') {
			        	displayBoard(grid);
			        	computerScore++;
			        	break;
			        }
			        
			        displayBoard(grid);
			        playerMove(grid, 'O');
			        
			        if (checkWin(grid) == 'O') {
			        	displayBoard(grid);
			        	playerScore++;
			        	break;
			        }
			    }
			    //turnTracker++;
			} while (turnTracker > 0);
			
			Scanner input = new Scanner(System.in);
			System.out.println("Play again? (y/n)");
			char response = input.next().charAt(0);
			
			if (response != 'y') {
				break;
			}
		}
	}
		
	// display board
	public static void displayBoard(char[][] grid) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(grid[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-----------");
		}
		System.out.println();
	}
	
	// populate sequentially
	public static void populateBoard(char[][] grid) {
		int position = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				grid[i][j] = (char)(position + '0');
				position++;
			}
		}
	}
	
	public static void playerMove(char[][] grid, char symbol){
		int i = 0;
		int j = 0;
		
		do {
			int input = myTools.userInput("Square selection for: " + symbol + " (1-9)", 1, 9);
			i = ((input - 1) / 3);
			j = ((input - 1) % 3);
			
		} while (!Character.isDigit(grid[i][j]));
		grid[i][j] = symbol;
	}
	
	public static void computerMove(char[][] grid, char self, char opponent){
		// 1) try to see if a win is possible for self
		//System.out.println(imminentWin(grid, self));
		if (imminentWin(grid, self) != 'n' && Character.isDigit(imminentWin(grid, opponent))) {
			int selfWinPosition = imminentWin(grid, self) - '0';
			int i = ((selfWinPosition - 1) / 3);
			int j = ((selfWinPosition - 1) % 3);
			grid[i][j] = self;
			return;
		}
		
		// 2) try to block opponent's win if self cannot win
		if (imminentWin(grid, opponent) != 'n' && Character.isDigit(imminentWin(grid, opponent))) {
			int blockPosition = imminentWin(grid, opponent) - '0';
			int i = ((blockPosition - 1) / 3);
			int j = ((blockPosition - 1) % 3);
			grid[i][j] = self;
			return;
		}
		
		// else, find next available random position to place
		int i = 0; 
		int j = 0;
		
		while (!Character.isDigit(grid[i][j])) {
			int rand = myTools.random(1, 9);
			i = ((rand - 1) / 3);
			j = ((rand - 1) % 3);
		}

		grid[i][j] = self;
	}

	public static char checkWin(char[][] grid) {
		char winner = 'n';
		// diagonal top left to bottom right
		if(grid[0][0] == grid[1][1] &&
			grid[1][1] == grid[2][2]) {
				winner = grid[0][0];
	    }
		
		// diagonal bottom left to top right
		if(grid[2][0] == grid[1][1] &&
			grid[1][1] == grid[0][2]) {
				winner = grid[2][0];
		}
		
		// check row
		for (int row = 0; row < 3; row++) {
			if (grid[row][0] == grid[row][1] &&
			    grid[row][1] == grid[row][2]) {
			    	winner = grid[row][0];
			}
		}
		
		// check column
		for (int col = 0; col < 3; col++) {
			if (grid[0][col] == grid[1][col] &&
			    grid[1][col] == grid[2][col]) {
			    	winner = grid[0][col];
			}
		}
		
		return winner;
	}
		
	public static char imminentWin(char[][] grid, char symbol) {
			char winner = 'n';
			// diagonal top left to bottom right
			if(grid[0][0] == symbol &&
				grid[1][1] == symbol &&
					Character.isDigit(grid[2][2])) {
						winner = grid[2][2];
		    }
			if(grid[2][2] == symbol && 
				grid[1][1] == symbol &&
					Character.isDigit(grid[0][0])) {
						winner = grid[0][0];
			}
			
			// diagonal bottom left to top right
			if(grid[2][0] == symbol &&
				grid[1][1] == symbol &&
					Character.isDigit(grid[0][2])) {
						winner = grid[0][2];
			}
			if(grid[0][2] == symbol &&
				grid[1][1] == symbol &&
					Character.isDigit(grid[2][0])) {
						winner = grid[2][0];
			}
			
			// check row
			for (int row = 0; row < 3; row++) {
				if(grid[row][0] == symbol &&
					grid[row][1] == symbol) {
				    	winner = grid[row][2];
				}
				if(grid[row][2] == symbol &&
					grid[row][1] == symbol) {
					    winner = grid[row][0];
				}
			}
			
			// check column
			for (int col = 0; col < 3; col++) {
				if(grid[0][col] == symbol &&
					grid[1][col] == symbol) {
				    	winner = grid[2][col];
				}
				if(grid[2][col] == symbol &&
					grid[1][col] == symbol) {
				    	winner = grid[0][col];
				}
			}
			
		return winner;
	}

}
