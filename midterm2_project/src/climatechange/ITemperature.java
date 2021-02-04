package climatechange;

public interface ITemperature 
{
	public String getCountry();
	
	public String getCountry3LetterCode();
	
	public String getMonth(); //should i change this to int?
	
	public int getYear();
	
	public double getTemperature(boolean getFahrenheit);
}
