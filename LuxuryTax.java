
public class LuxuryTax extends BoardSpace{

	public LuxuryTax(){
		super(38);
	}
	
	public void performAction(Player player){
		player.takeMoneyFromPlayer(75);
	}
}