package ru.journalofracer.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WeatherResponse {
/**
* {"coord":{"lon":37.7708,"lat":44.7239},
* "weather":[{"id":802,"main":"Clouds","description":"переменная облачность","icon":"03n"}],
* "base":"stations",
* "main":{"temp":28.25,"feels_like":29.83,"temp_min":28.25,"temp_max":28.25,"pressure":1009,"humidity":60,"sea_level":1009,"grnd_level":989},
* "visibility":10000,
* "wind":{"speed":1.58,"deg":107,"gust":1.87},
* "clouds":{"all":41},
* "dt":1721171142,
* "sys":{"type":1,"id":8962,"country":"RU","sunrise":1721181561,"sunset":1721236224},
* "timezone":10800,"id":518255,"name":"Новороссийск","cod":200}
*/
    private Coord coord;
    private List<Weather> weather;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int id;
    private String name;

    public double getLon() {
        return coord.getLon();
    }
    public double getLat() {
        return coord.getLat();
    }
    public double getTemp(){return main.getTemp();}
    public double getFeelsLike(){return main.getFeelsLike();}
    public double getPressure(){return main.getPressure();}
    public int getHumidity(){return main.getHumidity();}
    public double getTempMin(){return main.getTempMin();}
    public double getTempMax(){return main.getTempMax();}
    public int getIdWeather(){return weather.get(0).getId();}
    public String getMain(){return weather.get(0).getMain();}
    public String getDescription(){return weather.get(0).getDescription();}
    public String getIcon(){return weather.get(0).getIcon();}
    public String getCountry(){return sys.getCountry();}
    public double getSpeed(){return wind.getSpeed();}
    public int getDeg(){return wind.getDeg();}
    public int getAll(){return clouds.getAll();}

}
//"coord":{"lon":37.7708,"lat":44.7239}
@Data
class Coord {
    private double lon;
    private double lat;
}
//"weather":[{"id":802,"main":"Clouds","description":"переменная облачность","icon":"03n"}]
@Data
class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
//"main":{"temp":28.25,"feels_like":29.83,"temp_min":28.25,"temp_max":28.25,"pressure":1009,"humidity":60,"sea_level":1009,"grnd_level":989}
@Data
class Main {
    private double temp;
    private double feelsLike;
    private double pressure;
    private int humidity;
    private double tempMin;
    private double tempMax;
}
//"wind":{"speed":1.58,"deg":107,"gust":1.87}
@Data
class Wind {
    private double speed;
    private int deg;
}

@Data
class Clouds {
    private int all;
}
//"sys":{"type":1,"id":8962,"country":"RU","sunrise":1721181561,"sunset":1721236224}
@Data
class Sys {
    private String country;
}

