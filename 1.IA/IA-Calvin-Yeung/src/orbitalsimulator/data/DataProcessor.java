package orbitalsimulator.data;

import static java.lang.Math.*;
import orbitalsimulator.graphics.World;

public class DataProcessor {
	final private double GRAV_CONST = 6.67408e-11;
	final private double MASS_OF_SUN = 2*10e30;
	final private double ASTRO_UNIT = 1.5e12;
	
	private double mass, distance, period, velocity, angularVelocity, acceleration, force;
	private World world;
	
	public DataProcessor(World world) {
		this.world = world;
	}
	
	// updates data given two inputs
	public void updateData(double m, double distance) {
		this.mass = m * MASS_OF_SUN;
		this.distance = distance * ASTRO_UNIT;
		
		this.angularVelocity = sqrt(GRAV_CONST*mass/pow((getDistance()), 3));
		this.period = 2*PI / this.getAngularVelocity();
		this.velocity = this.getAngularVelocity() * this.getDistance();
		this.acceleration = this.getVelocity() * this.getAngularVelocity();
		this.force = this.getAcceleration() * this.getMass();
		
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
				"Mass of center planet: %.2f kg\n" +
				"Distance to planet: %.2f m\n" +
				"Orbital period: %.2f s\n",
				getMass(), getDistance(), getPeriod()
		);
	}
}
