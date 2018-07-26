import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {

	private static Player shoePlayer;
	
	@BeforeClass
	public static void setUpPlayer() {
		shoePlayer = new Player("shoe");
	}
	
	@Test
	public void testPlayerConstructor() {
		assertNotNull(shoePlayer);
	}
	
	@Test
	public void testPlayerToString(){
		assertEquals(shoePlayer.toString(), "shoe");
	}

}
