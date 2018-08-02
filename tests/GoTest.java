import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GoTest {

	public static Go goSpace;
	
	@BeforeClass
	public static void setup(){
		goSpace = new Go();
	}
	
	@Test
	public void testPassingGo() {
		Player player = new Player("player");
		player.movePlayer(39);		
		assertEquals(player.getPlayerBalance(), 200);
	}
}
