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
import orbitalsimulator.graphics.GraphContainer;
import orbitalsimulator.graphics.GraphicsContainer;
import orbitalsimulator.graphics.World;

public class FXMLDocumentController implements Initializable {

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
    private Button updateChangeButton;
    @FXML
    private Label unitLabel;
    @FXML
    private Label speedLabel;
    @FXML
    private TextField distanceField;

    private World simulatorContainer;
    private GraphicsContainer graphContainer;
    private DataProcessor dataProcessor;
    @FXML
    private Label errorLabel;

    /**
     * Initializes fields and runs graph and simulation rendering.
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // init fields
        simulatorContainer = new World(simulatorCanvas);
        dataProcessor = new DataProcessor(simulatorContainer);
        graphContainer = new GraphContainer(graphCanvas);

        simulatorContainer.setDataProcessor(dataProcessor);
        simulatorContainer.init();

        graphContainer.setDataProcessor(dataProcessor);
        graphContainer.init();

        // start rendering of simulation and graph
        simulatorContainer.start();
        graphContainer.start();

        // set action for disclaimer button
        disclaimerButton.setOnAction(new DisclaimerEventHandler());

        // update visuals to match initial data
        updatePressed(null);
    }	

    /**
     * Toggles run state of simulation.
     * @param event 
     */
    @FXML
    private void toggleSimulation(ActionEvent event) {
        simulatorContainer.setRunning(!simulatorContainer.isRunning());
        toggleSimulationButton.setText(
                simulatorContainer.isRunning() ? "Pause Simulation" : "Start Simulation");
    }

    /**
     * Updates data when simulation speed slider is altered.
     * @param event 
     */
    @FXML
    private void speedDragDetected(MouseEvent event) {
        simulatorContainer.setSimulationSpeed(speedSlider.getValue());
        speedLabel.setText(String.format("%.1f yrs/s", speedSlider.getValue()));
    }

    /**
     * Updates data to match user input.
     * @param event 
     */
    @FXML
    private void updatePressed(ActionEvent event) {

        double distance = 1, mass = 1, smallMass = 1;
        boolean invalid = false;

        // check if input string is invalid
        try {
            distance = Double.valueOf(distanceField.getText());
            mass = Double.valueOf(largeMassField.getText());
            smallMass = Double.valueOf(smallMassField.getText());
        }

        catch(Exception e) {
            invalid = true;
        }

        if(!invalid && (distance < 0 || distance > 2.3 || mass < 0 || smallMass < 0))
            invalid = true;

        if(!invalid) {
            errorLabel.setText("");
        }

        else {
            errorLabel.setText("Error: Invalid data. Input reset.");
            largeMassField.setText("1");
            smallMassField.setText("1");
            distanceField.setText("1");
        }
        
        dataProcessor.updateData(mass, smallMass, distance);
            toggleSimulationButton.setText("Start Simulation");
            statisticsLabel.setText(dataProcessor.toString());
    }
}
