package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class BookingManager {
    private final ArrayList<Booking> bookingList;
    private final PassengerStore passengerStore;
    private final VehicleManager vehicleManager;
   // private DateComparator byDate;



    public BookingManager(PassengerStore passengerStore, VehicleManager vehicleManager, String fileName) {
        this.bookingList = new ArrayList<>();
        this.passengerStore = passengerStore;
        this.vehicleManager = vehicleManager;
        loadBookingsFromFile(fileName);
    }



    public void loadBookingsFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));
//           Delimiter: set the delimiter to be a comma character ","
//                    or a carriage-return '\r', or a newline '\n'
            sc.useDelimiter("[,\r\n]+");

            while (sc.hasNext()) {
                int bookingId = sc.nextInt();
                int passengerId = sc.nextInt();  // vehicle type
                int vehicleId = sc.nextInt();
                String bookingDateTime = sc.next();
                double startLongitude = sc.nextDouble();
                double startLatitude = sc.nextDouble();
                double cost = sc.nextDouble();


            }
            sc.close();

        } catch (IOException e) {
            System.out.println("Exception thrown. " + e);
        }
    }


    //TODO implement functionality as per specification

    public static double distance(double lat1,
                                  double lat2, double lon1,
                                  double lon2)
    {

        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }
    public double calculateCost(int vehicleId, double startLatitude,double startLongitude,double endLatitude,double endLongitude)
    {
        Vehicle v= vehicleManager.findVehicleById(vehicleId);

        double cost=0;

        cost=distance(startLatitude,startLongitude,endLatitude,endLongitude) * v.getCostPerMile();

        return cost;

    }
    public BookingManager createBooking(int passengerId, int vehicleId,
                          int year, int month, int day, int hour, int minute,
                          double startLongitude, double startLatitude,
                          double endLongitude, double endLatitude) {

        double cost=calculateCost(vehicleId, startLatitude,startLongitude,endLatitude,endLongitude);

        if (passengerStore.findPassengerById(passengerId) != null) {
            if (vehicleManager.findVehicleById(vehicleId) != null) {
                Booking e = new Booking(passengerId,vehicleId,year,month,day,hour,minute,startLongitude,startLatitude,endLongitude,
                        endLatitude,cost);
                bookingList.add(e);
            }
            else {
                System.out.println("Vehicle does not exist");
            }
        } else {
            System.out.println("Passenger does not exist");
        }
        return null;

    }



    public void deleteAllBookings()
    {
        Iterator<Booking> it = bookingList.iterator();
        while (it.hasNext())
        {
            it.next();
            it.remove();
        }
    }

    public void deleteBookingByBookingId(int id)
    {
        int pos=-1;
        for (int i = 0; i < bookingList.size(); i++)
        {
            if (bookingList.get(i).getBookingId()==id)
            {
                pos=i;
            }
        }
        if(pos!=-1){
            bookingList.remove(pos);
        }

    }
    public void sortBookingBy(Comparator<Booking> comp)
        {
            bookingList.sort(comp);
        }


    public void displayBookings(){
        for (Booking b : bookingList)
            System.out.println(b);
    }
    //printing bookings that are in the future from current time


    public void displayBookingsCurrentToFuture()
    {
        LocalDateTime date= java.time.LocalDateTime.now();
        for (Booking b : bookingList){
            if( b.getBookingDateTime().isAfter(LocalDateTime.now())){

                System.out.println(b);



        }

    }
    }

    //printing bookings that are in the past from current time

    public void displayBookingByBookingId(int bookingId){
        for (Booking b : bookingList)
            if(b.getBookingId()==bookingId) {
                System.out.println(b);
            }

    }
    public void displayBookingByPassenegerId(int passengerId){
        for (Booking b : bookingList) {
            if (b.getPassengerId() == passengerId) {
                System.out.println(b);
            }

        }

    }
    public void displayBookingByVehicleId(int vehicleId){
        for (Booking b : bookingList) {
            if (b.getVehicleId() == vehicleId) {
                System.out.println(b);
            }

        }

    }
    public Booking findBookingByPassengerId(int passengerId){

    for(Booking b: bookingList) {
        if(b.getPassengerId()==passengerId){
            return b;
        }
    }
    return null;
}
    public Booking findBookingByVehicleId(int vehicleId){

        for(Booking b: bookingList) {
            if(b.getVehicleId()==vehicleId){
                return b;
            }
        }
        return null;
    }
    public Booking findBookingByBookingId(int bookingId){

        for(Booking b: bookingList) {
            if(b.getBookingId()==bookingId){
                return b;
            }
        }
        return null;
    }


    public void editBookingByDateTime(int id, int year, int month, int day, int hour, int minute)
    {

            for (Booking b : bookingList)
            {
                    if (b != null && id==(b.getBookingId()))
                    {
                        LocalDateTime date=LocalDateTime.of(year, month, day, hour, minute);

                        b.setBookingDateTime(date);

                    }


            }


    }
    public void editBookingStartLocation(int id, double startLatitude, double startLongitude)
    {
        for (Booking b : bookingList)
        {

            if (b != null && id==(b.getBookingId()))
            {
                LocationGPS startLocation = new LocationGPS(startLatitude, startLongitude);
                b.setStartLocation(startLocation);

            }


        }

    }
    public void editBookingEndLocation(int id, double endLatitude, double endLongitude)
    {
        for (Booking b : bookingList)
        {

            if (b != null && id==(b.getBookingId()))
            {
                LocationGPS endLocation = new LocationGPS(endLatitude, endLongitude);
                b.setEndLocation(endLocation);

            }


        }

    }
    public double averageLengthOfBookings()
    {
        double average=0;
        double total=0;
        int count=0;
         for(Booking b:bookingList)
         {
             total = distance(b.getStartLocation().getLatitude(), b.getStartLocation().getLongitude(),
                     b.getEndLocation().getLatitude(), b.getEndLocation().getLongitude() ) + total;
            count++;
         }
         average=total/ count;


        return average;
    }




}
