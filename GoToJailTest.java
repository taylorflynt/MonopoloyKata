import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GoToJailTest {

	private static PlayerTurn playerTurn;
	
	@BeforeClass
	public static void setup(){
		Gameboard gameboard = new Gameboard();
		playerTurn = new PlayerTurn(gameboard);
	}
	
	@Test
	public void testPlayerGoesToVisit() {
		Player player = new Player("");
		playerTurn.takePlayerTurn(player, 30);
		assertEquals(player.getBoardPosition(), 10);
		assertEquals(player.getPlayerBalance(), 0);
	}

	@Test
	public void testPlayerPassesGoToJail(){
		Player player = new Player("");
		playerTurn.takePlayerTurn(player, 35);
		assertEquals(player.getPlayerBalance(), 0);
		assertEquals(player.getBoardPosition(), 35);
	}
}
