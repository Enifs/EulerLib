package processor;

/**
 * Created by Enifs
 */

public class CharacterProcessor
{
    // ----------------------------------------------------------------------------
    // Section: Constructors 
    // ----------------------------------------------------------------------------
    
    // ----------------------------------------------------------------------------
    // Section: Getters and Setters 
    // ----------------------------------------------------------------------------
    
    // ----------------------------------------------------------------------------
    // Section: Other methods 
    // ----------------------------------------------------------------------------

	/**
	 * Returns character position in English alphabet. Case insensitive.
	 * 1 based counting.
	 */
	public int characterAlphabetPosition(char character)
	{
		int returnValue = -1;

		assert (Character.isLetter(character)) : "Parameter must be a letter!";

		if (Character.isLowerCase(character))
		{
			returnValue = (int) character - (int) 'a' + 1;
		}
		else
		{
			returnValue = (int) character - (int) 'A' + 1;
		}

		return returnValue;
	}
    // ----------------------------------------------------------------------------
    // Section: Fields 
    // ----------------------------------------------------------------------------

}
