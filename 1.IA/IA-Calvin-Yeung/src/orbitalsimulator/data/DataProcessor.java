package orbitalsimulator.data;

import static java.lang.Math.*;
import orbitalsimulator.graphics.World;

public class DataProcessor {
	final private double GRAV_CONST = 39.4336;
	
	private double mass, distance, period, velocity, angularVelocity, acceleration, force;
	private World world;
	
	public DataProcessor(World world) {
		this.world = world;
	}
	
	// updates data given two inputs
	public void updateData(double mass, double smallMass, double distance) {
		this.mass = mass;
		this.distance = distance;
		
		this.angularVelocity = sqrt(GRAV_CONST*getMass()/pow((getDistance()), 3));
		this.period = 2*PI / this.getAngularVelocity();
		this.velocity = this.getAngularVelocity() * this.getDistance();
		this.acceleration = this.getVelocity() * this.getAngularVelocity();
		this.force = this.getAcceleration() * smallMass * 3.002*10e-6;
		
		world.init();
	}

	public double getMass() {
		return mass;
	}

	public double getDistance() {
		return distance;
	}

	public double getPeriod() {
		return period;
	}

	public double getVelocity() {
		return velocity;
	}

	public double getAngularVelocity() {
		return angularVelocity;
	}

	public double getAcceleration() {
		return acceleration;
	}

	public double getForce() {
		return force;
	}
	
	public String toString() {
		return String.format(
				"Mass of center planet: %.2f×Msun\n" +
				"Distance to planet: %.2f AU\n" +
				"Orbital period: %.2f years\n" +
				"Speed: %.2f AU/year\n" +
				"Gravitational force: %.2f×10²² N",
				getMass(), getDistance(), getPeriod(), getVelocity(), getForce() * 2.99*10e2
		);
	}
}
