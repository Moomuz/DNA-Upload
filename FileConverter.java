package dna;

import java.io.*;
import java.util.*;

//Converts records in fastq file fasta records then writes fasta records into fasta file

public class FileConverter 
{
	private File fastq;
	private File fasta;
	
	public FileConverter(File fastq, File fasta)
	{
		this.fastq = fastq;
		this.fasta = fasta;
	}

	//converts fastq records in fastq file to fasta records
	//then writes fasta records into fasta file
	public void convert() throws IOException
	{
		//builds chain of readers
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		//builds chain of writers
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);
		
		//read, translate, write
		FastqRecord temp = null;
		boolean done = false;
		while(!done)
		{
			try
			{
				temp = fqr.readRecord();						//reads new record in fastq file
				if(temp == null)								//checks for end of file
				{												//if end, breaks out of loop
					done = true;
					break;
				}
				else if(!temp.qualityIsLow())					//checks non-empty record if quality is low
				{
					faw.writeRecord(new FastaRecord(temp));		//if quality is not low, writes record in fasta file
				}
			}
			catch (RecordFormatException x)						
			{
			}
		}
		
		//close fr, br, fw, and pw in reverse order of creation
		//fqr and faw do not close because they don't have close() methods
		pw.close();					
		fw.close();
		br.close();
		fr.close();
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Starting");
		try
		{
			File fastq = new File("data/HW4.fastq");
			if (!fastq.exists())
			{
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW4.fasta");
			if(!fasta.exists()) 
			{
				fasta.createNewFile();
			}
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		}
		catch (IOException x)
		{
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
	
}
