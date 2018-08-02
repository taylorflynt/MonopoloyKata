import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class DiceTest {

	private static StandardDice dice = new StandardDice(2, 12);

	@Test
	public void testRollIsInRange(){
		int rollResult = dice.roll();
		assertTrue(rollResult < 13 && rollResult > 1);
	}

}
