package basics;

import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * Created by Didzis on 25.08.2015..
 */
public class Number
{
	// ----------------------------------------------------------------------------
	// Section: Constructors
	// ----------------------------------------------------------------------------
	public Number(Integer i)
	{
		this.integerValue = i;
		this.mode = INTEGER_MODE;
	}


	public Number(Long l)
	{
		this.longValue = l;
		this.mode = LONG_MODE;
	}

	public Number(BigInteger bigInteger)
	{
		this.bigIntegerValue = bigInteger;
		this.mode = BIG_INTEGER_MODE;
	}


	// ----------------------------------------------------------------------------
	// Section: Retrievers
	// ----------------------------------------------------------------------------

	public int getIntegerValue()
	{
		return this.integerValue;
	}


	public long getLongValue()
	{
		return longValue;
	}


	public BigInteger getBigIntegerValue()
	{
		return bigIntegerValue;
	}


	public int getMode()
	{
		return mode;
	}

	// ----------------------------------------------------------------------------
	// Section: Addition
	// ----------------------------------------------------------------------------

	public int add(int i)
	{
		if (this.mode != INTEGER_MODE)
		{
			this.throwException();
		}

		this.integerValue += i;
		return this.integerValue;
	}

	public long add(long l)
	{
		if (this.mode != LONG_MODE)
		{
			this.throwException();
		}

		this.longValue += l;
		return this.longValue;
	}

	public BigInteger add(BigInteger bigInteger)
	{
		if (this.mode != LONG_MODE)
		{
			this.throwException();
		}

		this.bigIntegerValue = this.bigIntegerValue.add(bigInteger);
		return this.bigIntegerValue;
	}

	public BigInteger add(String stringNumber)
	{
		return this.add(new BigInteger(stringNumber));
	}

	public Number add(Number number)
	{
		switch (this.mode)
		{
			case INTEGER_MODE:
				this.add(number.integerValue);
				break;
			case LONG_MODE:
				this.add(number.longValue);
				break;
			case BIG_INTEGER_MODE:
				this.add(number.bigIntegerValue);
				break;
		}

		return this;
	}

	// ----------------------------------------------------------------------------
	// Section: Subtraction
	// ----------------------------------------------------------------------------

	public int subtract(int i)
	{
		if (this.mode != INTEGER_MODE)
		{
			this.throwException();
		}

		this.integerValue -= i;
		return this.integerValue;
	}

	public long subtract(long l)
	{
		if (this.mode != LONG_MODE)
		{
			this.throwException();
		}

		this.longValue -= l;
		return this.longValue;
	}

	public BigInteger subtract(BigInteger bigInteger)
	{
		if (this.mode != LONG_MODE)
		{
			this.throwException();
		}

		this.bigIntegerValue = this.bigIntegerValue.subtract(bigInteger);
		return this.bigIntegerValue;
	}

	public BigInteger subtract(String stringNumber)
	{
		return this.subtract(new BigInteger(stringNumber));
	}


	public Number subtract(Number number)
	{
		switch (this.mode)
		{
			case INTEGER_MODE:
				this.subtract(number.integerValue);
				break;
			case LONG_MODE:
				this.subtract(number.longValue);
				break;
			case BIG_INTEGER_MODE:
				this.subtract(number.bigIntegerValue);
				break;
		}

		return this;
	}


	// ----------------------------------------------------------------------------
	// Section: Exceptions
	// ----------------------------------------------------------------------------


	private class WrongNumberModeException extends Exception
	{
		public WrongNumberModeException(String message)
		{
			super(message);
		}
	}

	private void throwException()
	{
		try
		{
			throw new WrongNumberModeException(this.exceptionMessage());
		}
		catch (WrongNumberModeException e)
		{
			e.printStackTrace();
		}
	}

	private String exceptionMessage()
	{
		return "Number currently operates in " + this.mode;
	}

	int mode;

	int integerValue;
	long longValue;
	double doubleValue;
	BigInteger bigIntegerValue;
	BigDecimal bigDecimalValue;

	public static final int INTEGER_MODE = 1;
	public static final int LONG_MODE = 2;
	public static final int BIG_INTEGER_MODE = 3;
}
