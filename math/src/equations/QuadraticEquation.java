package equations;

/**
 * Created by Didzis on 24.08.2015..
 */
public class QuadraticEquation
{
	public QuadraticEquation(double a, double b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;

		this.solve();
	}


	private void solve()
	{
		double D = b*b - (4 * (a * c));

		root1 = (-b + Math.sqrt(D))/(2*a);
		root2 = (-b - Math.sqrt(D))/(2*a);
	}


	public double roo1()
	{
		return root1;
	}

	public double roo2()
	{
		return root2;
	}

	double root1;
	double root2;

	double a;
	double b;
	double c;
	double result = 0;
}
