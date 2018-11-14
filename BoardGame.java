package practiceProblems;

//TODO: make BoardGame a child of the class Game
public class BoardGame extends Game{
	private int pieces;
	private int boardSize;
	
	public BoardGame(String n, int max, boolean co_op, int r, String win, int i, int j) {
		super(n, max, co_op, r, win);
		pieces = i;
		boardSize = j;
	
	}

	//TODO: have BoardGame initialize the fields in here and also in its parent
	
	
	//TODO: Override the complexity, isFun, and toString methods
	//the complexity of a board game is the complexity of the parent class plus the number of pieces and board size
	//A BoardGame isFun if the parent isFun and there are at least 8 pieces and the boardSize is at least 40
	//the toString of BoardGame should return the parent's toString and also tack on the pieces and boardSize in the same tabbed fashion
	@Override
	public double complexity() {
		return super.complexity() + pieces + boardSize;
	}
	@Override
	public boolean isFun() {
		return super.isFun() && (pieces>=8) && (40<= boardSize);
	}
	@Override
	public String toString() {
		return super.toString() + String.format("\tNumber of pieces: %d \n\tBoardSize: %d\n\t",pieces,boardSize);
}
}
