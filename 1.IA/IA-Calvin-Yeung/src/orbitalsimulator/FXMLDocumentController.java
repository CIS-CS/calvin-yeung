package orbitalsimulator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import orbitalsimulator.graphics.GraphicsContainer;
import orbitalsimulator.graphics.World;

public class FXMLDocumentController implements Initializable {
	
	private Label label;
	@FXML
	private Button toggleSimulationButton;
	@FXML
	private Label statisticsLabel;
	@FXML
	private TextField inputField1;
	@FXML
	private TextField inputField2;
	@FXML
	private TextField smallMassField;
	@FXML
	private Slider speedSlider;
	@FXML
	private Canvas simulatorCanvas;
	@FXML
	private Canvas graphCanvas;
	@FXML
	private ChoiceBox<String> dropdown1;
	@FXML
	private ChoiceBox<String> dropdown2;
	@FXML
	private Button disclaimerButton;
	
	private final String[] VARIABLES = {"Large Planet Mass", "Distance", "Velocity"};
	private World simulatorContainer;
	private GraphicsContainer graphContainer;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initDropdown();
		initButtons();
		
		simulatorContainer = new World(simulatorCanvas);
		graphContainer = new GraphicsContainer(graphCanvas);
		
		simulatorContainer.start();
		graphContainer.start();
	}	

	@FXML
	private void toggleSimulation(ActionEvent event) {
	}

	@FXML
	private void showDisclaimer(ActionEvent event) {
	}
	
	private void initDropdown() {
		dropdown1.getItems().addAll(VARIABLES);
		dropdown2.getItems().addAll(VARIABLES);
		dropdown1.getSelectionModel().select(0);
		dropdown2.getSelectionModel().select(1);
	}
	
	private void initButtons() {
		disclaimerButton.setOnAction(new DisclaimerEventHandler());
	}
}
