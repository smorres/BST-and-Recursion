package practiceProblems;
import static practiceProblems.Recursion.powerSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
	public static void main(String[] args) {
		/*System.out.println("-----------------Question 1--------------------------\n");
		System.out.println("powerset(0) has size " + powerSet(0).size() + ": \n\t" + powerSet(0));
		System.out.println("powerset(1) has size " + powerSet(1).size() + ": \n\t" +powerSet(1));
		System.out.println("powerset(2) has size " + powerSet(2).size() + ": \n\t"+powerSet(2));
		System.out.println("powerset(3) has size " + powerSet(3).size() + ": \n\t"+powerSet(3));
		System.out.println("powerset(4) has size " + powerSet(4).size() + ": \n\t"+powerSet(4));

		
		
		System.out.println("\n\n-----------------Question 2--------------------------");
		Person p1 = new Person("Tyler", "Brown", 18, "basketball");
		Person p2 = new Person("Jared", "Graham", 19, "soccer");
		Person p3 = new Person("Anna", "Smith", 22, "basketball");
		Person p4 = new Person("Jeff", "Graham", 21, "hockey");
		Person p5 = new Person("Jared", "Perry", 18, "baseball");
		Person p6 = new Person("Tyler", "Smith", 17, "soccer");
		Person p7 = new Person("Tyler", "Poe", 21, "hockey");
		Person p8 = new Person("Anna", "Perry", 18, "hockey");
		Person p9 = new Person("Anna", "Poe", 19, "soccer");
		Person p10 = new Person("Rachel", "Brown", 19, "basketball");
		Person p11 = new Person("Jared", "Smith", 20, "baseball");
		
		
		Group group = new Group(new ArrayList<Person>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11)));
		
		System.out.println("Group sum: " + group.sum());
		
		
		CharCounter simple = new CharCounter(new ArrayList<String>(Arrays.asList(
				"1234567890", "123456", "12345")));
		System.out.println("simple charCounter sum: " + simple.sum());
		
		CharCounter charcount = new CharCounter(new ArrayList<String>(Arrays.asList(
				"Once upon a midnight dreary, while I pondered, weak and weary,\n",
				"Over many a quaint and curious volume of forgotten lore—\n",
				"While I nodded, nearly napping, suddenly there came a tapping,\n",
				"As of some one gently rapping, rapping at my chamber door.\n",
				"“’Tis some visitor,” I muttered, “tapping at my chamber door—\n",
				"Only this and nothing more.”\n"
				)));
			
		System.out.println("charCounter sum for first verse of The Raven, by Edgar Allen Poe: " + charcount.sum());
		
		System.out.println("\n\n-----------------Question 3--------------------------");
		Game game1 = new BoardGame("Chess", 2, false, 6, "checkmate the enemy king", 32, 64);
		Game game2 = new Game("Pandemic", 4, true, 8, "find the cure to four diseases");
		System.out.println(game1);
		System.out.println(game1.isFun());
		System.out.println(game2);
		System.out.println(game2.isFun());*/
		System.out.println("\n\n-----------------Question 4--------------------------");
		System.out.println("Use Subclass to add list");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(Reduction.reduce(new addition(), list, 0));
		System.out.println("using Lambda expression, multiply list");
		System.out.println(Reduction.reduce((a,b)-> a*b,list,1));
		
	}
}
