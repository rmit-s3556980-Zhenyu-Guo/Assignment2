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
	private Button backMeanMenuButton, cyclingButton;
	
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

}
