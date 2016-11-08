package orbitalsimulator.data;

import static java.lang.Math.*;
import orbitalsimulator.graphics.World;

public class DataProcessor {
	final private double G = 6.67408e-11;
	private World world;
	private double mass, distance, period, velocity, angularVelocity, acceleration, force;
	
	public DataProcessor(World world) {
		this.world = world;
	}
	
	public void updateData(String selectedItem, double value, double mass) {
		this.mass = mass;
		
		if(selectedItem.equals("Distance")) {
			this.distance = value;
			this.angularVelocity = sqrt(G*mass/pow(getDistance(), 3));
		}
		
		if(selectedItem.equals("Velocity")) {
			this.distance = G*mass/pow(value, 2);
			this.angularVelocity = sqrt(G*mass/pow(getDistance(), 3));
		}
		
		if(selectedItem.equals("Period")) {
			this.angularVelocity = 2*PI/value;
			this.distance = pow(G*mass/pow(getAngularVelocity(), 2), 1.0/3);
		}
		
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
}
