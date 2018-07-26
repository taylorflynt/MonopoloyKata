import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class DiceTest {

	private static Dice dice = new Dice(2, 12);

	@Test
	public void testRollIsInRange(){
		int rollResult = dice.Roll();
		assertTrue(rollResult < 13 && rollResult > 1);
	}

}
