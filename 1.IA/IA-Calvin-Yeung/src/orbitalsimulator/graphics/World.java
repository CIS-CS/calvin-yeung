package orbitalsimulator.graphics;

import javafx.scene.canvas.Canvas;
import orbitalsimulator.data.DataProcessor;

public class World extends GraphicsContainer {
	final private double X_MID = getWidth() / 2;
	final private double Y_MID = getHeight() / 2;
	
	private LargePlanet largePlanet;
	private SmallPlanet smallPlanet;
	
	public World(Canvas canvas) {
		super(canvas);
	}
	
	public void init() {
		removeAllEntities();
		
		double dist = getDataProcessor().getDistance() * 150 * getZoom();
		largePlanet = new LargePlanet();
		smallPlanet = new SmallPlanet(X_MID, Y_MID, dist, getDataProcessor().getAngularVelocity());
		
		addEntity(largePlanet, X_MID, Y_MID);
		addEntity(smallPlanet, X_MID + dist, Y_MID);
		this.setRunning(false);
	}
}
