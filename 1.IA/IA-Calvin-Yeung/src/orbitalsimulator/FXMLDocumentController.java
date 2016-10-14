/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orbitalsimulator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import orbitalsimulator.graphics.GraphicsContainer;
import orbitalsimulator.graphics.World;

/**
 *
 * @author Zephyr
 */
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
	
	private World simulatorContainer;
	private GraphicsContainer graphContainer;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
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
	
}
