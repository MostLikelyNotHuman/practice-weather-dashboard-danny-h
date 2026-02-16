package com.example.weather_app;

import com.example.weather_app.classes.CityWeather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class WeatherAppApplication {


	static RestTemplate restTemplate = new RestTemplate();

	public static void retrieveWeather(double lat, double lon, String cityName, String key) {
		CityWeather weather = restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + key, CityWeather.class);

		if (weather != null) {
			System.out.println("Weather report for " + cityName + ": \n" + weather.toString());
		} else {
			System.out.println("Unable to retrieve weather data for " + cityName);
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(WeatherAppApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Hello and welcome to the Weather Application. Please select a city to view the weather \n" +
					"Or view multiple summaries by entering multiple numbers separated by a space:\n" +
					"1. New York\n" +
					"2. London\n" +
					"3. Tokyo\n" +
					"4. Exit");
			String cityChoice = scanner.nextLine();
			String[] cityChoices = cityChoice.split(" ");
			if (!Arrays.asList(cityChoices).contains("1") && !Arrays.asList(cityChoices).contains("2") && !Arrays.asList(cityChoices).contains("3") && !Arrays.asList(cityChoices).contains("4")) {
				System.out.println("Invalid choice.");
			} else {
				if (Arrays.asList(cityChoices).contains("1")) {
					retrieveWeather(40.7128, -74.0060, "New York", System.getenv("OPENWEATHER_API_KEY"));
				}
				if (Arrays.asList(cityChoices).contains("2")) {
					retrieveWeather(51.5072, -0.1275, "London", System.getenv("OPENWEATHER_API_KEY"));
				}
				if (Arrays.asList(cityChoices).contains("3")) {
					retrieveWeather(35.6897, 139.6922, "Tokyo", System.getenv("OPENWEATHER_API_KEY"));
				}
				if (Arrays.asList(cityChoices).contains("4")) {
					System.out.println("Exiting application.");
					break;
				}
			}
		}

	}
}
