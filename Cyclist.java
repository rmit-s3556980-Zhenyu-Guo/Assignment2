import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Random;

public class Cyclist extends Athletes implements Serializable {

	private String ID;
	private String name;
	private String age;
	private String stateOfAustralia;
	private int point;
	
	public Cyclist() {
	}
	
	public Cyclist(String cID, String name, String age, String stateOfAustralia, int point) {
		super(cID, name, age, stateOfAustralia, point);
	}

	@Override
	public double compete(String type) {
		Random rand = new Random();
		// To make a random double from 500 to 800
		double time = (rand.nextInt(3) + 5 + Math.random()) * 100;
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		String convertDouble = decimalFormat.format(time);
		time = Double.parseDouble(convertDouble);
		return time;
	}

}
