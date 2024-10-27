import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Destination {
    private String name;
    private String date;
    private String preferences;
    private double budget;

    public Destination(String name, String date, String preferences, double budget) {
        this.name = name;
        this.date = date;
        this.preferences = preferences;
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return String.format("Destination: %s%nDate: %s%nPreferences: %s%nBudget: $%.2f%n",
                name, date, preferences, budget);
    }

    public String getWeatherInfo() {
        // Simulated weather information
        return "Weather at " + name + " on " + date + ": Sunny, 75°F.";
    }

    public String getMapLink() {
        // Simulated map link
        return "Map link for " + name + ": [Simulated Map Link]";
    }
}

public class TravelItineraryPlanner {
    private List<Destination> itinerary;

    public TravelItineraryPlanner() {
        itinerary = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
        System.out.println("Destination added!");
    }

    public void displayItinerary() {
        System.out.println("\n--- Travel Itinerary ---");
        if (itinerary.isEmpty()) {
            System.out.println("No destinations added.");
            return;
        }
        for (Destination destination : itinerary) {
            System.out.println(destination);
            System.out.println(destination.getWeatherInfo());
            System.out.println(destination.getMapLink());
        }
    }

    public double calculateTotalBudget() {
        double total = 0.0;
        for (Destination destination : itinerary) {
            total += destination.getBudget();
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelItineraryPlanner planner = new TravelItineraryPlanner();
        int choice;

        do {
            System.out.println("\n--- Travel Itinerary Planner ---");
            System.out.println("1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter destination name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter travel date (e.g., YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter your preferences (e.g., beach, city, etc.): ");
                    String preferences = scanner.nextLine();
                    System.out.print("Enter budget for this destination: ");
                    double budget = scanner.nextDouble();
                    planner.addDestination(new Destination(name, date, preferences, budget));
                    break;
                case 2:
                    planner.displayItinerary();
                    break;
                case 3:
                    double totalBudget = planner.calculateTotalBudget();
                    System.out.printf("Total Budget for the trip: $%.2f%n", totalBudget);
                    break;
                case 4:
                    System.out.println("Exiting the application. Safe travels!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
