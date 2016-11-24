package orbitalsimulator.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class EnergyGraph extends Entity {
	
	private double mass, distance;
	
	public void init() {
		mass = this.getContainer().getDataProcessor().getMass();
		distance = this.getContainer().getDataProcessor().getDistance();
	}
	
	@Override
	public void render(GraphicsContext gc) {
		gc.setStroke(Color.WHITE);
		gc.strokeLine(10, 10, 10, 320);
		gc.strokeLine(5, 165, 560, 165);
		
		for(int i = 10; i < 550; i += 10)
			gc.strokeLine(i + 10, 165 - f(i), i + 20, 165 - f(i+10));
	}

	@Override
	public void update(double delta) {
		
	}
	
	private double f(int i) {
		return i * i * 0.001;
	}
	
}
