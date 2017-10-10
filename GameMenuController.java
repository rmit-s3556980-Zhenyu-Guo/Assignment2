import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameMenuController {
	
	@FXML
	private Button backMeanMenuButton, cyclingButton, runningButton, swimmingButton;
	
	public void handleBackMeanMenuButton(ActionEvent event) throws IOException{
		
		Parent secondParent = FXMLLoader.load(getClass().getResource("MeanMenu.fxml"));
		Scene secondScene = new Scene(secondParent);
		
		//This line gets the Stage information
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(secondScene);
		window.show();
	}
	
	public void handleCyclingButton(ActionEvent event) throws IOException{
		
		MeanMenuController.data.setReStartUse(null);
		String gameID = "C" + Integer.toString(MeanMenuController.data.getCyclingGameNumber());
		MeanMenuController.data.setCyclingGameNumber(MeanMenuController.data.getCyclingGameNumber()+1);
		Cycling cycling = new Cycling(gameID, "Cycling", false, null);
		MeanMenuController.data.setCycling(cycling);
		MeanMenuController.data.setGameType("Cycling");
		
		ArrayList<String> choiseBuffer = new ArrayList<String> ();
		MeanMenuController.data.setChoiseBuffer(choiseBuffer);
		ArrayList<Cyclist> cyclistInGame = new ArrayList<Cyclist>();
		MeanMenuController.data.setcyclistInGame(cyclistInGame);
		cyclistInGame = MeanMenuController.data.getCyclistInGame();
		ArrayList<Official> officialInGame = new ArrayList<Official>();
		MeanMenuController.data.setOfficialInGame(officialInGame);
		officialInGame = MeanMenuController.data.getOfficialInGame();
		ArrayList<SuperAthletes> superAthletesInGame = new ArrayList<SuperAthletes>();
		MeanMenuController.data.setsuperAthletesInGame(superAthletesInGame);
		superAthletesInGame = MeanMenuController.data.getSuperAthletesInGame();
		
		
		Parent secondParent = FXMLLoader.load(getClass().getResource("CyclistMenu.fxml"));
		Scene secondScene = new Scene(secondParent);
		
		//This line gets the Stage information
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(secondScene);
		window.show();
	}
	
	public void handleRunningButton(ActionEvent event) throws IOException{
		MeanMenuController.data.setReStartUse(null);
		String gameID = "R" + Integer.toString(MeanMenuController.data.getRunningGameNumber());
		MeanMenuController.data.setRunningGameNumber(MeanMenuController.data.getRunningGameNumber()+1);
		Running running = new Running(gameID, "Running", false, null);
		MeanMenuController.data.setRunning(running);
		MeanMenuController.data.setGameType("Running");
		
		ArrayList<String> choiseBuffer = new ArrayList<String> ();
		MeanMenuController.data.setChoiseBuffer(choiseBuffer);
		ArrayList<Sprinter> runnerInGame = new ArrayList<Sprinter>();
		MeanMenuController.data.setRunnerInGame(runnerInGame);
		runnerInGame = MeanMenuController.data.getRunnerInGame();
		ArrayList<Official> officialInGame = new ArrayList<Official>();
		MeanMenuController.data.setOfficialInGame(officialInGame);
		officialInGame = MeanMenuController.data.getOfficialInGame();
		ArrayList<SuperAthletes> superAthletesInGame = new ArrayList<SuperAthletes>();
		MeanMenuController.data.setsuperAthletesInGame(superAthletesInGame);
		superAthletesInGame = MeanMenuController.data.getSuperAthletesInGame();
		
		
		Parent secondParent = FXMLLoader.load(getClass().getResource("RunnerMenu.fxml"));
		Scene secondScene = new Scene(secondParent);
		
		//This line gets the Stage information
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(secondScene);
		window.show();
	}
	
	public void handleSwimmingButton(ActionEvent event) throws IOException{
		MeanMenuController.data.setReStartUse(null);
		String gameID = "S" + Integer.toString(MeanMenuController.data.getSwimmingGameNumber());
		MeanMenuController.data.setSwimmingGameNumber(MeanMenuController.data.getSwimmingGameNumber() + 1);
		Swimming swimming = new Swimming(gameID, "Swimming", false, null);
		MeanMenuController.data.setSwimming(swimming);
		MeanMenuController.data.setGameType("Swimming");
		
		ArrayList<String> choiseBuffer = new ArrayList<String> ();
		MeanMenuController.data.setChoiseBuffer(choiseBuffer);
		ArrayList<Swimmer> swimmerInGame = new ArrayList<Swimmer>();
		MeanMenuController.data.setSwimmerInGame(swimmerInGame);
		swimmerInGame = MeanMenuController.data.getSwimmerInGame();
		ArrayList<Official> officialInGame = new ArrayList<Official>();
		MeanMenuController.data.setOfficialInGame(officialInGame);
		officialInGame = MeanMenuController.data.getOfficialInGame();
		ArrayList<SuperAthletes> superAthletesInGame = new ArrayList<SuperAthletes>();
		MeanMenuController.data.setsuperAthletesInGame(superAthletesInGame);
		superAthletesInGame = MeanMenuController.data.getSuperAthletesInGame();
		
		
		Parent secondParent = FXMLLoader.load(getClass().getResource("SwimmerMenu.fxml"));
		Scene secondScene = new Scene(secondParent);
		
		//This line gets the Stage information
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(secondScene);
		window.show();
	}
}
