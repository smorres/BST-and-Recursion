package practiceProblems;

public class BinarySearchTree {
	private char data;
	private BinarySearchTree left;
	private BinarySearchTree right;

	public BinarySearchTree(char ch) {
		this.data = ch;
	}

	public void insert(char element) {
		if (data == element)
			return;
		else if (data > element) {
			if (left == null)
				left = new BinarySearchTree(element);
			else
				left.insert(element);
		} else {
			if (right == null)
				right = new BinarySearchTree(element);
			else
				right.insert(element);
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
		BinarySearchTree tree = new BinarySearchTree('o');
		tree.insert('s');
		tree.insert('i');
		tree.insert('p');
		tree.insert('b');
		tree.insert('y');

		tree.prettyPrint();

		// should print "biopsy"
		System.out.println("\nExtracted word: " + tree.extractWord() + "\n");

		BinarySearchTree tree2 = new BinarySearchTree('s');
		tree2.insert('h');
		tree2.insert('y');
		tree2.insert('g');
		tree2.insert('t');
		tree2.insert('o');

		tree2.prettyPrint();

		// should print "ghosty"
		System.out.println("\nExtracted word: " + tree2.extractWord() + "\n");

		System.out.println("2^3 = " + powerOfTwo(3));
		System.out.println("2^10 = " + powerOfTwo(10));
		System.out.println("3^-2 = " + powerNums(3, -2));
		System.out.println("-4^-2 = " + powerNums(-4, -2));
		System.out.println("-3^2 = " + powerNums(-3, 2));

	}

	public static double powerNums(double x, double y) { // x^y
		if (x == 0) {
			return 0;
		}
		if (y == 0) {
			return 1.0;
		}
		if (y < 0) {
			System.out.println("recursive neg");
			return x / powerNums(x, -1 * (y - 1));
		} /*
			 * if(y < 0) { System.out.println("Hit negative"); return powerNums((1/x),-y); }
			 */
		else {
			System.out.println("recursive positive");
			return x * powerNums(x, y - 1);

		}

	}

}
//traverse in any order
//BST of ints
//whats the sum of all ints
