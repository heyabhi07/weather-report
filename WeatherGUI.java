// WeatherGUI.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;

public class WeatherGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Weather App");
        frame.setSize(450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(135, 206, 250)); // Light sky blue background

        JLabel titleLabel = new JLabel("Weather App");
        titleLabel.setBounds(150, 10, 200, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        frame.add(titleLabel);

        JLabel cityLabel = new JLabel("Enter City:");
        cityLabel.setBounds(50, 60, 100, 25);
        cityLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(cityLabel);

        JTextField cityField = new JTextField();
        cityField.setBounds(150, 60, 200, 25);
        frame.add(cityField);

        JButton fetchButton = new JButton("Get Weather");
        fetchButton.setBounds(150, 100, 150, 30);
        fetchButton.setBackground(new Color(0, 123, 255));
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(fetchButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(50, 150, 330, 120);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 14));
        resultArea.setBackground(new Color(224, 255, 255)); // Light cyan background
        frame.add(resultArea);

        fetchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String city = cityField.getText();
                if (!city.isEmpty()) {
                    String weatherData = fetchWeather(city);
                    resultArea.setText(weatherData);
                } else {
                    resultArea.setText("Please enter a city name.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static String fetchWeather(String city) {
        String apiKey = "f398aaaeb9236a01d6821a681beeb68e"; // Replace with your API Key
        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                return "City not found. Please enter a valid city name.";
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
            reader.close();

            JSONObject obj = new JSONObject(result.toString());
            String cityName = obj.getString("name");
            double temperature = obj.getJSONObject("main").getDouble("temp");
            int humidity = obj.getJSONObject("main").getInt("humidity");
            JSONArray weatherArray = obj.getJSONArray("weather");
            String description = weatherArray.getJSONObject(0).getString("description");

            return "City: " + cityName +
                   "\nTemperature: " + temperature + " °C" +
                   "\nWeather: " + description +
                   "\nHumidity: " + humidity + "%";

        } catch (Exception e) {
            return "Error: Please enter a valid city name.";
        }
    }
}
