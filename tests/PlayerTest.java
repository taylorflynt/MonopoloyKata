
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {

	private static Player shoePlayer;
	private static Player movingPlayer;
	private static Player nearGoPlayer;
	
	@BeforeClass
	public static void setUpPlayer() {
		shoePlayer = new Player("shoe");
		movingPlayer = new Player("mover");
		nearGoPlayer = new Player("Near Go");
	}
	
	@Test
	public void testPlayerConstructor() {
		assertNotNull(shoePlayer);
	}
	
	@Test
	public void testPlayerToString(){
		assertEquals(shoePlayer.toString(), "shoe");
	}
	
	@Test
	public void testGetBoardPosition(){
		assertEquals(shoePlayer.getBoardPosition(), 0);
	}
	
	@Test
	public void testMovePlayer(){
		movingPlayer.movePlayer(7);
		assertEquals(movingPlayer.getBoardPosition(), 7);
	}
	
	@Test
	public void testMovePlayerPastGo(){
		nearGoPlayer.movePlayer(39);
		assertEquals(nearGoPlayer.getBoardPosition(), 39);
		nearGoPlayer.movePlayer(6);
		assertEquals(nearGoPlayer.getBoardPosition(), 5);
	}

	@Test
	public void testGetRoundsPlayed(){
		assertEquals(shoePlayer.getRoundsPlayed(), 0);
	}
	
	@Test
	public void testTakeTurn(){
		assertEquals(shoePlayer.getRoundsPlayed(), 0);
		shoePlayer.takeTurn();
		assertEquals(shoePlayer.getRoundsPlayed(), 1);
	}
	
	@Test
	public void testInitialPlayerBalance(){
		Player startingPlayer = new Player("newbie");
		assertEquals(startingPlayer.getPlayerBalance(), 0);
	}
	
	@Test
	public void testPayingPlayer(){
		shoePlayer.payPlayer(200);
		assertEquals(shoePlayer.getPlayerBalance(), 200);
	}
	
	@Test
	public void testMakingPlayerPlay(){
		Player startingPlayer = new Player("newbie");
		startingPlayer.takeMoneyFromPlayer(200);
		assertEquals(startingPlayer.getPlayerBalance(), -200);
	}
	
}
