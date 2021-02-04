package climatechange;

import java.util.*;
import java.io.*;

public class WeatherIO implements IWeatherIO
{

	public WeatherIO() {}
	
	public ArrayList<ITemperature> readDataFromFile(String fileName) throws FileNotFoundException, IOException
	{
		// creates a file out of the file name input
		File input = new File(fileName);
		// creates a file reader out of the file
		FileReader fr = new FileReader(input);
		// creates a buffered reader out of the file reader
		BufferedReader br = new BufferedReader(fr);

		// ArrayList used to store all of the temperatures
		ArrayList<ITemperature> theTemperatures = new ArrayList<ITemperature>();
		
		String firstLine = br.readLine(); //rids of the first line of the csv file
		String currentLine = br.readLine(); //starts on the current line of the file
		
		// while the reader has not reached the end of the file
		while(currentLine != null)
		{
			// the parameters are split by a comma and space
			String[] tempParams = currentLine.split(", ");
			
			// each parameter is made into a variable
			double tmp = Double.parseDouble(tempParams[0]);
			int yr = Integer.parseInt(tempParams[1]);
			String mo = tempParams[2];
			String cntry = tempParams[3];
			String code = tempParams[4];
			
			// a new Temperature object is created from those variables in that one line
			Temperature temp = new Temperature(cntry, code, mo, yr, tmp);
			
			// the Temperature object is added to the ArrayList to store all of the temperatures
			theTemperatures.add(temp);
			
			//updates the current line of the file
			currentLine = br.readLine();
		}
		
		br.close();
		fr.close();
		
		return theTemperatures;
		
	}
	
	public void writeSubjectHeaderInFile(String filename, String subject) throws IOException
	{
		// creates a file writer out of the file name input
		FileWriter fw = new FileWriter(filename, true);
		// creates a print writer out of the file writer
		PrintWriter pw = new PrintWriter(fw);
		
		// the inputted subject is written, as well as a constant header
		pw.println(subject);
		pw.println("Temperature, Year, Month, Country, Country_Code");
		
		pw.close();
		fw.close();
	}
	
	public void writeDataToFile(String filename, ArrayList<ITemperature> theWeatherList) throws IOException 
	{
		// creates a file writer out of the file name input
		FileWriter fw = new FileWriter(filename, true);
		// creates a print writer out of the file writer
		PrintWriter pw = new PrintWriter(fw);
		
		// for every Temperature object in the ArrayList provided
		for(ITemperature t : theWeatherList)
		{
			// the toString version of that Temperature object is printed on a new line
			pw.println(t.toString());
		}
		pw.println(); // another line is used to space between tasks
		
		pw.close();
		fw.close();
	}
}
