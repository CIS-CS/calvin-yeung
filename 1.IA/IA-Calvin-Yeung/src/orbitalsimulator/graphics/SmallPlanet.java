package orbitalsimulator.graphics;

import static java.lang.Math.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SmallPlanet extends Entity {
	private double centerX, centerY, radius, orbitalRadius, angle, angularVelocity;
	
	public SmallPlanet(double centerX, double centerY, double orbitalRadius, double angularVelocity) {
		this.centerX = centerX;
		this.centerY = centerY;
		
		this.orbitalRadius = orbitalRadius;
		this.angularVelocity = angularVelocity;
		this.radius = 7;
		this.angle = 0;
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
