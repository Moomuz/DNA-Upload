package dna;

//FastaRecord contains the defline and sequence string from a record in a fastq file

public class FastaRecord implements DNARecord 
{	
	private String defline;
	private String sequence;

	//if defline does not start with ">", throws RecordFormatException with message saying 
	//what it saw and that it expected ">"
	public FastaRecord(String defline, String sequence) throws RecordFormatException
	{
		if(defline.charAt(0) != '>')
		{
			throw new RecordFormatException("Bad 1st char in defline in fasta record: saw " + defline.charAt(0) + ", expected >");
		}
		else
		{
			this.defline = defline;
		}
		this.sequence = sequence;
	}

	//for defline, changes first char '@' to '>'
	public FastaRecord(FastqRecord fastqRec)
	{
		this.defline = ">" + fastqRec.getDefline().substring(1);
		this.sequence = fastqRec.getSequence();
	}

	//returns defline
	public String getDefline()
	{
		return this.defline;
	}
	
	//returns sequence
	public String getSequence()
	{
		return this.sequence;
	}
	
	//checks deep equality of 2 instance variables
	//returns true if deep equal, false if not
	public boolean equals(Object x)
	{
		FastaRecord that = (FastaRecord)x;
		if(!this.defline.equals(that.defline))
		{
			return false;
		}
		else if(!this.sequence.equals(that.sequence))
		{
			return false;
		}
		return true;
	}

	//overrides hashCode
	//returns sum of defline, sequence, and quality as a hashCode
	public int hashCode()
	{
		return this.defline.hashCode() + this.sequence.hashCode();
	}
}
