import java.util.Scanner;
public class Exercise908 {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		boolean fan1Exists = false;
		boolean fan2Exists = false;
		String fan1Description = "";
		String fan2Description = "";
		//give users the choice to create the fans or not
		System.out.print("Would you like to create new fan?(yes/no) ");
		//making sure the user inputted either at least y or n
		while(true) {
			String affirm = scanner.nextLine().substring(0, 1).toLowerCase();
			if (!affirm.equals("n") && !affirm.equals("y")) {
				System.out.print("Invalid input. Please enter yes(y) or no(n): ");
			}
			if (affirm.equals("n"))
				break;
			if (affirm.equals("y")) {
				Fan fan1 = new Fan();
				//offloading code for user config to separate methods
				configureFan(fan1);
				//booleans and strings to display at the end in case fan is created
				fan1Exists = true;	
				fan1Description = "Fan 1 " + fan1.toString();
				break;
			}		
		}
		System.out.print("\nWould you like to create another fan?(yes/no) ");
		while(true) {
			String affirm = scanner.nextLine().substring(0, 1).toLowerCase();
			if (!affirm.equals("n") && !affirm.equals("y")) {
				System.out.print("Invalid input. Please enter yes(y) or no(n): ");
			}
			if (affirm.equals("n"))
				break;
			if (affirm.equals("y")) {
				Fan fan2 = new Fan();
				configureFan(fan2);
				fan2Exists = true;
				fan2Description = "Fan 2 " + fan2.toString();
				break;
			}		
		}
		if (fan1Exists)
		System.out.println("\n" + fan1Description);
		if (fan2Exists)
		System.out.println("\n" + fan2Description);
		scanner.close();
	}
	public static void configureFan(Fan fan) {
		//each configuration has its own method
		configurePower(fan);
		configureSpeed(fan);
		configureRadius(fan);
		configureColor(fan);
	}	
	public static void configurePower(Fan fan) {
		System.out.print("Turn the fan on?(yes/no) ");
		while (true) {
			String power = scanner.nextLine().substring(0, 1).toLowerCase();
			if (!power.equals("n") && !power.equals("y"))
				System.out.print("Invalid input. Please enter yes(y) or no(n): ");
			if (power.equals("n")) {
				fan.turnOff();
				break;
			}
			if (power.equals("y")) {
				fan.turnOn();
				break;
			}
		}
	}
	public static void configureSpeed(Fan fan) {
		System.out.print("Set fan speed(SLOW, MEDIUM, or FAST): ");
		while (true) {
			String fanSpeed = scanner.nextLine().toUpperCase();
			if (fanSpeed.equals("SLOW")) {
				fan.setSpeed(1);
				break;
			}
			if (fanSpeed.equals("MEDIUM")) {
				fan.setSpeed(2);
				break;
			}
			if (fanSpeed.equals("FAST")) {
				fan.setSpeed(3);
				break;
			}
			System.out.print("Please enter a valid speed(SLOW, MEDIUM, FAST): ");
		}
	
	}
	public static void configureRadius(Fan fan) {
		double dubRadius = 0.0;
		boolean validDubRadius = false;
		System.out.print("Set fan radius(enter a numeral): ");
		//using try catch instead of 'hasNext' to minimize problems with scanner
		//this way i can use 'nextLine' for all input
		while (!validDubRadius) {
			String radius = scanner.nextLine();
			try {
				dubRadius = Double.parseDouble(radius);
				fan.setRadius(dubRadius);
				validDubRadius = true;
			}
			catch (NumberFormatException nfe) {
				System.out.print("Please enter a numeral: ");
			}
		} 
	}
	public static void configureColor(Fan fan) {
		System.out.print("Set fan color: ");
		String fanColor = scanner.nextLine();
		fan.setColor(fanColor);
	}
}

