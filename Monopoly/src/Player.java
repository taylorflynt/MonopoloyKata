
public class Player {

	private String playerName;
	private int boardPosition;
	private int roundsPlayed;
	
	public Player(String name){
		this.playerName = name;
		this.boardPosition = 0;
		this.roundsPlayed = 0;
	}

	@Override
	public String toString() {
		return this.playerName;
	}

	public int getBoardPosition() {
		return boardPosition;
	}

	public void setBoardPosition(int boardPosition) {
		this.boardPosition = boardPosition;
	}
	
	public int getRoundsPlayed() {
		return roundsPlayed;
	}
	
	public void takeTurn(){
		roundsPlayed++;
	}
	
	
	
}
