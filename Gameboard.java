public class Gameboard{
	private static final int NUMBER_OF_SPOTS = 40;
	private static final int GO_LOCATION = 0;
	private static final int JAIL_LOCATION = 10;
	private BoardSpace[] boardLocations;

	public Gameboard(){
		this.boardLocations = new BoardSpace[] {new Go(), new IncomeTax(), new LuxuryTax(), new GoToJail(this)};
	}
	
	public BoardSpace getSpaceType(int boardLocation){
		for (int i = 0; i < boardLocations.length; i++){
			if(boardLocations[i].boardLocation == boardLocation){
				return boardLocations[i];
			}
		}
		
		return new EmptyBoardSpace();
	}
	
	public BoardSpace[] getBoardLocations(){
		return this.boardLocations;
	}
}