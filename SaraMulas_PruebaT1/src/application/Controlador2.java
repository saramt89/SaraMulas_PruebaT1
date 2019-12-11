package application;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controlador2 {
	
	@FXML
	AnchorPane rootPane;
	
	@FXML
	private Pane pane1, pane2, pane3, pane4;

	@FXML
	private ImageView drawerImage;

	public void initialize() {

		pane1.setStyle("-fx-background-image: url('application/1.jpg')");
		pane2.setStyle("-fx-background-image: url('application/2.jpg')");
		pane3.setStyle("-fx-background-image: url('application/3.jpg')");
		pane4.setStyle("-fx-background-image: url('application/4.jpg')");

		Animation();

		
	}

	public void Animation() {

		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), pane4);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();

		fadeTransition.setOnFinished(event -> {
			FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(3), pane3);
			fadeTransition1.setFromValue(1);
			fadeTransition1.setToValue(0);
			fadeTransition1.play();

			fadeTransition1.setOnFinished(event1 -> {

				FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(3), pane2);
				fadeTransition2.setFromValue(1);
				fadeTransition2.setToValue(0);
				fadeTransition2.play();

				fadeTransition2.setOnFinished(event2 -> {

					FadeTransition fadeTransition00 = new FadeTransition(Duration.seconds(3), pane2);
					fadeTransition00.setFromValue(0);
					fadeTransition00.setToValue(1);
					fadeTransition00.play();

					fadeTransition00.setOnFinished(event3 -> {
						FadeTransition fadeTransition11 = new FadeTransition(Duration.seconds(3), pane3);
						fadeTransition11.setFromValue(0);
						fadeTransition11.setToValue(1);
						fadeTransition11.play();

						fadeTransition11.setOnFinished(event4 -> {
							FadeTransition fadeTransition22 = new FadeTransition(Duration.seconds(3), pane4);
							fadeTransition22.setFromValue(0);
							fadeTransition22.setToValue(1);
							fadeTransition22.play();

							fadeTransition22.setOnFinished(event5 -> {
								Animation();
							});
						});

					});
				});

			});

		});
	}
	
	@FXML
	private void closeApp() {
		Stage thisStage = (Stage) rootPane.getScene().getWindow();
	    thisStage.close();	
	}

}
