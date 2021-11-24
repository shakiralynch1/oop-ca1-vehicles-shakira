package org.example;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BookingManager
{
    private final ArrayList<Booking> bookingList;
    private PassengerStore passengerStore;
    private VehicleManager vehicleManager;

    // Constructor
    public BookingManager() {

        this.bookingList = new ArrayList<>();
    }

    //TODO implement functionality as per specification
    public void addBooking(int passengerId, int vehicleId,LocalDateTime bookingDateTime, LocationGPS startLocation,
                           LocationGPS endLocation)
    {
        //construct a new passenger object

        Booking booking= new Booking(passengerId,vehicleId,bookingDateTime,startLocation,endLocation);

        boolean found=false;
        for(Booking b: bookingList) {
            if (b.equals(booking)) {
                found = true;
                break;
            }
        }
        if(found == false){
            bookingList.add(booking);

        }

        bookingList.add(booking);


    }

    public void displayBookings(){
        for (Booking b : bookingList)
            System.out.println(b.toString());
    }
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
    public void editBookingByDateTime(int id, LocalDateTime changeDateTime)
    {
            for (Booking b : bookingList)
            {

                    if (b != null && id==(b.getBookingId()))
                    {
                        b.setBookingDateTime(changeDateTime);

                    }


            }


    }
    public void editBookingStartLocation(int id, LocationGPS changedStartLocation)
    {
        for (Booking b : bookingList)
        {

            if (b != null && id==(b.getBookingId()))
            {
                b.setStartLocation(changedStartLocation);

            }


        }

    }
    public void editBookingEndLocation(int id, LocationGPS changedEndLocation)
    {
        for (Booking b : bookingList)
        {

            if (b != null && id==(b.getBookingId()))
            {
                b.setEndLocation(changedEndLocation);

            }


        }


    }

    public void deleteDateTimeBooking(int id)
    {
        for(Booking b: bookingList){
            if(b != null && id==(b.getBookingId()))
            {

            }
        }


    }




}
