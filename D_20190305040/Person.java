package D_20190305040;

public class Person implements PrisonInformation {
	private String name;
	private Integer id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void goToPrison() {
		System.out.println("goToPrison person");
		
	}
	public void sayYourName() {
		System.out.println("Person: sayYourName");
	}

}
