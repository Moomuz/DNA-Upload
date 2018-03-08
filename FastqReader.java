package dna;

import java.io.*;

//Reads lines from a BufferedReader and builds a FastqRecord

public class FastqReader 
{
	private BufferedReader theBufferedReader;
	
	public FastqReader(BufferedReader theBufferedReader)
	{
		this.theBufferedReader = theBufferedReader;
	}
	
	//reads next 4 lines in file, and returns a new fastq record if 4 lines constitute a record
	public FastqRecord readRecord() throws IOException, RecordFormatException
	{
		String defline = this.theBufferedReader.readLine();
		if(defline == null)													//first checks for end of file
		{
			return null;
		}
		else																//if not, reads next 3 lines 
		{
			String sequence = this.theBufferedReader.readLine();			//assigns each line to defline, sequence, quality
			this.theBufferedReader.readLine();								//skips "+"
			String quality = this.theBufferedReader.readLine();
			return new FastqRecord(defline, sequence, quality);				//constructs and returns FastqRecord using assigned String vars
		}
	}
}
