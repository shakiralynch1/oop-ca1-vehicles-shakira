package org.example;

import java.util.Comparator;

public class CarMilesPerKWhComparator implements Comparator<Car> {

    public int compare(Car car1, Car car2)
    {
        return Double.compare(car1.getMilesPerKm(), car2.getMilesPerKm());
    }
}
