/**
 * Created by Enifs
 */
package permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PermutationProcessor
{
	// ----------------------------------------------------------------------------
    // Section: Constructors 
    // ----------------------------------------------------------------------------

	public PermutationProcessor(String chars)
	{
		this.characters = new LinkedList<Character>();
		this.size = chars.length();

		for (int i = 0; i < chars.length(); i++)
		{
			this.characters.add(chars.charAt(i));
		}
	}

	// ----------------------------------------------------------------------------
    // Section: Getters and Setters 
    // ----------------------------------------------------------------------------
    
    // ----------------------------------------------------------------------------
    // Section: Other methods 
    // ----------------------------------------------------------------------------

	public String nextPermutation()
	{
		int k = -1;
		int l = -1;

		for (int i = 0; i < this.size - 1; i++)
		{
			char c1 = this.characters.get(i);
			char c2 = this.characters.get(i + 1);
			if (c1 < c2)
			{
				k = i;
			}
		}

		if (k == -1)
		{
			if (!this.isLastPermutationFound)
			{
				this.lastPermutation = this.convertToString();
				this.isLastPermutationFound = true;
			}
		}
		else
		{
			char c = this.characters.get(k);

			for (int i = this.size - 1; i >= 0; i--)
			{
				if (this.characters.get(i) > c)
				{
					l = i;
					break;
				}
			}
		}

		if (k != -1 && l != -1)
		{
			this.swap(k, l);
		}

		// reversing from k+1 till end

		Stack stack = new Stack();

		for (int i = k+1; i < this.size; i++)
		{
			stack.push(this.characters.get(i));
		}

		for (int i = k + 1; i < this.size; i++)
		{
			this.characters.set(i, (Character) stack.pop());
		}

		assert (stack.isEmpty()) : "Stack should be empty!";

		return this.convertToString();
	}

	public String convertToString()
	{
		StringBuilder builder = new StringBuilder(this.characters.size());

		for (int i = 0; i < this.characters.size(); i++)
		{
			builder.append(this.characters.get(i));
		}

		return builder.toString();
	}

	private void swap(int k, int l)
	{
	 	char tmp = this.characters.get(k);
		this.characters.set(k, this.characters.get(l));
		this.characters.set(l, tmp);
	}

	public boolean isLastPermutationFound()
	{
		return this.isLastPermutationFound;
	}

	// ----------------------------------------------------------------------------
    // Section: Fields 
    // ----------------------------------------------------------------------------

	LinkedList<Character> characters;

	private final int size;

	private boolean isLastPermutationFound = false;
	private String lastPermutation;
}
