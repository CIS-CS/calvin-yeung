package orbitalsimulator.graphics;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GraphicsContainer extends AnimationTimer {
	private Canvas canvas;
	private GraphicsContext gc;
	private long previousTime;
	private ArrayList<Entity> activeEntities;
	private boolean isRunning;
	
	private double simulationSpeed;
	
	public GraphicsContainer(Canvas canvas) {
		this.activeEntities = new ArrayList<Entity>();
		this.canvas = canvas;
		this.previousTime = System.nanoTime();
		this.simulationSpeed = 1;
		this.isRunning = false;
		
		gc = canvas.getGraphicsContext2D();
	}
	
	@Override
	public void handle(long currentTime) {
		double delta = 0.17 * simulationSpeed;
		previousTime = currentTime;
		
		render(gc);
		if(isRunning)
			update(delta);
	}
	
	public void render(GraphicsContext gc) {
		clearScreen();
		
		for(int i = 0; i < activeEntities.size(); i++)
			activeEntities.get(i).render(gc);
	}
	
	public void update(double delta) {
		for(int i = 0; i < activeEntities.size(); i++)
			activeEntities.get(i).update(delta);
	}
	
	public void addEntity(Entity e, double x, double y) {
		activeEntities.add(e);
		
		e.setContainer(this);
		e.setX(x);
		e.setY(y);
	}
	
	public void removeEntity(Entity e) {
		activeEntities.remove(e);
		e.setContainer(null);
	}
	
	public void removeAllEntities() {
		for(int i = activeEntities.size()-1; i > 0; i--)
			activeEntities.get(i).setContainer(null);
		activeEntities.clear();
	}
	
	public void clearScreen() {
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, getWidth(), getHeight());
	}
	
	public double getWidth() {
		return canvas.getWidth();
	}
	
	public double getHeight() {
		return canvas.getHeight();
	}
	
	public boolean isRunning() {
		return this.isRunning;
	}
	
	public void setSimulationSpeed(double simulationSpeed) {
		this.simulationSpeed = simulationSpeed;
	}
	
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
}
