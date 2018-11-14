package practiceProblems;

import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//review lab08 and lab09 from scratch to brush up on recursion
public class Recursion {
	// TODO: first we will implement the Comparator sorter using a lambda
	// expression.
	// note that it sorts Lists of Integers.
	// if one of the list's has a smaller size than the other, then we consider the
	// bigger list greater
	// for instance, [5] would be considered smaller than [1,4] since the 2nd list
	// has size 2 while the first has size 1
	// otherwise, if both lists are the same size, then we compare element wise.
	// the list which has the smaller element at the first position they differ at
	// is considered smaller than the other
	// for instance, [1,2,3] should be considered smaller than [1,2,5] since 3 < 5
	// if you are comparing two indentical lists, (same size and same integers) then
	// throw a new IllegalArgumentException,
	// explaining we are comparing two identical lists
	// the only reason we do this is to ensure the powerSet method does not contain
	// duplicate lists in it.
	// this is not considered conventional behavior for a Comparator!
	private static Comparator<List<Integer>> sorter = (list1, list2) -> {
		if (list1 != null && list2 != null) {
			if (list1.size() < list2.size()) {
				return -1;
			} else if (list1.size() > list2.size()) {
				return 1;
			} else {
				for (int i = 0; i < list1.size(); i++) {
					if (list1.get(i) < list2.get(i)) {
						return -1;
					} else if (list1.get(i) > list2.get(i)) {

						return 1;
					}

				}
				throw new IllegalArgumentException("Lists are identical");
			}

		}
		return 0;
	};

	// TODO: now, the real question. We want to generate a powerSet of all numbers,
	// 1 through n.
	// for instance, the power set for n = 0 should be
	// [[]] just a set containing the empty set (note the size of the power set is
	// 1)
	// the power set for n = 1 should be
	// [[], [1]], the set containing the empty set and the singleton set containing
	// 1 (note the size of the power set is 2)
	// as a last example, for n = 2, the powerSet should be
	// [[], [1], [2], [1,2]], the set containing the empty set, both singleton sets,
	// and the set [1,2] (note the size of the power set is 4)

	// notice that given a value for n, the power set contains 2^n sets.
	// why? well, for each element, you have 2 choices, either to include the
	// element in a set, or not include it in the set.
	// this insight is the key to thinking recursively about this problem.

	// first, handle some cases.
	// if n < 0, throw a new IllegalArgumentException explaining n must be
	// non-negative
	// next, we handle the base case.
	// start by making a List<List<Integer>> retVal initialized to an empty
	// ArrayList
	// if n == 0, then we add an empty ArrayList of Integers to retVal and return
	// retVal

	// otherwise, we recursively generate the powerSet of 1 through n-1
	// using this smaller generated powerSet, for each set in it, we add the set,
	// but also the set with n appended to it at the end
	// note: you will need to make a deepCopy of each set in the smaller powerset
	// before appending n to the end of the deepCopy
	// you may use a for loop to create the deepCopies that you need to append
	// for instance, if the smaller generated powerSet were [[], [1]] then we would
	// append
	// [], [] + 2 = [2], [1], [1] + 2 = [1,2] to our retVal
	// for(List<Integer> list : retVal){
	// List<integer> current = new List<>();
	// current.add( list + n );
	// retVal.add(current);

	// TODO: finally, before returning the retVal, we want to sort retVal using the
	// comparator we made above
	// recall we can do this by calling retVal.sort(sorter);
	public static List<List<Integer>> powerSet(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n must be non-negative");
		}
		List<List<Integer>> retVal = new ArrayList<>();
		List<List<Integer>> subList = new ArrayList<>();

		if (n == 0) {
			List<Integer> empty = new ArrayList<>();
			retVal.add(empty);
			return retVal;
		}
		subList = powerSet(n - 1);
		retVal.addAll(subList);
		// retval has all numbers up to n in it
		// need the combo of all numbers in n, without repeating
		for (List<Integer> list : subList) {
			List<Integer> deepCopy = new ArrayList<>();
			for (Integer i : list)
				deepCopy.add(i); // now you have a copy of the list
			deepCopy.add(n);
			retVal.add(deepCopy);
		}
		retVal.sort(sorter);
		return retVal;

		/*
		 * if(n==0) { ArrayList addition = new ArrayList<Integer>();
		 * retVal.add(addition); System.out.println("this is retval: "+retVal); return
		 * retVal; } else { ArrayList appended = new ArrayList<Integer>(); for(int i =
		 * 0; i<retVal.size();i++) { appended.add(retVal.get(i)); }
		 * appended.add(powerSet(n-1)); System.out.println(appended);
		 * retVal.append(appended); retVal.sort(sorter);
		 * 
		 * return retVal; }
		 */
	}
}
