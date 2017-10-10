import javafx.animation.PathTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StartGameWindow {
	public void display(String title, String massage, double[] rank){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(200);
		
		Label label = new Label();
		label.setText(massage);
		
		
		Rectangle rectangle = new Rectangle (0, 0, 25, 50);
		rectangle.setFill(Color.ORANGE);
				
		Pane pane = new Pane();
		Circle circle = new Circle(125, 100, 50);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Line line = new Line();
		line.setStartX(0);
		line.setEndX(120);
		line.setStartY(20);
		line.setEndY(20);
		
		pane.getChildren().add(line);
		pane.getChildren().add(rectangle);
		
		Double time = rank[rank.length - 1];
		Duration dr = Duration.millis(rank[rank.length - 1]*10);
		Duration first = Duration.millis(rank[0]*10);
		
		
		PathTransition pt = new PathTransition();
		pt.setDuration(dr);
		pt.setPath(line);
		pt.setNode(rectangle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		//pt.setCycleCount(Timeline.INDEFINITE);
		//pt.setAutoReverse(true);
		pt.play();
		
		Button closeButton = new Button("Skip");
		closeButton.setOnAction(e -> {
			if(pt.getCurrentTime().lessThan(first)){
				System.out.println(rank[0]);
				System.out.println(rank[rank.length-1]);
				System.out.println(pt.getCurrentTime());
				System.out.println(dr);
				InformationWindow info = new InformationWindow();
				info.display("Notice", "The game is not finish");
			} else {
			window.close();
			InformationWindow info = new InformationWindow();
			info.display(title, massage);
			}
		});
		
		VBox layout = new VBox(10);
		
        layout.getChildren().addAll(pane, closeButton);
        layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
