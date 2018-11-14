package practiceProblems;

public class RecUtil extends Rectangle {
	double factor;

	public RecUtil(double l, double w, double f) {
		super(l, w);
		if (f <= 0) {
			throw new IllegalArgumentException("bad input");
		}
		factor = f;
	}

	@Override
	public double area() {
		double lw = super.perimeter() / 2; // perineter is 2l+2w, so /2 is legnth +width
		double squareside = lw / 2; // this gives you a new legnth for the side that would make a square,
		return squareside * squareside; // which will have the max area for a rectagle with that perimeter
	}

	@Override
	public double perimeter() {
		return super.perimeter() * factor;
	}
}
