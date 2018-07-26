import java.util.Random;

public class Dice {
	Random numberGenerator = new Random();
	private final int minFaceValue;
	private final int maxFaceValue;
	
	public Dice(int minFaceValue, int maxFaceValue){
		this.minFaceValue = minFaceValue;
		this.maxFaceValue = maxFaceValue;
	}
	
	public int Roll(){
		return numberGenerator.nextInt((maxFaceValue - minFaceValue) + 1) + minFaceValue;
	}
}
