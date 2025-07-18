# Weather App - Java GUI Project

A simple and stylish Java GUI application to fetch real-time weather data using the OpenWeatherMap API.  
This project demonstrates API integration, JSON parsing, exception handling, and a user-friendly interface using Java Swing.

# Features
- Input city name via GUI
- Fetch real-time temperature, humidity, and weather description
- Stylish and responsive GUI using Java Swing
- Exception handling for invalid or unknown city names
- Integration with OpenWeatherMap API using HTTP requests
- Displays error messages if the city is not found

# Technologies Used
- Java
- Java Swing (for GUI)
- HTTP API requests
- JSON parsing using `org.json` library

# Project Structure
WeatherApp Project/
│
├── WeatherGUI.java
├── json-20210307.jar
├── README.md


# Setup Instructions

Prerequisites:
- Java JDK installed
- Download JSON library: [json-20210307.jar](https://repo1.maven.org/maven2/org/json/json/20210307/json-20210307.jar)

# Compile the Project:
If the JAR is in the same folder:
```bash
javac -cp ".;json-20210307.jar" WeatherGUI.java

> Run the Project:
If the JAR is in the same folder: java -cp ".;json-20210307.jar" WeatherGUI
If the JAR is in a lib folder: java -cp ".;lib/json-20210307.jar" WeatherGUI

---
##Sample UI:

+-----------------------------+
|        Weather App          |
|                             |
|  Enter City:  [ Hyderabad ] |
|                             |
|         [ Get Weather ]     |
|                             |
|  City: Hyderabad            |
|  Temp: 24.8°C               |
|  Weather: overcast clouds   |
|  Humidity: 79%              |
+-----------------------------+

---

Example Output

Correct Input:
When you enter a valid city like Hyderabad, the app shows:
City: Hyderabad
Temperature: 24.8 °C
Weather: overcast clouds
Humidity: 79%

Incorrect Input:
When you enter an invalid city name like UnknownCity123:
City not found. Please enter a valid city name.

Empty Input:
When you click the button without entering a city:
Please enter a city name.


# Future Improvements
-Add loading spinner while fetching data

-Add country selection

-Use modern JavaFX for more advanced UI

-Add unit testing for API and exception handling


---

# Author
MS Abhishek

---

# API Source
OpenWeatherMap API
