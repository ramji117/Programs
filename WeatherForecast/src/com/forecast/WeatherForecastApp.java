package com.forecast;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class WeatherForecastApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the city name: ");
        String city = scanner.nextLine();

        try {
            String apiKey = "Your Api Id";
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                Scanner responseScanner = new Scanner(inputStream);
                StringBuilder response = new StringBuilder();

                while (responseScanner.hasNextLine()) {
                    response.append(responseScanner.nextLine());
                }

                responseScanner.close();

                // Parse the JSON response using Gson
                Gson gson = new Gson();
                WeatherData weatherData = gson.fromJson(response.toString(), WeatherData.class);

                System.out.println("Weather forecast for " + city + ":");
                System.out.println("Temperature: " + weatherData.getMain().getTemp() + " °C");
                System.out.println("Humidity: " + weatherData.getMain().getHumidity() + "%");
                System.out.println("Weather: " + weatherData.getWeather().get(0).getDescription());
            } else {
                System.out.println("Failed to fetch weather data. Please try again later.");
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WeatherData {
    private MainData main;
    private java.util.List<Weather> weather;

    public MainData getMain() {
        return main;
    }

    public void setMain(MainData main) {
        this.main = main;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }
}

class MainData {
    private double temp;
    private int humidity;

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}

class Weather {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
