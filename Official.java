
public class Official {

	private String ID;
	private String name;
	private String age;
	private String stateOfAustralia;
	
	public Official(String ID, String name, String age, String stateOfAustralia){
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.stateOfAustralia = stateOfAustralia;
	}
	
	public String getID(){
		return ID;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAge(){
		return age;
	}
	
	public String getStateOfAustralia(){
		return stateOfAustralia;
	}

}
