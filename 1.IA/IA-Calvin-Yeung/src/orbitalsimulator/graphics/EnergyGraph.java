package orbitalsimulator.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.lang.Math;

public class EnergyGraph extends Entity {
	
	private final double G = 39.4336;
	private final int Y_OFFSET = 165;
	private final int X_OFFSET = 10;
	private double mass, distance, xScale, yScale;
	
	public void init() {
		
	}
	
	@Override
	public void render(GraphicsContext gc) {
		
		mass = this.getContainer().getDataProcessor().getMass();
		distance = this.getContainer().getDataProcessor().getDistance();
		
		// calculate values
		xScale = 2.0*550/(5*distance);
		
		double r = distance * xScale;
		double pe = f1(mass, r);
		double ke = f2(mass, r);
		
		yScale = -2.0*330/(5*pe);
		
		// draw axis
		gc.setStroke(Color.WHITE);
		gc.strokeLine(10, 10, 10, 320);
		gc.strokeLine(5, 165, 560, 165);
		
		// draw curve
		int step = 5;
		for(int i = 5; i < 550; i += step) {
			gc.setStroke(Color.CORNFLOWERBLUE);
			gc.strokeLine(i + X_OFFSET, Y_OFFSET - f1(mass, i) * yScale, i + step + X_OFFSET, Y_OFFSET - f1(mass, (i+step)) * yScale);
			gc.setStroke(Color.PALEGOLDENROD);
			gc.strokeLine(i + X_OFFSET, Y_OFFSET - f2(mass, i) * yScale, i + step + X_OFFSET, Y_OFFSET - f2(mass, i+step) * yScale);
		}
		
		// draw indicator lines
		gc.setStroke(Color.GRAY);
		gc.strokeLine(r, Y_OFFSET - pe * yScale, r,  Y_OFFSET - ke * yScale);
		gc.strokeLine(X_OFFSET, Y_OFFSET - pe * yScale, r, Y_OFFSET - pe * yScale);
		gc.strokeLine(X_OFFSET, Y_OFFSET - ke * yScale, r, Y_OFFSET - ke * yScale);
		
		// draw labels
		gc.setFill(Color.WHITE);
		gc.fillText(String.format("%.2f AU", distance), r + 5, Y_OFFSET + 15);
		gc.fillText(String.format("PE = %.2f", pe), X_OFFSET + 5, Y_OFFSET - pe * yScale - 5);
		gc.fillText(String.format("KE = %.2f", ke), X_OFFSET + 5, Y_OFFSET - ke * yScale - 5);
		
		// TODO: Y_SCALE, Zoom feature
	}

	@Override
	public void update(double delta) {
		
	}
	
	private double f1(double m, double r) {
		r /= xScale;
		return -Math.sqrt(G*m/r);
	}
	
	private double f2(double m, double r) {
		return -f1(m, r) / 2;
	}
	
}
