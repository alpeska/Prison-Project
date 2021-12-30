package D_20190305040;

public class Warden extends Person {
	String grade_code;
	@Override
	public void goToPrison() {
		System.out.println("goToPrison:" + this.getName() + " is going to Prison");
		
	}
	public void sayYourName() {
		System.out.println( this.getName() + " is saying name");
	}

}
