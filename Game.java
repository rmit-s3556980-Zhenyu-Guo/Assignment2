import java.util.HashMap;

public abstract class Game {

	private String gameID;
	private boolean result = false;
	private String gameType;
	private String predict;
	
	
	public Game(String gameID, String gameType, boolean result, String predic){
		this.gameID = gameID;
		this.result = result;
		this.gameType = gameType;
		this.predict = predic;
	}
	
	public String getGameID(){
		return gameID;
	}
	
	public String getGameType(){
		return gameType;
	}
	
	public String getPredict(){
		return predict;
	}
	
	public boolean getResult(){
		return result;
	}
	
	public abstract void resetPoints(Data data);
}
