package orbitalsimulator.graphics;

import javafx.scene.canvas.Canvas;

public class World extends GraphicsContainer {
	final private double X_MID = getWidth() / 2;
	final private double Y_MID = getHeight() / 2;
	
	private LargePlanet largePlanet;
	private SmallPlanet smallPlanet;
	
	public World(Canvas canvas) {
		super(canvas);
		
		double orbitalRadius = 150;
		largePlanet = new LargePlanet();
		smallPlanet = new SmallPlanet(X_MID, Y_MID);
		
		addEntity(largePlanet, X_MID, Y_MID);
		addEntity(smallPlanet, X_MID + orbitalRadius, Y_MID);
	}
}
