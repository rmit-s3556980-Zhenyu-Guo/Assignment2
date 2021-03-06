import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChoiceWindow {
	
	boolean result;
	
	public boolean display(String message){
		
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Notice");
		window.setMinWidth(200);
		
		Label label = new Label();
		label.setText(message);
		
		Button yes = new Button("Yes");
		Button no = new Button("No");
		
		yes.setOnAction(e -> {
			result = true;
			window.close();
		});
		
		no.setOnAction(e -> {
			window.close();
		});
		
		VBox layout = new VBox(10);
		
		layout.getChildren().addAll(label, yes, no);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return result;
	}
}
