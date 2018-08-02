
public class Player {

	private String playerName;
	private int boardPosition;
	private int roundsPlayed;
	private int balance;
	
	public Player(String name){
		this.playerName = name;
		this.boardPosition = 0;
		this.roundsPlayed = 0;
		this.balance = 0;
	}

	@Override
	public String toString() {
		return this.playerName;
	}

	public int getBoardPosition() {
		return boardPosition;
	}

	public void movePlayer(int numberOfSpacesToMove){
		this.boardPosition = (getBoardPosition() + numberOfSpacesToMove) % 40;
	}
	
	public int getRoundsPlayed() {
		return roundsPlayed;
	}
	
	public int getPlayerBalance(){
		return balance;
	}
	
	public void takeTurn(){
		roundsPlayed++;
	}
	
	public void payPlayer(int amountToPayPlayer){
		this.balance += amountToPayPlayer;
	}
	
	public void takeMoneyFromPlayer(int amountPlayerOwes){
		this.balance -= amountPlayerOwes;
	}
}