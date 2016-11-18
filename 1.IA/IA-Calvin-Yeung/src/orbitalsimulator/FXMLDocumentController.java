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
import javafx.scene.input.DragEvent;
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
	@FXML
	private Label unitLabel;
	@FXML
	private Label speedLabel;
	
	// initialize files
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		simulatorContainer = new World(simulatorCanvas);
		dataProcessor = new DataProcessor(simulatorContainer);
		graphContainer = new GraphicsContainer(graphCanvas);
		
		simulatorContainer.setDataProcessor(dataProcessor);
		simulatorContainer.init();
		
		initDropdown();
		initActions();
		
		// start rendering of simulation and graph
		simulatorContainer.start();
		graphContainer.start();
	}	
	
	// toggles run state of simulation
	@FXML
	private void toggleSimulation(ActionEvent event) {
		simulatorContainer.setRunning(!simulatorContainer.isRunning());
		toggleSimulationButton.setText(
			simulatorContainer.isRunning() ? "Pause Simulation" : "Start Simulation");
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
		speedLabel.setText(String.format("%.1f yrs/s", speedSlider.getValue()));
	}

	@FXML
	private void updatePressed(ActionEvent event) {
		String selectedItem = dropdown.getSelectionModel().getSelectedItem();
		double value = Double.valueOf(inputField.getText());
		double mass = Double.valueOf(largeMassField.getText());
		
		dataProcessor.updateData(selectedItem, value, mass);
		
		simulatorContainer.setRunning(false);
		toggleSimulationButton.setText("Start Simulation");
	}
}
