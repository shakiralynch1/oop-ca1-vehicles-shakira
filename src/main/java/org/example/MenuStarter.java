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
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
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
                + "3. EXIT"
                + "Enter Option [1,5]";
        final int DISPLAY = 1;
        final int FIND = 2;
        final int EXIT = 3;

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
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
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
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }

    private void vehicleMenu() throws IOException {
        final String MENU_ITEMS = "\n*** VEHICLE MENU ***\n"
                + "1. Display all vehicles \n"
                + "2. Find all vehicles\n"
                + "3. Find vehicle by registration\n"
                + "4. Find vehicles by type\n"
                + "5. Exit back to Main Menu"
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
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
    }
    private void bookingMenu(){
        System.out.println("Still working on it");
    }

}
