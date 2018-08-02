
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTurnTest {

	private static PlayerTurn playerTurn;
	
	@BeforeClass
	public static void setup(){
		Gameboard gameBoard = new Gameboard();
		playerTurn = new PlayerTurn(gameBoard);
	}
	
	@Test
	public void testPlayerPassesGo() {
		Player player = new Player("");
		playerTurn.takePlayerTurn(player, 37);
		playerTurn.takePlayerTurn(player, 5);
		assertEquals(player.getPlayerBalance(), 200);
	}
	
	@Test
	public void testPlayerStartsOnGo(){
		Player player = new Player("");
		playerTurn.takePlayerTurn(player, 28);
		assertEquals(player.getPlayerBalance(), 0);
	}
	
	@Test
	public void testPlayerPassesGoTwice(){
		Player player = new Player("");
		playerTurn.takePlayerTurn(player, 91);
		assertEquals(player.getPlayerBalance(), 400);
	}

}
