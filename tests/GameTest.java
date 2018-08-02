import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GameTest {

	private static Game game;
	private static Gameboard gameboard;
	private static StandardDice dice;
	private static Player [] players;
	
	@BeforeClass
	public static void setUpGame() {
		setUpGameWithPlayers(4);
	}
	
	@Test
	public void testGameExists() {
		assertNotNull(game);
	}
	
	@Test
	public void testGameHasBoard(){
		assertEquals(game.getGameboard(), gameboard);
	}
	
	@Test
	public void testGameHasDice(){
		assertEquals(game.getDice(), dice);
	}
	
	@Test
	public void testGameHasPlayers(){
		assertEquals(game.getPlayers(), players);
	}
	
	public void testAddingSpecificPlayers(){
		Player horsePlayer = new Player("horse");
		Player carPlayer = new Player("car");
		Player[] testPlayers = {horsePlayer, carPlayer};
		
		Game specificPlayerGame = new Game(testPlayers);
		assertEquals(specificPlayerGame.getPlayers()[0].toString(), "horse");
		assertEquals(specificPlayerGame.getPlayers()[0].toString(), "car");
	}
	
	
	@Test(expected = ArithmeticException.class )
	public void testTooFewPlayers(){
		Player[] singlePlayer = createPlayers(1);
		Game soloPlayerGame = new Game(singlePlayer);
	}
	
	@Test(expected = ArithmeticException.class )
	public void testTooManyPlayers(){
		Player[] manyPlayers = createPlayers(9);
		Game manyPlayerGame = new Game(manyPlayers);
	}
	
	@Test
	public void testRandomOrder(){
		Player horsePlayer = new Player("horse");
		Player carPlayer = new Player("car");
		Player[] testPlayers = {horsePlayer, carPlayer};
		
		Game specificPlayerGame = new Game(testPlayers);
	}
	
	@Test
	public void testGamePlayedAllRounds(){
		game.playGame();
		
		assertEquals(game.getCurrentRound(), 20);
	}
	
	@Test
	public void testPlayerOrderStaysSame(){
		game.playGame();
	}
	
	private static void setUpGameWithPlayers(int numberOfPlayers){
		
		players = createPlayers(numberOfPlayers);
		dice = new StandardDice(1, 6);
		
		game = new Game(players);
		game.setDice(dice);
		
	}
	
	private static Player[] createPlayers(int numberOfPlayers){
		Player[] players = new Player[numberOfPlayers];
		
		for (int i = 0; i < numberOfPlayers; i ++){
			Player temporaryPlayer = new Player("generic");
			players[i] = temporaryPlayer;
		}
		return players;
	}
}
