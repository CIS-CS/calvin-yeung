package orbitalsimulator.graphics;

import javafx.scene.canvas.Canvas;

public class GraphContainer extends GraphicsContainer {
	public GraphContainer(Canvas canvas) {
		super(canvas);
	}

	@Override
	public void init() {
		EnergyGraph eg = new EnergyGraph();
		addEntity(eg, 0, 0);
		eg.init();
	}
}
