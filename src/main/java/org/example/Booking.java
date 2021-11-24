package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;

//d
class Booking {
    private int bookingId;
    private int passengerId;
    private int vehicleId;
    private LocalDateTime bookingDateTime;
    private LocationGPS startLocation;
    private LocationGPS endLocation;
    private double cost;  //Calculated at booking time


    public Booking(int bookingId, int passengerId,
                   LocalDateTime bookingDateTime, LocationGPS startLocation,
                   LocationGPS endLocation) {
        this.bookingId = bookingId;
        this.passengerId = passengerId;
        this.vehicleId = vehicleId;
        this.bookingDateTime = bookingDateTime;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.cost = cost;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public LocationGPS getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(LocationGPS endLocation) {
        this.endLocation = endLocation;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public LocationGPS getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(LocationGPS startLocation) {
        this.startLocation = startLocation;
    }


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }





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



        }









    //TODO - see specification=edit, delete and output


