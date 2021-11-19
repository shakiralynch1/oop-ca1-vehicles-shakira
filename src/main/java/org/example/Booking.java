package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;


class Booking
{
    private int bookingId;
    private int passengerId;
    private int vehicleId;
    private LocalDateTime bookingDateTime;
    private LocationGPS startLocation;
    private LocationGPS endLocation;
    private double cost;  //Calculated at booking time


    public Booking(int bookingId, int passengerId, int vehicleId,
                   LocalDateTime bookingDateTime, LocationGPS startLocation,
                   LocationGPS endLocation, double cost)
    {
        this.bookingId = bookingId;
        this.passengerId = passengerId;
        this.vehicleId=vehicleId;
        this.bookingDateTime=bookingDateTime;
        this.startLocation= startLocation;
        this.endLocation=endLocation;
        this.cost=cost;
    }





    //TODO - see specification=edit, delete and output

}
