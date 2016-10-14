package orbitalsimulator.graphics;

import static java.lang.Math.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SmallPlanet extends Entity {
	private double centerX, centerY, radius, orbitalRadius, angle, angularVelocity;
	
	public SmallPlanet(double centerX, double centerY) {
		this.centerX = centerX;
		this.centerY = centerY;
		
		this.orbitalRadius = 150;
		this.radius = 7;
		this.angle = 0;
		this.angularVelocity = PI / 32;
	}

	@Override
	public void render(GraphicsContext gc) {
		gc.setFill(Color.CORNFLOWERBLUE);
		gc.fillOval(getX() - radius, getY() - radius, radius*2, radius*2);
	}

	@Override
	public void update(double delta) {
		angle += angularVelocity * delta;
		angle %= 2*PI;
		
		setX(centerX + orbitalRadius * cos(angle));
		setY(centerY + orbitalRadius * sin(angle));
	}
}
