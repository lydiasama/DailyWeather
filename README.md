# DailyWeather

Daily Weather Application is for get temperature of current time.
And it can forecast the weather for you for 1 day.

# Usage
## 1. Input your city
[![Screenshot_2018-06-24-22-01-00-47.md.png](https://www.img.live/images/2018/06/24/Screenshot_2018-06-24-22-01-00-47.md.png)](https://www.img.live/image/Vmvjq)

## 2. You will see how's the weather from your current time.
[![Screenshot_2018-06-24-22-01-06-59.md.png](https://www.img.live/images/2018/06/24/Screenshot_2018-06-24-22-01-06-59.md.png)](https://www.img.live/image/q47a4)
* You can toggle the unit between Celsius and Fahrenheit by tap on the button that is on the top-right of screen.
* You can tap on the button **WHOLE-DAY FORECAST** for show the weather forecast for 1 day.

## 3. The whole-day forecast
[![Screenshot_2018-06-24-22-01-10-86.md.png](https://www.img.live/images/2018/06/24/Screenshot_2018-06-24-22-01-10-86.md.png)](https://www.img.live/image/q4ajY)
* It will show you a list of the weather forecast count up from your current time for 24 hours.

# Reuse and Customize
```const val API_URL = "http://api.openweathermap.org/data/2.5/"
const val API_KEY = "a5785043086e07a8483a305abf1b4742"
const val API_MODE = "json"
const val CELSIUS_UNIT = "metric"
const val FAHRENHEIT_UNIT = "imperial"
const val DEFAULT_UNIT = CELSIUS_UNIT
const val FORECAST_DAY = 1   // between 1-5```
* You can customize for your own app by replace your API_KEY, Change your default unit, Change the number of day you want to forecast.
* But if yout want to forecast more than 5 days you must change the url of API. [see more](https://openweathermap.org/api)


# API Reference
[OpenWeatherMap](https://openweathermap.org/)