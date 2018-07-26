import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GameTest {

	private static Game game;
	private static Gameboard gameboard;
	private static Dice dice;
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
	/*
	@Test(expected = RuntimeException.class )
	public void testTooFewPlayers(){
		Player[] singlePlayer = createPlayers(1);
		Game soloPlayerGame = new Game(singlePlayer);
	}
	
	@Test(expected = RuntimeException.class )
	public void testTooManyPlayers(){
		Player[] manyPlayers = createPlayers(8);
		Game manyPlayerGame = new Game(manyPlayers);
	}
	*/
	
	@Test
	public void testRandomOrder(){
		Player horsePlayer = new Player("horse");
		Player carPlayer = new Player("car");
		Player[] testPlayers = {horsePlayer, carPlayer};
		
		Game specificPlayerGame = new Game(testPlayers);
	}
	
	@Test
	public void testBasicPlayerMovement(){
		Player horsePlayer = new Player("horse");
		Player carPlayer = new Player("car");
		Player[] testPlayers = {horsePlayer, carPlayer};
		Game specificPlayerGame = new Game(testPlayers);
		
		int rollResult = 7;
		specificPlayerGame.movePlayer(rollResult, horsePlayer);
		
		assertEquals(horsePlayer.getBoardPosition(), 7);
	}
	
	@Test
	public void testPlayerPassesGoMovement(){
		Player horsePlayer = new Player("horse");
		Player carPlayer = new Player("car");
		Player[] testPlayers = {horsePlayer, carPlayer};
		Game specificPlayerGame = new Game(testPlayers);
		
		specificPlayerGame.movePlayer(38, horsePlayer);
		assertEquals(horsePlayer.getBoardPosition(), 38);
		
		specificPlayerGame.movePlayer(6, horsePlayer);
		assertEquals(horsePlayer.getBoardPosition(), 5);
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
		gameboard = new Gameboard();
		dice = new Dice(2, 12);
		
		game = new Game(players);
		game.setGameboard(gameboard);
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
