package climatechange;

import java.util.*;
import java.io.*;

public interface IWeatherIO 
{
	public ArrayList<ITemperature> readDataFromFile(String fileName) throws FileNotFoundException, IOException;
	
	public void writeSubjectHeaderInFile(String filename, String subject) throws IOException;
	
	public void writeDataToFile(String filename, ArrayList<ITemperature> theWeatherList) throws IOException;

}
