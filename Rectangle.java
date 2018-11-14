package practiceProblems;

public class Rectangle {
	double legnth, width;

	public Rectangle(double l, double w) {
		legnth = l;
		width = w;
	}

	public double area() {
		return legnth * width;
	}

	public double perimeter() {
		return 2 * legnth + 2 * width;
	}
}
