
public class Go extends BoardSpace{
	public Go(){
		super(0);
	}	
	
	public void performAction(Player player){
		player.payPlayer(200);
	}
}
