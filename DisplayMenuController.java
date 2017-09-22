import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DisplayMenuController {
	@FXML
	static
	Label displayLabel;
	
	@FXML
	Button displayMenuBackButton;
	
	public static void setDisplayLabel(String massage){
		displayLabel.setText(massage);
	}
	
	public void handleDisplayMenuBackButton(ActionEvent event) throws IOException{
		Parent meanMenu = FXMLLoader.load(getClass().getResource("MeanMenu.fxml"));
		Scene scene = new Scene(meanMenu);
		
		//This line gets the Stage information
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(scene);
		window.show();
	}
	
}
