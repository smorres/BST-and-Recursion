package practiceProblems;

import java.util.ArrayList;
import java.util.List;

//TODO: make CharCounter implement Summer by returning the sum of each String's length found in list
//for instance, if the Strings "a", "bat", "cat" were in list, we'd return 7
//you must do it without a lambda expression
public class CharCounter implements Adder{
	List<String> list = new ArrayList<>();
	
	public CharCounter(List<String> lst) {
		list = lst;
	}
	
	@Override
	public int sum() {
		int stringLength = 0;
		for(String s : list) {
			int current = s.length();
			stringLength += current;
		}
		return stringLength;
	}
}
