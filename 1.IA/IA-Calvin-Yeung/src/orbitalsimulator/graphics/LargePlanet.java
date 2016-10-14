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
		gc.setFill(Color.GOLDENROD);
		gc.fillOval(getX() - radius, getY() - radius, radius*2, radius*2);
	}

	@Override
	public void update(double delta) {
		
	}
}
