package D_20190305040;
//inheritance
public class Inmate extends Person {
	String department_name;
	@Override
	public void goToPrison() {
		System.out.println("goToPrison:" + this.getName() + " is going to prison");
		
	}
	public void sayYourName() {
		System.out.println(this.getName() + " is saying name");
	}
	

}
