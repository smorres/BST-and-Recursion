package practiceProblems;

//
public class LambdaDriver {

	// TODO: summation simply returns the sum of the strings according to LamdaSum's
	// implementation
	// should be a simple one liner. make sure you created the interface LambdaSum
	// before attempting this file
	public static int summation(String str1, String str2, LambdaSum s) {
		return s.sum2(str1, str2);

	}

	public static void main(String[] args) {
		String str1 = "Indiana";
		String str2 = "Mississippi";

		// TODO: call summation correctly, using a lambda expression to represent
		// LambdaSum
		// such that it returns the sum of each String's length
		System.out.println(LambdaDriver.summation(str1, str2, (a, b) -> a.length() + b.length())); // how do you do this
																									// with lambda
																									// expressions?

		// TODO: call summation correctly, using a lambda expression to represent
		// LambdaSum
		// such that it returns the total times I or i appears in either string
		System.out.println(LambdaDriver.summation(str1, str2, (a, b) -> { // you need dummy vars any time your making a
																			// lambda expression.
			// in this instance you use two variables because the interface uses two.
			// when there is an interface on the lab test you must use a lambda expression
			// to create method, WHEN THERE IS ONLY ONE INTERFACE METHOD!!!
			a = a.toLowerCase();
			b = b.toLowerCase();
			int acount = 0;
			int bcount = 0;
			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) == 'i') {
					acount = acount + 1;
				}
			}
			for (int i = 0; i < b.length(); i++) {
				if (b.charAt(i) == 'i') {
					bcount = bcount + 1;
				}

			}
			return acount + bcount;
		}));
	}
}
