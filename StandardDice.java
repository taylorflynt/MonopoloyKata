import java.util.Random;

public class StandardDice implements IDice{
	Random numberGenerator = new Random();
	private final int minFaceValue;
	private final int maxFaceValue;
	
	public StandardDice(int minFaceValue, int maxFaceValue){
		this.minFaceValue = minFaceValue;
		this.maxFaceValue = maxFaceValue;
	}
	
	public int roll(){
		int firstRoll = numberGenerator.nextInt((maxFaceValue - minFaceValue) + 1) + minFaceValue;
		int secondRoll = numberGenerator.nextInt((maxFaceValue - minFaceValue) + 1) + minFaceValue;
		
		return firstRoll + secondRoll;		
	}
}
