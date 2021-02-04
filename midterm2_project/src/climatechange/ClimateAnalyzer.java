package climatechange;

import java.util.*;
import java.io.*;;

public class ClimateAnalyzer extends WeatherIO implements IClimateAnalyzer {
	// Instance variable used to convert the integer value of the month that the
	// user inputs to a String.
	private TreeMap<Integer, String> monthsConverter = new TreeMap<Integer, String>();

	// This represents the ArrayList of all of the Temperature objects.
	private ArrayList<ITemperature> allTemps;

	// This represents the HashSet of all country names to check the validity of
	// user input.
	private HashSet<String> allCountries;

	public ClimateAnalyzer() throws IOException {
		monthsConverter.put(1, "Jan");
		monthsConverter.put(2, "Feb");
		monthsConverter.put(3, "Mar");
		monthsConverter.put(4, "Apr");
		monthsConverter.put(5, "May");
		monthsConverter.put(6, "Jun");
		monthsConverter.put(7, "Jul");
		monthsConverter.put(8, "Aug");
		monthsConverter.put(9, "Sep");
		monthsConverter.put(10, "Oct");
		monthsConverter.put(11, "Nov");
		monthsConverter.put(12, "Dec");

		allTemps = readDataFromFile(
				"climatedata/world_temp_2000-2016.csv");

		allCountries = new HashSet<String>();

		for (ITemperature tmp : allTemps) {
			allCountries.add(tmp.getCountry());
		}
	}

	// Task A1: Returns the Temperature object with the lowest temperature in a
	// country and month specified by the user.
	public ITemperature getLowestTempByMonth(String country, int month) throws IOException {
		// This represents the ordered TreeSet of all of the Temperature objects with
		// the same country and month.
		TreeSet<ITemperature> sameCountryAndMonth = new TreeSet<ITemperature>();

		// Every Temperature that has the same country and year as the user provides is
		// added to the TreeSet.
		for (ITemperature tmp : allTemps) {
			if (tmp.getCountry().equals(country) && tmp.getMonth().equals(monthsConverter.get(month))) {
				sameCountryAndMonth.add(tmp);
			}
		}
		// The TreeSet is filed through an ArrayList.
		ArrayList<ITemperature> sameCAndM = new ArrayList<ITemperature>(sameCountryAndMonth);
		// Another ArrayList is created using the desired element of the original
		// TreeSet.
		ArrayList<ITemperature> ans = new ArrayList<ITemperature>();
		ans.add(sameCAndM.get(0));

		// The file is created, a header is written, and the required data of the
		// Temperature object is written.
		writeSubjectHeaderInFile("climatedata/taskA1_climate_info.csv",
				"Task A1: Lowest Temperature in " + country + " in " + monthsConverter.get(month));
		writeDataToFile("climatedata/taskA1_climate_info.csv", ans);

		// The desired Temperature object is returned.
		return ans.get(0);
	}

	// Task A1: Returns the Temperature object with the highest temperature in a
	// country and month specified by the user.
	public ITemperature getHighestTempByMonth(String country, int month) throws IOException {
		// This represents the ordered TreeSet of all of the Temperature objects with
		// the same country and month.
		TreeSet<ITemperature> sameCountryAndMonth = new TreeSet<ITemperature>();

		// Every Temperature that has the same country and year as the user provides is
		// added to the TreeSet.
		for (ITemperature tmp : allTemps) {
			if (tmp.getCountry().equals(country) && tmp.getMonth().equals(monthsConverter.get(month))) {
				sameCountryAndMonth.add(tmp);
			}
		}
		// The TreeSet is filed through an ArrayList.
		ArrayList<ITemperature> sameCAndM = new ArrayList<ITemperature>(sameCountryAndMonth);
		// Another ArrayList is created using the desired element of the original
		// TreeSet.
		ArrayList<ITemperature> ans = new ArrayList<ITemperature>();
		ans.add(sameCAndM.get(sameCAndM.size() - 1));

		// The file is created, a header is written, and the required data of the
		// Temperature object is written.
		writeSubjectHeaderInFile("climatedata/taskA1_climate_info.csv",
				"Task A1: Highest Temperature in " + country + " in " + monthsConverter.get(month));
		writeDataToFile("climatedata/taskA1_climate_info.csv", ans);

		// The desired Temperature object is returned.
		return ans.get(0);
	}

	// Task A2: Returns the Temperature object with the lowest temperature in a
	// country and year specified by the user.
	public ITemperature getLowestTempByYear(String country, int year) throws IOException {
		// This represents the ordered TreeSet of all of the Temperature objects with
		// the same country and year.
		TreeSet<ITemperature> sameCountryAndYear = new TreeSet<ITemperature>();

		// Every Temperature that has the same country and year as the user provides is
		// added to the TreeSet.
		for (ITemperature tmp : allTemps) {
			if (tmp.getCountry().equals(country) && tmp.getYear() == year) {
				sameCountryAndYear.add(tmp);
			}
		}
		// The TreeSet is filed through an ArrayList.
		ArrayList<ITemperature> sameCAndY = new ArrayList<ITemperature>(sameCountryAndYear);
		// Another ArrayList is created using the desired element of the original
		// TreeSet.
		ArrayList<ITemperature> ans = new ArrayList<ITemperature>();
		ans.add(sameCAndY.get(0));

		// The file is created, a header is written, and the required data of the
		// Temperature object is written.
		writeSubjectHeaderInFile("climatedata/taskA2_climate_info.csv",
				"Task A2: Lowest Temperature in " + country + " in " + year);
		writeDataToFile("climatedata/taskA2_climate_info.csv", ans);

		// The desired Temperature object is returned.
		return ans.get(0);
	}

	// Task A2: Returns the Temperature object with the highest temperature in a
	// country and year specified by the user.
	public ITemperature getHighestTempByYear(String country, int year) throws IOException {
		// This represents the ordered TreeSet of all of the Temperature objects with
		// the same country and year.
		TreeSet<ITemperature> sameCountryAndYear = new TreeSet<ITemperature>();

		// Every Temperature that has the same country and year as the user provides is
		// added to the TreeSet.
		for (ITemperature tmp : allTemps) {
			if (tmp.getCountry().equals(country) && tmp.getYear() == year) {
				sameCountryAndYear.add(tmp);
			}
		}
		// The TreeSet is filed through an ArrayList.
		ArrayList<ITemperature> sameCAndY = new ArrayList<ITemperature>(sameCountryAndYear);
		// Another ArrayList is created using the desired element of the original
		// TreeSet.
		ArrayList<ITemperature> ans = new ArrayList<ITemperature>();
		ans.add(sameCAndY.get(sameCAndY.size() - 1));

		// The file is created, a header is written, and the required data of the
		// Temperature object is written.
		writeSubjectHeaderInFile("climatedata/taskA2_climate_info.csv",
				"Task A2: Lowest Temperature in " + country + " in " + year);
		writeDataToFile("climatedata/taskA2_climate_info.csv", ans);

		// The desired Temperature object is returned.
		return ans.get(0);
	}

	// Task A3: Returns the Temperature objects in an ArrayList in a certain country
	// within a range of temperatures.
	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp)
			throws IOException {
		// This represents the TreeSet of all of the Temperature objects of a certain
		// country within a given temperature range.
		TreeSet<ITemperature> withinRange = new TreeSet<ITemperature>();

		// Every Temperature that has the same country and within the range that the
		// user provides is added to the TreeSet.
		for (ITemperature tmp : allTemps) {
			if (tmp.getCountry().equals(country) && tmp.getTemperature(false) >= rangeLowTemp
					&& tmp.getTemperature(false) <= rangeHighTemp) {
				withinRange.add(tmp);
			}
		}
		// The TreeSet is filed through an ArrayList.
		ArrayList<ITemperature> withinRange1 = new ArrayList<ITemperature>(withinRange);

		// The file is created, a header is written, and the required data of the
		// Temperature object is written.
		writeSubjectHeaderInFile("climatedata/taskA3_climate_info.csv",
				"Task A3: Temperatures within range " + rangeLowTemp + " and " + rangeHighTemp + " in " + country);
		writeDataToFile("climatedata/taskA3_climate_info.csv", withinRange1);

		// The desired TreeSet is returned.
		return withinRange;
	}

	// Task A4: Returns the Temperature object with the lowest temperature in a
	// certain country.
	public ITemperature getLowestTempYearByCountry(String country) throws IOException {
		// This represents the ordered TreeSet of all of the Temperature objects with
		// the same country and year.
		TreeSet<ITemperature> sameCountry = new TreeSet<ITemperature>();

		// Every Temperature that has the same country and year as the user provides is
		// added to the TreeSet.
		for (ITemperature tmp : allTemps) {
			if (tmp.getCountry().equals(country)) {
				sameCountry.add(tmp);
			}
		}
		// The TreeSet is filed through an ArrayList.
		ArrayList<ITemperature> sameC = new ArrayList<ITemperature>(sameCountry);
		// Another ArrayList is created using the desired element of the original
		// TreeSet.
		ArrayList<ITemperature> ans = new ArrayList<ITemperature>();
		ans.add(sameC.get(0));

		// The file is created, a header is written, and the required data of the
		// Temperature object is written.
		writeSubjectHeaderInFile("climatedata/taskA4_climate_info.csv", "Task A4: Lowest Temperature in " + country);
		writeDataToFile("climatedata/taskA4_climate_info.csv", ans);

		return ans.get(0);
	}

	// Task A4: Returns the Temperature object with the highest temperature in a
	// certain country.
	public ITemperature getHighestTempYearByCountry(String country) throws IOException {
		// This represents the ordered TreeSet of all of the Temperature objects with
		// the same country and year.
		TreeSet<ITemperature> sameCountry = new TreeSet<ITemperature>();

		// Every Temperature that has the same country and year as the user provides is
		// added to the TreeSet.
		for (ITemperature tmp : allTemps) {
			if (tmp.getCountry().equals(country)) {
				sameCountry.add(tmp);
			}
		}
		// The TreeSet is filed through an ArrayList.
		ArrayList<ITemperature> sameC = new ArrayList<ITemperature>(sameCountry);
		// Another ArrayList is created using the desired element of the original
		// TreeSet.
		ArrayList<ITemperature> ans = new ArrayList<ITemperature>();
		ans.add(sameC.get(sameC.size() - 1));

		// The file is created, a header is written, and the required data of the
		// Temperature object is written.
		writeSubjectHeaderInFile("climatedata/taskA4_climate_info.csv", "Task A4: Highest Temperature in " + country);
		writeDataToFile("climatedata/taskA4_climate_info.csv", ans);

		return ans.get(0);
	}

	// Task B1: Returns a list of the top 10 lowest-temperatured Temperature objects
	// in unique countries in a specified month.
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month) throws IOException {
		// This represents the ordered TreeSet of all of the Temperature objects with
		// the same country and month.
		TreeSet<ITemperature> sameMonth = new TreeSet<ITemperature>();

		// Makes sure that all countries added to the ans are UNIQUE
		HashSet<String> countries = new HashSet<String>();

		// Every Temperature that has the same country and year as the user provides is
		// added to the TreeSet.
		for (ITemperature tmp : allTemps) {
			if (tmp.getMonth().equals(monthsConverter.get(month))) {
				sameMonth.add(tmp);
			}
		}
		// The TreeSet is filed through an ArrayList.
		ArrayList<ITemperature> sameM = new ArrayList<ITemperature>(sameMonth);
		// Another ArrayList is created using the desired element of the original
		// TreeSet.
		ArrayList<ITemperature> ans = new ArrayList<ITemperature>();

		// Makes sure that all countries added to the ans are UNIQUE, starts at
		// beginning
		int i = 0;
		while (ans.size() != 10) {
			if (countries.add(sameM.get(i).getCountry())) {
				ans.add(sameM.get(i));
			}
			i++;
		}

		// The file is created, a header is written, and the required data of the
		// Temperature object is written.
		writeSubjectHeaderInFile("climatedata/taskB1_climate_info.csv",
				"Task B1: Top 10 Lowest Temperatures in All Countries in " + monthsConverter.get(month));
		writeDataToFile("climatedata/taskB1_climate_info.csv", ans);

		// The desired ArrayList<ITemperature> object is returned.
		return ans;
	}

	// Task B1: Returns a list of the top 10 highest-temperatured Temperature
	// objects in unique countries in a specified month.
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month) throws IOException {
		// This represents the ordered TreeSet of all of the Temperature objects with
		// the same country and month.
		TreeSet<ITemperature> sameMonth = new TreeSet<ITemperature>();

		// Makes sure that all countries added to the ans are UNIQUE
		HashSet<String> countries = new HashSet<String>();

		// Every Temperature that has the same country and year as the user provides is
		// added to the TreeSet.
		for (ITemperature tmp : allTemps) {
			if (tmp.getMonth().equals(monthsConverter.get(month))) {
				sameMonth.add(tmp);
			}
		}
		// The TreeSet is filed through an ArrayList.
		ArrayList<ITemperature> sameM = new ArrayList<ITemperature>(sameMonth);
		// Another ArrayList is created using the desired element of the original
		// TreeSet.
		ArrayList<ITemperature> ans = new ArrayList<ITemperature>();

		// Makes sure that all countries added to the ans are UNIQUE, starts at end
		int i = sameM.size() - 1;
		while (ans.size() != 10) {
			if (countries.add(sameM.get(i).getCountry())) {
				ans.add(sameM.get(i));
			}
			i--;
		}

		Collections.reverse(ans);

		// The file is created, a header is written, and the required data of the
		// Temperature object is written.
		writeSubjectHeaderInFile("climatedata/taskB1_climate_info.csv",
				"Task B1: Top 10 Highest Temperatures in All Countries in " + monthsConverter.get(month));
		writeDataToFile("climatedata/taskB1_climate_info.csv", ans);

		// The desired ArrayList<ITemperature> object is returned.
		return ans;
	}

	// Task B2: Returns a list of the top 10 lowest-temperatured Temperature objects
	// in unique countries.
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp() throws IOException {
		// Makes sure that all countries added to the ans are UNIQUE
		HashSet<String> countries = new HashSet<String>();

		// Created to sort all of the Temperature objects by temperature.
		TreeSet<ITemperature> allTemps1 = new TreeSet<ITemperature>(allTemps);

		// Created to get the desired Temperature objects in their ordered form.
		ArrayList<ITemperature> allTemps2 = new ArrayList<ITemperature>(allTemps1);

		// Another ArrayList is created using the desired element of the original
		// TreeSet.
		ArrayList<ITemperature> ans = new ArrayList<ITemperature>();

		// Makes sure that all countries added to the ans are UNIQUE, starts at
		// beginning
		int i = 0;
		while (ans.size() != 10) {
			if (countries.add(allTemps2.get(i).getCountry())) {
				ans.add(allTemps2.get(i));
			}
			i++;
		}

		// The file is created, a header is written, and the required data of the
		// Temperature object is written.
		writeSubjectHeaderInFile("climatedata/taskB2_climate_info.csv",
				"Task B2: Top 10 Lowest Temperatures in All Countries");
		writeDataToFile("climatedata/taskB2_climate_info.csv", ans);

		// The desired ArrayList<ITemperature> object is returned.
		return ans;
	}

	// Task B2: Returns a list of the top 10 highest-temperatured Temperature
	// objects in unique countries.
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp() throws IOException {

		// Makes sure that all countries added to the ans are UNIQUE
		HashSet<String> countries = new HashSet<String>();

		// Created to sort all of the Temperature objects by temperature.
		TreeSet<ITemperature> allTemps1 = new TreeSet<ITemperature>(allTemps);

		// Created to get the desired Temperature objects in their ordered form.
		ArrayList<ITemperature> allTemps2 = new ArrayList<ITemperature>(allTemps1);

		// Another ArrayList is created using the desired element of the original
		// TreeSet.
		ArrayList<ITemperature> ans = new ArrayList<ITemperature>();

		// Makes sure that all countries added to the ans are UNIQUE, starts at end
		int i = allTemps2.size() - 1;
		while (ans.size() != 10) {
			if (countries.add(allTemps2.get(i).getCountry())) {
				ans.add(allTemps2.get(i));
			}
			i--;
		}

		Collections.reverse(ans);

		// The file is created, a header is written, and the required data of the
		// Temperature object is written.
		writeSubjectHeaderInFile("climatedata/taskB2_climate_info.csv",
				"Task B2: Top 10 Highest Temperatures in All Countries");
		writeDataToFile("climatedata/taskB2_climate_info.csv", ans);

		// The desired ArrayList<ITemperature> object is returned.
		return ans;
	}

	// Task B3: Returns the Temperature objects in an ArrayList within a range of
	// temperatures.
	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp)
			throws IOException {
		// Created to sort all of the Temperature objects by temperature.
		TreeSet<ITemperature> withinRange = new TreeSet<ITemperature>();

		// Every Temperature that has the same country and within the range that the
		// user provides is added to the TreeSet.
		for (ITemperature tmp : allTemps) {
			if (tmp.getTemperature(false) >= lowRangeTemp && tmp.getTemperature(false) <= highRangeTemp) {
				withinRange.add(tmp);
			}
		}
		// The TreeSet is filed through an ArrayList.
		ArrayList<ITemperature> withinRange1 = new ArrayList<ITemperature>(withinRange);

		// The file is created, a header is written, and the required data of the
		// Temperature object is written.
		writeSubjectHeaderInFile("climatedata/taskB3_climate_info.csv",
				"Task B3: Temperatures in All Countries between " + lowRangeTemp + " and " + highRangeTemp);
		writeDataToFile("climatedata/taskB3_climate_info.csv", withinRange1);

		// The desired ArrayList<ITemperature> object is returned.
		return withinRange1;
	}

	// Task C1: Returns the top 10 Temperature object with the greatest changes in
	// temperature in a specified month between two specified years.
	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2) throws IOException {
		// Makes sure that all countries added to the ans are UNIQUE
		HashSet<String> countries = new HashSet<String>();

		// This represents all of the Temperature objects in the same month and one of
		// the years.
		ArrayList<ITemperature> sameMonthAndYears = new ArrayList<ITemperature>();
		// Those Temperature objects are filed through the ArrayList.
		for (ITemperature tmp : allTemps) {
			if (tmp.getMonth().equals(monthsConverter.get(month))
					&& (tmp.getYear() == year1 || tmp.getYear() == year2)) {
				sameMonthAndYears.add(tmp);
			}
		}
		// Another ArrayList is created to represent all of the Temperature objects with
		// their difference in Celsius.
		ArrayList<ITemperature> deltas = new ArrayList<ITemperature>();
		// Those delta-ed ITemperature objects are added to the ArrayList of delta-ed
		// Temperatures
		for (int i = 0; i < sameMonthAndYears.size() - 1; i += 2) {
			ITemperature temp1 = sameMonthAndYears.get(i);
			ITemperature temp2 = sameMonthAndYears.get(i + 1);

			double deltaTempC = Math.abs(temp1.getTemperature(false) - temp2.getTemperature(false));

			ITemperature delated = new Temperature(temp1.getCountry(), temp1.getCountry3LetterCode(), temp1.getMonth(),
					temp2.getYear() - temp1.getYear(), deltaTempC);
			deltas.add(delated);
		}

		// Those delta-ed Temperatures are filtered through a Tree Set to get sorted.
		TreeSet<ITemperature> sortedDeltas = new TreeSet<ITemperature>(deltas);

		ArrayList<ITemperature> sortedDeltas1 = new ArrayList<ITemperature>(sortedDeltas);

		ArrayList<ITemperature> ans = new ArrayList<ITemperature>();

		// Makes sure that all countries added to the ans are UNIQUE, starts at end and
		// adds objects until answer reaches 10
		int i = sortedDeltas1.size() - 1;
		while (ans.size() != 10) {
			if (countries.add(sortedDeltas1.get(i).getCountry())) {
				ans.add(sortedDeltas1.get(i));
			}
			i--;
		}

		Collections.reverse(ans);

		// The file is created, a header is written, and the required data of the
		// Temperature object is written.
		writeSubjectHeaderInFile("climatedata/taskC1_climate_info.csv",
				"Task C1: Temperature Deltas in All Countries in " + monthsConverter.get(month) + " between " + year1
						+ " and " + year2);
		writeDataToFile("climatedata/taskC1_climate_info.csv", ans);

		return ans;
	}

	public void runClimateAnalyzer() {
		Scanner in = new Scanner(System.in);

		// Testing getLowestTempByMonth -- A1
		try 
		{
			System.out.println("Find the lowest temperature in a certain country and month.");
			System.out.println("Enter a country:");
			String ctry1 = in.nextLine();
			int mo1 = 0;
			while (!allCountries.contains(ctry1)) 
			{
				System.out.println("Not a valid country! Please enter another country.");
				ctry1 = in.nextLine();
			}
			while(mo1 == 0)
			{
				try {
					System.out.println("Enter a numerical value for month (1-12):");
					mo1 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while (mo1 < 1 || mo1 > 12) 
			{
				try 
				{
					System.out.println("Not a valid month! Please enter another month (1-12).");
					mo1 = in.nextInt();
				} catch (InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			getLowestTempByMonth(ctry1, mo1);
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}

		// Testing getHighestTempByMonth -- A1
		try
		{
			System.out.println();
			System.out.println("Find the highest temperature in a certain country and month.");
			in.nextLine();
			System.out.println("Enter a country:");
			String ctry2 = in.nextLine();
			int mo2 = 0;
			while (!allCountries.contains(ctry2)) 
			{
				System.out.println("Not a valid country! Please enter another country.");
				ctry2 = in.nextLine();
			}
			while(mo2 == 0)
			{
				try {
					System.out.println("Enter a numerical value for month (1-12):");
					mo2 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while (mo2 < 1 || mo2 > 12) 
			{
				try
				{
					System.out.println("Not a valid month! Please enter another month (1-12).");
					mo2 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			getHighestTempByMonth(ctry2, mo2);
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}

		// Testing getLowestTempByYear -- A2
		try {
			System.out.println();
			System.out.println("Find the lowest temperature in a certain country and year.");
			in.nextLine();
			System.out.println("Enter a country:");
			String ctry3 = in.nextLine();
			int yr = 0;
			while(!allCountries.contains(ctry3))
			{
				System.out.println("Not a valid country! Please enter another country.");
				ctry3 = in.nextLine();
			}
			while(yr == 0) 
			{
				try 
				{
					System.out.println("Enter a year between 2000 and 2016:");
					yr = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while(yr < 2000 || yr > 2016)
			{
				try
				{
					System.out.println("Not a valid year. Please enter another year (2000-2016).");
					yr = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			getLowestTempByYear(ctry3, yr);
		} catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		// Testing getHighestTempByYear -- A2
		try {
			System.out.println();
			System.out.println("Find the highest temperature in a certain country and year.");
			in.nextLine();
			System.out.println("Enter a country:");
			String ctry4 = in.nextLine();
			int yr2 = 0;
			while(!allCountries.contains(ctry4))
			{
				System.out.println("Not a valid country! Please enter another country.");
				ctry4 = in.nextLine();
			}
			while(yr2 == 0)
			{
				try
				{
					System.out.println("Enter a year between 2000 and 2016:");
					yr2 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while(yr2 < 2000 || yr2 > 2016)
			{
				try
				{
					System.out.println("Not a valid year. Please enter another year (2000-2016).");
					yr2 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			getHighestTempByYear(ctry4, yr2);
		} catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		// Testing getTempWithinRange -- A3
		try {
			System.out.println();
			System.out.println("Find the all temperatures in a certain country and range.");
			in.nextLine();
			System.out.println("Enter a country:");
			String ctry5 = in.nextLine();
			double lowtmp = Double.MIN_VALUE;
			double hightmp = Double.MAX_VALUE;
			while(!allCountries.contains(ctry5))
			{
				System.out.println("Not a valid country! Please enter another country.");
				ctry5 = in.nextLine();
			}
			while(lowtmp == Double.MIN_VALUE)
			{
				try
				{
					System.out.println("Enter a low temperature range: ");
					lowtmp = in.nextDouble();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while(hightmp == Double.MAX_VALUE)
			{
				try
				{
					System.out.println("Enter a high temperature range: ");
					hightmp = in.nextDouble();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while(lowtmp > hightmp)
			{
				try
				{
					System.out.println("Invalid higher temperature! Entire a temp higher than the lower temperature.");
					hightmp = in.nextDouble();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			getTempWithinRange(ctry5, lowtmp, hightmp);
		} catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		// Testing getLowestTempYearByCountry -- A4
		try {
			System.out.println();
			System.out.println("Find the lowest temperature in a certain country.");
			in.nextLine();
			System.out.println("Enter a country:");
			String ctry6 = in.nextLine();
			while(!allCountries.contains(ctry6))
			{
				System.out.println("Not a valid country! Please enter another country.");
				ctry6 = in.nextLine();
			}
			getLowestTempYearByCountry(ctry6);
		} catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		// Testing getHighestTempYearByCountry -- A4
		try {
			System.out.println();
			System.out.println("Find the highest temperature in a certain country.");
			System.out.println("Enter a country:");
			String ctry7 = in.nextLine();
			while(!allCountries.contains(ctry7))
			{
				System.out.println("Not a valid country! Please enter another country.");
				ctry7 = in.nextLine();
			}
			getHighestTempYearByCountry(ctry7);
		} catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		// Testing allCountriesGetTop10LowestTemp(int month) -- B1
		try {
			System.out.println();
			System.out.println("Find the top 10 lowest temperatures in a certain month.");
			int mo3 = 0;
			while(mo3 == 0)
			{
				try
				{
					System.out.println("Enter a numerical value for month (1-12):");
					mo3 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while(mo3 < 1 || mo3 > 12)
			{
				try 
				{
					System.out.println("Not a valid month! Please enter another month (1-12).");
					mo3 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			allCountriesGetTop10LowestTemp(mo3);
		} catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		// Testing allCountriesGetTop10HighestTemp(int month) -- B1
		try {
			System.out.println();
			System.out.println("Find the top 10 highest temperature in a certain month.");
			int mo4 = 0;
			while(mo4 == 0)
			{
				try
				{
					System.out.println("Enter a numerical value for month (1-12):");
					mo4 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while(mo4 < 1 || mo4 > 12)
			{
				try
				{
					System.out.println("Not a valid month! Please enter another month (1-12).");
					mo4 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			allCountriesGetTop10HighestTemp(mo4);
		} catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		// Testing allCountriesGetTop10LowestTemp() -- B2
		System.out.println();
		System.out.println("Finding the top 10 lowest and highest temperatures from all countries (no input required)...");
		try {
			allCountriesGetTop10LowestTemp();
		} catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		// Testing allCountriesGetTop10HighestTemp() -- B2
		try {
			allCountriesGetTop10HighestTemp();
		} catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		// Testing allCountriesGetAllDataWithinTempRange() -- B3
		try {
			System.out.println();
			System.out.println("Find all countries with temperatures within a certain range.");
			double lowtmp2 = Double.MIN_VALUE;
			double hightmp2 = Double.MAX_VALUE;
			while(lowtmp2 == Double.MIN_VALUE)
			{
				try
				{
					System.out.println("Enter a low temperature range: ");
					lowtmp2 = in.nextDouble();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while(hightmp2 == Double.MAX_VALUE)
			{
				try 
				{
					System.out.println("Enter a high temperature range: ");
					hightmp2 = in.nextDouble();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while(lowtmp2 > hightmp2)
			{
				try
				{
					System.out.println("Invalid higher temperature! Entire a temp higher than the lower temperature.");
					hightmp2 = in.nextDouble();
				} catch (InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			allCountriesGetAllDataWithinTempRange(lowtmp2, hightmp2);
		} catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
		// Testing allCountriesTop10TempDelta -- C1
		try {
			System.out.println();
			System.out.println("Find the top 10 countries with the highest change in temperature in the same month.");
			int mo5 = 0;
			int year1 = 0;
			int year2 = 0;
			while(mo5 == 0)
			{
				try
				{
					System.out.println("Enter a numerical value for month: (1-12)");
					mo5 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while(mo5 < 1 || mo5 > 12)
			{
				try
				{
					System.out.println("Not a valid month! Please enter another month (1-12).");
					mo5 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while(year1 == 0)
			{
				try
				{
					System.out.println("Enter a lower range for a year (2000-2016):");
					year1 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while(year1 < 2000 || year1 > 2016)
			{
				try
				{
					System.out.println("Not a valid year. Please enter another year (2000-2016).");
					year1 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while(year2 == 0)
			{
				try
				{
					System.out.println("Enter a higher range for a year (2000-2016):");
					year2 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			while(year2 < 2000 || year2 > 2016)
			{
				try 
				{
					System.out.println("Not a valid year. Please enter another year (2000-2016).");
					year2 = in.nextInt();
				} catch(InputMismatchException i)
				{
					System.out.println("You entered the wrong type. Please enter a number. Try again!");
					in.next();
				}
			}
			allCountriesTop10TempDelta(mo5, year1, year2);
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		

		in.close();
	}

	public static void main(String[] args)
	{
		try {
			ClimateAnalyzer ca = new ClimateAnalyzer();
			ca.runClimateAnalyzer();
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

}
