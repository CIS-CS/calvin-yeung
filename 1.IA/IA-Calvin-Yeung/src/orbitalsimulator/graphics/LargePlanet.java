package orbitalsimulator.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class LargePlanet extends Entity {
	private double mass;
	private double radius;
	
	public LargePlanet() {
		this.radius = 25;
	}

	@Override
	public void render(GraphicsContext gc) {
		double r = radius * getContainer().getZoom();
		gc.setFill(Color.GOLDENROD);
		gc.fillOval(getX() - r, getY() - r, r*2, r*2);
	}

	@Override
	public void update(double delta) {
		
	}
}
