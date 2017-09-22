import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Swimming extends Game{

	private String gameID;
	private boolean result = false;
	private String gameType;
	private String predict;
	
	public Swimming(String gameID, String gameType, boolean result, String predict) {
		super(gameID, gameType, result, predict);
		
	}

	@Override
	public void resetPoints(Data data) {
		data.getSwimming().getGameID();
		HashMap<String, Double> reset = (HashMap<String, Double>) data.getResultList().get(data.getSwimming().getGameID());
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
			if(entry.getValue() == rank[0] && data.getSwimmerList().containsKey(entry.getKey())){
				((Swimmer) data.getSwimmerList().get(entry.getKey())).setPoint(-5);;
			}
			if(entry.getValue() == rank[1] && data.getSwimmerList().containsKey(entry.getKey())){
				((Swimmer) data.getSwimmerList().get(entry.getKey())).setPoint(-2);;
			}
			if(entry.getValue() == rank[2] && data.getSwimmerList().containsKey(entry.getKey())){
				((Swimmer) data.getSwimmerList().get(entry.getKey())).setPoint(-1);;
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
