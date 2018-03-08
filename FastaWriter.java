package dna;

import java.io.*;

//Writes a fast record to a print writer

public class FastaWriter 
{
	private PrintWriter thePrintWriter;
	
	public FastaWriter(PrintWriter thePrintWriter)
	{
		this.thePrintWriter = thePrintWriter;
	}
	
	//gets defline and sequence from FastaRecord and prints them on separate lines
	public void writeRecord(FastaRecord rec) throws IOException
	{
		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());
		thePrintWriter.flush();
	}
}
