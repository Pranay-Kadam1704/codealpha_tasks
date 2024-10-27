import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    private String type;
    private double price; // Price in INR
    private boolean isAvailable;

    public Room(String type, double price) {
        this.type = type;
        this.price = price;
        this.isAvailable = true;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void reserve() {
        isAvailable = false;
    }
}

class Reservation {
    private String userName;
    private Room room;
    private String checkIn;
    private String checkOut;

    public Reservation(String userName, Room room, String checkIn, String checkOut) {
        this.userName = userName;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getDetails() {
        return "User: " + userName + ", Room Type: " + room.getType() +
               ", Check-in: " + checkIn + ", Check-out: " + checkOut +
               ", Total Price: " + room.getPrice();
    }
}

public class HotelReservationSystem {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public HotelReservationSystem() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room("Standard", 3000.0)); // Price in INR
        rooms.add(new Room("Deluxe", 5000.0));
        rooms.add(new Room("Suite", 8000.0));
    }

    public void searchAvailableRooms() {
        System.out.println("Available Rooms:");
        boolean found = false;
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room.getType() + " - " + room.getPrice());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No rooms available.");
        }
    }

    public void makeReservation(String userName, String roomType, String checkIn, String checkOut) {
        for (Room room : rooms) {
            if (room.getType().equalsIgnoreCase(roomType) && room.isAvailable()) {
                room.reserve();
                Reservation reservation = new Reservation(userName, room, checkIn, checkOut);
                reservations.add(reservation);
                System.out.println("Reservation successful: " + reservation.getDetails());
                return;
            }
        }
        System.out.println("Room not available.");
    }

    public void viewBookingDetails() {
        System.out.println("Current Reservations:");
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        for (Reservation reservation : reservations) {
            System.out.println(reservation.getDetails());
        }
    }

    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Search Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    system.searchAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter room type: ");
                    String roomType = scanner.nextLine();
                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    String checkIn = scanner.nextLine();
                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    String checkOut = scanner.nextLine();
                    system.makeReservation(userName, roomType, checkIn, checkOut);
                    break;
                case 3:
                    system.viewBookingDetails();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
