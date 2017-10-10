import java.io.Serializable;
import java.text.DecimalFormat;

public class Sprinter extends Athletes implements Serializable{
	private String ID;
	private String name;
	private String age;
	private String stateOfAustralia;
	private int point;
	
	public Sprinter(){
		
	}
	public Sprinter(String rID, String name, String age, String stateOfAustralia, int point) {
		super(rID, name, age, stateOfAustralia, point);
		
	}

	@Override
	public double compete(String type) {
		double time = (1 + Math.random()) * 10;
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		String convertDouble = decimalFormat.format(time);
		time = Double.parseDouble(convertDouble);
		return time;
	}


}
