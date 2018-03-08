package dna;


//FastqRecord contains the defline, sequence, and quality string from a record in a fastq file

public class FastqRecord implements DNARecord
{
	private String defline;
	private String sequence;
	private String quality;
	
	//if defline does not start with "@", throws RecordFormatException with message saying 
	//what it saw and that it expected "@"
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException
	{
		if(defline.charAt(0) != '@')
		{
			throw new RecordFormatException("Bad 1st char in defline in fastq record: saw " + defline.charAt(0) + ", expected @");
		}
		else
		{
			this.defline = defline;
		}
		this.sequence = sequence;
		this.quality = quality;
	}
	
	//returns defline
	public String getDefline()
	{
		return this.defline;
	}
	
	//returns defline
	public String getSequence()
	{
		return this.sequence;
	}

	//checks deep equality of 3 instance variables
	//returns true if deep equal, false if not
	public boolean equals(Object x)
	{
		FastqRecord that = (FastqRecord)x;
		if(!this.defline.equals(that.defline))
		{
			return false;
		}
		else if(!this.sequence.equals(that.sequence))
		{
			return false;
		}
		else if(!this.quality.equals(that.quality))
		{
			return false;
		}
		return true;
	}

	//checks if quality contains "!" or "#"
	//if quality contains "!" or "#", returns true
	//otherwise returns false
	public boolean qualityIsLow()
	{
		if(this.quality.contains("!") || this.quality.contains("#"))
		{
			return true;
		}
		return false;
	}
	
	//overrides hashCode
	//returns sum of defline, sequence, and quality as a hashCode
	public int hashCode()
	{
		return this.defline.hashCode() + this.sequence.hashCode() + this.quality.hashCode();
	}
}
