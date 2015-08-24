/**
 * Created by Enifs
 */
package sequences;

import java.math.BigInteger;

public class FibonacciSequence
{
    // ----------------------------------------------------------------------------
    // Section: Constructors 
    // ----------------------------------------------------------------------------

	public FibonacciSequence()
	{
		this.previous = new BigInteger(String.valueOf(FIBONACCI_FIRST));
		this.current = new BigInteger(String.valueOf(FIBONACCI_SECOND));

		this.currentIndex = 2;
	}

	// ----------------------------------------------------------------------------
    // Section: Getters and Setters 
    // ----------------------------------------------------------------------------

	public int getCurrentIndex()
	{
		return currentIndex;
	}

	public int getCurrent()
	{
		int rv = -1;

		try
		{
			rv = Integer.parseInt(this.current.toString());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return rv;
	}

	// ----------------------------------------------------------------------------
    // Section: Other methods
    // ----------------------------------------------------------------------------

	public String nextAsString()
	{
		BigInteger x = this.current.add(this.previous);
		this.previous = this.current;
		this.current = x;

		this.currentIndex++;

		return x.toString();
	}


	public int next()
	{
		int x = -1;
		String s = this.nextAsString();

		try
		{
			x = Integer.parseInt(s);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		assert (x != -1) :"Fibonacci number to large for int. " + this.currentIndex;

		return x;
	}

	// ----------------------------------------------------------------------------
    // Section: Fields 
    // ----------------------------------------------------------------------------
	private BigInteger previous;
	private BigInteger current;

	int currentIndex;

	public static final int FIBONACCI_FIRST = 1;
	public static final int FIBONACCI_SECOND = 1;
}
