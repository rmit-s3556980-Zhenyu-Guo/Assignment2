import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Map.Entry;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MeanMenuController {
	static Data data = new Data();
	private int dataInsert = 0;
	@FXML
	private Button selectGameButton, predictButton, runButton, displayResultButton, displayPointButton, exitButton;
	
	
	public void handleSelectGameButton(ActionEvent event) throws IOException{
		if(dataInsert==0){
			data.Officer();
			data.Cyclist();
			data.Swimmer();
			data.Sprinter();
			data.SuperAthletes();
			dataInsert++;
		}
		
		Parent gameMenu = FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
		Scene secondScene = new Scene(gameMenu);
		
		//This line gets the Stage information
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(secondScene);
		window.show();
	}
	
	
	public void handlePredictButton(ActionEvent event) throws IOException{
		PerdictionWindow pedict = new PerdictionWindow();
		pedict.display();
	}
	
	
	public void handleRunButton(ActionEvent event){
		if(data.getGameType() == null){
			InformationWindow info = new InformationWindow();
			info.display("Notice", "There are no game!");
		} else {
			if(data.getReStartUse() == null){
				HashMap<String, Double> result = new HashMap<String, Double>();
				if(data.getGameType() == "Cycling"){
					data.setReStartUse("ran");
					String gameID = data.getCycling().getGameID();
					System.out.println("The game is start. Please wait...");
					startCycling(gameID, result);
				}
				else if(data.getGameType() == "Running"){
					data.setReStartUse("ran");
					String gameID = data.getRunning().getGameID();
					System.out.println("The game is start. Please wait...");
					startRunning(gameID, result);
				}
				else if(data.getGameType() == "Swimming"){
					data.setReStartUse("ran");
					String gameID = data.getSwimming().getGameID();
					System.out.println("The game is start. Please wait...");
					startSwimming(gameID, result);
				}
				else{
					System.out.println("The game does not exist.");
				}
			} else {
				System.out.println("Would you like restart the game?(yes/no)");
				Scanner sc = new Scanner(System.in);
				String choice = sc.nextLine();
				if(choice.equals("yes")){
					resetPoints();
					System.out.println("You should reset the prediction first!");
					data.setReStartUse(null);
					//predictMenuControl();
				}
				else if(choice.equals("no")){
					//meanMenuControl();
				}
				
			}
			
		}
	}
	public void startCycling(String gameID, HashMap<String, Double> result){
		//CyclingGameParticipator cGP = (CyclingGameParticipator) data.getCyclingGameList().get(gameID);
		int athletesNumber = data.getCyclistInGame().size() + data.getSuperAthletesInGame().size();
		double[] rank = new double[athletesNumber];
		for(int i=0;i<data.getCyclistInGame().size();i++){
			Cyclist c = (Cyclist) data.getCyclistInGame().get(i);
			double time = c.compete(data.getGameType());
			String ID = c.getID();
			result.put(ID, time);
			rank[i] = time;
		}
		int j=0;
		for(int i=data.getCyclistInGame().size();i<athletesNumber;i++){
			SuperAthletes s = (SuperAthletes) data.getSuperAthletesInGame().get(j);
			double time = s.compete(data.getGameType());
			String ID = s.getID();
			result.put(ID, time);
			rank[i] = time;
			j++;
		}
		Arrays.sort(rank);
		String winner = null, second = null, third = null;
		try{
		    Thread.sleep(((int) rank[athletesNumber-1])*1);
		}
		catch (InterruptedException e){
		    //e.printStackTrace();
		}
		System.out.println("The game is finished.");
		Iterator iter = result.entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			if(entry.getValue()==rank[0]){
				winner = entry.getKey();
			}
			if(entry.getValue()==rank[1]){
				second = entry.getKey();
			}
			if(entry.getValue()==rank[2]){
				third = entry.getKey();
			}
		}
		InformationWindow info = new InformationWindow();
	    String massage = "The 1st is: " + winner + "\tHis result is: " + rank[0]
	    					+ "\nThe 2nd is: " + second + "\tHis result is: " + rank[1]
	    					+ "\nThe 3rd  is: " + third + "\tHis result is: " + rank[2];
	    String title;
//		info.display("Game finished!", massage);
//		System.out.println("The winner is: " + winner + "\tHis result is: " + rank[0]);
//		System.out.println("The second is: " + second + "\tHis result is: " + rank[1]);
//		System.out.println("The third  is: " + third + "\tHis result is: " + rank[2]);
		data.getResultList().put(gameID, result);
		if(data.getPredict().equals(winner)){
			title = "You win";
			System.out.println("You win!");
		}else{
			title = "You loose";
			System.out.println("You loose!");
		}
		info.display(title, massage);
		setPoints(winner, second, third);
		//meanMenuControl();
	}
	public void startRunning(String gameID, HashMap<String, Double> result){
		int athletesNumber = data.getRunnerInGame().size() + data.getSuperAthletesInGame().size();
		double[] rank = new double[athletesNumber];
		for(int i=0;i<data.getRunnerInGame().size();i++){
			Sprinter r = (Sprinter) data.getRunnerInGame().get(i);
			double time = r.compete(data.getGameType());
			String ID = r.getID();
			result.put(ID, time);
			rank[i] = time;
		}
		int j=0;
		for(int i=data.getRunnerInGame().size();i<athletesNumber;i++){
			SuperAthletes s = (SuperAthletes) data.getSuperAthletesInGame().get(j);
			double time = s.compete(data.getGameType());
			String ID = s.getID();
			result.put(ID, time);
			rank[i] = time;
			j++;
		}
		Arrays.sort(rank);
		String winner = null, second = null, third = null;
		try{
		    Thread.sleep(((int) rank[athletesNumber-1])*1000);
		}
		catch (InterruptedException e){
		    //e.printStackTrace();
		}
		System.out.println("The game is finished.");
		Iterator iter = result.entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			if(entry.getValue()==rank[0]){
				winner = entry.getKey();
			}
			if(entry.getValue()==rank[1]){
				second = entry.getKey();
			}
			if(entry.getValue()==rank[2]){
				third = entry.getKey();
			}
		}
		System.out.println("The winner is: " + winner + "\tHis result is: " + rank[0]);
		System.out.println("The second is: " + second + "\tHis result is: " + rank[1]);
		System.out.println("The third  is: " + third + "\tHis result is: " + rank[2]);
		data.getResultList().put(gameID, result);
		if(data.getPredict().equals(winner)){
			System.out.println("You win!");
		}else
			System.out.println("You loose!");
		setPoints(winner, second, third);
		//meanMenuControl();
	}
	public void startSwimming(String gameID, HashMap<String, Double> result){
		int athletesNumber = data.getSwimmerInGame().size() + data.getSuperAthletesInGame().size();
		double[] rank = new double[athletesNumber];
		for(int i=0;i<data.getSwimmerInGame().size();i++){
			Swimmer s = (Swimmer) data.getSwimmerInGame().get(i);
			double time = s.compete(data.getGameType());
			String ID = s.getID();
			result.put(ID, time);
			rank[i] = time;
		}
		int j=0;
		for(int i=data.getSwimmerInGame().size();i<athletesNumber;i++){
			SuperAthletes s = (SuperAthletes) data.getSuperAthletesInGame().get(j);
			double time = s.compete(data.getGameType());
			String ID = s.getID();
			result.put(ID, time);
			rank[i] = time;
			j++;
		}
		Arrays.sort(rank);
		String winner = null, second = null, third = null;
		try{
		    Thread.sleep(((int) rank[athletesNumber-1])*1000);
		}
		catch (InterruptedException e){
		    //e.printStackTrace();
		}
		System.out.println("The game is finished.");
		Iterator iter = result.entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			if(entry.getValue()==rank[0]){
				winner = entry.getKey();
			}
			if(entry.getValue()==rank[1]){
				second = entry.getKey();
			}
			if(entry.getValue()==rank[2]){
				third = entry.getKey();
			}
		}
		System.out.println("The winner is: " + winner + "\tHis result is: " + rank[0]);
		System.out.println("The second is: " + second + "\tHis result is: " + rank[1]);
		System.out.println("The third  is: " + third + "\tHis result is: " + rank[2]);
		data.getResultList().put(gameID, result);
		if(data.getPredict().equals(winner)){
			System.out.println("You win!");
		}else
			System.out.println("You loose!");
		setPoints(winner, second, third);
		//meanMenuControl();
	}
	public void setPoints(String winner, String second, String third){
		if(data.getCyclistList().get(winner) != null || data.getsprinterList().get(winner) != null || data.getSwimmerList().get(winner)!= null){
			if(data.getGameType().equals("Cycling")){
				Cyclist c1 = (Cyclist) data.getCyclistList().get(winner);
				c1.setPoint(5);
			} else if (data.getGameType().equals("Running")){
				Sprinter r1 = (Sprinter) data.getsprinterList().get(winner);
				r1.setPoint(5);
			} else if(data.getGameType().equals("Swimming")){
				Swimmer s1 = (Swimmer) data.getSwimmerList().get(winner);
				s1.setPoint(5);
			} else
				System.out.println("There are some errors in setpoints()");
		} else {
			SuperAthletes sa1 = (SuperAthletes) data.getSuperAthletesList().get(winner);
			sa1.setPoint(5);
		} 
		if(data.getCyclistList().get(second) != null || data.getsprinterList().get(second) != null || data.getSwimmerList().get(second) != null){
			if(data.getGameType().equals("Cycling")){
				Cyclist c2 = (Cyclist) data.getCyclistList().get(second);
				c2.setPoint(2);
			} else if (data.getGameType().equals("Running")){
				Sprinter r2 = (Sprinter) data.getsprinterList().get(second);
				r2.setPoint(2);
			} else if(data.getGameType().equals("Swimming")){
				Swimmer s2 = (Swimmer) data.getSwimmerList().get(second);
				s2.setPoint(2);
			} else
				System.out.println("There are some errors in setpoints()");
		}else{
			SuperAthletes sa2 = (SuperAthletes) data.getSuperAthletesList().get(second);
			sa2.setPoint(2);
		}
		if(data.getCyclistList().get(third) != null || data.getsprinterList().get(third) != null || data.getSwimmerList().get(third) != null){
			if(data.getGameType().equals("Cycling")){
				Cyclist c3 = (Cyclist) data.getCyclistList().get(third);
				c3.setPoint(1);
			} else if (data.getGameType().equals("Running")){
				Sprinter r3 = (Sprinter) data.getsprinterList().get(third);
				r3.setPoint(1);
			} else if(data.getGameType().equals("Swimming")){
				Swimmer s3 = (Swimmer) data.getSwimmerList().get(third);
				s3.setPoint(1);
			} else
				System.out.println("There are some errors in setpoints()");
		}else{
			SuperAthletes sa2 = (SuperAthletes) data.getSuperAthletesList().get(third);
			sa2.setPoint(1);
		}
	}
	public void resetPoints(){
		if(data.getGameType() == "Cycling"){
			data.getCycling().resetPoints(data);
		} 
		else if(data.getGameType() == "Running"){
			data.getRunning().resetPoints(data);
		}
		else if(data.getGameType() == "Swimming"){
			data.getSwimming().resetPoints(data);
		}
	}
	
	
	public void handleDisplayResultButton(ActionEvent event) throws IOException{
		InformationWindow info = new InformationWindow();
		String massage = "\n";
		if(data.getResultList().size()!=0){
			Iterator iter = data.getResultList().entrySet().iterator();		
			while (iter.hasNext()){
				HashMap.Entry<String, HashMap<String, Double>> entry = (Entry<String, HashMap<String, Double>>)iter.next();
				massage = massage + getMessage(entry.getKey());
			}
			//meanMenuControl();
		} else {
			System.out.println("There are not any game has been finished!");
			//meanMenuControl();
		}
		info.display("Rusults", massage);
		
	}
	public String getMessage(String gameID){
		HashMap<String, Double> result = (HashMap<String, Double>) data.getResultList().get(gameID);
		Double[] rank = new Double[result.size()];
		int i = 0;
		Iterator iter = result.entrySet().iterator();		
		while (iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			//System.out.println("ID" + entry.getKey() + "time" + entry.getValue());
			rank[i] = entry.getValue();
			i++;		
		}
		Arrays.sort(rank);
		String winner = null, second = null, third = null, referee;
		String winnerName = null, seconderName = null, thirderName = null, refereeName;
		iter = result.entrySet().iterator();
		while (iter.hasNext()){
			HashMap.Entry<String, Double> entry = (Entry<String, Double>)iter.next();
			if(rank[0]==entry.getValue()){
				winner = entry.getKey();
			}
			if(rank[1]==entry.getValue()){
				second = entry.getKey();
			}
			if(rank[2]==entry.getValue()){
				third = entry.getKey();
			}
		}
		winnerName = getAthletesName(winner, winnerName);
		seconderName = getAthletesName(second, seconderName);
		thirderName = getAthletesName(third, thirderName);
		referee = data.getOfficial().getID();
		refereeName = data.getOfficial().getName();
//		System.out.println("GameID:\t" + gameID +"\tUser prediction:\t" + data.getPredictList().get(gameID));
//		System.out.println("\tRefereeID:\t" + referee + "\tReferee's Name:\t" + refereeName);
//		System.out.println("\tWinnerID:\t" + winner + "\tWinner's Name:\t" + winnerName + "\tResult:\t" + rank[0]);
//		System.out.println("\tSeconderID:\t" + second + "\tseconder's Name:" + seconderName + "\tResult:\t" + rank[1]);
//		System.out.println("\tThirderID:\t" + third + "\tthirder's Name:\t" + thirderName + "\tResult:\t" + rank[2]);
		String message;
		message = "GameID:\t" + gameID +"\tUser prediction:\t" + data.getPredictList().get(gameID)
				+ "\n\tRefereeID:\t" + referee + "\tReferee's Name:\t" + refereeName
				+ "\n\tWinnerID:\t" + winner + "\tWinner's Name:\t" + winnerName + "\tResult:\t" + rank[0]
				+ "\n\tSeconderID:\t" + second + "\tseconder's Name:" + seconderName + "\tResult:\t" + rank[1]
				+ "\n\tThirderID:\t" + third + "\tthirder's Name:\t" + thirderName + "\tResult:\t" + rank[2] + "\n";
		return message;
	}
	public String getAthletesName(String ID, String Name){
		if(data.getCyclistList().get(ID)!=null){
			Cyclist c = (Cyclist) data.getCyclistList().get(ID);
			Name = c.getName();
		} 
		else if(data.getSwimmerList().get(ID)!=null){
			Swimmer s = (Swimmer) data.getSwimmerList().get(ID);
			Name = s.getName();
		}
		else if(data.getsprinterList().get(ID)!=null){
			Sprinter r = (Sprinter) data.getsprinterList().get(ID);
			Name = r.getName();
		}
		else {
			SuperAthletes first = (SuperAthletes) data.getSuperAthletesList().get(ID);
			Name = first.getName();
		}
		return Name;
	}
	
	
	public void handleDisplayPointButton(ActionEvent event) throws IOException{
		
	}
	
	
	public void handleExitButton(ActionEvent event) throws IOException{
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
	}
	

}
