package practiceProblems;

import java.util.ArrayList;
import java.util.List;

//TODO: make Group implement Summer by returning the sum of each Person's age found in people
//for instance, if there were 3 Persons in people and their ages were 1,2,3, then we'd return 6
//you must do it without a lambda expression
public class Group implements Adder{
	private List<Person> people = new ArrayList<>();

	public Group(List<Person> p) {
		people = p;
	}
	
	@Override
	public int sum() {
		int totalAge = 0;
		for(Person p : people) {
			int current = p.getAge();
			totalAge += current;
		}return totalAge;
	}
	
	
}
