package com.example.weather_app.classes;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class CityWeather {

    private HashMap<String, Double> coord = new HashMap<>();
    private List<HashMap<String, Object>> weather;
    private String base;
    private HashMap<String, Double> main = new HashMap<>();
    private int visibility;
    private HashMap<String, Object> wind = new HashMap<>();
    private HashMap<String, Object> rain = new HashMap<>();
    private HashMap<String, Object> clouds = new HashMap<>();
    private int dt;
    private HashMap<String, Object> sys = new HashMap<>();
    private int timezone;
    private int id;
    private String name;
    private int cod;

    public HashMap<String, Double> getCoord() {
        return coord;
    }

    public void setCoord(HashMap<String, Double> coord) {
        this.coord = coord;
    }

    public List<HashMap<String, Object>> getWeather() {
        return weather;
    }

    public void setWeather(List<HashMap<String, Object>> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public HashMap<String, Double> getMain() {
        return main;
    }

    public void setMain(HashMap<String, Double> main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public HashMap<String, Object> getWind() {
        return wind;
    }

    public void setWind(HashMap<String, Object> wind) {
        this.wind = wind;
    }

    public HashMap<String, Object> getRain() {
        return rain;
    }

    public void setRain(HashMap<String, Object> rain) {
        this.rain = rain;
    }

    public HashMap<String, Object> getClouds() {
        return clouds;
    }

    public void setClouds(HashMap<String, Object> clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public HashMap<String, Object> getSys() {
        return sys;
    }

    public void setSys(HashMap<String, Object> sys) {
        this.sys = sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    //The API returns the temperature in KELVIN??????
    public double getTemperatureInFahrenheit() {
        double tempInKelvin = main.get("temp");
        DecimalFormat df = new DecimalFormat("#.#");
        String tempInFahrenheit = df.format((tempInKelvin - 273.15) * 9/5 + 32);
        return Double.parseDouble(tempInFahrenheit);
    }

    @Override
    public String toString() {
        return "The current weather is " + weather.get(0).get("description") + " with a temperature of " + getTemperatureInFahrenheit() + " degrees Fahrenheit and a humidity of " + main.get("humidity") + "%.";
    }
}

