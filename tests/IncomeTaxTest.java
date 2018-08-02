import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class IncomeTaxTest {

	public static IncomeTax incomeTaxSpot;
	
	@BeforeClass
	public static void setup(){
		incomeTaxSpot = new IncomeTax();
	}
	
	@Test
	public void testIncomeTaxPayLessThanTwoHundred() {
		Player poorPlayer = new Player("");
		poorPlayer.payPlayer(1800);
		incomeTaxSpot.performAction(poorPlayer);
		assertEquals(poorPlayer.getPlayerBalance(), 1620);
	}
	
	@Test
	public void testIncomeTaxPayGreaterThanTwoHundred() {
		Player poorPlayer = new Player("");
		poorPlayer.payPlayer(2200);
		incomeTaxSpot.performAction(poorPlayer);
		assertEquals(poorPlayer.getPlayerBalance(), 2000);
	}
	
	@Test
	public void testIncomeTaxBrokePlayer() {
		Player poorPlayer = new Player("");
		incomeTaxSpot.performAction(poorPlayer);
		assertEquals(poorPlayer.getPlayerBalance(), 0);
	}
	
	@Test
	public void testPlayerPassesIncomeTax() {
		Player poorPlayer = new Player("");
		poorPlayer.payPlayer(1800);
		poorPlayer.movePlayer(6);
		assertEquals(poorPlayer.getPlayerBalance(), 1800);
	}

}
