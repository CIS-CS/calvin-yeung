package orbitalsimulator;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import orbitalsimulator.data.DataProcessor;

public class DataUpdateEventHandler implements EventHandler {
	
	private DataProcessor dataProcessor;
	private ChoiceBox<String> dropdown;
	private TextField inputField, largeMassField;
	
	DataUpdateEventHandler(DataProcessor dataProcessor, ChoiceBox<String> dropdown, TextField inputField, TextField largeMassField) {
		this.dataProcessor = dataProcessor;
		this.dropdown = dropdown;
		this.inputField = inputField;
		this.largeMassField = largeMassField;
	}

	@Override
	public void handle(Event event) {
		String selectedItem = dropdown.getSelectionModel().getSelectedItem();
		// validate later
		double value = Double.valueOf(inputField.getText());
		double mass = Double.valueOf(largeMassField.getText());
		dataProcessor.updateData(selectedItem, value, mass);
	}
}
