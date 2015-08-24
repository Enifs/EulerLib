package processor;

//
// Created by Enifs.
//

import equations.QuadraticEquation;
import search.BinaryIntegerSearch;
import search.Functor;

import java.math.BigInteger;
import java.util.*;

public class NumberProcessor
{
	/**
	 * H(n)=n(2n−1)
	 */
	public int hexagonalNumber(int n)
	{
		return n *(2*n - 1);
	}


	/**
	 * P(n)=n(3n−1)/2
	 */
	public int pentagonalNumber(int n)
	{
		return ( n *(3*n - 1) ) / 2;
	}

	/**
	 * Tells if the given integer is a triangle number.
	 */
	public boolean isPentagonalNumber(int n)
	{
		boolean returnValue = false;

		QuadraticEquation equation = new QuadraticEquation(3, -1, -(2*n));

		double positiveRoot = Math.max(equation.roo1(), equation.roo2());

		if (Math.floor(positiveRoot) == positiveRoot)
		{
			returnValue = true;
		}

		return returnValue;
	}

	/**
	 * Calculates n-th triangle number t by formula t = ½n(n+1);
	 */
	public int triangleNumber(int n)
	{
		return (n * (n + 1))/2;
	}


	/**
	 * Tells if the given integer is a triangle number.
	 */
	public boolean isTriangleNumber(int n)
	{
		boolean returnValue = false;

		QuadraticEquation equation = new QuadraticEquation(1, 1, -(2*n));

		double positiveRoot = Math.max(equation.roo1(), equation.roo2());

		if (Math.floor(positiveRoot) == positiveRoot)
		{
			returnValue = true;
		}

		return returnValue;
	}

	/**
	 * Checks if given integer is a square of another integer
	 * @return
	 */
	public boolean isWholeNumberSquare(final int number)
	{
		boolean returnValue = true;

		BinaryIntegerSearch search = new BinaryIntegerSearch(0, number / 2, new Functor<Integer>()
		{
			@Override
			public Integer f(Integer parameter)
			{
				int sq = parameter * parameter;

				if (sq == number)
				{
					return 0;
				}
				else if (sq < number)
				{
					return 1;
				}
				else
				{
					return -1;
				}
			}
		});

		return search.run() != null;
	}

	/**
	 * Checks if absolute value of given integer reads the same from both ends;
	 * */
	public boolean isSymmetric(int number)
	{
		boolean returnValue = true;
		number = Math.abs(number);
		String a = Integer.toString(number);

		for (int i = 0; i < a.length() / 2 && returnValue; i++)
		{
			if (a.charAt(i) != a.charAt(a.length() - 1 - i))
			{
				returnValue = false;
			}
		}

		return returnValue;
	}


	/**
	 * Checks if absolute value of given integer is 'pandigital'.
	 * Pandigital - number contains x digits and it is composed from every digit [1..x];
	 */
	public boolean isPandigital(int number)
	{
		return this.isPandigital(Integer.toString(number));
	}

	public boolean isPandigital(String number)
	{
		boolean returnValue = true;

		for (int i = 1; i <= number.length() && returnValue; i++)
		{
			String si = Integer.toString(i);

			if (number.indexOf(si.charAt(0)) == -1)
			{
				returnValue = false;
			}
		}

		return returnValue;
	}
	/**
	 * Gets a number of digits for the absolute value of the given number.
	 */
	public int numberOfDigits(int number)
	{
		if (number < 0)
		{
			number *= -1;
		}

		return String.valueOf(number).length();
	}


	/**
	 * Adds sum of all elements of the list.
	 * @param numbers
	 */
	public int sumCollectionElements(Collection<Integer> numbers)
	{
		int sum = 0;

		for (Integer number : numbers)
		{
			sum += number;
		}

		return sum;
	}


	/**
	* Calculates all proper divisors of a given number and returns a list of them.
	* Given number itself is not a proper divisor.
	*/
	public List<Integer> allProperDivisors(int number)
	{
		assert (number > 0) : "parameter has to be positive.";

		List<Integer> divisors = new ArrayList<Integer>();

		 int limit = Integer.MAX_VALUE;

		 for (int i = 1; i < limit; i++)
		 {
			if (number % i == 0)
			{
				divisors.add(i);

				int otherDivisor = number / i;

				if (otherDivisor != i)
				{
					divisors.add(otherDivisor);
				}

				limit = otherDivisor;
			}
		}

		Collections.sort(divisors);
		divisors.remove(divisors.size() - 1);

		return divisors;
	}


    /**
	 * todo: Not really number of divisors.
     * This method return the amount of Divisors for a given Integer.
     * @param numberAsString Integer to process.
     * @return The amount of divisors.
     */
	public int getNumberOfDivisors(String numberAsString)
	{
        LinkedList<Integer> primeFactors = this.getPrimeFactors(numberAsString);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (Integer factor : primeFactors)
        {
            if (map.containsKey(factor))
            {
                int x = map.get(factor);
                map.put(factor, x + 1);
            }
            else
            {
                map.put(factor, 1);
            }
        }

        int returnValue = 1;

        for (Integer integer : map.values())
        {
            integer ++;
            returnValue *= integer;
        }

        return returnValue;
    }
	// ----------------------------------------------------------------------------
	// Section: Collatz sequence
	// ----------------------------------------------------------------------------

    /**
     * Collatz sequence:
     * n → n/2 (n is even)
     * n → 3n + 1 (n is odd)
     */
    public int nextInCollatzSequence(int number)
    {
        int returnValue = -1;
        if (number % 2 == 0)
        {
            returnValue = number/2;
        }
        else
        {
            returnValue = (number * 3) + 1;
        }

        return returnValue;
    }

    /**
     * Collatz sequence:
     * n → n/2 (n is even)
     * n → 3n + 1 (n is odd)
     */
    public BigInteger nextInCollatzSequence(BigInteger number)
    {
        BigInteger returnValue = new BigInteger("-1");
        if (number.mod(new BigInteger("2")).equals(0))
        {
            returnValue = number.divide(new BigInteger("2"));
        }
        else
        {
            returnValue = number.multiply(new BigInteger("3"));
            returnValue = returnValue.add(new BigInteger("1"));
        }

        return returnValue;
    }

	// ----------------------------------------------------------------------------
	// Section: Abundant, Perfect, Deficient
	// ----------------------------------------------------------------------------
	/**
	 * Perfect number has its proper divisor sum equal to itself.
	 */
	public boolean isPerfectNumber(int number)
	{
		boolean rv = false;

		int sumProperDivisors = this.sumCollectionElements(this.allProperDivisors(number));

		return number == sumProperDivisors;
	}


	/**
	 * Deficient number has its proper divisor sum less than itself.
	 */
	public boolean isDeficientNumber(int number)
	{
		boolean rv = false;

		int sumProperDivisors = this.sumCollectionElements(this.allProperDivisors(number));

		return number > sumProperDivisors;
	}


	/**
	 * Abundant number has its proper divisor sum greater than itself.
	 */
	public boolean isAbundantNumber(int number)
	{
		boolean rv = false;

		int sumProperDivisors = this.sumCollectionElements(this.allProperDivisors(number));

		return number < sumProperDivisors;
	}


	// ----------------------------------------------------------------------------
	// Section: Prime numbers
	// ----------------------------------------------------------------------------


	/**
	 * This function returns a list of prime factors for a given number.
	 * None of the prime factors should ever be bigger
	 * than <code>Integer.MAX_VALUE</code>, however, source number can.
	 */
	public LinkedList<Integer> getPrimeFactors(String numberAsString)
	{
		BigInteger zero = new BigInteger("0");
		LinkedList<Integer> primeFactors = new LinkedList<Integer>();
		BigInteger x = new BigInteger(numberAsString);
		boolean go = true;
		Integer i = 1;
		while (go)
		{
			if (isPrime(i))
			{
				if (zero.equals(x.remainder(new BigInteger(i.toString()))))
				{
					primeFactors.add(i);
					x = x.divide(new BigInteger(i.toString()));
					i = 1;
				}
			}
			i++;
			if (x.equals(new BigInteger("1")))
			{
				go = false;
			}
		}

		return primeFactors;
	}


	/**
	 * This function tells, if given number is a prime.
	 *
	 * @return True, if given number is a prime.
	 */
	public boolean isPrime(long n)
	{
		boolean prime = true;

		for (long i = 3; i <= Math.sqrt(n); i += 2)
		{
			if (n % i == 0)
			{
				prime = false;
				break;
			}
		}

		if ((n % 2 != 0 && prime && n > 2) || n == 2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
