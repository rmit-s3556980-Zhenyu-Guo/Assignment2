import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Cycling extends Game{

	private String gameID;
	private boolean result = false;
	private String gameType;
	private String predict;
	
	public Cycling(String gameID, String gameType, boolean result, String predict) {
		super(gameID, gameType, result, predict);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void resetPoints(Data data) {
		data.getCycling().getGameID();
		HashMap<String, Double> reset = (HashMap<String, Double>) data.getResultList().get(data.getCycling().getGameID());
		Iterator iter = reset.entrySet().iterator();
		Double[] rank = new Double[reset.size()];
		int i = 0;
		while(iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			rank[i] = entry.getValue();
			i++;
		}
		Arrays.sort(rank);
		iter = reset.entrySet().iterator();
		while(iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			if(entry.getValue() == rank[0] && data.getCyclistList().containsKey(entry.getKey())){
				((Cyclist) data.getCyclistList().get(entry.getKey())).setPoint(-5);;
			}
			if(entry.getValue() == rank[1] && data.getCyclistList().containsKey(entry.getKey())){
				((Cyclist) data.getCyclistList().get(entry.getKey())).setPoint(-2);;
			}
			if(entry.getValue() == rank[2] && data.getCyclistList().containsKey(entry.getKey())){
				((Cyclist) data.getCyclistList().get(entry.getKey())).setPoint(-1);;
			}
			if(entry.getValue() == rank[0] && data.getSuperAthletesList().containsKey(entry.getKey())){
				((SuperAthletes) data.getSuperAthletesList().get(entry.getKey())).setPoint(-5);;
			}
			if(entry.getValue() == rank[1] && data.getSuperAthletesList().containsKey(entry.getKey())){
				((SuperAthletes) data.getSuperAthletesList().get(entry.getKey())).setPoint(-2);;
			}
			if(entry.getValue() == rank[2] && data.getSuperAthletesList().containsKey(entry.getKey())){
				((SuperAthletes) data.getSuperAthletesList().get(entry.getKey())).setPoint(-1);;
			}
		}
		
	}


}
