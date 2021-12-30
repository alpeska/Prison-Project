package D_20190305040;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class main {

	public static void main(String[] args) {

		Map<Integer, Object> wardenMap = new HashMap<Integer, Object>();
		System.out.println("⛧⛧⛧⛧⛧PLEASE ENTER 3 WARDEN⛧⛧⛧⛧⛧");
		System.out.println("⛧⛧⛧⛧⛧ADDING WARDEN LIST⛧⛧⛧⛧⛧");
		for (int i = 3; i > 0; i--) {

			Warden temp_warden = insert_Warden(i);
			wardenMap.put(i, temp_warden);

		}

		// generic collection - LIST 2
		ArrayList<Object> person_list = new ArrayList<Object>();
		System.out.println("⛧⛧⛧⛧⛧PLEASE ENTER 3 INMATE⛧⛧⛧⛧⛧");
		System.out.println("⛧⛧⛧⛧⛧ADDING INMATE LIST⛧⛧⛧⛧⛧");
		for (int i = 1; i <= 3; i++) {

			Inmate temp_warden = insert_Inmate(i);
			person_list.add(temp_warden);

		}

		// generic collection - LIST 1

		ArrayList<GenericsCrimeClass<?>> course_list = new ArrayList<GenericsCrimeClass<?>>();
		System.out.println("⛧⛧⛧⛧⛧PLEASE ENTER 3 Entered Inmate Date⛧⛧⛧⛧⛧");
		System.out.println("⛧⛧⛧⛧⛧ADDING Penalty LIST⛧⛧⛧⛧⛧");

		for (int i = 1; i <= 3; i++) {
			Scanner myObj = new Scanner(System.in);
			System.out.println("Enter Penalty Time (day) for : " + i);

			String WardenName = myObj.nextLine();
			course_list.add(insert_Course(WardenName));

		}

		System.out.println("⛧⛧⛧⛧⛧ADDED DEFAULT Penalty⛧⛧⛧⛧⛧");
		course_list.add(insert_Course(0));

		// polymorphism
		System.out.println("⛧⛧⛧⛧⛧polymorphism ⛧⛧⛧⛧⛧");
		((Warden) wardenMap.get(1)).goToPrison();
		((Warden) wardenMap.get(2)).goToPrison();
		((Warden) wardenMap.get(3)).goToPrison();
		// polymorphism
		((Inmate) person_list.get(0)).goToPrison();
		((Inmate) person_list.get(1)).goToPrison();
		((Inmate) person_list.get(2)).goToPrison();

		((Warden) wardenMap.get(1)).sayYourName();
		((Warden) wardenMap.get(2)).sayYourName();
		((Warden) wardenMap.get(3)).sayYourName();
		((Inmate) person_list.get(0)).sayYourName();
		((Inmate) person_list.get(1)).sayYourName();
		((Inmate) person_list.get(2)).sayYourName();

		System.out.println("⛧⛧⛧⛧⛧LISTING-> INMATE LIST⛧⛧⛧⛧⛧");
		// using lambda
		wardenMap.forEach((k, v) -> System.out.println((k + " : " +((Warden) v).getName() +" --> "+ ((Warden) v).grade_code)));

		System.out.println("⛧⛧⛧⛧⛧LISTING-> WARDEN LIST⛧⛧⛧⛧⛧");
		// using lambda
		person_list.forEach(person -> System.out.println(((Inmate) person).getName() +" --> " + ((Inmate) person).department_name));

		System.out.println("⛧⛧⛧⛧⛧LISTING-> Penalty (day) LIST⛧⛧⛧⛧⛧");
		// using lambda
		course_list.forEach(course -> System.out.println(course.getCrime_code()));

		System.out.println("⛧⛧⛧⛧⛧Generics Set Warden and Inmate⛧⛧⛧⛧⛧");
		// generic collection - Set 1
		Set<Person> personSet = new HashSet<Person>();
		personSet.add(((Warden) wardenMap.get(1)));
		personSet.add(((Inmate) person_list.get(1)));

		// using lambda
		System.out.println("⛧⛧⛧⛧⛧using lambda on SET collection⛧⛧⛧⛧⛧");
		personSet.forEach(person -> System.out.println(person.getName()));

		System.out.println("⛧⛧⛧⛧⛧list update value with using lambda on inmateMap⛧⛧⛧⛧⛧");

		wardenMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEachOrdered(x -> System.out.println(((((Warden) x.getValue()).grade_code + " updated"))));

		System.out.println("⛧⛧⛧⛧⛧LISTING-> Inmate LIST after updating⛧⛧⛧⛧⛧");
		// using lambda
		wardenMap.forEach((k, v) -> System.out.println((k + " : "  + ((Warden) v).getName()) +" --> " + ((Warden) v).grade_code));
	}

	public static Warden insert_Warden(int id) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("FOR Inmate  : " + id);
		System.out.println("Enter Inmate Name : ");

		String WardenName = myObj.nextLine();

		System.out.println("Enter Inmate crime : ");

		String grade_code = myObj.nextLine();

		Warden warden = new Warden();

		warden.setName(WardenName);
		warden.grade_code = grade_code;
		warden.setId(id);

		return warden;

	}

	public static Inmate insert_Inmate(int id) {
		Scanner myObj = new Scanner(System.in);
		System.out.println("FOR Warden  : " + id);
		System.out.println("Enter Warden Name : ");

		String TeacherName = myObj.nextLine();

		System.out.println("Enter Warden department : ");

		String department_name = myObj.nextLine();

		Inmate inmate = new Inmate();

		inmate.setName(TeacherName);
		inmate.department_name = department_name;
		inmate.setId(id);

		return inmate;

	}

	public static GenericsCrimeClass<?> insert_Course(Object o) {
		GenericsCrimeClass<?> new_crime = null;
		if (o.getClass().getSimpleName().equals("String")) {
			new_crime = new GenericsCrimeClass<>((String) o);

		} else if (o.getClass().getSimpleName().equals("Integer")) {
			new_crime = new GenericsCrimeClass<>((Integer) o);

		}

		return new_crime;

	}

}
