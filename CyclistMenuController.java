import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.collections.ObservableList;
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

public class CyclistMenuController {
	@FXML
	private Button cyclingBackButton, addAthletesID, addRefereeButton;
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
	
	private ArrayList<String> choiseBuffer;
	
	
	 public void handleAddRefereeButton(ActionEvent event){
		 
		 if (refereeButton1.isSelected())
			 addRefereeInGame(refereeButton1);
		 if (refereeButton2.isSelected())
			 System.out.println(refereeButton2.getText());
		 if (refereeButton3.isSelected())
			 System.out.println(refereeButton3.getText());
		 if (refereeButton4.isSelected())
			 System.out.println(refereeButton4.getText());
		 if (refereeButton5.isSelected())
			 System.out.println(refereeButton5.getText());
		 if (refereeButton6.isSelected())
			 System.out.println(refereeButton6.getText());
	    
	 }
	 public void addRefereeInGame(RadioButton radio){
		 if(MeanMenuController.data.getOfficialInGame().size() != 0){
			 InformationWindow info = new InformationWindow();
			 info.display("Notice", "The game has already have a referee!");
			}
			else{
				if(MeanMenuController.data.getOfficialList().get(radio.getText()) != null){
					MeanMenuController.data.getOfficialInGame().add((Official) MeanMenuController.data.getOfficialList().get(radio.getText()));	
					MeanMenuController.data.setOfficial((Official) MeanMenuController.data.getOfficialList().get(radio.getText()));
					System.out.println("Your choice is successfull!");
					System.out.println("Now we have: " + MeanMenuController.data.getOfficialInGame().size() + " official in game.");
				} 
			}
	 }
	 
	 public void handleCyclingBackButton(ActionEvent event) throws IOException{
		 if(MeanMenuController.data.getOfficialInGame().size()!=0 && (MeanMenuController.data.getSuperAthletesInGame().size() + MeanMenuController.data.getCyclistInGame().size()) >= 5){
		 	Parent secondParent = FXMLLoader.load(getClass().getResource("GameMenu.fxml"));
			Scene secondScene = new Scene(secondParent);
			
			//This line gets the Stage information
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(secondScene);
			window.show();
		 }
		 else if((MeanMenuController.data.getSuperAthletesInGame().size() + MeanMenuController.data.getCyclistInGame().size()) < 5){
			 InformationWindow info= new InformationWindow();
			 info.display("Notice!", "There are less than 5 athletes in the game!");
		 } else {
			 InformationWindow info= new InformationWindow();
			 info.display("Notice!", "There are not referee in the game, you have to choose a referee!");
		 }
	 }
	 
	 public void handleAddAthletesID(ActionEvent event){
		 if(MeanMenuController.data.getGameType().equals("Cycling")){
		 	choiseCyclistControl();
		 	choiseSuperAthletesControl();
		 }
		 if(MeanMenuController.data.getGameType().equals("Swimming"))
			 choiseSwimmerControl();
	 }
	 
	 
	 public void choiseSwimmerControl(){
		 
		 if(s1Box.isSelected())
			 addCyclistInGame(s1Box);		 
		 if(s2Box.isSelected())
			 addCyclistInGame(s2Box);		 
		 if(s3Box.isSelected())
			 addCyclistInGame(s3Box);		 
		 if(s4Box.isSelected())
			 addCyclistInGame(s4Box);		 
		 if(s5Box.isSelected())
			 addCyclistInGame(s5Box);		 
		 if(s6Box.isSelected())
			 addCyclistInGame(s6Box);		 
		 if(s7Box.isSelected())
			 addCyclistInGame(s7Box);		 
		 if(s8Box.isSelected())
			 addCyclistInGame(s8Box);
	 }
	 public void addSwimmerInGame(CheckBox checkbox){
 		 if(MeanMenuController.data.getSwimmerInGame().size()<8){
			 System.out.println("Yes" + checkbox.getText());
			 String ID = checkbox.getText();
			 Swimmer s = (Swimmer) MeanMenuController.data.getSwimmerList().get(ID);
			 if (MeanMenuController.data.getSwimmerInGame().contains(s)){
				 System.out.println(ID + " is in the game.");
			 } else {
				 MeanMenuController.data.getSwimmerInGame().add(s);
				 System.out.println("Cyclist in game: " + MeanMenuController.data.getSwimmerInGame().size());
			 }
 		 } else {
 			 System.out.println("Cyclist " + checkbox.getText() +" can't be add in game.");
 			 System.out.println("Because there are 8 athletes in the game.");
 		 }
	 }
	 
	 public void choiseCyclistControl(){
		 
		 if(c1Box.isSelected())
			 addCyclistInGame(c1Box);		 
		 if(c2Box.isSelected())
			 addCyclistInGame(c2Box);		 
		 if(c3Box.isSelected())
			 addCyclistInGame(c3Box);		 
		 if(c4Box.isSelected())
			 addCyclistInGame(c4Box);		 
		 if(c5Box.isSelected())
			 addCyclistInGame(c5Box);		 
		 if(c6Box.isSelected())
			 addCyclistInGame(c6Box);		 
		 if(c7Box.isSelected())
			 addCyclistInGame(c7Box);		 
		 if(c8Box.isSelected())
			 addCyclistInGame(c8Box);
		 
	 }
 	 public void addCyclistInGame(CheckBox checkBox){
 		 if(MeanMenuController.data.getSuperAthletesInGame().size() + MeanMenuController.data.getCyclistInGame().size()<8){
			 System.out.println("Yes" + checkBox.getText());
			 String ID = checkBox.getText();
			 Cyclist c = (Cyclist) MeanMenuController.data.getCyclistList().get(ID);
			 if (MeanMenuController.data.getCyclistInGame().contains(c)){
				 System.out.println(ID + " is in the game.");
			 } else {
				 MeanMenuController.data.getCyclistInGame().add(c);
				 System.out.println("Cyclist in game: " + MeanMenuController.data.getCyclistInGame().size());
			 }
 		 } else {
 			 System.out.println("Cyclist " + checkBox.getText() +" can't be add in game.");
 			 System.out.println("Because there are 8 athletes in the game.");
 		 }
	 }
	 
 	 public void choiseSuperAthletesControl(){
 		 if(sa01Box.isSelected())
			 addSuperAthletesInGame(sa01Box);		 
		 if(sa02Box.isSelected())
			 addSuperAthletesInGame(sa02Box);		 
		 if(sa03Box.isSelected())
			 addSuperAthletesInGame(sa03Box);		 
		 if(sa04Box.isSelected())
			 addSuperAthletesInGame(sa04Box);		 
		 if(sa05Box.isSelected())
			 addSuperAthletesInGame(sa05Box);		 
		 if(sa06Box.isSelected())
			 addSuperAthletesInGame(sa06Box);		 
		 if(sa07Box.isSelected())
			 addSuperAthletesInGame(sa07Box);		 
		 if(sa08Box.isSelected())
			 addSuperAthletesInGame(sa08Box);
 	 }
 	 public void addSuperAthletesInGame(CheckBox checkBox){
 		 int number = 0;
 		 number = MeanMenuController.data.getSuperAthletesInGame().size() + MeanMenuController.data.getCyclistInGame().size();
 		if(number<8){
			 System.out.println("Yes" + checkBox.getText());
			 String ID = checkBox.getText();
			 SuperAthletes sa = (SuperAthletes) MeanMenuController.data.getSuperAthletesList().get(ID);
			 if (MeanMenuController.data.getSuperAthletesInGame().contains(sa)){
				 System.out.println(ID + " is in the game.");
			 } else {
				 MeanMenuController.data.getSuperAthletesInGame().add(sa);
				 System.out.println("SuperAthletes in game: " + MeanMenuController.data.getSuperAthletesInGame().size());
				 System.out.println("Athletes in game: " + (MeanMenuController.data.getSuperAthletesInGame().size() + MeanMenuController.data.getCyclistInGame().size()));
			 }
		 } else {
			 System.out.println("Cyclist " + checkBox.getText() +" can't be add in game.");
			 System.out.println("Because there are 8 athletes in the game.");
		 }
 	 }
 	 	
}














