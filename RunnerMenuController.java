import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class RunnerMenuController {
	@FXML
	private Button runningBackButton, addAthletesID, addRefereeButton;
	@FXML
	private RadioButton refereeButton1, refereeButton2, refereeButton3, refereeButton4, refereeButton5, refereeButton6;
	@FXML
	private ToggleGroup refereeGroup;
	@FXML
	private CheckBox c1Box, c2Box, c3Box, c4Box, c5Box, c6Box, c7Box, c8Box;
	@FXML
	private CheckBox sa01Box, sa02Box, sa03Box, sa04Box, sa05Box, sa06Box, sa07Box, sa08Box;
	@FXML
	private CheckBox s1Box, s2Box, s3Box, s4Box, s5Box, s6Box, s7Box, s8Box;
	@FXML
	private CheckBox r1Box, r2Box, r3Box, r4Box, r5Box, r6Box, r7Box, r8Box; 

	//private ObservableList<String> choiseBuffer;

	public void handleAddRefereeButton(ActionEvent event) {

		if (refereeButton1.isSelected())
			addRefereeInGame(refereeButton1);
		if (refereeButton2.isSelected())
			addRefereeInGame(refereeButton2);
		if (refereeButton3.isSelected())
			addRefereeInGame(refereeButton3);
		if (refereeButton4.isSelected())
			addRefereeInGame(refereeButton4);
		if (refereeButton5.isSelected())
			addRefereeInGame(refereeButton5);
		if (refereeButton6.isSelected())
			addRefereeInGame(refereeButton6);

	}
	public void addRefereeInGame(RadioButton radio) {
		if (MeanMenuController.data.getOfficialInGame().size() != 0) {
			InformationWindow info = new InformationWindow();
			info.display("Notice", "The game has already have a referee!");
		} else {
			if (MeanMenuController.data.getOfficialList().get(radio.getText()) != null) {
				MeanMenuController.data.getOfficialInGame()
						.add((Official) MeanMenuController.data.getOfficialList().get(radio.getText()));
				MeanMenuController.data
						.setOfficial((Official) MeanMenuController.data.getOfficialList().get(radio.getText()));
				System.out.println("Your choice is successfull!");
				System.out.println(
						"Now we have: " + MeanMenuController.data.getOfficialInGame().size() + " official in game.");
			}
		}
	}

	
	public void handleRunningBackButton(ActionEvent event) throws IOException {
		if (MeanMenuController.data.getOfficialInGame().size() != 0
				&& (MeanMenuController.data.getSuperAthletesInGame().size()
						+ MeanMenuController.data.getRunnerInGame().size()) >= 5) {
			Parent secondParent = FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
			Scene secondScene = new Scene(secondParent);

			// This line gets the Stage information
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

			window.setScene(secondScene);
			window.show();
		} else if ((MeanMenuController.data.getSuperAthletesInGame().size()
				+ MeanMenuController.data.getRunnerInGame().size()) < 5) {
			ChoiceWindow cw = new ChoiceWindow();
			if(cw.display("There are less than 5 athletes in the game."+"\nWould you want to cancled game and go back?")){
				MeanMenuController.data.setRunningGameNumber(MeanMenuController.data.getRunningGameNumber() - 1);
				MeanMenuController.data.setRunning(null);
				MeanMenuController.data.setGameType(null);
				MeanMenuController.data.setOfficial(null);
				Parent secondParent = FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
				Scene secondScene = new Scene(secondParent);

				// This line gets the Stage information
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

				window.setScene(secondScene);
				window.show();
			}
		} else {
			ChoiceWindow cw= new ChoiceWindow();			
			if(cw.display("There are no referee."+"\nWould you want to cancled game and go back?")){
				MeanMenuController.data.setRunningGameNumber(MeanMenuController.data.getRunningGameNumber() - 1);
				MeanMenuController.data.setRunning(null);
				MeanMenuController.data.setGameType(null);
				MeanMenuController.data.setOfficial(null);
				Parent secondParent = FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
				Scene secondScene = new Scene(secondParent);

				// This line gets the Stage information
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

				window.setScene(secondScene);
				window.show();
			};
		}
	}

	
	public void handleAddAthletesID(ActionEvent event) {
		//ArrayList<String> choiseBuffer = new ArrayList<String> ();
		if (MeanMenuController.data.getGameType().equals("Running")) {
			if(checkChoise()){	
				choiseRunnerControl();
				choiseSuperAthletesControl();
				///MeanMenuController.data.setChoiseBuffer(choiseBuffer);
			} else {
				
				ArrayList<String> choiseBuffer = new ArrayList<String> ();
				MeanMenuController.data.setChoiseBuffer(choiseBuffer);
				
				
				InformationWindow info = new InformationWindow();
				info.display("Notice", "Only 8 athletes can be add in a game.\nPlease re-choose athletes.");				
				//MeanMenuController.data.setChoiseBuffer(choiseBuffer);
			}
		}
	}

	public void choiseSwimmerControl() {

		if (s1Box.isSelected())
			addCyclistInGame(s1Box);
		if (s2Box.isSelected())
			addCyclistInGame(s2Box);
		if (s3Box.isSelected())
			addCyclistInGame(s3Box);
		if (s4Box.isSelected())
			addCyclistInGame(s4Box);
		if (s5Box.isSelected())
			addCyclistInGame(s5Box);
		if (s6Box.isSelected())
			addCyclistInGame(s6Box);
		if (s7Box.isSelected())
			addCyclistInGame(s7Box);
		if (s8Box.isSelected())
			addCyclistInGame(s8Box);
	}
	public void addSwimmerInGame(CheckBox checkbox) {
		if (MeanMenuController.data.getSwimmerInGame().size() < 8) {
			System.out.println("Yes" + checkbox.getText());
			String ID = checkbox.getText();
			Swimmer s = (Swimmer) MeanMenuController.data.getSwimmerList().get(ID);
			if (MeanMenuController.data.getSwimmerInGame().contains(s)) {
				System.out.println(ID + " is in the game.");
			} else {
				MeanMenuController.data.getSwimmerInGame().add(s);
				System.out.println("Cyclist in game: " + MeanMenuController.data.getSwimmerInGame().size());
			}
		} else {
			System.out.println("Cyclist " + checkbox.getText() + " can't be add in game.");
			System.out.println("Because there are 8 athletes in the game.");
		}
	}

	
	public void choiseCyclistControl() {
		
			if (c1Box.isSelected())
				addCyclistInGame(c1Box);
			if (c2Box.isSelected())
				addCyclistInGame(c2Box);
			if (c3Box.isSelected())
				addCyclistInGame(c3Box);
			if (c4Box.isSelected())
				addCyclistInGame(c4Box);
			if (c5Box.isSelected())
				addCyclistInGame(c5Box);
			if (c6Box.isSelected())
				addCyclistInGame(c6Box);
			if (c7Box.isSelected())
				addCyclistInGame(c7Box);
			if (c8Box.isSelected())
				addCyclistInGame(c8Box);
		
		
	}
	public void addCyclistInGame(CheckBox checkBox) {
		
		if (MeanMenuController.data.getSuperAthletesInGame().size()
				+ MeanMenuController.data.getCyclistInGame().size() < 8) {
			System.out.println("Yes" + checkBox.getText());
			String ID = checkBox.getText();
			Cyclist c = (Cyclist) MeanMenuController.data.getCyclistList().get(ID);
			if (MeanMenuController.data.getCyclistInGame().contains(c)) {
				System.out.println(ID + " is in the game.");
			} else {
				MeanMenuController.data.getCyclistInGame().add(c);
				System.out.println("Cyclist in game: " + MeanMenuController.data.getCyclistInGame().size());
			}
		} else {
			System.out.println("Cyclist " + checkBox.getText() + " can't be add in game.");
			System.out.println("Because there are 8 athletes in the game.");
		}
		
	}
	public void addChoiceBuffer(CheckBox checkBox){
			System.out.println("Yes" + checkBox.getText());
			System.out.println(MeanMenuController.data.getChoiseBuffer().size());
			String ID = checkBox.getText();
			if(MeanMenuController.data.getChoiseBuffer().contains(ID)){
				System.out.println("Athlete is existed.");
			} else {
				MeanMenuController.data.getChoiseBuffer().add(ID);
			}
	}
	
	public void choiseRunnerControl(){
		
		if (r1Box.isSelected())
			addRunnerInGame(r1Box);
		if (r2Box.isSelected())
			addRunnerInGame(r2Box);
		if (r3Box.isSelected())
			addRunnerInGame(r3Box);
		if (r4Box.isSelected())
			addRunnerInGame(r4Box);
		if (r5Box.isSelected())
			addRunnerInGame(r5Box);
		if (r6Box.isSelected())
			addRunnerInGame(r6Box);
		if (r7Box.isSelected())
			addRunnerInGame(r7Box);
		if (r8Box.isSelected())
			addRunnerInGame(r8Box);
	}
	public void addRunnerInGame(CheckBox checkBox){
		if (MeanMenuController.data.getSuperAthletesInGame().size()
				+ MeanMenuController.data.getRunnerInGame().size() < 8) {
			System.out.println("Yes" + checkBox.getText());
			String ID = checkBox.getText();
			Sprinter r = (Sprinter) MeanMenuController.data.getsprinterList().get(ID);
			if (MeanMenuController.data.getRunnerInGame().contains(r)) {
				System.out.println(ID + " is in the game.");
			} else {
				MeanMenuController.data.getRunnerInGame().add(r);
				System.out.println("Runner in game: " + MeanMenuController.data.getRunnerInGame().size());
			}
		} else {
			System.out.println("Runner " + checkBox.getText() + " can't be add in game.");
			System.out.println("Because there are 8 athletes in the game.");
		}
	}
	
	
	public boolean checkChoise(){
		if (r1Box.isSelected())
			addChoiceBuffer(r1Box);
		if (r2Box.isSelected())
			addChoiceBuffer(r2Box);
		if (r3Box.isSelected())
			addChoiceBuffer(r3Box);
		if (r4Box.isSelected())
			addChoiceBuffer(r4Box);
		if (r5Box.isSelected())
			addChoiceBuffer(r5Box);
		if (r6Box.isSelected())
			addChoiceBuffer(r6Box);
		if (r7Box.isSelected())
			addChoiceBuffer(r7Box);
		if (r8Box.isSelected())
			addChoiceBuffer(r8Box);
		
		
		if (sa01Box.isSelected())
			addChoiceBuffer(sa02Box);
		if (sa02Box.isSelected())
			addChoiceBuffer(sa03Box);
		if (sa03Box.isSelected())
			addChoiceBuffer(sa03Box);
		if (sa04Box.isSelected())
			addChoiceBuffer(sa04Box);
		if (sa05Box.isSelected())
			addChoiceBuffer(sa05Box);
		if (sa06Box.isSelected())
			addChoiceBuffer(sa06Box);
		if (sa07Box.isSelected())
			addChoiceBuffer(sa07Box);
		if (sa08Box.isSelected())
			addChoiceBuffer(sa08Box);
		
		if(MeanMenuController.data.getChoiseBuffer().size()<=8)
			return true;
		else
			return false;
	}
	
	
	public void choiseSuperAthletesControl() {
		if (sa01Box.isSelected())
			addSuperAthletesInGame(sa01Box);
		if (sa02Box.isSelected())
			addSuperAthletesInGame(sa02Box);
		if (sa03Box.isSelected())
			addSuperAthletesInGame(sa03Box);
		if (sa04Box.isSelected())
			addSuperAthletesInGame(sa04Box);
		if (sa05Box.isSelected())
			addSuperAthletesInGame(sa05Box);
		if (sa06Box.isSelected())
			addSuperAthletesInGame(sa06Box);
		if (sa07Box.isSelected())
			addSuperAthletesInGame(sa07Box);
		if (sa08Box.isSelected())
			addSuperAthletesInGame(sa08Box);
	}
	public void addSuperAthletesInGame(CheckBox checkBox) {
		int number = 0;
		number = MeanMenuController.data.getSuperAthletesInGame().size()
				+ MeanMenuController.data.getRunnerInGame().size();
		if (number < 8) {
			System.out.println("Yes" + checkBox.getText());
			String ID = checkBox.getText();
			SuperAthletes sa = (SuperAthletes) MeanMenuController.data.getSuperAthletesList().get(ID);
			if (MeanMenuController.data.getSuperAthletesInGame().contains(sa)) {
				System.out.println(ID + " is in the game.");
			} else {
				MeanMenuController.data.getSuperAthletesInGame().add(sa);
				System.out.println("SuperAthletes in game: " + MeanMenuController.data.getSuperAthletesInGame().size());
				System.out.println("Athletes in game: " + (MeanMenuController.data.getSuperAthletesInGame().size()
						+ MeanMenuController.data.getRunnerInGame().size()));
			}
		} else {
			System.out.println("Runner " + checkBox.getText() + " can't be add in game.");
			System.out.println("Because there are 8 athletes in the game.");
		}
	}
	
}
