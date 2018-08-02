
public class GoToJail extends BoardSpace {
	private Gameboard gameboard;
	
	public GoToJail(Gameboard gameboard){
		super(30);
		this.gameboard = gameboard;
	}
	
	public void performAction(Player player){
		while(player.getBoardPosition() != 10){
			player.movePlayer(1);
		}
	}
}