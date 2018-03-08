package dna;

//Our own Exception used for record formats

public class RecordFormatException extends Exception
{
	//provides exception's message
	public RecordFormatException(String message)
	{
		super(message);
	}
}
