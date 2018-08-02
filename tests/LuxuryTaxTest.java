import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class LuxuryTaxTest {

	private static LuxuryTax luxuryTaxSpot;
	
	@BeforeClass
	public static void setUpGame() {
		luxuryTaxSpot = new LuxuryTax();
	} 
	
	@Test
	public void testLandsOnLuxuryTax() {
		Player player = new Player("player");
		assertEquals(player.getPlayerBalance(), 0);
		luxuryTaxSpot.performAction(player);
		assertEquals(player.getPlayerBalance(), -75);
	}
	
	@Test
	public void testPassLuxuryTax(){
		Player player = new Player("player");
		player.payPlayer(500);
		player.movePlayer(39);
		assertEquals(player.getPlayerBalance(), 500);
	}

}
