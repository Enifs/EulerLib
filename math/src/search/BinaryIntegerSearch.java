package search;


public class BinaryIntegerSearch
{
	public BinaryIntegerSearch(int minEstimate, int maxEstimate, Functor functor)
	{
		this.maxEstimate = maxEstimate;
		this.minEstimate = minEstimate;
		this.functor = functor;
	}


	/**
	 * This function does binary search between min and max estimate.
	 * @return Answer, that satisfies functor or null.
	 */
	public Integer run()
	{
		Integer answer = null;

		if (functor.f(minEstimate) == 0)
		{
			answer = minEstimate;
		}

		if (functor.f(maxEstimate) == 0)
		{
			answer = maxEstimate;
		}

		while (answer == null && maxEstimate - minEstimate > 1)
		{
			int guess = minEstimate + (maxEstimate - minEstimate) / 2;

			if (guess == minEstimate)
			{
				guess++;
			}

			int f = functor.f(guess);

			if (f == 0)
			{
				answer = guess;
			}
			else if (f < 0)
			{
				maxEstimate = guess;
			}
			else
			{
				minEstimate = guess;
			}

		}

		return answer;
	}

	private int minEstimate;
	private int maxEstimate;

	// functor should return one of three: -1, 0 or 1.
	// -1 - search lower
	// 0 - an answer is found.
	// 1 - search higher
	private Functor<Integer> functor;
}
