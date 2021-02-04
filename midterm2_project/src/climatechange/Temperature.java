package climatechange;

import java.util.TreeMap;
import java.util.TreeSet;

public class Temperature implements ITemperature, Comparable<Temperature>
{
	private String country;
	private String country3LetterCode;
	private String month;
	private int year;
	private double temperature;
	
	// Instance variable used to convert the String value of the month that the user inputs to an integer.
	private TreeMap<String, Integer> monthsConverter = new TreeMap<String, Integer>();
	
	public Temperature(String country, String country3LetterCode, String month, int year, double temperature)
	{
		this.country = country;
		this.country3LetterCode = country3LetterCode;
		this.month = month;
		this.year = year;
		this.temperature = temperature;
		
		// Used to convert the String values of month to Integers.
		monthsConverter.put("Jan", 1);
		monthsConverter.put("Feb", 2);
		monthsConverter.put("Mar", 3);
		monthsConverter.put("Apr", 4);
		monthsConverter.put("May", 5);
		monthsConverter.put("Jun", 6);
		monthsConverter.put("Jul", 7);
		monthsConverter.put("Aug", 8);
		monthsConverter.put("Sep", 9);
		monthsConverter.put("Oct", 10);
		monthsConverter.put("Nov", 11);
		monthsConverter.put("Dec", 12);
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public String getCountry3LetterCode()
	{
		return country3LetterCode;
	}
	
	public String getMonth()
	{
		return month;
	}
	
	public int getYear()
	{
		return year;
	}
	
	// Can return the temperature of a Temperature object in Fahrenheit or Celcius.
	public double getTemperature(boolean getFahrenheit)
	{
		if(getFahrenheit)
		{
			return (temperature * 1.8) + 32;
		}
		else
		{
			return temperature;
		}
	}
	
	// Returns true if the compareTo method deems they are equal.
	public boolean equals(Object x)
	{
		Temperature t = (Temperature)x;
		if(this.compareTo(t) == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Orders the Temperature objects.
	public int compareTo(Temperature t)
	{
		// Orders by temperatures first.
		double tmpDiff = this.temperature - t.temperature;
		
		// If the temperatures are the same...
		if(tmpDiff == 0)
		{
			// Then order by country name.
			int countryDiff = this.country.compareTo(t.country);
			if(countryDiff == 0)
			{
				// If the country names are the same, orders by year.
				int yrDiff = this.year - t.year;
				if(yrDiff == 0)
				{
					// If the years are the same, orders by month.
					int monthDiff = monthsConverter.get(month) - monthsConverter.get(t.month);
					{
						// If the months are also the same, the objects are equal.
						if(monthDiff == 0)
						{
							return 0;
						}
						return (int)Math.signum(monthDiff);
					}
				}
				return (int)Math.signum(yrDiff);
			}
			return (int)Math.signum(countryDiff);
		}
		
		return (int)Math.signum(tmpDiff);
		
	}
	
	public int hashCode()
	{
		return (int)(temperature + year);
	}
	
	public String toString()
	{
		return String.format("%.2f", temperature) +  " (C), " + 
				String.format("%.2f", this.getTemperature(true)) + " (F), " + 
				year + ", " + month + ", " + country + ", " +  
				country3LetterCode;
	}

}
