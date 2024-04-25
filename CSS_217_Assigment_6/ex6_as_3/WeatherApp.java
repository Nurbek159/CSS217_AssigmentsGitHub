package ex6_as_3;

// Client code (mobile application)
public class WeatherApp {
    private WeatherAPIAdapter weatherAPIAdapter;

    public WeatherApp(WeatherAPIAdapter weatherAPIAdapter) {
        this.weatherAPIAdapter = weatherAPIAdapter;
    }

    public void displayWeatherData(String location) {
        try {
            WeatherData weatherData = weatherAPIAdapter.getWeatherData(location);
            System.out.println("Weather in " + weatherData.getLocation() + ":");
            System.out.println("Temperature: " + weatherData.getTemperature() + "°C");
            System.out.println("Humidity: " + weatherData.getHumidity() + "%");
            System.out.println("Description: " + weatherData.getDescription());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        WeatherAPIAdapter api1Adapter = new API1Adapter(new API1Service());
        WeatherApp app1 = new WeatherApp(api1Adapter);
        app1.displayWeatherData("New York");

        WeatherAPIAdapter api2Adapter = new API2Adapter(new API2Service());
        WeatherApp app2 = new WeatherApp(api2Adapter);
        app2.displayWeatherData("San Francisco");
    }
}