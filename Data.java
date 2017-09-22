import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Data {

	private HashMap<String, Sprinter> sprinterList = new HashMap<String, Sprinter>();
	private HashMap<String, Swimmer> swimmerList = new HashMap<String, Swimmer>();
	private HashMap<String, Cyclist> cyclistList = new HashMap<String, Cyclist>();
	private HashMap<String, Official> officialList = new HashMap<String, Official>();
	private HashMap<String, SuperAthletes> superAthletesList = new HashMap<>();
	private HashMap<String, HashMap<String, Double>> resultList = new HashMap<String, HashMap<String, Double>>();
	private HashMap<String, String> predictList = new HashMap<String, String>();
	
	private ArrayList<Cyclist> cyclistInGame = new ArrayList<Cyclist>();
	private ArrayList<SuperAthletes> superAthletesInGame = new ArrayList<SuperAthletes>();
	private ArrayList<Swimmer> swimmerInGame = new ArrayList<Swimmer>();
	private ArrayList<Sprinter> runnerInGame = new ArrayList<Sprinter>();
	private ArrayList<Official> officialInGame = new ArrayList<Official>();
	
	private Swimming s;
	private Running r;
	private Cycling c;
	private Official o;
	
	private String gameType;
	private String pridict;
	
	private int cyclingGameNumber = 1;
	private int runningGameNumber = 1;
	private int swimmingGameNumber = 1;
	private String reStartUse = null;
	
	
	public void Officer(){
		officialList.put("a1", new Official("a1", "Bowen", "cc", "dd"));
		officialList.put("a2", new Official("a2", "Jacob", "cc", "dd"));
		officialList.put("a3", new Official("a3", "Yu", "cc", "dd"));
		officialList.put("a4", new Official("a4", "Elva", "cc", "dd"));
		officialList.put("a5", new Official("a5", "Ethan", "cc", "dd"));
		officialList.put("a6", new Official("a6", "Matthew", "cc", "dd"));		
	}
	public void SuperAthletes(){
		superAthletesList.put("SA01", new SuperAthletes("SA01", "Nicholas", "asdff", "fa", 0));
		superAthletesList.put("SA02", new SuperAthletes("SA02", "Jack", "asdff", "fa", 0));
		superAthletesList.put("SA03", new SuperAthletes("SA03", "Joshua", "asdff", "fa", 0));
		superAthletesList.put("SA04", new SuperAthletes("SA04", "Michael", "asdff", "fa", 0));
		superAthletesList.put("SA05", new SuperAthletes("SA05", "Ryan", "asdff", "fa", 0));
		superAthletesList.put("SA06", new SuperAthletes("SA06", "Andrew", "asdff", "fa", 0));
		superAthletesList.put("SA07", new SuperAthletes("SA07", "Brandon", "asdff", "fa", 0));
		superAthletesList.put("SA08", new SuperAthletes("SA08", "Mason", "asdff", "fa", 0));
	}
	public void Cyclist(){
		cyclistList.put("c1", new Cyclist("c1", "Caden", "ff", "aa", 0));
		cyclistList.put("c2", new Cyclist("c2", "Tyler", "ff", "aa", 0));
		cyclistList.put("c3", new Cyclist("c3", "Dylan", "ff", "aa", 0));
		cyclistList.put("c4", new Cyclist("c4", "Jaden", "ff", "aa", 0));
		cyclistList.put("c5", new Cyclist("c5", "Zachar", "ff", "aa", 0));
		cyclistList.put("c6", new Cyclist("c6", "Conner", "ff", "aa", 0));
		cyclistList.put("c7", new Cyclist("c7", "Logan", "ff", "aa", 0));
		cyclistList.put("c8", new Cyclist("c8", "Cameron", "ff", "aa", 0));
		
	}
	public void Sprinter(){
		sprinterList.put("r1", new Sprinter("r1", "Caleb", "ff", "aa", 0));
		sprinterList.put("r2", new Sprinter("r2", "Noah", "ff", "aa", 0));
		sprinterList.put("r3", new Sprinter("r3", "Alexande", "ff", "aa", 0));
		sprinterList.put("r4", new Sprinter("r4", "Jackson", "ff", "aa", 0));
		sprinterList.put("r5", new Sprinter("r5", "Brayden", "ff", "aa", 0));
		sprinterList.put("r6", new Sprinter("r6", "Lucas", "ff", "aa", 0));
		sprinterList.put("r7", new Sprinter("r7", "William", "ff", "aa", 0));
		sprinterList.put("r8", new Sprinter("r8", "Nathan", "ff", "aa", 0));
		sprinterList.put("r9", new Sprinter("r9", "Joseph", "ff", "aa", 0));
	}
	public void Swimmer(){
		swimmerList.put("s1", new Swimmer("s1", "Justin", "ff", "aa", 0));
		swimmerList.put("s2", new Swimmer("s2", "Daniel", "ff", "aa", 0));
		swimmerList.put("s3", new Swimmer("s3", "Benjamin", "ff", "aa", 0));
		swimmerList.put("s4", new Swimmer("s4", "Christopher", "ff", "aa", 0));
		swimmerList.put("s5", new Swimmer("s5", "James", "ff", "aa", 0));
		swimmerList.put("s6", new Swimmer("s6", "Gavin", "ff", "aa", 0));
		swimmerList.put("s7", new Swimmer("s7", "Evan", "ff", "aa", 0));
		swimmerList.put("s8", new Swimmer("s8", "Austin", "ff", "aa", 0));
	}
	
	public Swimming getSwimming(){
		return s;
	}
	public Running getRunning(){
		return r;
	}
	public Cycling getCycling(){
		return c;
	}
	public Official getOfficial(){
		return o;
	}
	public String getGameType(){
		return gameType;
	}
	public String getPredict(){
		return pridict;
	}
	
	public void setSwimming(Swimming s){
		this.s = s;
	}
	public void setRunning(Running r){
		this.r = r;
	}
	public void setCycling(Cycling c){
		this.c = c;
	}
	public void setOfficial(Official o){
		this.o = o;
	}
	public void setGameType(String sGT){
		gameType = sGT;
	}
	public void setPredict(String pridict){
		this.pridict = pridict;
	}
	
	public void setcyclistInGame(ArrayList<Cyclist> cIG){
		cyclistInGame = cIG ;
	}
	public void setsuperAthletesInGame(ArrayList<SuperAthletes> saIG){
		superAthletesInGame = saIG;
	}
	public void setSwimmerInGame(ArrayList<Swimmer> sIG){
		swimmerInGame = sIG;
	}
	public void setRunnerInGame(ArrayList<Sprinter> rIG){
		runnerInGame = rIG;
	}
	
	public ArrayList getCyclistInGame(){
		return cyclistInGame;
	}
	public ArrayList getSuperAthletesInGame(){
		return superAthletesInGame;
	}
	public ArrayList getSwimmerInGame(){
		return swimmerInGame;
	}
	public ArrayList getRunnerInGame(){
		return runnerInGame;
	}
	
	public HashMap getsprinterList(){
		return sprinterList;
	}
	public HashMap getSwimmerList(){
		return swimmerList;
	}
	public HashMap getCyclistList(){
		return cyclistList;
	}
	public HashMap getOfficialList(){
		return officialList;
	}
	public HashMap getSuperAthletesList(){
		return superAthletesList;
	}
	public HashMap getResultList(){
		return resultList;
	}
	public HashMap getPredictList(){
		return predictList;
	}
	
	public void printCyclistInGame(){
		for(int i = 0; i < cyclistInGame.size(); i++){
			System.out.println("Cyclist ID: \t" + cyclistInGame.get(i).getID());
		}
	}
	public void printSuperAthletesInGame(){
		for(int i = 0; i < superAthletesInGame.size(); i++){
			System.out.println("SuperAthletes ID: \t" + superAthletesInGame.get(i).getID());
		}
	}
	public void printSwimmerInGame(){
		for(int i = 0; i < swimmerInGame.size(); i++){
			System.out.println("Swimmer ID: \t" + swimmerInGame.get(i).getID());
		}
	}
	public void printRunnerInGame(){
		for(int i = 0; i < runnerInGame.size(); i++){
			System.out.println("Runner ID: \t" + runnerInGame.get(i).getID());
		}
	}
	
	public int getCyclingGameNumber() {
		return cyclingGameNumber;
	}
	public void setCyclingGameNumber(int cyclingGameNumber) {
		this.cyclingGameNumber = cyclingGameNumber;
	}
	public int getRunningGameNumber() {
		return runningGameNumber;
	}
	public void setRunningGameNumber(int runningGameNumber) {
		this.runningGameNumber = runningGameNumber;
	}
	public int getSwimmingGameNumber() {
		return swimmingGameNumber;
	}
	public void setSwimmingGameNumber(int swimmingGameNumber) {
		this.swimmingGameNumber = swimmingGameNumber;
	}
	public String getReStartUse() {
		return reStartUse;
	}
	public void setReStartUse(String reStartUse) {
		this.reStartUse = reStartUse;
	}
	public ArrayList<Official> getOfficialInGame() {
		return officialInGame;
	}
	public void setOfficialInGame(ArrayList<Official> officialInGame) {
		this.officialInGame = officialInGame;
	}
	
	
	
	
	
	
	
	
	
	
	
}
