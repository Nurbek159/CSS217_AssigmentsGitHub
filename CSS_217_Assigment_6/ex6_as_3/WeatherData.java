package ex6_as_3;

// Common data model used by the mobile application
class WeatherData {
    private String location;
    private double temperature;
    private double humidity;
    private String description;

    // Getters and setters
    public void setLocation(String location) {
        this.location = location;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public String getDescription() {
        return description;
    }
}

// Interface for the weather API adapters
interface WeatherAPIAdapter {
    WeatherData getWeatherData(String location);
}

// Placeholder class for API 1 Service
class API1Service {
    public API1WeatherData getWeatherData(String location) {
        // Dummy implementation, replace with actual API logic
        API1WeatherData data = new API1WeatherData();
        data.setCity(location);
        data.setTemperature(25.0);
        data.setHumidity(60.0);
        data.setWeatherCondition("Sunny");
        return data;
    }
}

// Placeholder class for API 1 Weather Data
class API1WeatherData {
    private String city;
    private double temperature;
    private double humidity;
    private String weatherCondition;

    // Getters and setters
    public void setCity(String city) {
        this.city = city;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public String getCity() {
        return city;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }
}

// Adapter for API 1
class API1Adapter implements WeatherAPIAdapter {
    private API1Service api1Service;

    public API1Adapter(API1Service api1Service) {
        this.api1Service = api1Service;
    }

    @Override
    public WeatherData getWeatherData(String location) {
        API1WeatherData api1WeatherData = api1Service.getWeatherData(location);
        WeatherData weatherData = new WeatherData();
        weatherData.setLocation(api1WeatherData.getCity());
        weatherData.setTemperature(api1WeatherData.getTemperature());
        weatherData.setHumidity(api1WeatherData.getHumidity());
        weatherData.setDescription(api1WeatherData.getWeatherCondition());
        return weatherData;
    }
}

// Placeholder class for API 2 Service
class API2Service {
    public API2WeatherData fetchWeatherData(String location) {
        // Dummy implementation, replace with actual API logic
        API2WeatherData data = new API2WeatherData();
        data.setPlace(location);
        data.setTemp(20.0);
        data.setHumidity(40.0);
        data.setCondition("Cloudy");
        return data;
    }
}

// Placeholder class for API 2 Weather Data
class API2WeatherData {
    private String place;
    private double temp;
    private double humidity;
    private String condition;

    // Getters and setters
    public void setPlace(String place) {
        this.place = place;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPlace() {
        return place;
    }

    public double getTemp() {
        return temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public String getCondition() {
        return condition;
    }
}

// Adapter for API 2
class API2Adapter implements WeatherAPIAdapter {
    private API2Service api2Service;

    public API2Adapter(API2Service api2Service) {
        this.api2Service = api2Service;
    }

    @Override
    public WeatherData getWeatherData(String location) {
        API2WeatherData api2WeatherData = api2Service.fetchWeatherData(location);
        WeatherData weatherData = new WeatherData();
        weatherData.setLocation(api2WeatherData.getPlace());
        weatherData.setTemperature(api2WeatherData.getTemp());
        weatherData.setHumidity(api2WeatherData.getHumidity());
        weatherData.setDescription(api2WeatherData.getCondition());
        return weatherData;
    }
}