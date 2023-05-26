public class Fan {
	final int SLOW = 1;
	final int MEDIUM = 2;
	final int FAST = 3;
	private int speed = 0;
	private boolean on = false;
	private double radius = 0;
	String color = "";

	//constructor
	public Fan() {
		this.speed = SLOW;
		this.on = false;
		this.radius = 5;
		this.color = "blue";
	}	

	//accessors and mutators	
	public void setSpeed(int value) {
		this.speed = value;				
	}
	public String getSpeed() {
		String spin = "";
		//switch statement for converting from int to String for user-readability
		switch (this.speed) {
			case SLOW: 
				spin =  "SLOW";
				break;
			case MEDIUM: 
				spin =  "MEDIUM";
				break;
			case FAST: 
				spin =  "FAST";
				break;
		}
		return spin;
	}

	public void turnOn() {
		this.on = true;
	}
	public void turnOff() {
		this.on = false;
	}
	public boolean isOn() {
		return this.on;
	}

	public void setRadius(double value) {
		this.radius = value;
	}
	public double getRadius() {
		return this.radius;
	}

	public void setColor(String value) {
		this.color = value;
	}
	public String getColor() {
		return this.color;
	}

	//return a description of the fan
	//If the fan is on, the method returns the fan speed, color, and radius in one combined string.
	//If the fan is not on, the method returns the fan color and radius along with the string “fan is off” in one combined string
	public String toString() {
		if (this.on) 
			return String.format("Properties-\nSpeed: %s\nColor: %s\nRadius: %.2f", 
						    this.getSpeed(), this.color, this.radius);
			return String.format("Properties-\nColor: %s\nRadius: %.2f\nfan is off", 
					    this.color, this.radius);
	}
}
