package orbitalsimulator;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import orbitalsimulator.data.DataProcessor;

public class DataUpdateEventHandler implements EventHandler {
	
	private DataProcessor dataProcessor;
	private ChoiceBox<String> dropdown1, dropdown2;
	private TextField inputField1, inputField2;
	
	DataUpdateEventHandler(DataProcessor dataProcessor, ChoiceBox<String> dropdown1, ChoiceBox<String> dropdown2, TextField inputField1, TextField inputField2) {
		this.dataProcessor = dataProcessor;
		this.dropdown1 = dropdown1;
		this.dropdown2 = dropdown2;
		this.inputField1 = inputField1;
		this.inputField2 = inputField2;
	}

	@Override
	public void handle(Event event) {
		String selectedItem1 = dropdown1.getSelectionModel().getSelectedItem();
		String selectedItem2 = dropdown2.getSelectionModel().getSelectedItem();
		
		// validate later
		double value1 = Double.valueOf(inputField1.getText());
		double value2 = Double.valueOf(inputField2.getText());
		dataProcessor.updateData(selectedItem1, selectedItem2, value1, value2);
	}
}
