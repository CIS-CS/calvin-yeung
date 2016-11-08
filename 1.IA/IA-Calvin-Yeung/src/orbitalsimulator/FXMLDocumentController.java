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
import javafx.scene.input.MouseEvent;
import orbitalsimulator.data.DataProcessor;
import orbitalsimulator.graphics.GraphicsContainer;
import orbitalsimulator.graphics.World;

public class FXMLDocumentController implements Initializable {
	
	private Label label;
	@FXML
	private Button toggleSimulationButton;
	@FXML
	private Label statisticsLabel;
	@FXML
	private TextField smallMassField;
	@FXML
	private Slider speedSlider;
	@FXML
	private Canvas simulatorCanvas;
	@FXML
	private Canvas graphCanvas;
	@FXML
	private Button disclaimerButton;
	@FXML
	private TextField largeMassField;
	@FXML
	private ChoiceBox<String> dropdown;
	@FXML
	private TextField inputField;
	
	private final String[] VARIABLES = {"Distance", "Velocity", "Period"};
	private World simulatorContainer;
	private GraphicsContainer graphContainer;
	private DataProcessor dataProcessor;
	@FXML
	private Button updateChangeButton;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		dataProcessor = new DataProcessor(simulatorContainer);
		simulatorContainer = new World(simulatorCanvas, dataProcessor);
		graphContainer = new GraphicsContainer(graphCanvas);
		
		initDropdown();
		initActions();
		
		simulatorContainer.start();
		graphContainer.start();
	}	

	@FXML
	private void toggleSimulation(ActionEvent event) {
		simulatorContainer.setRunning(!simulatorContainer.isRunning());
	}
	
	private void initDropdown() {
		dropdown.getItems().addAll(VARIABLES);
		dropdown.getSelectionModel().select(0);
	}
	
	private void initActions() {
		DataUpdateEventHandler dataHandler = new DataUpdateEventHandler(
				dataProcessor, dropdown, inputField, largeMassField);
		
		disclaimerButton.setOnAction(new DisclaimerEventHandler());
		updateChangeButton.setOnAction(dataHandler);
	}

	@FXML
	private void speedDragDetected(MouseEvent event) {
		simulatorContainer.setSimulationSpeed(speedSlider.getValue());
	}
}
