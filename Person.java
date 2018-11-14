package practiceProblems;

public class Person {
	private String firstName;
	private String lastName;
	private int age;
	private String hobby;
	
	public Person(String first, String last, int a, String h) {
		firstName = first;
		lastName = last;
		age = a;
		hobby = h;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getHobby() {
		return hobby;
	}
	
	public String toString() {
		return String.format("%s %s: age %d, enjoys %s", firstName, lastName, age, hobby);
	}
}
