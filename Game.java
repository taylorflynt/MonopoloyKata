import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {
	private final int TOTAL_ROUNDS = 20;
	private final int MINIMUM_PLAYERS = 2;
	private final int MAXIMUM_PLAYERS = 8;
	private int currentRound;
	private Gameboard gameboard;
	private StandardDice dice;
	private Player[] players;
	private Player[] playerOrder;
	private PlayerTurn playerTurn;

	public Game(Player[] players){
		this.players = players;
		checkNumberOfPlayers(players);
		this.playerOrder = randomizePlayerOrder(players);
		currentRound = 0;
		gameboard = new Gameboard();
		playerTurn = new PlayerTurn(gameboard);
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public Player[] getPlayerOrder(){
		return playerOrder;
	}

	public IDice getDice() {
		return dice;
	}

	public void setDice(StandardDice dice) {
		this.dice = dice;
	}

	public Gameboard getGameboard() {
		return gameboard;
	}
	
	public void nextTurn(){
		for (int i = 0; i < playerOrder.length; i ++){
			int rollResult = dice.roll();
			playerTurn.takePlayerTurn(playerOrder[i], rollResult);
		}
		currentRound++;
	}
	
	public int getCurrentRound() {
		return currentRound;
	}

	public void playGame(){
		for (int i = currentRound; i < TOTAL_ROUNDS; i  ++){
			nextTurn();
		}
	}
	
	private void checkNumberOfPlayers(Player[] players){
		if (players.length < MINIMUM_PLAYERS || players.length > MAXIMUM_PLAYERS)
				throw new ArithmeticException("incorrect number of players");
	}
	
	private Player[] randomizePlayerOrder(Player[] players){
		List<Player> playersList = Arrays.asList(players);
		Collections.shuffle(playersList);
		
		Player[] shuffledPlayers = new Player[playersList.size()];
		return playersList.toArray(shuffledPlayers);
	}
}
