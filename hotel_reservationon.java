import java.util.Scanner;
class run
{
    public static void main(String[] args)
    {
        Hotel hotel = new Hotel(5);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do
        {
            System.out.println("\nHotel Reservation System Menu:");
            System.out.println("1. Make a Reservation");
            System.out.println("2. View Reservations");
            System.out.println("3. View Available Rooms");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    String contact = scanner.nextLine();
                    Customer customer = new Customer(name, contact);

                    System.out.print("Enter room type (Single): ");
                    String roomType = scanner.nextLine();
                    System.out.print("Enter check-in date (dd-mm-yyyy): ");
                    String checkInDate = scanner.nextLine();
                    System.out.print("Enter check-out date (dd-mm-yyyy): ");
                    String checkOutDate = scanner.nextLine();

                    hotel.makeReservation(customer, roomType, checkInDate, checkOutDate);
                    break;
                case 2:
                    hotel.displayReservations();
                    break;
                case 3:
                    hotel.displayAvailableRooms();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Please try again.");
            }
        }
        while (choice != 4);
    }
}
