package practiceProblems;

public class BSTofStrings {
	private String data;
	private BSTofStrings left;
	private BSTofStrings right;

	public BSTofStrings(String element) {
		this.data = element;
	}
	public void insert(String element) {
		if (data == element)
			return;
		else if (data.length() > element.length()) {
			if (left == null)
				left = new BSTofStrings(element);
			else
				left.insert(element);
		} else {
			if (right == null)
				right = new BSTofStrings(element);
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
	// we build the returned string by adding each string in the BST
	// when you are done, make sure the main works

	private String AllTheStrings() {
		String retVal = "";
		if (left != null) {
			retVal += left.AllTheStrings();
		}
		retVal += data;
		if (right != null) {
			retVal += right.AllTheStrings();
		}
		return retVal;
	}

	// sum of the number of characters in the strings at each node?
	private int sumOfChars() {
		int sum = 0;
		if (left != null) {
			sum += left.sumOfChars(); // This recalls sumOfChars on the total chars.
		}

		sum += data.length(); // this adds the current node to sum.

		if (right != null) { // if right has a node it adds the value of that to sum.
			sum += right.sumOfChars();
		}
		return sum;
	}

	public static void main(String[] args) {
		BSTofStrings tree = new BSTofStrings("apple");
		tree.insert("one");
		tree.insert("shane");
		tree.insert("cool");
		tree.insert("tree");
		tree.insert("barged-in");
		tree.prettyPrint();
		System.out.println(tree.AllTheStrings());
		System.out.println(tree.sumOfChars());
	}
}
