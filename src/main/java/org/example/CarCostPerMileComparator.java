package org.example;

import java.util.Comparator;

public class CarCostPerMileComparator implements Comparator<Car> {

    public int compare(Car car1, Car car2)
    {
        return Double.compare(car1.getCostPerMile(), car2.getCostPerMile());
    }
}
