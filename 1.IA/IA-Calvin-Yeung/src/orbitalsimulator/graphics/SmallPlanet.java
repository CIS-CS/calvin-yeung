package orbitalsimulator.graphics;

import static java.lang.Math.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SmallPlanet extends Entity {
	private final double RADIUS = 7;
	private double centerX, centerY, orbitalRadius, angle, angularVelocity;
	
	public SmallPlanet(double centerX, double centerY, double orbitalRadius, double angularVelocity) {
		this.centerX = centerX;
		this.centerY = centerY;
		
		this.orbitalRadius = orbitalRadius;
		this.angularVelocity = angularVelocity;
		this.angle = 0;
	}

	@Override
	public void render(GraphicsContext gc) {
		double r = RADIUS * getContainer().getZoom();
		
		// draw orbital path
		gc.setStroke(Color.LIGHTGREY);
		gc.strokeOval(centerX - orbitalRadius, centerY - orbitalRadius, orbitalRadius*2, orbitalRadius*2);
		
		// draw planet
		gc.setFill(Color.CORNFLOWERBLUE);
		gc.fillOval(getX() - r, getY() - r, r*2, r*2);
	}

	@Override
	public void update(double delta) {
		angle += angularVelocity * delta;
		angle %= 2*PI;
		
		setX(centerX + orbitalRadius * cos(angle));
		setY(centerY + orbitalRadius * sin(angle));
	}
}
