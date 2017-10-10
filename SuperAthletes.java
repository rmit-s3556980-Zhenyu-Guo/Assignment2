import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Random;

public class SuperAthletes extends Athletes implements Serializable{

	private String ID;
	private String name;
	private String age;
	private String stateOfAustralia;
	private int point;
	
	public SuperAthletes(){
		
	}
	public SuperAthletes(String ID, String name, String age, String stateOfAustralia, int point) {
		super(ID, name, age, stateOfAustralia, point);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double compete(String type) {
		double time = 0;
		if(type.equals("Cycling")){
			Random rand = new Random();
			// To make a random double from 500 to 800
			time = (rand.nextInt(3) + 5 + Math.random()) * 100;
		}
		else if(type.equals("Swimming")){
			time = (1 + Math.random()) * 100;
		}
		else if(type.equals("Running")){
			time = (1 + Math.random()) * 10;
		}
		else
			System.out.println("Something wrong with the type!");
		DecimalFormat decimalFormat = new DecimalFormat("#.00");
		String convertDouble = decimalFormat.format(time);
		time = Double.parseDouble(convertDouble);
		return time;
	}
}
