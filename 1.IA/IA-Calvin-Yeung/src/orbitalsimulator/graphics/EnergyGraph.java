package orbitalsimulator.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.lang.Math;

public class EnergyGraph extends Entity {
	
	private final double G = 6.67e-11;
	private double mass, distance;
	
	public void init() {
		
	}
	
	@Override
	public void render(GraphicsContext gc) {
		gc.setStroke(Color.WHITE);
		gc.strokeLine(10, 10, 10, 320);
		gc.strokeLine(5, 165, 560, 165);
		
		mass = this.getContainer().getDataProcessor().getMass();
		distance = this.getContainer().getDataProcessor().getDistance();
		
		int step = 5;
		for(int i = 10; i < 550; i += step) {
			gc.setStroke(Color.CORNFLOWERBLUE);
			gc.strokeLine(i + 10, 165 - f1(mass, i), i + 10 + step, 165 - f1(mass, i+step));
			gc.setStroke(Color.PALEGOLDENROD);
			gc.strokeLine(i + 10, 165 - f2(mass, i), i + 10 + step, 165 - f2(mass, i+step));
		}
	}

	@Override
	public void update(double delta) {
		
	}
	
	private double f1(double m, double r) {
		double val = -Math.sqrt(G*m/(r*1.5e11))/ 100;
		return val;
	}
	
	private double f2(double m, double r) {
		double val = 0.5*Math.sqrt(G*m/(r*1.5e11))/ 100;
		return val;
	}
	
}
