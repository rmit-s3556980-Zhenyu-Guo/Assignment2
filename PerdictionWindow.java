import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PerdictionWindow {
	public void display(){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Perdiction");
		window.setMinWidth(200);
		
		ChoiceBox<String> choiceBox = new ChoiceBox<String>();
		if(MeanMenuController.data.getGameType().equals("Cycling")){
			for(int i = 0; i<MeanMenuController.data.getCyclistInGame().size(); i++){
				String cyclistID;
				Cyclist c = (Cyclist) MeanMenuController.data.getCyclistInGame().get(i);
				cyclistID = c.getID();
				choiceBox.getItems().add(cyclistID);
			}
			for(int i = 0; i<MeanMenuController.data.getSuperAthletesInGame().size(); i++){
				String superID;
				SuperAthletes sa = (SuperAthletes) MeanMenuController.data.getSuperAthletesInGame().get(i);
				superID = sa.getID();
				choiceBox.getItems().add(superID);
			}
		}
		else if(MeanMenuController.data.getGameType().equals("Running")){
			for(int i = 0; i<MeanMenuController.data.getRunnerInGame().size(); i++){
				String runnerID;
				Sprinter r = (Sprinter) MeanMenuController.data.getRunnerInGame().get(i);
				runnerID = r.getID();
				choiceBox.getItems().add(runnerID);
			}
			for(int i = 0; i<MeanMenuController.data.getSuperAthletesInGame().size(); i++){
				String superID;
				SuperAthletes sa = (SuperAthletes) MeanMenuController.data.getSuperAthletesInGame().get(i);
				superID = sa.getID();
				choiceBox.getItems().add(superID);
			}
		}
		else if(MeanMenuController.data.getGameType().equals("Swimming")){
			for(int i = 0; i<MeanMenuController.data.getSwimmerInGame().size(); i++){
				String swimmerID;
				Swimmer s = (Swimmer) MeanMenuController.data.getSwimmerInGame().get(i);
				swimmerID = s.getID();
				choiceBox.getItems().add(swimmerID);
			}
			for(int i = 0; i<MeanMenuController.data.getSuperAthletesInGame().size(); i++){
				String superID;
				SuperAthletes sa = (SuperAthletes) MeanMenuController.data.getSuperAthletesInGame().get(i);
				superID = sa.getID();
				choiceBox.getItems().add(superID);
			}
		}
		
		Label label = new Label();
		label.setText("Please Perdict a winner!");
		Button submit = new Button("Submit");
		
		submit.setOnAction(e -> {
			if(MeanMenuController.data.getGameType().equals("Cycling")){
				String athleteID = choiceBox.getValue();
				MeanMenuController.data.setPredict(athleteID);
				System.out.println("You predict " + athleteID + " as winner!");
				MeanMenuController.data.getPredictList().put(MeanMenuController.data.getCycling().getGameID(), athleteID);
				window.close();
			}
			else if(MeanMenuController.data.getGameType().equals("Running")){
				String athleteID = choiceBox.getValue();
				MeanMenuController.data.setPredict(athleteID);
				System.out.println("You predict " + athleteID + " as winner!");
				MeanMenuController.data.getPredictList().put(MeanMenuController.data.getRunning().getGameID(), athleteID);
				window.close();
			}
			else if(MeanMenuController.data.getGameType().equals("Swimming")){
				String athleteID = choiceBox.getValue();
				MeanMenuController.data.setPredict(athleteID);
				System.out.println("You predict " + athleteID + " as winner!");
				MeanMenuController.data.getPredictList().put(MeanMenuController.data.getSwimming().getGameID(), athleteID);
				window.close();
			}
			
		});
		
		VBox layout = new VBox(10);
        layout.getChildren().addAll(label, choiceBox, submit);
        layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
