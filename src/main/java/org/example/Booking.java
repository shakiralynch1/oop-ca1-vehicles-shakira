package org.example;

import java.time.LocalDateTime;
import java.util.Date;

//d
class Booking {
    private int bookingId;
    private int passengerId;
    private int vehicleId;
    private LocalDateTime bookingDateTime;
    private PassengerStore passengerStore;
    private VehicleManager vehicleManager;
    private LocationGPS startLocation;

    private LocationGPS endLocation;
    private IdGenerator idGenerator = IdGenerator.getInstance("next-id-store.txt");
    private double cost;  //Calculated at booking time


    public Booking(int passengerId, int vehicleId,
                   int year, int month, int day, int hour, int minute,
                   double startLongitude, double startLatitude,
                   double endLongitude, double endLatitude, double cost) {
        this.bookingId = idGenerator.getNextId();
        this.passengerId = passengerId;
        this.vehicleId = vehicleId;
        this.bookingDateTime = LocalDateTime.of(year, month, day, hour, minute);
        this.startLocation = new LocationGPS(startLatitude, startLongitude);
        this.endLocation = new LocationGPS(endLatitude, endLongitude);

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



    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", passengerId=" + passengerId +
                ", vehicleId=" + vehicleId +
                ", bookingDateTime=" + bookingDateTime +
                ", startLocation=" + startLocation +
                ", endLocation=" + endLocation +
                ", cost=" + cost +
                '}';
    }
}


    //TODO - see specification=edit, delete and output


