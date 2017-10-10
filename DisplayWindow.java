import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DisplayWindow {
	
	public void display(String title, String massage){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setWidth(500);
		window.setHeight(300);
		window.setResizable(false);
		
		Label label = new Label();
		label.setText(massage);
		Button closeButton = new Button("Ok");
		closeButton.setOnAction(e -> window.close());
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(label);
		VBox layout = new VBox(10);
        layout.getChildren().addAll(scrollPane, closeButton);
        layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
