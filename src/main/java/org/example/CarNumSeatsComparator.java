package org.example;

import java.util.Comparator;

public class CarNumSeatsComparator implements Comparator<Car> {

    public int compare(Car car1, Car car2)
    {
        return Integer.compare(car1.getNumSeats(), car2.getNumSeats());
    }
}

