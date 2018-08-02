
public class IncomeTax extends BoardSpace{

	public IncomeTax(){
		super(4);
	}
	
	public void performAction(Player player){
		int tenPercentOfPlayerBalance = (int) (player.getPlayerBalance() * 0.1);
		
		if(tenPercentOfPlayerBalance > 200)
			player.takeMoneyFromPlayer(200);
		
		else
			player.takeMoneyFromPlayer(tenPercentOfPlayerBalance);
	}
}
