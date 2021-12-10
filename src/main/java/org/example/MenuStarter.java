package org.example;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuStarter {
    // Components (objects) used in this App
    PassengerStore passengerStore;  // encapsulates access to list of Passengers
    VehicleManager vehicleManager;  // encapsulates access to list of Vehicles
    BookingManager bookingManager;  // deals with all bookings

    public static void main(String[] args) {
        MenuStarter menu = new MenuStarter();
        menu.start();
    }

    public void start() {
        // create PassengerStore and load all passenger records from text file
        passengerStore = new PassengerStore("passengers.txt");

        // create VehicleManager, and load all vehicles from text file
        vehicleManager = new VehicleManager("vehicles.txt");

        try {
            displayMainMenu();        // User Interface - Menu
        } catch (IOException e) {
            e.printStackTrace();
        }


        vehicleManager.displayAllVehicles();


        String registration = "172LH234106";
        Vehicle vehicle = vehicleManager.findVehicleByRegistration(registration);
        if (vehicle == null)
            System.out.println("No vehicle with registration " + registration + " was found.");
        else
            System.out.println("Found Vehicle: " + vehicle.toString());

        // Create BookingManager and load all bookings from file
        // bookingManager = new BookingManager("bookings.txt");

        //pMgr.saveToFile();

        System.out.println("Program ending, Goodbye");
    }

    private void displayMainMenu() throws IOException {

        final String MENU_ITEMS = "\n*** MAIN MENU OF OPTIONS ***\n"
                + "1. Passengers\n"
                + "2. Vehicles\n"
                + "3. Bookings\n"
                + "4. Exit\n"
                + "Enter Option [1,4]";

        final int PASSENGERS = 1;
        final int VEHICLES = 2;
        final int BOOKINGS = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case PASSENGERS:
                        System.out.println("Passengers option chosen");
                        passengerMenu();
                        break;
                    case VEHICLES:
                        System.out.println("Vehicles option chosen");
                        vehicleMenu();
                        break;
                    case BOOKINGS:
                        System.out.println("Bookings option chosen");
                        bookingMenu();
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.println("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

        System.out.println("\nExiting Main Menu, goodbye.");

    }

    // Sub-Menu for Passenger operations
    //
    private void passengerMenu() throws IOException {
        final String MENU_ITEMS = "\n*** PASSENGER MENU ***\n"
                + "1. Display passenger options\n"
                + "2. Find passenger options\n"
                + "3. Edit passenger options\n"
                + "4. Delete passenger options\n"
                + "5. Add a passenger\n"
                + "6. EXIT\n"
                + "Enter Option [1,6]";
        final int DISPLAY = 1;
        final int FIND = 2;
        final int EDIT=3;
        final int DELETE=4;
        final int ADD=5;
        final int EXIT = 6;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case DISPLAY:
                        displayPassengerMenu();
                        break;
                    case FIND:
                        findPassengerMenu();
                    case EDIT:
                        editPassengerMenu();
                    case DELETE:
                        deletePassengerMenu();
                    case ADD:
                        addPassengerMenu();
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);


    }


    private void displayPassengerMenu() {
        final String MENU_ITEMS = "\n*** DISPLAY PASSENGER MENU ***\n"
                + "1. Show all Passengers\n"
                + "2. Display passenger by name\n"
                + "3. Display passenger by email\n"
                + "4. Display passenger by phone number\n"
                + "5. Display passenger by location\n"
                + "6. Exit\n"
                + "Enter Option [1,6]";

        final int SHOW_ALL = 1;
        final int DISPLAY_BY_NAME = 2;
        final int DISPLAY_BY_EMAIL = 3;
        final int DISPLAY_BY_PHONE = 4;
        final int DISPLAY_BY_LOCATION = 5;
        final int EXIT = 6;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case SHOW_ALL:
                        System.out.println("Display ALL Passengers");
                        passengerStore.displayAllPassengers();
                        break;
                    case DISPLAY_BY_NAME:
                        System.out.println("Display Passenger by Name");
                        System.out.println("Enter passenger name: ");
                        String name = keyboard.nextLine();
                        passengerStore.displayPassengersByName(name);

                        break;
                    case DISPLAY_BY_EMAIL:
                        System.out.println("Display Passenger by email");
                        System.out.println("Enter passenger email: ");
                        String email = keyboard.nextLine();
                        passengerStore.displayPassengersByEmail(email);
                        break;
                    case DISPLAY_BY_PHONE:
                        System.out.println("Display Passenger by phone");
                        System.out.println("Enter passenger phone: ");
                        String phone = keyboard.nextLine();
                        passengerStore.displayPassengersByNumber(phone);
                        break;
                    case DISPLAY_BY_LOCATION:
                        System.out.println("Display Passenger by location");
                        System.out.println("Enter passenger phone: ");
                        String location = keyboard.next();
                        passengerStore.displayPassengersByEmail(location);
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.println("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }

    private void findPassengerMenu() {
        final String MENU_ITEMS = "\n*** FIND PASSENGER MENU ***\n"
                + "1. Find passenger by name\n"
                + "2. Find passenger by email\n"
                + "3. Find passenger by phone\n"
                + "4. Find passenger by location\n"
                + "5. Exit\n"
                + "Enter Option [1,5]";

        final int FIND_BY_NAME = 1;
        final int FIND_BY_EMAIL = 2;
        final int FIND_BY_PHONE = 3;
        final int FIND_BY_LOCATION = 4;
        final int EXIT = 5;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInputFind = keyboard.nextLine();
                option = Integer.parseInt(usersInputFind);
                switch (option) {
                    case FIND_BY_NAME:
                        System.out.println("Find Passenger by Name");
                        System.out.println("Enter passenger name: ");
                        String name = keyboard.nextLine();
                        Passenger p = passengerStore.findPassengerByName(name);
                        if (p == null)
                            System.out.println("No passenger matching the name \"" + name + "\"");
                        else
                            System.out.println("Found passenger: \n" + p.toString());
                        break;
                    case FIND_BY_EMAIL:
                        System.out.println("Find Passenger by Email");
                        System.out.println("Enter passenger Email: ");
                        String email = keyboard.nextLine();
                        Passenger p1 = passengerStore.findPassengerByEmail(email);
                        if (p1 == null)
                            System.out.println("No passenger matching the name \"" + email + "\"");
                        else
                            System.out.println("Found passenger: \n" + p1.toString());
                        break;
                    case FIND_BY_PHONE:
                        System.out.println("Find Passenger by Phone");
                        System.out.println("Enter passenger Phone: ");
                        String phone = keyboard.nextLine();
                        Passenger p2 = passengerStore.findPassengerByEmail(phone);
                        if (p2 == null)
                            System.out.println("No passenger matching the name \"" + phone + "\"");
                        else
                            System.out.println("Found passenger: \n" + p2.toString());
                        break;
                    case FIND_BY_LOCATION:
                        System.out.println("Find Passenger by Location");
                        System.out.println("Enter passenger Location: ");
                        String location = keyboard.nextLine();
                        Passenger p3 = passengerStore.findPassengerByEmail(location);
                        if (p3 == null)
                            System.out.println("No passenger matching the name \"" + location + "\"");
                        else
                            System.out.println("Found passenger: \n" + p3.toString());
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.println("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }
    private void editPassengerMenu(){
        final String MENU_ITEMS = "\n*** EDIT PASSENGER MENU ***\n"
                + "1. Edit passenger name\n"
                + "2. Edit passenger phone\n"
                + "3. Edit passenger location\n"
                + "4. EXIT\n"
                + "Enter Option [1,4]";
        final int EDIT_NAME = 1;
        final int EDIT_PHONE = 2;
        final int EDIT_LOCATION = 3;
        final int EXIT =4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case EDIT_NAME:
                        System.out.println("Edit Passenger Name");
                        System.out.println("Please enter the email for the passenger name you wish to change : ");
                        String email = keyboard.nextLine();
                        if(passengerStore.findPassengerByEmail(email)==null){
                            System.out.println("Passenger does not exist");
                        }
                        else {
                            System.out.println("Enter the name you wish to change the current name to: ");
                            String name= keyboard.nextLine();
                            passengerStore.editPassengerName(email, name);
                            System.out.println("Name changed!");
                        }
                        break;
                    case EDIT_PHONE:
                        System.out.println("Edit Passenger Number");
                        System.out.println("Please enter the email for the passenger name you wish to change : ");
                        String email1 = keyboard.nextLine();
                        if(passengerStore.findPassengerByEmail(email1)==null){
                            System.out.println("Passenger does not exist");
                        }
                        else {
                            System.out.println("Enter the phone you wish to change the current phone to: ");
                            String phone= keyboard.nextLine();
                            passengerStore.editPassengerPhone(email1, phone);
                            System.out.println("Phone changed!");
                        }
                        break;
                    case EDIT_LOCATION:
                        System.out.println("Edit passenger location");
                        System.out.println("Please enter the passenger email for the passengers locations you wish to edit : ");
                        String email3 = keyboard.nextLine();
                        if(passengerStore.findPassengerByEmail(email3)==null){
                            System.out.println("Passenger does not exist");
                        }
                        else {
                            System.out.println("Please enter the location you wish to have below");
                            System.out.println("Enter the  latitude: ");
                            double endLat = keyboard.nextDouble();
                            System.out.println("Enter the  longitude: ");
                            double endLong = keyboard.nextDouble();
                            passengerStore.editPassengerLocation(email3, endLong, endLat);
                        }
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.println("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }
private void deletePassengerMenu(){
    final String MENU_ITEMS = "\n*** DELETE PASSENGER MENU ***\n"
            + "1. Delete all passengers\n"
            + "2. Delete passenger by location\n"
            + "3. EXIT\n"
            + "Enter Option [1,3]";
    final int DELETE_ALL = 1;
    final int DELETE_NAME    = 2;
    final int EXIT =3;

    Scanner keyboard = new Scanner(System.in);
    int option = 0;
    do {
        System.out.println("\n" + MENU_ITEMS);
        try {
            String usersInput = keyboard.nextLine();
            option = Integer.parseInt(usersInput);
            switch (option) {
                case DELETE_ALL:
                    System.out.println("Deleting all passengers...");
                    System.out.println("Are you sure you want to cancel all passengers??" +
                            "Enter 'Yes' or 'No' ");
                    String message= keyboard.nextLine();
                    if(message.equalsIgnoreCase("Yes")) {
                        passengerStore.deleteAllPassengers();
                    }
                    else {
                        System.out.println("No problem, wise choice!");
                    }
                    break;
                case DELETE_NAME:
                    System.out.println("Delete passenger by passenger name");
                    System.out.println("Please enter passenger name for the passenger you wish to delete: ");
                    String name= keyboard.nextLine();
                    if(passengerStore.findPassengerByName(name)==null){
                        System.out.println("Passenger does not exist");
                    }
                    System.out.println("Deleting the booking...");
                    passengerStore.deletePassengersByName(name);
                    break;
                case EXIT:
                    System.out.println("Exit Menu option chosen");
                    break;
                default:
                    System.out.println("Invalid option - please enter number in range");
                    break;
            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Invalid option - please enter number in range");
        }
    } while (option != EXIT);
}
private void addPassengerMenu(){
        final String MENU_ITEMS = "\n*** ADD BOOKING MENU ***\n"
                + "1. Add a Passenger\n"
                + "2. EXIT\n"
                + "Enter Option [1]";
        final int ADD = 1;
        final int EXIT =2;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case ADD:
                        System.out.println("Add a passenger!");
                        System.out.println("Please enter all the details below to add a passenger.");
                        System.out.println("Enter passenger name: ");
                        String name= keyboard.nextLine();
                        System.out.println("Enter passenger email: ");
                        String email = keyboard.nextLine();
                        System.out.println("Enter passenger phone: ");
                        String phone = keyboard.nextLine();
                        System.out.println("Enter Location... ");
                        System.out.println("Enter longitude: ");
                        double longitude = keyboard.nextDouble();
                        System.out.println("Enter latitude: ");
                        double latitude = keyboard.nextDouble();
                        passengerStore.addPassenger(name,email,phone,longitude,latitude);
                        System.out.println("Passenger made...");
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.println("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }


    private void vehicleMenu() throws IOException {
        final String MENU_ITEMS = "\n*** VEHICLE MENU ***\n"
                + "1. Display all vehicles \n"
                + "2. Find all vehicles\n"
                + "3. Find vehicle by registration\n"
                + "4. Find vehicles by type\n"
                + "5. Exit back to Main Menu\n"
                + "Enter Option [1,5]";
        final int ALL_V = 1;
        final int FIND_V = 2;
        final int FIND_REG = 3;
        final int FIND_TYPE = 4;
        final int EXIT =5;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case ALL_V:
                        System.out.println("Displaying all vehicles");
                        vehicleManager.displayAllVehicles();
                        break;
                    case FIND_V:
                        System.out.println("Find all vehicles");
                        vehicleManager.findAllVehicles();
                        break;
                    case FIND_REG:
                        System.out.println("Find vehicle by registration");
                        System.out.println("Please enter a registration: ");
                        String reg = keyboard.next();
                        if(vehicleManager.findVehicleByRegistration(reg)==null){
                            System.out.println("Registration does not exist");
                        }
                        break;
                    case FIND_TYPE:
                        System.out.println("Find vehicle by type");
                        System.out.println("Please enter type of car: ");
                        String type= keyboard.next();
                        if(vehicleManager.findVehicleByUserType(type)==null){
                        System.out.println("No cars of this type exist");
                    }
                     break;
                    case EXIT:
                    System.out.println("Exit Menu option chosen");
                    break;
                    default:
                        System.out.println("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
    }
    private void bookingMenu(){
        final String MENU_ITEMS = "\n*** BOOKING MENU ***\n"
                + "1. Display booking options\n"
                + "2. Find booking options\n"
                + "3. Edit booking options\n"
                + "4. Delete booking options\n"
                + "5. Add a booking\n"
                + "6. EXIT\n"
                + "Enter Option [1,6]";
        final int DISPLAY = 1;
        final int FIND = 2;
        final int EDIT = 3;
        final int DELETE =4;
        final int ADD =5;
        final int EXIT = 6;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case DISPLAY:
                        displayBookingMenu();
                        break;
                    case FIND:
                        findBookingMenu();
                        break;
                    case EDIT:
                        editBookingMenu();
                        break;
                    case DELETE:
                        deleteBookingMenu();
                        break;
                    case ADD:
                        addBookingMenu();
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.println("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
    }




    private void displayBookingMenu()  {
            final String MENU_ITEMS = "\n*** DISPLAY PASSENGER MENU ***\n"
                    + "1. Show all Bookings\n"
                    + "2. Display Bookings in the future\n"
                    + "3. Display booking by Booking ID\n"
                    + "4. Display booking by Passenger ID\n"
                    + "5. Display booking by Vehicle ID\n"
                    + "6. Display current to future\n"
                    + "7. EXIT\n"
                    + "Enter Option [1,7]";

            final int SHOW_ALL = 1;
            final int DISPLAY_BY_FUTURE = 2;
            final int DISPLAY_BY_BOOK_ID = 3;
            final int DISPLAY_BY_PASS_ID = 4;
            final int DISPLAY_BY_VEHC_ID = 5;
            final int DISPLAY_FUTURE=6;
            final int EXIT = 7;

            Scanner keyboard = new Scanner(System.in);
            int option = 0;
            do {
                System.out.println("\n" + MENU_ITEMS);
                try {
                    String usersInput = keyboard.nextLine();
                    option = Integer.parseInt(usersInput);
                    switch (option) {
                        case SHOW_ALL:
                            System.out.println("Display ALL Bookings");
                            bookingManager.displayBookings();
                            break;
                        case DISPLAY_BY_FUTURE:
                            System.out.println("Display Bookings for the future");
                            bookingManager.displayBookingsCurrentToFuture();

                            break;
                        case DISPLAY_BY_BOOK_ID:
                            System.out.println("Display booking by booking ID");
                            System.out.println("Enter booking ID: ");
                            int bookingId = keyboard.nextInt();
                            bookingManager.displayBookingByBookingId(bookingId);
                            break;
                        case DISPLAY_BY_PASS_ID:
                            System.out.println("Display booking by passenger ID");
                            System.out.println("Enter passenger ID: ");
                            int passengerId = keyboard.nextInt();
                            bookingManager.displayBookingByPassenegerId(passengerId);
                            break;
                        case DISPLAY_BY_VEHC_ID:
                            System.out.println("Display booking by vehicle ID");
                            System.out.println("Enter vehicle ID: ");
                            int vehicleId = keyboard.nextInt();
                            bookingManager.displayBookingByVehicleId(vehicleId);
                            break;
                        case DISPLAY_FUTURE:
                            System.out.println("Display bookings from current to future");
                            bookingManager.sortBookingBy(new DateComparator());
                            bookingManager.displayBookingsCurrentToFuture();
                            break;
                        case EXIT:
                            System.out.println("Exit Menu option chosen");
                            break;
                        default:
                            System.out.println("Invalid option - please enter number in range");
                            break;
                    }

                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Invalid option - please enter number in range");
                }
            } while (option != EXIT);

        }

    private void findBookingMenu() {
            final String MENU_ITEMS = "\n*** FIND BOOKING MENU ***\n"
                    + "1. Find all vehicles\n"
                    + "2. Find vehicle by registration\n"
                    + "3. EXIT\n"
                    + "Enter Option [1,3]";
            final int FIND_PASS_ID = 1;
            final int FIND_VEH_ID = 2;
            final int EXIT =3;

            Scanner keyboard = new Scanner(System.in);
            int option = 0;
            do {
                System.out.println("\n" + MENU_ITEMS);
                try {
                    String usersInput = keyboard.nextLine();
                    option = Integer.parseInt(usersInput);
                    switch (option) {
                        case FIND_PASS_ID:
                            System.out.println("Find booking by passenger ID");
                            System.out.println("Please enter a passenger ID: ");
                            int passId = keyboard.nextInt();
                            if(bookingManager.findBookingByPassengerId(passId)==null){
                                System.out.println("Passenger does not exist");
                            }
                            break;
                        case FIND_VEH_ID:
                            System.out.println("Find booking by vehicle ID");
                            System.out.println("Please enter a vehicle ID: ");
                            int vehId = keyboard.nextInt();
                            if(bookingManager.findBookingByVehicleId(vehId)==null){
                                System.out.println("Vehicle does not exist");
                            }
                        break;
                        case EXIT:
                            System.out.println("Exit Menu option chosen");
                            break;
                        default:
                            System.out.println("Invalid option - please enter number in range");
                            break;
                    }

                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("Invalid option - please enter number in range");
                }
            } while (option != EXIT);
        }

    private void editBookingMenu() {
        final String MENU_ITEMS = "\n*** EDIT BOOKING MENU ***\n"
                + "1. Edit booking date time\n"
                + "2. Edit booking start location\n"
                + "3. Edit booking end location\n"
                + "4. EXIT\n"
                + "Enter Option [1,4]";
        final int EDIT_DATE = 1;
        final int EDIT_START = 2;
        final int EDIT_END = 3;
        final int EXIT =4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case EDIT_DATE:
                        System.out.println("Edit bookings date time");
                        System.out.println("Please enter the booking ID for the booking date time you wish to edit : ");
                        int bookId = keyboard.nextInt();
                        if(bookingManager.findBookingByBookingId(bookId)==null){
                            System.out.println("Booking does not exist");
                        }
                        else {
                            System.out.println("Please enter the date time you wish to have below");
                            System.out.println("Enter year: ");
                            int year = keyboard.nextInt();
                            System.out.println("Enter month: ");
                            int month = keyboard.nextInt();
                            System.out.println("Enter day: ");
                            int day = keyboard.nextInt();
                            System.out.println("Enter hour: ");
                            int hour = keyboard.nextInt();
                            System.out.println("Enter minute: ");
                            int minute = keyboard.nextInt();
                            bookingManager.editBookingByDateTime(bookId, year, month, day, hour, minute);
                        }
                        break;
                    case EDIT_START:
                        System.out.println("Edit booking start location");
                        System.out.println("Please enter the booking ID for the booking start location you wish to edit : ");
                        int bookId1 = keyboard.nextInt();
                        if(bookingManager.findBookingByBookingId(bookId1)==null){
                            System.out.println("Booking does not exist");
                        }
                        else {
                            System.out.println("Please enter the start location you wish to have below");
                            System.out.println("Enter  the start latitude: ");
                            double startLat = keyboard.nextDouble();
                            System.out.println("Enter the start longitude: ");
                            double startLong = keyboard.nextDouble();
                            bookingManager.editBookingStartLocation(bookId1, startLat, startLong);
                        }
                        break;
                    case EDIT_END:
                        System.out.println("Edit booking end location");
                        System.out.println("Please enter the booking ID for the booking end location you wish to edit : ");
                        int bookId3 = keyboard.nextInt();
                        if(bookingManager.findBookingByBookingId(bookId3)==null){
                            System.out.println("Booking does not exist");
                        }
                        else {
                            System.out.println("Please enter the end location you wish to have below");
                            System.out.println("Enter the end latitude: ");
                            double endLat = keyboard.nextDouble();
                            System.out.println("Enter the end location: ");
                            double endLong = keyboard.nextDouble();
                            bookingManager.editBookingStartLocation(bookId3, endLat, endLong);
                        }
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.println("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }
    private void deleteBookingMenu(){
        final String MENU_ITEMS = "\n*** DELETE BOOKING MENU ***\n"
                + "1. Delete all bookings\n"
                + "2. Delete booking by bookingID\n"
                + "3. EXIT\n"
                + "Enter Option [1,3]";
        final int DELETE_ALL = 1;
        final int DELETE_ID = 2;
        final int EXIT =3;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case DELETE_ALL:
                        System.out.println("Deleting all bookings...");
                        System.out.println("Are you sure you want to cancel all bookings??" +
                                "Enter 'Yes' or 'No' ");
                        String message= keyboard.nextLine();
                        if(message.equalsIgnoreCase("Yes")) {
                            bookingManager.deleteAllBookings();
                        }
                        else {
                            System.out.println("No problem, wise choice!");
                        }
                        break;
                    case DELETE_ID:
                        System.out.println("Delete booking by bookingID");
                        System.out.println("Please enter bookingID for the booking you wish to delete: ");
                        int bookId= keyboard.nextInt();
                        if(bookingManager.findBookingByBookingId(bookId)==null){
                            System.out.println("Booking does not exist");
                        }
                        System.out.println("Deleting the booking...");
                        bookingManager.deleteBookingByBookingId(bookId);
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.println("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid option - please enter number in range");
            }
        } while (option != EXIT);


    }
    private void addBookingMenu(){
        final String MENU_ITEMS = "\n*** ADD BOOKING MENU ***\n"
                + "1. Add a booking\n"
                + "2. EXIT\n"
                + "Enter Option [1,2]";
        final int ADD = 1;
        final int EXIT =2;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case ADD:
                        System.out.println("Create a booking!");
                        System.out.println("Please enter all the details below to make a booking.");
                        System.out.println("Enter the IDs...");
                        System.out.println("Enter passenger ID: ");
                        int passId= keyboard.nextInt();
                        System.out.println("Enter Vehicle ID: ");
                        int vehId = keyboard.nextInt();
                        System.out.println("Enter date details...");
                        System.out.println("Enter year: ");
                        int year = keyboard.nextInt();
                        System.out.println("Enter month: ");
                        int month = keyboard.nextInt();
                        System.out.println("Enter day: ");
                        int day = keyboard.nextInt();
                        System.out.println("Enter hour: ");
                        int hour = keyboard.nextInt();
                        System.out.println("Enter minute: ");
                        int minute = keyboard.nextInt();
                        System.out.println("Enter location details...");
                        System.out.println("Enter  the start latitude: ");
                        double startLat = keyboard.nextDouble();
                        System.out.println("Enter the start longitude: ");
                        double startLong = keyboard.nextDouble();
                        System.out.println("Enter the end latitude: ");
                        double endLat = keyboard.nextDouble();
                        System.out.println("Enter the end location: ");
                        double endLong = keyboard.nextDouble();
                        bookingManager.createBooking(passId,vehId,year,month,day,hour,minute,startLong,startLat,endLong,endLat);

                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.println("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }

}
