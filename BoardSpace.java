
public abstract class BoardSpace implements IBoardSpace{
	public int boardLocation;
	
	public BoardSpace(int boardLocation){
		this.boardLocation = boardLocation;
	}
	
	public void performAction(Player player){ }
	
}