package practiceProblems;

import java.util.List;

public class Reduction{
	//This is important
	public static int reduce(BinaryOperation op, List<Integer> list, int startVal) {
		int retVal = startVal;
		for(Integer i : list) {
			retVal = op.Operator(retVal, i); //this is crucial
		}return retVal;
	}
}
