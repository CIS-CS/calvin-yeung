package orbitalsimulator.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.lang.Math;

public class EnergyGraph extends Entity {
	
	private final double G = 39.4336;
	private final int Y_OFFSET = 165;
	private final int X_OFFSET = 10;
	private double mass, distance, xScale;
	
	public void init() {
		
	}
	
	@Override
	public void render(GraphicsContext gc) {
		gc.setStroke(Color.WHITE);
		gc.strokeLine(10, 10, 10, 320);
		gc.strokeLine(5, 165, 560, 165);
		
		mass = this.getContainer().getDataProcessor().getMass();
		distance = this.getContainer().getDataProcessor().getDistance();
		xScale = 2.0*550/(5*distance);
		
		int step = 5;
		for(int i = 5; i < 550; i += step) {
			gc.setStroke(Color.CORNFLOWERBLUE);
			gc.strokeLine(i + X_OFFSET, Y_OFFSET - f1(mass, i), i + step + X_OFFSET, Y_OFFSET - f1(mass, (i+step)));
			gc.setStroke(Color.PALEGOLDENROD);
			gc.strokeLine(i + X_OFFSET, Y_OFFSET - f2(mass, i), i + step + X_OFFSET, Y_OFFSET - f2(mass, i+step));
		}
		
		double r = distance * xScale;
		gc.setStroke(Color.GRAY);
		gc.strokeLine(r, Y_OFFSET - f1(mass, r), r,  Y_OFFSET - f2(mass, r));
		gc.strokeLine(X_OFFSET, Y_OFFSET - f1(mass, r), r, Y_OFFSET - f1(mass, r));
		gc.strokeLine(X_OFFSET, Y_OFFSET - f2(mass, r), r, Y_OFFSET - f2(mass, r));
	}

	@Override
	public void update(double delta) {
		
	}
	
	private double f1(double m, double r) {
		r /= xScale;
		double val = -Math.sqrt(G*m/r) * 10;
		return val;
	}
	
	private double f2(double m, double r) {
		return -f1(m, r) / 2;
	}
	
}
