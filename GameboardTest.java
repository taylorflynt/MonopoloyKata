import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GameboardTest {
	
	public static Gameboard gameBoard;
	
	@BeforeClass
	public static void setup(){
		gameBoard = new Gameboard();
	}
	
	@Test
	public void testLocationsIsNotEmpty(){
		assertNotNull(gameBoard.getBoardLocations());
	}
	
	@Test
	public void testGoIsAtBeginning() {
		assertTrue(gameBoard.getSpaceType(0) instanceof Go);
	}
	
	@Test
	public void testLuxuryTaxAtCorrectPosition() {
		assertTrue(gameBoard.getSpaceType(38) instanceof LuxuryTax);
	}
	
	@Test
	public void testIncomeTaxAtCorrectPosition() {
		assertTrue(gameBoard.getSpaceType(4) instanceof IncomeTax);
	}
	
	@Test
	public void testGoToJailAtCorrectPosition() {
		assertTrue(gameBoard.getSpaceType(30) instanceof GoToJail);
	}
}