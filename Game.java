package practiceProblems;

public class Game {
	private int maxPlayers;
	private boolean cooperative;
	private String name;
	private int rating;
	private String winCondition;
	
	public Game(String n, int max, boolean co_op, int r, String win) {
		maxPlayers = max;
		cooperative = co_op;
		name = n;
		rating = r;
		winCondition = win;
	}
	
	public double complexity() {
		return maxPlayers + rating;
	}
	
	public boolean isFun() {
		return rating > 5 && !cooperative && !name.equals("tic tac toe");
	}
	
	public String toString() {
		return String.format("*****%s*****\n\tmaxPlayers: %d\n\tcooperative: %b\n\tcomplexity: %f\n\trating: %d\n\tWin condition: %s\n", name.toUpperCase(), maxPlayers, cooperative, complexity(), rating, winCondition);
	}
}
