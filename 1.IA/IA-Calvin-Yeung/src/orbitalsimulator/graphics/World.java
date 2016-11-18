package orbitalsimulator.graphics;

import javafx.scene.canvas.Canvas;
import orbitalsimulator.data.DataProcessor;

public class World extends GraphicsContainer {
	final private double X_MID = getWidth() / 2;
	final private double Y_MID = getHeight() / 2;
	
	private LargePlanet largePlanet;
	private SmallPlanet smallPlanet;
	private DataProcessor dataProcessor;
	
	public World(Canvas canvas) {
		super(canvas);
	}
	
	public void init() {
		removeAllEntities();
		
		largePlanet = new LargePlanet();
		smallPlanet = new SmallPlanet(X_MID, Y_MID, dataProcessor.getDistance(), dataProcessor.getAngularVelocity());
		
		addEntity(largePlanet, X_MID, Y_MID);
		addEntity(smallPlanet, X_MID + dataProcessor.getDistance(), Y_MID);
	}
	
	public void setDataProcessor(DataProcessor dp) {
		this.dataProcessor = dp;
	}
}
