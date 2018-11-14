package practiceProblems;

public class IntegerBST {
	private int data;
	private IntegerBST left;
	private IntegerBST right;

	public IntegerBST(int ch) {
		this.data = ch;
	}

	public void insert(int element) {
		if (data == element)
			return;
		else if (data > element) {
			if (left == null)
				left = new IntegerBST(element);
			else
				left.insert(element);
		} else {
			if (right == null)
				right = new IntegerBST(element);
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
	public int sum() {// returns the sum of the tree
		int sum = 0;
		if (left != null) {
			sum += left.sum();
		}
		sum += data; // this is current node
		if (right != null) {
			sum += right.sum();
		}
		return sum;
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

	public static int factorial(int n) {
		if (n < 0)
			throw new IllegalArgumentException("cant be negative");
		if (n == 0 || n == 1) {
			return n;
		} else {
			return n * factorial(n - 1);
		}
	}

	public static double squareRoot(double n) {
		return squareRootHelper(n, 4);
	}

	private static double squareRootHelper(double n, double approx) {
		if (n == 0) {
			return 0;
		}
		if (Math.abs((approx * approx) - n) < 1e-10) {
			return approx;
		} else {
			return squareRootHelper(n, ((approx + n / approx) / 2));
		}
	}

	/*
	 * public int depth(int element) {
	 * 
	 * if(data == element) return 0; if(data > element) { if(left == null) { return
	 * -1; }int leftdepth = left.depth(element); if(leftdepth ==-1)return -1; }
	 * return 1+leftdepth;
	 * 
	 * }
	 */
	public String parent(int element) {
		if (data == element)
			return "root";
		if (data > element) {
			if (left == null)
				return "missing";
			if (left.data == element)
				return data + "";
			return left.parent(element);
		}
		if (right == null)
			return "missing";
		if (right.data == element)
			return data + "";
		return right.parent(element);
	}

	public static void main(String[] args) {
		IntegerBST tree = new IntegerBST(6);
		tree.insert(1);
		tree.insert(5);
		tree.insert(7);
		tree.insert(2);
		tree.insert(3);
		System.out.println(tree.sum());
		tree.prettyPrint();
		System.out.println("\n\nFactorial(5): " + factorial(5));
		System.out.println("\n\nSquareRoot(4): " + squareRoot(4));
		System.out.println(tree.parent(6));

	}
}
//traverse in any order
//BST of ints
//whats the sum of all ints
//you will have insert and pretty print
// the tree given will have only one data type
