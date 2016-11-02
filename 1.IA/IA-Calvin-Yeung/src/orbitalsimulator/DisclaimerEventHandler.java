package orbitalsimulator;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DisclaimerEventHandler implements EventHandler {

	@Override
	public void handle(Event event) {
		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("DisclaimerFXML.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setResizable(false);
			
			stage.show();
		}
		
		catch(Exception e) {System.err.printf("Error: %s\n", e);}
	}
	
}
