import java.text.DecimalFormat;

public class Swimmer extends Athletes{
	
	private String ID;
	private String name;
	private String age;
	private String stateOfAustralia;
	private int point;

	public Swimmer(String sID, String name, String age, String stateOfAustralia, int point) {
		super(sID, name, age, stateOfAustralia, point);
	}

	@Override
	public double compete(String type) {
		double time = (1 + Math.random()) * 100;
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		String convertDouble = decimalFormat.format(time);
		time = Double.parseDouble(convertDouble);
		return time;
	}


}
