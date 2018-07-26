import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Game {
	private final int TOTAL_ROUNDS = 20;
	private final int MINIMUM_PLAYERS = 2;
	private final int MAXIMUM_PLAYERS = 8;
	private int currentRound;
	private Gameboard gameboard;
	private Dice dice;
	private Player[] players;
	private Player[] playerOrder;

	public Game(Player[] players){
		this.players = players;
		checkNumberOfPlayers(players);
		this.playerOrder = randomizePlayerOrder(players);
		currentRound = 0;
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public Player[] getPlayerOrder(){
		return playerOrder;
	}

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public Gameboard getGameboard() {
		return gameboard;
	}

	public void setGameboard(Gameboard gameboard) {
		this.gameboard = gameboard;
	}
	
	public void movePlayer(int rollResult, Player player){
		int currentPlayerPosition = player.getBoardPosition();
		int playerDestination = (currentPlayerPosition + rollResult) % 39;
		
		player.setBoardPosition(playerDestination);
	}
	
	public void nextTurn(){
		for (int i = 0; i < playerOrder.length; i ++){
			int rollResult = dice.Roll();
			movePlayer(rollResult, playerOrder[i]);
			playerOrder[i].takeTurn();
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
				throw new RuntimeException();
	}
	
	private Player[] randomizePlayerOrder(Player[] players){
		List<Player> playersList = Arrays.asList(players);
		Collections.shuffle(playersList);
		
		Player[] shuffledPlayers = new Player[playersList.size()];
		return playersList.toArray(shuffledPlayers);
	}
}
