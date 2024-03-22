import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class City {
    private String cityName;
    private List<Double> temperatureRecords;

    public City(String cityName) {
        this.cityName = cityName;
        this.temperatureRecords = new ArrayList<>();
    }

    public void addTemperatureRecord(double temperature) {
        temperatureRecords.add(temperature);
    }

    public List<Double> getTemperatureRecords() {
        return temperatureRecords;
    }

    public double getAverageTemperature() {
        if (temperatureRecords.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double temperature : temperatureRecords) {
            sum += temperature;
        }
        return sum / temperatureRecords.size();
    }

    public String getCityName() {
        return cityName;
    }
}

public class TemperatureTracker {
    private Map<String, City> cities;

    public TemperatureTracker() {
        this.cities = new HashMap<>();
    }

    public void addCity(String cityName) {
        cities.put(cityName, new City(cityName));
    }

    public void addTemperatureRecord(String cityName, double temperature) {
        City city = cities.get(cityName);
        if (city != null) {
            city.addTemperatureRecord(temperature);
            System.out.println("Temperature record added for " + cityName);
        } else {
            System.out.println("City not found: " + cityName);
        }
    }

    public void displayCityTemperatureRecords(String cityName) {
        City city = cities.get(cityName);
        if (city != null) {
            List<Double> temperatureRecords = city.getTemperatureRecords();
            System.out.println("Temperature records for " + cityName + ": " + temperatureRecords);
            System.out.println("Average temperature: " + city.getAverageTemperature());
        } else {
            System.out.println("City not found: " + cityName);
        }
    }

    public static void main(String[] args) {
        TemperatureTracker tracker = new TemperatureTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add City");
            System.out.println("2. Add Temperature Record");
            System.out.println("3. Display City Temperature Records");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter city name: ");
                    String cityName = scanner.nextLine();
                    tracker.addCity(cityName);
                    break;

                case 2:
                    System.out.print("Enter city name: ");
                    cityName = scanner.nextLine();
                    System.out.print("Enter temperature: ");
                    double temperature = scanner.nextDouble();
                    tracker.addTemperatureRecord(cityName, temperature);
                    break;

                case 3:
                    System.out.print("Enter city name: ");
                    cityName = scanner.nextLine();
                    tracker.displayCityTemperatureRecords(cityName);
                    break;

                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
