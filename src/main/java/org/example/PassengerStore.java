package org.example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class PassengerStore {

    private final ArrayList<Passenger> passengerList;

    public PassengerStore(String fileName) {
        this.passengerList = new ArrayList<>();
        loadPassengerDataFromFile(fileName);
    }

    public List<Passenger> getAllPassengers() {
        return this.passengerList;
    }

    public void displayAllPassengers() {
        for (Passenger p : this.passengerList) {
            System.out.println(p.toString());
        }
    }
    //not allowed duplicates
    public Passenger addPassenger(String name, String email, String phone,
                                  double latitude, double longitude)
    {
        //construct a new passenger object
        Passenger passenger= new Passenger(name,email,phone,latitude,longitude);

        boolean found=false;
        for(Passenger p: passengerList) {
            if (p.equals(passenger)) {
                found = true;
                break;
            }
        }
            if(found == false){
                passengerList.add(passenger);

        }

        passengerList.add(passenger);


        return passenger;
    }


    /**
     * Read Passenger records from a text file and create and add Passenger
     * objects to the PassengerStore.
     */
    private void loadPassengerDataFromFile(String filename) {

        try {
            Scanner sc = new Scanner(new File(filename));
//           Delimiter: set the delimiter to be a comma character ","
//                    or a carriage-return '\r', or a newline '\n'
            sc.useDelimiter("[,\r\n]+");

            while (sc.hasNext()) {
                int id = sc.nextInt();
                String name = sc.next();
                String email = sc.next();
                String phone = sc.next();
                double latitude = sc.nextDouble();
                double longitude = sc.nextDouble();

                // construct a Passenger object and add it to the passenger list
                passengerList.add(new Passenger(id, name, email, phone, latitude, longitude));
            }
            sc.close();

        } catch (IOException e) {
            System.out.println("Exception thrown. " + e);
        }
    }

    // TODO - see functional spec for details of code to add



    public void displayPassengersByName(String name){

        for(Passenger p: passengerList) {
            if(p.getName().equalsIgnoreCase(name)){
                System.out.println(p);
            }
        }
    }
    public void displayPassengersByEmail(String email){

        for(Passenger p: passengerList) {
            if(p.getEmail().equalsIgnoreCase(email)){
                System.out.println(p);
            }
        }
    }
    public void displayPassengersByNumber(String number){

        for(Passenger p: passengerList) {
            if(p.getPhone().equalsIgnoreCase(number)){
                System.out.println(p);
            }
        }
    }
    public void displayPassengersByLocation(LocationGPS location){

        for(Passenger p: passengerList) {
            if(p.getLocation()==(location)){
                System.out.println(p);
            }
        }
    }
    public Passenger findPassengerByName(String name){

        for(Passenger p: passengerList) {
            if(p.getName().equalsIgnoreCase(name)){
                return p;
            }
        }
        return null;
}
    public Passenger findPassengerByEmail(String email){

        for(Passenger p: passengerList) {
            if(p.getEmail().equalsIgnoreCase(email)){
                return p;
            }
        }
        return null;
    }
    public Passenger findPassengerByPhone(String phone){

        for(Passenger p: passengerList) {
            if(p.getPhone().equalsIgnoreCase(phone)){
                return p;
            }
        }
        return null;
    }
    public Passenger findPassengerByLocation(LocationGPS location){

        for(Passenger p: passengerList) {
            if(p.getLocation()==(location)){
                return p;
            }
        }
        return null;
    }
    public void editPassengerName(String email, String changedName)
    {
        for (Passenger p : passengerList)
        {

            if (p != null && email.equalsIgnoreCase(p.getEmail()))
            {
                p.setName(changedName);

            }


        }


    }
    public void editPassengerPhone(String email, String changedPhone)
    {
        for (Passenger p : passengerList)
        {

            if (p != null && email.equalsIgnoreCase(p.getEmail()))
            {
                p.setPhone(changedPhone);

            }


        }


    }
    public void editPassengerLocation(String email, double longitude, double latitude)
    {
        for (Passenger p : passengerList)
        {

            if (p != null && email.equalsIgnoreCase(p.getEmail()))
            {
                p.setLocation(latitude, longitude);


            }


        }


    }
    public void deleteAllPassengers() {
        Iterator<Passenger> it = passengerList.iterator();
        while (it.hasNext())
        {
            it.next();
            it.remove();
        }

    }
    public void deletePassengersByLocation(LocationGPS location) {
        for (int i = 0; i < passengerList.size(); i++)
        {
            if (passengerList.get(i).getLocation()==(location))
            {
                passengerList.remove(i);
            }
        }

    }



} // end class
