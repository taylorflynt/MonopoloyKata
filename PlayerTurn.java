
public class PlayerTurn {
	private Gameboard gameBoard;
	
	public PlayerTurn(Gameboard gameBoard){
		this.gameBoard = gameBoard;
	}
	
	public void takePlayerTurn(Player player, int rollResult){
		movePlayer(player, rollResult);
		takePlayerAction(player);
		player.takeTurn();
	}
	
	private void movePlayer(Player player, int rollResult){		
		int oldPosition = player.getBoardPosition();
		player.movePlayer(rollResult);
		
		if (oldPosition > player.getBoardPosition() && player.getBoardPosition() != 0){
			player.payPlayer(200);
		}
	}
	
	private void takePlayerAction(Player player){
		BoardSpace currentSpace = this.gameBoard.getSpaceType(player.getBoardPosition());
		currentSpace.performAction(player);
	}
}
