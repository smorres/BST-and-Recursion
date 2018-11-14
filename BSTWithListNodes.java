package practiceProblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BSTWithListNodes {
	private Comparator<List<Integer>> comparator;
	private List<Integer> data;
	private BSTWithListNodes left;
	private BSTWithListNodes right;

	public BSTWithListNodes(List<Integer> ch) {
		data = ch;
	}
	public BSTWithListNodes(Comparator<List<Integer>> comp) {
		this.comparator = comp;
	}

	public BSTWithListNodes(Comparator<List<Integer>> comp, List<Integer> data) {
		this.comparator = comp;
		this.data = data;
	}

	/*
	 * public void insert(int element){ if(data == element) return; else if(data >
	 * element) { if(left == null) left = new IntegerBST(element); else
	 * left.insert(element); } else{ if(right == null) right = new
	 * IntegerBST(element); else right.insert(element); } }
	 */
	public int compare(int a, int b) {
		
			if (a < b) {
				return -1;
			}
			if (a > b) {
				return 1;
			}
			if (a == b)
				return 0;
		
		throw new IllegalArgumentException("one of lists is null");
	}

	public void insert(List<Integer> element) {
		/*
		 * the reason this doesnt work is because it inserts each element multiple times
		 * per round, must add a comparator that decides when it gets inserted. eg
		 * comparing first element in list or sum of list elements
		 */

		if (comparator.compare(data, element) == 0) {
			return;
		}
		if (comparator.compare(data, element) > 0) {
			if (left == null) {
				left = new BSTWithListNodes(element);
			} else {
				left.insert(element);
				return;
			}
		}
		if (comparator.compare(data, element) < 0) {
			if (right == null) {
				right = new BSTWithListNodes(element);
			} else {
				right.insert(element);
				return;
			}
		}
	}

	public void prettyPrint() {
		prettyPrint(0);
	}

	private void prettyPrint(int indentLevel) {
		if (left != null)
			left.prettyPrint(indentLevel + 1);
		for (int i = 0; i < indentLevel; i++)
			System.out.print("  ");
		System.out.println(data);
		if (right != null)
			right.prettyPrint(indentLevel + 1);
	}

	// TODO: returns the word formed by doing an in order traversal
	// we build the returned string by adding each char in the BST
	// when you are done, make sure the main works

	public String extractWord() {
		String retVal = "";
		if (left != null) {

			retVal = retVal + left.extractWord();
			/*
			 * was doing retval = left.data; this does nothing should have been this
			 */
		}
		retVal = retVal + data;

		if (right != null) {
			retVal = retVal + right.extractWord();
		}
		return retVal;

	}

	// TODO: returns 2^n
	// if n is negative, throw an IllegalArgumentException saying "bad input"
	// the base case occurs if n is 0, in which case we return 1
	// otherwise we use the recursive relation: 2^n = 2^(n-1)*2
	// note this has nothing to do with BSTs, just put here for the sake of
	// convenience
	public static int powerOf2(int n) {
		return powerHelper(n, 0);
	}

	public static int powerOfTwo(int n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			throw new IllegalArgumentException("cant be negative");
		} else {
			return 2 * powerOfTwo(n - 1);
		}
	}

	private static int powerHelper(int n, int indent) {
		int retVal = 1;
		if (n < 0) {
			throw new IllegalArgumentException("cant be negative");
		}
		for (int i = 0; i < indent; i++)
			System.out.print("\t");
		System.out.println("Call to 2^" + n);
		if (n != 0) {
			for (int i = 0; i < indent; i++)
				System.out.print("\t");
			System.out.println("recursively calculating 2 times 2^(" + (n - 1) + ")");
			retVal = (2 * powerHelper(n - 1, indent + 1));
		} else {
			for (int i = 0; i < indent; i++)
				System.out.print("\t");
			System.out.println("returning base case. 2^0 = 1");
			retVal = 1;
		}
		for (int i = 0; i < indent; i++)
			System.out.print("\t");
		System.out.println("returning " + retVal);
		return retVal;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(4);

		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(5);
		list3.add(6);

		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(7);
		list4.add(8);

		List<Integer> list5 = new ArrayList<Integer>();
		list5.add(9);
		list5.add(10);

		Comparator<List<Integer>> intComp = (i, j) ->i.get(0) - j.get(0); // lambda expression
		
		BSTWithListNodes tree = new BSTWithListNodes(intComp);
		tree.insert(list1);
		tree.insert(list2);
		tree.insert(list3);
		tree.insert(list4);
		tree.insert(list5);
		tree.prettyPrint();

		// should print "biopsy"
		// System.out.println("\nExtracted word: "+tree.extractWord() + "\n");
		/*
		 * BSTWithListNodes tree2 = new BSTWithListNodes('s'); tree2.insert('h');
		 * tree2.insert('y'); tree2.insert('g'); tree2.insert('t'); tree2.insert('o');
		 * 
		 * tree2.prettyPrint();
		 * 
		 * //should print "ghosty"
		 * System.out.println("\nExtracted word: "+tree2.extractWord() + "\n");
		 */
		System.out.println("2^3 = " + powerOfTwo(3));
		System.out.println("2^10 = " + powerOfTwo(10));
		System.out.println("3^-2 = " + powerNums(3, -2));
	}

	public static double powerNums(double x, double y) { // x^y
		if (x == 0) {
			return 0;
		}
		if (y == 0) {
			return 1.0;
		}
		if (y < 0) {
			return x / powerNums(x, -1 * (y - 1));
		} else {
			return x * powerNums(x, y - 1);
		}
	}
}
