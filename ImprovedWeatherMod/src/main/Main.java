package main;

import java.util.Random;

public class Main {

	private static String[] windDirection = {"North", "South", "East", "West", "Northeast", "Northwest", "Southeast", "Southwest"};

	public static void main(String[] args) {
		//int ws = 15; // Wind speed in mph
		//int T = 60; // Temperature in F
		//int RH = 50; // Relative humidity as a whole number; 50 = 50%
		//int wc = T; // Wind chill temperature, default is same as temperature
		//int hi = T; // Heat index temperature, default is same as temperature
		int season = 3; // Each chunk is in the same season, so this is a global var; 1 = winter, 2 = spring, 3 = summer, 4 = fall	

		//System.out.println("Temperature is: " + T);
		
		westCoastChunk(season);
		System.out.println("");
		southChunk(season);
		System.out.println("");
		midwestChunk(season);
		System.out.println("");
		southWestChunk(season);
		System.out.println("");
		northEastChunk(season);
		// Pushing
		
	}

	private static boolean isPrecipitating(double randPrecip, double precipRate, int T, int RH) {
		boolean isPrecipitating = false;

		if(randPrecip <= precipRate && T <= 32) {
			isPrecipitating = true;
			System.out.println("It is snowing");
		}
		else if(randPrecip <= precipRate && T > 32) {
			isPrecipitating = true;
			if(T >= 75 && RH >= 65) {
				System.out.println("Thunderstorms in the area");
			}
			else {
				System.out.println("It is raining");
			}
		}
		else {
			isPrecipitating = false;
			System.out.println("It is not raining");
		}

		return isPrecipitating;
	}

	// Calculate wind chill temperature
	private static int windChillTemperature(int T, int ws) {
		int wc = T;
		// Wind chill only takes place if temperature is 50 degrees or colder
		if(T <= 50) {
			wc = (int) (35.74 + (0.6215 * T) - (35.75 * Math.pow(ws, 0.16)) + (0.4275 * T * Math.pow(ws, 0.16)));
		}
		System.out.println("Wind chill temperature is: " + wc);
		return wc;
	}

	private static int heatIndexTemperature(int T, int RH) {
		int hi = T;
		// Heat index only takes place if temperature is 80 degrees or hotter
		if(RH >= 40) {
			hi = (int) (0.5 * (T + 61.0 + ((T-68.0)*1.2) + (RH*0.094)));

			if(hi >= 80) {
				hi = (int)(-42.379 + 2.04901523*T + 10.14333127*RH - .22475541*T*RH - .00683783*T*T - .05481717*RH*RH + .00122874*T*T*RH + .00085282*T*RH*RH - .00000199*T*T*RH*RH);
			}
		}
		System.out.println("Heat index is: " + hi);
		return hi;
	}

	// We want to define some chunks. We will start with broad chunks.
	// Chunks = [West Coast, Mountains, Southwest, Great Plains, South, Northeast]

	// Define the West Coast chunk
	private static void westCoastChunk(int season) {

		//Different behavior based on what season we're in

		System.out.println("Conditions based off of Seattle, WA");

		if(season == 1) {
			// We want a wind direction; in winter the wind at the surface comes from the southwest typically, but can sometimes come from the north
			// We have 8 directions, and we know that one has more of a chance of occuring than the others

			double randPrecip = Math.random();

			int minRH = 75;
			int maxRH = 80;

			int minSpeed = 5;
			int maxSpeed = 20;

			int ws = (int)Math.floor(Math.random()*(maxSpeed - minSpeed + 1) + minSpeed);
			System.out.println("Wind speed is: " + ws);


			int minTemp = 32;
			int maxTemp = 49;

			int T = (int)Math.floor(Math.random()*(maxTemp - minTemp + 1) + minTemp);
			System.out.println("Thermometer temperature is: " + T);

			int RH = (int)Math.floor(Math.random()*(maxRH - minRH + 1) + minRH);
			System.out.println("RH is: " + RH);

			windChillTemperature(T, ws);
			isPrecipitating(randPrecip, 0.44, T, RH);

		}

		else if(season == 2) {

			double randPrecip = Math.random();
			int minTemp = 42;
			int maxTemp = 63;

			int minRH = 69;
			int maxRH = 74;

			int minSpeed = 5;
			int maxSpeed = 15;

			int ws = (int)Math.floor(Math.random()*(maxSpeed - minSpeed + 1) + minSpeed);
			System.out.println("Wind speed is: " + ws);

			int T = (int)Math.floor(Math.random()*(maxTemp - minTemp + 1) + minTemp);
			System.out.println("Thermometer temperature is: " + T);

			int RH = (int)Math.floor(Math.random()*(maxRH - minRH + 1) + minRH);
			System.out.println("RH is: " + RH);

			windChillTemperature(T, ws);
			isPrecipitating(randPrecip, 0.33, T, RH);
		}

		else if(season == 3) {
			
			double randPrecip = Math.random();
			int minRH = 50;
			int maxRH = 60;

			int minTemp = 54;
			int maxTemp = 85;

			int T = (int)Math.floor(Math.random()*(maxTemp - minTemp + 1) + minTemp);
			System.out.println("Thermometer temperature is: " + T);

			int RH = (int)Math.floor(Math.random()*(maxRH - minRH + 1) + minRH);
			System.out.println("RH is: " + RH);

			heatIndexTemperature(T, RH);
			isPrecipitating(randPrecip, 0.14, T, RH);
		}

		else if(season == 4) {

		}

	}

	private static void southChunk(int season) {

		//Different behavior based on what season we're in

		System.out.println("Conditions based off of Orlando, FL");

		if(season == 1) {

			double randPrecip = Math.random();

			int minRH = 74;
			int maxRH = 77;

			int minTemp = 51;
			int maxTemp = 79;

			int T = (int)Math.round(Math.random()*(maxTemp - minTemp + 1) + minTemp);
			System.out.println("Thermometer temperature is: " + T);

			int RH = (int)Math.round(Math.random()*(maxRH - minRH + 1) + minRH);
			System.out.println("RH is: " + RH);

			heatIndexTemperature(T, RH);
			isPrecipitating(randPrecip, 0.13, T, RH);

		}

		else if(season == 2) {

		}

		else if(season == 3) {

			double randPrecip = Math.random();

			int minRH = 76;
			int maxRH = 79;

			int minTemp = 73;
			int maxTemp = 92;

			int T = (int)Math.floor(Math.random()*(maxTemp - minTemp + 1) + minTemp);
			System.out.println("Thermometer temperature is: " + T);

			int RH = (int)Math.floor(Math.random()*(maxRH - minRH + 1) + minRH);
			System.out.println("RH is: " + RH);

			heatIndexTemperature(T, RH);
			isPrecipitating(randPrecip, 0.43, T, RH);
		}

		else if(season == 4) {

		}

	}

	private static void midwestChunk(int season) {

		System.out.println("Conditions based off of Des Moines, IA");

		if(season == 1) {
			// We want a wind direction; in winter the wind at the surface comes from the southwest typically, but can sometimes come from the north
			// We have 8 directions, and we know that one has more of a chance of occuring than the others

			double randPrecip = Math.random();

			int minRH = 71;
			int maxRH = 75;

			int minSpeed = 9;
			int maxSpeed = 20;

			int minTemp = 13;
			int maxTemp = 35;

			int T = (int)Math.floor(Math.random()*(maxTemp - minTemp + 1) + minTemp);
			System.out.println("Thermometer temperature is: " + T);

			int ws = (int)Math.floor(Math.random()*(maxSpeed - minSpeed + 1) + minSpeed);
			System.out.println("Wind speed is: " + ws);

			int RH = (int)Math.floor(Math.random()*(maxRH - minRH + 1) + minRH);
			System.out.println("RH is: " + RH);

			windChillTemperature(T, ws);
			isPrecipitating(randPrecip, 0.16, T, RH);

		}

		else if(season == 2) {

		}

		else if(season == 3) {

			double randPrecip = Math.random();

			int minRH = 57;
			int maxRH = 65;

			int minTemp = 62;
			int maxTemp = 86;

			int T = (int)Math.floor(Math.random()*(maxTemp - minTemp + 1) + minTemp);
			System.out.println("Thermometer temperature is: " + T);

			int RH = (int)Math.floor(Math.random()*(maxRH - minRH + 1) + minRH);
			System.out.println("RH is: " + RH);

			heatIndexTemperature(T, RH);
			isPrecipitating(randPrecip, 0.24, T, RH);
		}
	}
	
	private static void southWestChunk(int season) {

		System.out.println("Conditions based off of Phoenix, AZ");

		if(season == 1) {
			// We want a wind direction; in winter the wind at the surface comes from the southwest typically, but can sometimes come from the north
			// We have 8 directions, and we know that one has more of a chance of occuring than the others

			double randPrecip = Math.random();

			int minRH = 42;
			int maxRH = 50;

			int minSpeed = 2;
			int maxSpeed = 6;

			int minTemp = 44;
			int maxTemp = 72;

			int T = (int)Math.floor(Math.random()*(maxTemp - minTemp + 1) + minTemp);
			System.out.println("Thermometer temperature is: " + T);

			int ws = (int)Math.floor(Math.random()*(maxSpeed - minSpeed + 1) + minSpeed);
			System.out.println("Wind speed is: " + ws);

			int RH = (int)Math.floor(Math.random()*(maxRH - minRH + 1) + minRH);
			System.out.println("RH is: " + RH);

			windChillTemperature(T, ws);
			isPrecipitating(randPrecip, 0.08, T, RH);

		}

		else if(season == 2) {

		}

		else if(season == 3) {

			double randPrecip = Math.random();

			int minRH = 20;
			int maxRH = 38;

			int minTemp = 76;
			int maxTemp = 106;

			int T = (int)Math.floor(Math.random()*(maxTemp - minTemp + 1) + minTemp);
			System.out.println("Thermometer temperature is: " + T);

			int RH = (int)Math.floor(Math.random()*(maxRH - minRH + 1) + minRH);
			System.out.println("RH is: " + RH);

			heatIndexTemperature(T, RH);
			isPrecipitating(randPrecip, 0.04, T, RH);
		}
		else if(season == 4){
			
		}
	}
	
	private static void northEastChunk(int season) {

		System.out.println("Conditions based off of New York, NY");

		if(season == 1) {
			// We want a wind direction; in winter the wind at the surface comes from the southwest typically, but can sometimes come from the north
			// We have 8 directions, and we know that one has more of a chance of occuring than the others

			double randPrecip = Math.random();

			int minRH = 60;
			int maxRH = 62;

			int minSpeed = 10;
			int maxSpeed = 20;

			int minTemp = 26;
			int maxTemp = 44;

			int T = (int)Math.floor(Math.random()*(maxTemp - minTemp + 1) + minTemp);
			System.out.println("Thermometer temperature is: " + T);

			int ws = (int)Math.floor(Math.random()*(maxSpeed - minSpeed + 1) + minSpeed);
			System.out.println("Wind speed is: " + ws);

			int RH = (int)Math.floor(Math.random()*(maxRH - minRH + 1) + minRH);
			System.out.println("RH is: " + RH);

			windChillTemperature(T, ws);
			isPrecipitating(randPrecip, 0.26, T, RH);

		}

		else if(season == 2) {

		}

		else if(season == 3) {

			double randPrecip = Math.random();

			int minRH = 62;
			int maxRH = 65;

			int minTemp = 63;
			int maxTemp = 87;

			int T = (int)Math.floor(Math.random()*(maxTemp - minTemp + 1) + minTemp);
			System.out.println("Thermometer temperature is: " + T);

			int RH = (int)Math.floor(Math.random()*(maxRH - minRH + 1) + minRH);
			System.out.println("RH is: " + RH);

			heatIndexTemperature(T, RH);
			isPrecipitating(randPrecip, 0.26, T, RH);
		}
	}
	
	// FOR THE FUTURE--------
	// Boston's climate will be related to that of New York's. Boston's temperature will equal New York - 2 while its wind speed will equal New York + 2
	// This way weather can be further regionalized without declaring new classes
}
