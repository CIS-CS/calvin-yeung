public class Heater {
    private double temperature, min, max, increment;
    
    public Heater(double min, double max) {
        this.min = min;
        this.max = max;
        
        temperature = 15f;
        increment = 5f;
    }
    
    public boolean setIncrement(double inc) {
        if(inc > 0) {
            increment = inc;
            return true;
        }
        
        return false;
    }
    
    public void warmer() {
        temperature += increment;
        
        if(temperature > max)
            temperature = max;
    }
    
    public void cooler() {
        temperature -= increment;
        
        if(temperature < min)
            temperature = min;
    }
    
    public double getTemperature() {
        return temperature;
    }
}
